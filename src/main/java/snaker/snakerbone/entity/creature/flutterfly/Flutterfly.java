package snaker.snakerbone.entity.creature.flutterfly;

import net.minecraft.core.BlockPos;
import net.minecraft.network.protocol.Packet;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.AvoidEntityGoal;
import net.minecraft.world.entity.ai.goal.BreedGoal;
import net.minecraft.world.entity.ai.goal.TemptGoal;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.animal.Parrot;
import net.minecraft.world.entity.monster.Spider;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraftforge.network.NetworkHooks;
import snaker.snakerbone.data.SnakerBoneAttributes;
import snaker.snakerbone.entity.base.FlyingCreatureBase;
import snaker.snakerbone.registry.SnakerBoneContentRegistry;
import snaker.snakerbone.registry.SnakerBoneEntityRegistry;
import snaker.snakerbone.util.SnakerBonePolicy;
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

/**
 * Created by SnakerBone on 2/01/2023
 **/
@SuppressWarnings(SnakerBonePolicy.WarningSuppression.CUSTOM_SET)
public class Flutterfly extends FlyingCreatureBase implements IAnimatable {
    private final AnimationFactory FACTORY = GeckoLibUtil.createFactory(this);

    public Flutterfly(EntityType<? extends FlyingCreatureBase> type, Level world) {

        super(type, world);

    }

    private <E extends IAnimatable> PlayState predicate(AnimationEvent<E> entity) {

        entity.getController().setAnimation(new AnimationBuilder().addAnimation("animation.flutterfly.fly", ILoopType.EDefaultLoopTypes.LOOP));

        return PlayState.CONTINUE;
    }

    public static boolean spawnRules(EntityType<Flutterfly> type, ServerLevelAccessor world, MobSpawnType reason, BlockPos pos, RandomSource random) {

        return true;

    }

    public static AttributeSupplier attributes() {
        return Animal.createMobAttributes()
                .add(Attributes.MAX_HEALTH, SnakerBoneAttributes.FLUTTERFLY_HEALTH)
                .add(Attributes.MOVEMENT_SPEED, SnakerBoneAttributes.MOVEMENT_SPEED)
                .add(Attributes.FLYING_SPEED, SnakerBoneAttributes.FLYING_SPEED).build();
    }

    @Override
    protected void registerGoals() {

        super.registerGoals();
        goalSelector.addGoal(3, new BreedGoal(this, 1));
        goalSelector.addGoal(4, new TemptGoal(this, 1.25, Ingredient.of(ItemTags.FLOWERS), false));
        goalSelector.addGoal(6, new AvoidEntityGoal<>(this, Spider.class, 6f, 1D, 1.2D));
        goalSelector.addGoal(6, new AvoidEntityGoal<>(this, Parrot.class, 6f, 1D, 1.2D));

    }

    @Nullable
    @Override
    protected SoundEvent getAmbientSound() {

        return SnakerBoneContentRegistry.FLUTTERFLY_AMBIENT.get();

    }

    @Override
    public InteractionResult mobInteract(Player player, InteractionHand hand) {

        ItemStack stack = player.getItemInHand(hand);

        isFood(stack);

        return super.mobInteract(player, hand);
    }

    @Nullable
    @Override
    public Flutterfly getBreedOffspring(@Nullable ServerLevel server, @Nullable AgeableMob mate) {

        return SnakerBoneEntityRegistry.FLUTTERFLY.get().create(server);

    }

    @Override
    public boolean isFood(ItemStack stack) {

        return stack.is(ItemTags.FLOWERS);

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
