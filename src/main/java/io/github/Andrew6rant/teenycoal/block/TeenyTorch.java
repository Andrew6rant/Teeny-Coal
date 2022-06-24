package io.github.Andrew6rant.teenycoal.block;

import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.block.TorchBlock;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

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
    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView view, BlockPos pos, ShapeContext context) {
        return VoxelShapes.cuboid(0.375f, 0f, 0.375f, 0.625f, 0.375f, 0.625f);
    }
}
