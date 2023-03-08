package snaker.snakerbone.entity.boss.utterfly;

import net.minecraft.core.BlockPos;
import net.minecraft.network.protocol.Packet;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.RandomSource;
import net.minecraft.world.BossEvent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraftforge.network.NetworkHooks;
import snaker.snakerbone.data.SnakerBoneAttributes;
import snaker.snakerbone.entity.ai.control.SnakerBoneFlyingControl;
import snaker.snakerbone.entity.ai.goal.SnakerBoneHommingAttackGoal;
import snaker.snakerbone.entity.ai.goal.SnakerBoneLookAroundGoal;
import snaker.snakerbone.entity.ai.goal.SnakerBoneRandomFlyGoal;
import snaker.snakerbone.entity.base.BossBase;
import snaker.snakerbone.registry.SnakerBoneContentRegistry;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.builder.ILoopType;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;
import software.bernie.geckolib3.util.GeckoLibUtil;

import javax.annotation.Nullable;

import static snaker.snakerbone.util.SnakerBonePolicy.WarningSuppression.CUSTOM_SET;

/**
 * Created by SnakerBone on 4/01/2023
 **/
@SuppressWarnings(CUSTOM_SET)
public class Utterfly extends BossBase implements IAnimatable {
    private final AnimationFactory FACTORY = GeckoLibUtil.createFactory(this);

    public Utterfly(EntityType<? extends BossBase> type, Level world) {

        super(type, world);

        moveControl = new SnakerBoneFlyingControl(this);

    }

    private <E extends IAnimatable> PlayState predicate(AnimationEvent<E> entity) {

        if (entity.isMoving()) {

            entity.getController().setAnimation(new AnimationBuilder().addAnimation("animation.utterfly.fly", ILoopType.EDefaultLoopTypes.LOOP));

        }

        return PlayState.CONTINUE;

    }

    public static boolean spawnRules(EntityType<Utterfly> type, ServerLevelAccessor world, MobSpawnType reason, BlockPos pos, RandomSource random) {

        return random.nextInt(8) == 0;

    }

    public static AttributeSupplier attributes() {
        return Monster.createMobAttributes()
                .add(Attributes.MAX_HEALTH, SnakerBoneAttributes.UTTERFLY_HEALTH)
                .add(Attributes.ATTACK_DAMAGE, SnakerBoneAttributes.UTTERFLY_ATTACK)
                .add(Attributes.ATTACK_SPEED, SnakerBoneAttributes.ATTACK_SPEED)
                .add(Attributes.FOLLOW_RANGE, SnakerBoneAttributes.FLYING_FOLLOW_RANGE)
                .add(Attributes.MOVEMENT_SPEED, SnakerBoneAttributes.MOVEMENT_SPEED)
                .add(Attributes.FLYING_SPEED, SnakerBoneAttributes.FLYING_SPEED).build();
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
        goalSelector.addGoal(5, new SnakerBoneRandomFlyGoal(this));
        goalSelector.addGoal(7, new SnakerBoneLookAroundGoal(this));
        goalSelector.addGoal(7, new SnakerBoneHommingAttackGoal(this, false, 1, 2, 4));
        targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, true));
    }

    @Override
    public boolean causeFallDamage(float pFallDistance, float pMultiplier, DamageSource pSource) {

        return false;

    }

    @Nullable
    @Override
    protected SoundEvent getAmbientSound() {

        return SnakerBoneContentRegistry.UTTERFLY_AMBIENT.get();

    }

    @Override
    protected SoundEvent getDeathSound() {

        return SnakerBoneContentRegistry.ENTITY_DEATH.get();

    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {

        return SoundEvents.SLIME_BLOCK_PLACE;

    }

    @Override
    public BossEvent.BossBarColor getBarColor() {

        return BossEvent.BossBarColor.GREEN;

    }

    @Override
    public void registerControllers(AnimationData data) {

        data.addAnimationController(new AnimationController<>(this, "controller", 0, this::predicate));

    }

    @Override
    public AnimationFactory getFactory() {

        return FACTORY;

    }

    @Override
    public Packet<?> getAddEntityPacket() {

        return NetworkHooks.getEntitySpawningPacket(this);

    }
}
