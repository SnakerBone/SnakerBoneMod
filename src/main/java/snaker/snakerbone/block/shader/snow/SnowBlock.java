package snaker.snakerbone.block.shader.snow;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;
import snaker.snakerbone.registry.SnakerBoneContentRegistry;

import static net.minecraft.world.level.material.Material.METAL;
import static snaker.snakerbone.util.SnakerBonePolicy.WarningSuppression.CUSTOM_SET;

/**
 * Created by SnakerBone on 22/02/2023
 **/
@SuppressWarnings(CUSTOM_SET)
public class SnowBlock extends BaseEntityBlock {

    public SnowBlock() {

        super(Properties.of(METAL).requiresCorrectToolForDrops().strength(5));

    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {

        return SnakerBoneContentRegistry.SNOW_BE.get().create(pos, state);

    }

    @Override
    public RenderShape getRenderShape(BlockState state) {

        return RenderShape.ENTITYBLOCK_ANIMATED;

    }
}
