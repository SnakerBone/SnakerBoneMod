package snaker.snakerbone.entity.mob;

import net.minecraft.Util;
import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.Tags;
import org.jetbrains.annotations.Nullable;
import snaker.snakerbone.data.AttributeConstants;
import snaker.snakerbone.entity.MobVariants;
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
 * Created by SnakerBone on 2/01/2023
 **/
public class Cosmo extends MobBase implements IAnimatable {
    private static final EntityDataAccessor<Integer> VARIANT_ID = SynchedEntityData.defineId(Cosmo.class, EntityDataSerializers.INT);
    private final AnimationFactory FACTORY = GeckoLibUtil.createFactory(this);

    public Cosmo(EntityType<? extends Monster> type, Level world) {
        super(type, world);
    }

    private <E extends IAnimatable> PlayState predicate(AnimationEvent<E> entity) {
        if (entity.isMoving()) {
            entity.getController().setAnimation(new AnimationBuilder().addAnimation("animation.cosmo.walk", ILoopType.EDefaultLoopTypes.LOOP));
        } else {
            entity.getController().setAnimation(new AnimationBuilder().addAnimation("animation.cosmo.idle", ILoopType.EDefaultLoopTypes.LOOP));
        }
        return PlayState.CONTINUE;
    }

    public static boolean spawnRules(EntityType<Cosmo> type, ServerLevelAccessor world, MobSpawnType reason, BlockPos pos, RandomSource random) {
        if (world.getLevel().dimension() == Level.OVERWORLD) {
            return Monster.checkMonsterSpawnRules(type, world, reason, pos, random);
        }
        if (world.getLevel().dimension() == Level.NETHER) {
            return world.getLevel().getBlockState(pos) != Blocks.LAVA.defaultBlockState();
        }
        if (world.getLevel().dimension() == Level.END) {
            return true;
        }
        return Monster.checkMonsterSpawnRules(type, world, reason, pos, random);
    }

    public static AttributeSupplier attributes() {
        return Monster.createMobAttributes()
                .add(Attributes.MAX_HEALTH, AttributeConstants.COSMO_HEALTH)
                .add(Attributes.ATTACK_DAMAGE, AttributeConstants.COSMO_ATTACK)
                .add(Attributes.FOLLOW_RANGE, AttributeConstants.FOLLOW_RANGE)
                .add(Attributes.ATTACK_SPEED, AttributeConstants.ATTACK_SPEED)
                .add(Attributes.MOVEMENT_SPEED, AttributeConstants.MOVEMENT_SPEED).build();
    }

    public SpawnGroupData finalizeSpawn(ServerLevelAccessor accessor, DifficultyInstance difficulty, MobSpawnType reason, @Nullable SpawnGroupData group, @Nullable CompoundTag tag) {
        MobVariants.Cosmo variant = Util.getRandom(MobVariants.Cosmo.values(), random);
        MobVariants.Cosmo end = MobVariants.Cosmo.PURPLE;
        MobVariants.Cosmo nether = MobVariants.Cosmo.RED;
        MobVariants.Cosmo alpha = MobVariants.Cosmo.ALPHA;
        boolean isNether = accessor.getLevel().dimension() == Level.NETHER;
        boolean isEnd = accessor.getLevel().dimension() == Level.END;
        boolean alphaFlag = variant == alpha && random.nextInt(36) == 0;
        if (isNether) {
            setVariant(nether);
            if (alphaFlag) {
                setVariant(alpha);
            }
        } else if (isEnd) {
            setVariant(end);
            if (alphaFlag) {
                setVariant(alpha);
            }
        } else {
            setVariant(variant);
            if (alphaFlag) {
                setVariant(alpha);
            }
        }
        return super.finalizeSpawn(accessor, difficulty, reason, group, tag);
    }

    @Override
    public boolean hurt(DamageSource source, float amount) {
        Player player = Minecraft.getInstance().player;
        ItemStack heldItem = player.getItemInHand(InteractionHand.MAIN_HAND);
        if (player.isCreative()) {
            return super.hurt(source, amount);
        }
        if (!player.isCreative() && heldItem.is(Tags.Items.STONE)) {
            return super.hurt(source, getMaxHealth() / random.nextInt(4, 8));
        }
        return false;
    }

    @Override
    public boolean fireImmune() {
        return getVariant().getId() == 1;
    }

    @Override
    public boolean doHurtTarget(Entity entity) {
        LivingEntity target = getTarget();
        if (target == null) {
            return false;
        }
        if (getVariant().getId() == 6) {
            target.addEffect(new MobEffectInstance(MobEffects.BLINDNESS, 25, 1));
            target.teleportTo(target.getRandomX(16), target.getY(), target.getRandomZ(16));
            level.playSound(null, target.getX(), target.getY(), target.getZ(), SoundEvents.FOX_TELEPORT, SoundSource.BLOCKS, 1, 1);
        }
        return super.doHurtTarget(target);
    }

    public MobVariants.Cosmo getVariant() {
        return MobVariants.Cosmo.byId(this.getTypeVariant() & 255);
    }

    private int getTypeVariant() {
        return entityData.get(VARIANT_ID);
    }

    private void setVariant(MobVariants.Cosmo variant) {
        entityData.set(VARIANT_ID, variant.getId() & 255);
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        entityData.define(VARIANT_ID, 0);
    }

    @Override
    public void readAdditionalSaveData(CompoundTag tag) {
        super.readAdditionalSaveData(tag);
        entityData.set(VARIANT_ID, tag.getInt("Variant"));
    }

    @Override
    public void addAdditionalSaveData(CompoundTag tag) {
        super.addAdditionalSaveData(tag);
        tag.putInt("Variant", getTypeVariant());
    }

    @Nullable
    @Override
    protected SoundEvent getAmbientSound() {
        return SoundEvents.SCULK_CLICKING;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return ContentRegistry.COSMO_HURT.get();
    }

    @Override
    protected SoundEvent getDeathSound() {
        return ContentRegistry.ENTITY_DEATH.get();
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
