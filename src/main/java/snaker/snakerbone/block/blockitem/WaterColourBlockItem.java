package snaker.snakerbone.block.blockitem;

import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.extensions.common.IClientItemExtensions;
import snaker.snakerbone.client.render.block.WaterColourBlockItemRender;
import snaker.snakerbone.utility.Utilities;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;
import software.bernie.geckolib3.util.GeckoLibUtil;

import java.util.function.Consumer;

/**
 * Created by SnakerBone on 22/02/2023
 **/
public class WaterColourBlockItem extends BlockItem implements IAnimatable {
    public WaterColourBlockItem(Block block, Properties properties) {
        super(block, properties);
    }

    @Override
    public void initializeClient(Consumer<IClientItemExtensions> consumer) {
        super.initializeClient(consumer);
        consumer.accept(new IClientItemExtensions() {
            private final BlockEntityWithoutLevelRenderer bewlr = new WaterColourBlockItemRender();

            @Override
            public BlockEntityWithoutLevelRenderer getCustomRenderer() {
                return bewlr;
            }
        });
    }

    @Override
    public void registerControllers(AnimationData data) {
        data.addAnimationController(new AnimationController<>(this, "controller", 0, Utilities::noAnimation));
    }

    @Override
    public AnimationFactory getFactory() {
        return GeckoLibUtil.createFactory(this);
    }
}
