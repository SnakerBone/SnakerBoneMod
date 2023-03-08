package snaker.snakerbone.block.shader.snow;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
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
 * Created by SnakerBone on 22/02/2023
 **/
@SuppressWarnings(CUSTOM_SET)
public class SnowBlockEntity extends BlockEntity implements IAnimatable {
    private final AnimationFactory FACTORY = GeckoLibUtil.createFactory(this);

    public SnowBlockEntity(BlockPos pos, BlockState state) {

        super(SnakerBoneContentRegistry.SNOW_BE.get(), pos, state);

    }

    /**
     * This has no animations to play so we will continue...
     **/
    private <E extends IAnimatable> PlayState predicate(AnimationEvent<E> entity) {

        return PlayState.CONTINUE;

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