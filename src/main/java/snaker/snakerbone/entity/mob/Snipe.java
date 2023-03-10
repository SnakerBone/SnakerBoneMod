package snaker.snakerbone.entity.mob;

import net.minecraft.core.BlockPos;
import net.minecraft.network.protocol.Packet;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.util.RandomSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraftforge.network.NetworkHooks;
import org.jetbrains.annotations.NotNull;
import snaker.snakerbone.data.SnakerBoneAttributes;
import snaker.snakerbone.entity.ai.SnakerBoneDodgeProjectileGoal;
import snaker.snakerbone.entity.ai.SnakerBoneLaserAttackGoal;
import snaker.snakerbone.entity.base.FlyingMobBase;
import snaker.snakerbone.registry.SnakerBoneContentRegistry;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;
import software.bernie.geckolib3.util.GeckoLibUtil;

/**
 * Created by SnakerBone on 2/01/2023
 **/
public class Snipe extends FlyingMobBase implements IAnimatable {
    private final AnimationFactory FACTORY = GeckoLibUtil.createFactory(this);

    public Snipe(EntityType<? extends Snipe> type, Level world) {

        super(type, world);

    }

    /**
     * This entity has no animations to play so we will continue...
     **/
    private <E extends IAnimatable> PlayState predicate(AnimationEvent<E> entity) {

        return PlayState.CONTINUE;

    }

    public static AttributeSupplier attributes() {
        return Monster.createMobAttributes()
                .add(Attributes.MAX_HEALTH, SnakerBoneAttributes.SNIPE_HEALTH)
                .add(Attributes.ATTACK_DAMAGE, SnakerBoneAttributes.SNIPE_ATTACK)
                .add(Attributes.ATTACK_SPEED, SnakerBoneAttributes.ATTACK_SPEED)
                .add(Attributes.FOLLOW_RANGE, SnakerBoneAttributes.FLYING_FOLLOW_RANGE)
                .add(Attributes.MOVEMENT_SPEED, SnakerBoneAttributes.MOVEMENT_SPEED)
                .add(Attributes.FLYING_SPEED, SnakerBoneAttributes.FLYING_SPEED).build();
    }

    public static boolean spawnRules(EntityType<Snipe> type, ServerLevelAccessor world, MobSpawnType reason, BlockPos pos, RandomSource random) {

        return random.nextInt(8) == 0;

    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
        goalSelector.addGoal(9, new SnakerBoneDodgeProjectileGoal(this));
        goalSelector.addGoal(4, new SnakerBoneLaserAttackGoal(this, 2, 0, 20));
    }

    @Override
    protected @NotNull SoundEvent getAmbientSound() {

        return SnakerBoneContentRegistry.SNIPE_AMBIENT.get();

    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {

        return SnakerBoneContentRegistry.SNIPE_HURT.get();

    }

    @Override
    protected SoundEvent getDeathSound() {

        return SnakerBoneContentRegistry.ENTITY_DEATH.get();

    }

    @Override
    public Packet<?> getAddEntityPacket() {

        return NetworkHooks.getEntitySpawningPacket(this);

    }

    @Override
    public void registerControllers(AnimationData data) {

        data.addAnimationController(new AnimationController<>(this, "controller", 0, this::predicate));

    }

    @Override
    public AnimationFactory getFactory() {

        return FACTORY;

    }
}
