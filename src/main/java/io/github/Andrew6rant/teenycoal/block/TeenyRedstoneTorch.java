package io.github.Andrew6rant.teenycoal.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.RedstoneTorchBlock;
import net.minecraft.particle.DefaultParticleType;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

import java.util.Random;

public class TeenyRedstoneTorch extends RedstoneTorchBlock {
    public TeenyRedstoneTorch(Settings settings) {
        super(settings);
    }
    @Override
    public int getWeakRedstonePower(BlockState state, BlockView world, BlockPos pos, Direction direction) {
        return state.get(LIT) && Direction.UP != direction ? 7 : 0;
    }
    public void randomDisplayTick(BlockState state, World world, BlockPos pos, Random random){
        boolean lit = state.get(LIT);
        double d = (double)pos.getX() + 0.5D;
        double e = (double)pos.getY() + 0.4D;
        double f = (double)pos.getZ() + 0.5D;
        if (lit) {
            world.addParticle(this.particle, d, e, f, 0.0D, 0.0D, 0.0D);
        }
    }
}
