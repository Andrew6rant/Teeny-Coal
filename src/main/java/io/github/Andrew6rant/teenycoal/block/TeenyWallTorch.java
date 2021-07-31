package io.github.Andrew6rant.teenycoal.block;

import net.minecraft.block.BlockState;
import net.minecraft.block.WallTorchBlock;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;

import java.util.Random;

public class TeenyWallTorch extends WallTorchBlock {
    public TeenyWallTorch(Settings settings, ParticleEffect particle){
        super(settings, particle);
    }
    @Override
    public void randomDisplayTick(BlockState state, World world, BlockPos pos, Random random){
        Direction direction = state.get(FACING);
        double d = (double)pos.getX() + 0.5D;
        double e = (double)pos.getY() + 0.4D;
        double f = (double)pos.getZ() + 0.5D;
        Direction direction2 = direction.getOpposite();
        world.addParticle(ParticleTypes.SMOKE, d + 0.37D * (double)direction2.getOffsetX(), e + 0.22D, f + 0.37D * (double)direction2.getOffsetZ(), 0.0D, 0.0D, 0.0D);
        world.addParticle(this.particle, d + 0.37D * (double)direction2.getOffsetX(), e + 0.22D, f + 0.37D * (double)direction2.getOffsetZ(), 0.0D, 0.0D, 0.0D);
    }
}
