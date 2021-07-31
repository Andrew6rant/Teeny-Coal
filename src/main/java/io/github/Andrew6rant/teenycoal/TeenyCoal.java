package io.github.Andrew6rant.teenycoal;

import io.github.Andrew6rant.teenycoal.block.TeenyTorch;
import io.github.Andrew6rant.teenycoal.block.TeenyWallTorch;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.*;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class TeenyCoal implements ModInitializer {

	public static final ItemGroup ITEM_GROUP = FabricItemGroupBuilder.build(
			new Identifier("teenycoal", "general"),
			() -> new ItemStack(TeenyCoal.TEENY_TORCH));

	public static void registerItem(String itemName, Item item) {
		Registry.register(Registry.ITEM, new Identifier("teenycoal", itemName), item);
	}
	public static void registerTorch(String torchName, Block torch, String wallTorchName, Block wallTorch) {
		Registry.register(Registry.BLOCK, new Identifier("teenycoal", torchName), torch);
		Registry.register(Registry.BLOCK, new Identifier("teenycoal", wallTorchName), wallTorch);
		Registry.register(Registry.ITEM, new Identifier("teenycoal", torchName), new WallStandingBlockItem(torch, wallTorch, new Item.Settings().group(TeenyCoal.ITEM_GROUP)));
	}
	public static void registerFuel(Object blockOrItem, int value) {
		FuelRegistry.INSTANCE.add((ItemConvertible) blockOrItem, value);
	}

	public static final TeenyTorch TEENY_TORCH = new TeenyTorch(FabricBlockSettings.of(Material.DECORATION).nonOpaque().noCollision().luminance(10), ParticleTypes.FLAME);
	public static final TeenyWallTorch TEENY_WALL_TORCH = new TeenyWallTorch(FabricBlockSettings.of(Material.DECORATION).nonOpaque().noCollision().luminance(10), ParticleTypes.FLAME);
	public static final TeenyTorch TEENY_REDSTONE_TORCH = new TeenyTorch(FabricBlockSettings.of(Material.DECORATION).nonOpaque().luminance(10), ParticleTypes.FLAME);
	public static final TeenyWallTorch TEENY_REDSTONE_WALL_TORCH = new TeenyWallTorch(FabricBlockSettings.of(Material.DECORATION).nonOpaque().luminance(10), ParticleTypes.FLAME);
	public static final Item TEENY_COAL = new Item(new Item.Settings().group(TeenyCoal.ITEM_GROUP));
	public static final Item TEENY_CHARCOAL = new Item(new Item.Settings().group(TeenyCoal.ITEM_GROUP));

	@Override
	public void onInitialize() {
		registerTorch(Names.TEENY_TORCH, TEENY_TORCH, Names.TEENY_WALL_TORCH, TEENY_WALL_TORCH);
		registerItem(Names.TEENY_CHARCOAL, TEENY_CHARCOAL);	registerFuel(TEENY_CHARCOAL, 10);
		registerItem(Names.TEENY_COAL, TEENY_COAL);	registerFuel(TEENY_COAL, 10);
	}
}