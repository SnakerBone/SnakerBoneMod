package snaker.snakerbone.item;

import net.minecraft.world.item.Item;
import snaker.snakerbone.utility.Utilities;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;
import software.bernie.geckolib3.util.GeckoLibUtil;

/**
 * Created by SnakerBone on 11/03/2023
 **/
public class CosmoSpine extends Item implements IAnimatable {
    public CosmoSpine(Properties properties) {
        super(properties);
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
