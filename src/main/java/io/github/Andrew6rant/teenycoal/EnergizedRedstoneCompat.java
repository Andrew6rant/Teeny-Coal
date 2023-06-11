package io.github.Andrew6rant.teenycoal;

import io.github.Andrew6rant.teenycoal.block.TeenyRedstoneTorch;
import io.github.Andrew6rant.teenycoal.block.TeenyRedstoneWallTorch;
import io.github.Andrew6rant.teenycoal.compat.TeenyEnergizedRedstoneTorch;
import io.github.Andrew6rant.teenycoal.compat.TeenyEnergizedRedstoneWallTorch;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Blocks;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.item.Item;

import static io.github.Andrew6rant.teenycoal.TeenyCoal.registerItem;
import static io.github.Andrew6rant.teenycoal.TeenyCoal.registerTorch;

public class EnergizedRedstoneCompat {

    public static final TeenyRedstoneTorch TEENY_ENERGIZED_REDSTONE_TORCH = new TeenyEnergizedRedstoneTorch(FabricBlockSettings.copyOf(Blocks.REDSTONE_TORCH).nonOpaque().noCollision().luminance(10));
    public static final TeenyRedstoneWallTorch TEENY_ENERGIZED_REDSTONE_WALL_TORCH = new TeenyEnergizedRedstoneWallTorch(FabricBlockSettings.copyOf(Blocks.REDSTONE_WALL_TORCH).nonOpaque().noCollision().luminance(10));
    public static final Item TEENY_ENERGIZED_REDSTONE_DUST = new Item(new Item.Settings());

    public static void energizedRedstoneCompat() {
        //TeenyRedstoneTorch TEENY_ENERGIZED_REDSTONE_TORCH = new TeenyEnergizedRedstoneTorch(FabricBlockSettings.of(Material.DECORATION).nonOpaque().noCollision().luminance(10));
        //TeenyRedstoneWallTorch TEENY_ENERGIZED_REDSTONE_WALL_TORCH = new TeenyEnergizedRedstoneWallTorch(FabricBlockSettings.of(Material.DECORATION).nonOpaque().noCollision().luminance(10));
        registerTorch("energized_redstone", Names.TEENY_ENERGIZED_REDSTONE_TORCH, TEENY_ENERGIZED_REDSTONE_TORCH, Names.TEENY_ENERGIZED_REDSTONE_WALL_TORCH, TEENY_ENERGIZED_REDSTONE_WALL_TORCH);
        registerItem("energized_redstone", Names.TEENY_ENERGIZED_REDSTONE_DUST, TEENY_ENERGIZED_REDSTONE_DUST);
    }

    public static void energizedRedstoneClientCompat() {
        BlockRenderLayerMap.INSTANCE.putBlock(TEENY_ENERGIZED_REDSTONE_TORCH, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(TEENY_ENERGIZED_REDSTONE_WALL_TORCH, RenderLayer.getCutout());
    }
}

