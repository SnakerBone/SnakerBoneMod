package snaker.snakerbone.block.shader.watercolour;

import net.minecraft.core.BlockPos;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;
import snaker.snakerbone.registry.SnakerBoneContentRegistry;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;
import software.bernie.geckolib3.util.GeckoLibUtil;

/**
 * Created by SnakerBone on 22/02/2023
 **/
public class WaterColourBlockEntity extends BlockEntity implements IAnimatable {
    private final AnimationFactory FACTORY = GeckoLibUtil.createFactory(this);

    public WaterColourBlockEntity(BlockPos pos, BlockState state) {

        super(SnakerBoneContentRegistry.WATERCOLOUR_BE.get(), pos, state);

    }

    /**
     * This has no animations to play so we will continue...
     **/
    private <E extends IAnimatable> PlayState predicate(AnimationEvent<E> entity) {

        return PlayState.CONTINUE;

    }

    @Nullable
    @Override
    public Packet<ClientGamePacketListener> getUpdatePacket() {

        return ClientboundBlockEntityDataPacket.create(this);

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