package io.github.Andrew6rant.teenycoal.block;

import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.block.WallRedstoneTorchBlock;
import net.minecraft.particle.DefaultParticleType;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

import java.util.Random;

public class TeenyRedstoneWallTorch extends WallRedstoneTorchBlock {

    public TeenyRedstoneWallTorch(Settings settings) {
        super(settings);
    }
    @Override
    public int getWeakRedstonePower(BlockState state, BlockView world, BlockPos pos, Direction direction) {
        return state.get(LIT) && state.get(FACING) != direction ? 7 : 0;
    }
    @Override
    public void randomDisplayTick(BlockState state, World world, BlockPos pos, Random random){
        boolean lit = state.get(LIT);
        Direction direction = state.get(FACING).getOpposite();
        double d = (double)pos.getX() + 0.5D;
        double e = (double)pos.getY() + 0.4D;
        double f = (double)pos.getZ() + 0.5D;
        if (lit) {
            world.addParticle(this.particle, d + 0.37D * (double)direction.getOffsetX(), e + 0.22D, f + 0.37D * (double)direction.getOffsetZ(), 0.0D, 0.0D, 0.0D);
        }
    }
    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView view, BlockPos pos, ShapeContext context) {
        Direction direction = state.get(FACING);
        // Switch statements can't be used if I want 1.16 support in the same jar :(
        // Would've been able to do this:
        //
        // return switch (direction){
        //     case NORTH: VoxelShapes.cuboid(0.34375f, 0.1875f, 0.75f, 0.65625f, 0.625f, 1f);
        //     case SOUTH: VoxelShapes.cuboid(0.34375f, 0.1875f, 0f, 0.65625f, 0.625f, 0.25f);
        //     case EAST: VoxelShapes.cuboid(0f, 0.1875f, 0.34375f, 0.25f, 0.625f, 0.65625f);
        //     case WEST: VoxelShapes.cuboid(0.75f, 0.1875f, 0.34375f, 1f, 0.625f, 0.65625f);
        // }

        if(direction.equals(Direction.NORTH)) {
            return VoxelShapes.cuboid(0.34375f, 0.1875f, 0.75f, 0.65625f, 0.625f, 1f);
        } else if (direction.equals(Direction.SOUTH)) {
            return VoxelShapes.cuboid(0.34375f, 0.1875f, 0f, 0.65625f, 0.625f, 0.25f);
        } else if (direction.equals(Direction.EAST)) {
            return VoxelShapes.cuboid(0f, 0.1875f, 0.34375f, 0.25f, 0.625f, 0.65625f);
        } else if (direction.equals(Direction.WEST)) {
            return VoxelShapes.cuboid(0.75f, 0.1875f, 0.34375f, 1f, 0.625f, 0.65625f);
        } else {
            return VoxelShapes.cuboid(0.375f, 0f, 0.375f, 0.625f, 0.4375f, 0.625f);
            // This should never be called, but just in case, it defaults to the default Teeny Redstone Torch cuboid
        }
    }
}
