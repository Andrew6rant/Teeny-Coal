package io.github.Andrew6rant.teenycoal.block;

import net.minecraft.block.BlockState;
import net.minecraft.block.TorchBlock;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.Random;

public class TeenyTorch extends TorchBlock {
    public TeenyTorch(Settings settings, ParticleEffect particle){
        super(settings, particle);
    }
    @Override
    public void randomDisplayTick(BlockState state, World world, BlockPos pos, Random random){
        double d = (double)pos.getX() + 0.5D;
        double e = (double)pos.getY() + 0.4D;
        double f = (double)pos.getZ() + 0.5D;
        world.addParticle(ParticleTypes.SMOKE, d, e, f, 0.0D, 0.0D, 0.0D);
        world.addParticle(this.particle, d, e, f, 0.0D, 0.0D, 0.0D);
    }
}
