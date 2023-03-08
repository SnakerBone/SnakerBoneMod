package snaker.snakerbone.block.shader.fire;

import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.extensions.common.IClientItemExtensions;
import snaker.snakerbone.block.shader.fire.render.FireBlockItemRender;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;
import software.bernie.geckolib3.util.GeckoLibUtil;

import java.util.function.Consumer;

import static snaker.snakerbone.util.SnakerBonePolicy.WarningSuppression.CUSTOM_SET;

/**
 * Created by SnakerBone on 22/02/2023
 **/
@SuppressWarnings(CUSTOM_SET)
public class FireBlockItem extends BlockItem implements IAnimatable {
    private final AnimationFactory FACTORY = GeckoLibUtil.createFactory(this);

    public FireBlockItem(Block block, Properties properties) {

        super(block, properties);

    }

    /**
     * This has no animations to play so we will continue...
     **/
    private <E extends IAnimatable> PlayState predicate(AnimationEvent<E> entity) {

        return PlayState.CONTINUE;

    }

    @Override
    public void initializeClient(Consumer<IClientItemExtensions> consumer) {

        super.initializeClient(consumer);

        consumer.accept(new IClientItemExtensions() {

            private final BlockEntityWithoutLevelRenderer bewlr = new FireBlockItemRender();

            @Override
            public BlockEntityWithoutLevelRenderer getCustomRenderer() {

                return bewlr;

            }

        });

    }

    ;

    @Override
    public void registerControllers(AnimationData data) {

        data.addAnimationController(new AnimationController<>(this, "controller", 0, this::predicate));

    }

    @Override
    public AnimationFactory getFactory() {

        return FACTORY;

    }
}
