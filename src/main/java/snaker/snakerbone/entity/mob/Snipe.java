package snaker.snakerbone.entity.mob;

import net.minecraft.core.BlockPos;
import net.minecraft.network.protocol.Packet;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.util.RandomSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraftforge.network.NetworkHooks;
import org.jetbrains.annotations.NotNull;
import snaker.snakerbone.data.AttributeConstants;
import snaker.snakerbone.entity.ai.DodgeProjectileGoal;
import snaker.snakerbone.entity.ai.LaserAttackGoal;
import snaker.snakerbone.entity.base.FlyingMobBase;
import snaker.snakerbone.registry.ContentRegistry;
import snaker.snakerbone.utility.Utilities;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.controller.AnimationController;
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

    public static AttributeSupplier attributes() {
        return Monster.createMobAttributes()
                .add(net.minecraft.world.entity.ai.attributes.Attributes.MAX_HEALTH, AttributeConstants.SNIPE_HEALTH)
                .add(net.minecraft.world.entity.ai.attributes.Attributes.ATTACK_DAMAGE, AttributeConstants.SNIPE_ATTACK)
                .add(net.minecraft.world.entity.ai.attributes.Attributes.ATTACK_SPEED, AttributeConstants.ATTACK_SPEED)
                .add(net.minecraft.world.entity.ai.attributes.Attributes.FOLLOW_RANGE, AttributeConstants.FLYING_FOLLOW_RANGE)
                .add(net.minecraft.world.entity.ai.attributes.Attributes.MOVEMENT_SPEED, AttributeConstants.MOVEMENT_SPEED)
                .add(net.minecraft.world.entity.ai.attributes.Attributes.FLYING_SPEED, AttributeConstants.FLYING_SPEED).build();
    }

    public static boolean spawnRules(EntityType<Snipe> type, ServerLevelAccessor world, MobSpawnType reason, BlockPos pos, RandomSource random) {
        return random.nextInt(8) == 0;
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
        goalSelector.addGoal(9, new DodgeProjectileGoal(this));
        goalSelector.addGoal(4, new LaserAttackGoal(this, 2, 0, 20));
    }

    @Override
    protected @NotNull SoundEvent getAmbientSound() {
        return ContentRegistry.SNIPE_AMBIENT.get();
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return ContentRegistry.SNIPE_HURT.get();
    }

    @Override
    protected SoundEvent getDeathSound() {
        return ContentRegistry.ENTITY_DEATH.get();
    }

    @Override
    public Packet<?> getAddEntityPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }

    @Override
    public void registerControllers(AnimationData data) {
        data.addAnimationController(new AnimationController<>(this, "controller", 0, Utilities::noPlaystate));
    }

    @Override
    public AnimationFactory getFactory() {
        return GeckoLibUtil.createFactory(this);
    }
}
