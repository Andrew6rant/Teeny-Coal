package io.github.Andrew6rant.teenycoal;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.render.RenderLayer;

public class TeenyCoalClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(TeenyCoal.TEENY_TORCH, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(TeenyCoal.TEENY_WALL_TORCH, RenderLayer.getCutout());
    }
}
