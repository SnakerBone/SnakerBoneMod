package snaker.snakerbone.entity.mob;

import net.minecraft.core.BlockPos;
import net.minecraft.network.protocol.Packet;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.RandomSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.network.NetworkHooks;
import snaker.snakerbone.data.AttributeConstants;
import snaker.snakerbone.entity.base.MobBase;
import snaker.snakerbone.registry.ContentRegistry;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.builder.ILoopType;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;
import software.bernie.geckolib3.util.GeckoLibUtil;

/**
 * Created by SnakerBone on 02/01/2023
 **/
public class Flare extends MobBase implements IAnimatable {
    private final AnimationFactory FACTORY = GeckoLibUtil.createFactory(this);

    public Flare(EntityType<? extends MobBase> type, Level world) {
        super(type, world);
    }

    private <E extends IAnimatable> PlayState predicate(AnimationEvent<E> entity) {
        entity.getController().setAnimation(new AnimationBuilder().addAnimation("animation.flare.living", ILoopType.EDefaultLoopTypes.LOOP));
        return PlayState.CONTINUE;
    }

    public static boolean spawnRules(EntityType<Flare> type, ServerLevelAccessor world, MobSpawnType reason, BlockPos pos, RandomSource random) {
        return world.getLevel().getBlockState(pos) != Blocks.LAVA.defaultBlockState();
    }

    public static AttributeSupplier attributes() {
        return Monster.createMobAttributes()
                .add(Attributes.MAX_HEALTH, AttributeConstants.FLARE_HEALTH)
                .add(Attributes.ATTACK_DAMAGE, AttributeConstants.FLARE_ATTACK)
                .add(Attributes.FOLLOW_RANGE, AttributeConstants.FOLLOW_RANGE)
                .add(Attributes.ATTACK_SPEED, AttributeConstants.ATTACK_SPEED)
                .add(Attributes.MOVEMENT_SPEED, AttributeConstants.MOVEMENT_SPEED).build();
    }

    @Override
    public boolean doHurtTarget(Entity entity) {
        entity.setSecondsOnFire(5);
        return super.doHurtTarget(entity);
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return SoundEvents.BLAZE_AMBIENT;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundEvents.BLAZE_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return ContentRegistry.ENTITY_DEATH.get();
    }

    @Override
    public boolean fireImmune() {
        return true;
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
