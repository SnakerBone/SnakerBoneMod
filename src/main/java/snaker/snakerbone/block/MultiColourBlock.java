package snaker.snakerbone.block;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;
import snaker.snakerbone.registry.SnakerBoneContentRegistry;

import static net.minecraft.world.level.material.Material.METAL;

/**
 * Created by SnakerBone on 22/02/2023
 **/
public class MultiColourBlock extends BaseEntityBlock {
    public MultiColourBlock() {

        super(Properties.of(METAL).requiresCorrectToolForDrops().strength(5));

    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {

        return SnakerBoneContentRegistry.MULTICOLOUR_BE.get().create(pos, state);

    }

    @Override
    public RenderShape getRenderShape(BlockState state) {

        return RenderShape.ENTITYBLOCK_ANIMATED;

    }
}
