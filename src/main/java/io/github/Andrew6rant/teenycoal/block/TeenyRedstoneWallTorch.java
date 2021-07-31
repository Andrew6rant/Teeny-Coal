package io.github.Andrew6rant.teenycoal.block;

import net.minecraft.block.BlockState;
import net.minecraft.block.WallRedstoneTorchBlock;
import net.minecraft.particle.DefaultParticleType;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
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
}
