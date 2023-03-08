package snaker.snakerbone.entity.projectile.laser;

import net.minecraft.network.protocol.Packet;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraftforge.network.NetworkHooks;
import snaker.snakerbone.registry.SnakerBoneContentRegistry;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;
import software.bernie.geckolib3.util.GeckoLibUtil;

import static snaker.snakerbone.util.SnakerBonePolicy.WarningSuppression.CUSTOM_SET;

/**
 * Created by SnakerBone on 20/02/2023
 **/
@SuppressWarnings(CUSTOM_SET)
public class Laser extends AbstractArrow implements IAnimatable {
    private final AnimationFactory FACTORY = GeckoLibUtil.createFactory(this);

    public Laser(EntityType<? extends AbstractArrow> type, Level world) {

        super(type, world);

    }

    public Laser(EntityType<? extends AbstractArrow> type, double x, double y, double z, Level world) {

        super(type, x, y, z, world);

    }

    public Laser(EntityType<? extends AbstractArrow> type, LivingEntity shooter, Level world) {

        super(type, shooter, world);

    }

    /**
     * This entity has no animations to play so we will continue...
     **/
    private <E extends IAnimatable> PlayState predicate(AnimationEvent<E> entity) {

        return PlayState.CONTINUE;

    }

    @Override
    protected void onHitEntity(EntityHitResult result) {

        DamageSource source = DamageSource.arrow(this, null);

        result.getEntity().hurt(source, 8);

        kill();

    }

    @Override
    protected void onHitBlock(BlockHitResult result) {

        kill();

    }

    @Override
    public void tick() {

        super.tick();

        if (!level.isClientSide) {

            this.setNoGravity(true);

        }

        if (tickCount > 40) {

            kill();

        }
    }

    @Override
    protected SoundEvent getDefaultHitGroundSoundEvent() {

        return SnakerBoneContentRegistry.BULLET.get();

    }

    @Override
    protected ItemStack getPickupItem() {

        return ItemStack.EMPTY;

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
