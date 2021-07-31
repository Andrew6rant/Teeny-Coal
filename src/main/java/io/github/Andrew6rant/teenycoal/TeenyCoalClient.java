package io.github.Andrew6rant.teenycoal;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.block.Block;
import net.minecraft.client.render.RenderLayer;

public class TeenyCoalClient implements ClientModInitializer {

    public static void registerCutout(Block block) {
        BlockRenderLayerMap.INSTANCE.putBlock(block, RenderLayer.getCutout());
    }

    @Override
    public void onInitializeClient() {
        registerCutout(TeenyCoal.TEENY_TORCH);
        registerCutout(TeenyCoal.TEENY_WALL_TORCH);
        registerCutout(TeenyCoal.TEENY_REDSTONE_TORCH);
        registerCutout(TeenyCoal.TEENY_REDSTONE_WALL_TORCH);
        registerCutout(TeenyCoal.TEENY_SOUL_TORCH);
        registerCutout(TeenyCoal.TEENY_SOUL_WALL_TORCH);
    }
}
