package snaker.snakerbone.item;

import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.extensions.common.IClientItemExtensions;
import snaker.snakerbone.client.render.item.CosmoSpineItemRender;
import snaker.snakerbone.utility.Utilities;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;
import software.bernie.geckolib3.util.GeckoLibUtil;

import java.util.function.Consumer;

/**
 * Created by SnakerBone on 11/03/2023
 **/
public class CosmoSpine {
    public static class Red extends Item implements IAnimatable {
        public Red(Properties properties) {
            super(properties);
        }

        @Override
        public void registerControllers(AnimationData data) {
            data.addAnimationController(new AnimationController<>(this, "controller", 0, Utilities::noPlaystate));
        }

        @Override
        public void initializeClient(Consumer<IClientItemExtensions> consumer) {
            super.initializeClient(consumer);
            consumer.accept(new IClientItemExtensions() {
                private final BlockEntityWithoutLevelRenderer bewlr = new CosmoSpineItemRender.Red();

                @Override
                public BlockEntityWithoutLevelRenderer getCustomRenderer() {
                    return bewlr;
                }
            });
        }

        @Override
        public AnimationFactory getFactory() {
            return GeckoLibUtil.createFactory(this);
        }
    }

    public static class Green extends Item implements IAnimatable {
        public Green(Properties properties) {
            super(properties);
        }

        @Override
        public void registerControllers(AnimationData data) {
            data.addAnimationController(new AnimationController<>(this, "controller", 0, Utilities::noPlaystate));
        }

        @Override
        public void initializeClient(Consumer<IClientItemExtensions> consumer) {
            super.initializeClient(consumer);
            consumer.accept(new IClientItemExtensions() {
                private final BlockEntityWithoutLevelRenderer bewlr = new CosmoSpineItemRender.Green();

                @Override
                public BlockEntityWithoutLevelRenderer getCustomRenderer() {
                    return bewlr;
                }
            });
        }

        @Override
        public AnimationFactory getFactory() {
            return GeckoLibUtil.createFactory(this);
        }
    }

    public static class Blue extends Item implements IAnimatable {
        public Blue(Properties properties) {
            super(properties);
        }

        @Override
        public void registerControllers(AnimationData data) {
            data.addAnimationController(new AnimationController<>(this, "controller", 0, Utilities::noPlaystate));
        }

        @Override
        public void initializeClient(Consumer<IClientItemExtensions> consumer) {
            super.initializeClient(consumer);
            consumer.accept(new IClientItemExtensions() {
                private final BlockEntityWithoutLevelRenderer bewlr = new CosmoSpineItemRender.Blue();

                @Override
                public BlockEntityWithoutLevelRenderer getCustomRenderer() {
                    return bewlr;
                }
            });
        }

        @Override
        public AnimationFactory getFactory() {
            return GeckoLibUtil.createFactory(this);
        }
    }

    public static class Yellow extends Item implements IAnimatable {
        public Yellow(Properties properties) {
            super(properties);
        }

        @Override
        public void registerControllers(AnimationData data) {
            data.addAnimationController(new AnimationController<>(this, "controller", 0, Utilities::noPlaystate));
        }

        @Override
        public void initializeClient(Consumer<IClientItemExtensions> consumer) {
            super.initializeClient(consumer);
            consumer.accept(new IClientItemExtensions() {
                private final BlockEntityWithoutLevelRenderer bewlr = new CosmoSpineItemRender.Yellow();

                @Override
                public BlockEntityWithoutLevelRenderer getCustomRenderer() {
                    return bewlr;
                }
            });
        }

        @Override
        public AnimationFactory getFactory() {
            return GeckoLibUtil.createFactory(this);
        }
    }

    public static class Pink extends Item implements IAnimatable {
        public Pink(Properties properties) {
            super(properties);
        }

        @Override
        public void registerControllers(AnimationData data) {
            data.addAnimationController(new AnimationController<>(this, "controller", 0, Utilities::noPlaystate));
        }

        @Override
        public void initializeClient(Consumer<IClientItemExtensions> consumer) {
            super.initializeClient(consumer);
            consumer.accept(new IClientItemExtensions() {
                private final BlockEntityWithoutLevelRenderer bewlr = new CosmoSpineItemRender.Pink();

                @Override
                public BlockEntityWithoutLevelRenderer getCustomRenderer() {
                    return bewlr;
                }
            });
        }

        @Override
        public AnimationFactory getFactory() {
            return GeckoLibUtil.createFactory(this);
        }
    }

    public static class Purple extends Item implements IAnimatable {
        public Purple(Properties properties) {
            super(properties);
        }

        @Override
        public void registerControllers(AnimationData data) {
            data.addAnimationController(new AnimationController<>(this, "controller", 0, Utilities::noPlaystate));
        }

        @Override
        public void initializeClient(Consumer<IClientItemExtensions> consumer) {
            super.initializeClient(consumer);
            consumer.accept(new IClientItemExtensions() {
                private final BlockEntityWithoutLevelRenderer bewlr = new CosmoSpineItemRender.Purple();

                @Override
                public BlockEntityWithoutLevelRenderer getCustomRenderer() {
                    return bewlr;
                }
            });
        }

        @Override
        public AnimationFactory getFactory() {
            return GeckoLibUtil.createFactory(this);
        }
    }

    public static class Alpha extends Item implements IAnimatable {
        public Alpha(Properties properties) {
            super(properties);
        }

        @Override
        public void registerControllers(AnimationData data) {
            data.addAnimationController(new AnimationController<>(this, "controller", 0, Utilities::noPlaystate));
        }

        @Override
        public void initializeClient(Consumer<IClientItemExtensions> consumer) {
            super.initializeClient(consumer);
            consumer.accept(new IClientItemExtensions() {
                private final BlockEntityWithoutLevelRenderer bewlr = new CosmoSpineItemRender.Alpha();

                @Override
                public BlockEntityWithoutLevelRenderer getCustomRenderer() {
                    return bewlr;
                }
            });
        }

        @Override
        public AnimationFactory getFactory() {
            return GeckoLibUtil.createFactory(this);
        }
    }
}
