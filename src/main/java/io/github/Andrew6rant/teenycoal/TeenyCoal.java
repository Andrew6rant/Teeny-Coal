package io.github.Andrew6rant.teenycoal;

import io.github.Andrew6rant.teenycoal.block.TeenyRedstoneTorch;
import io.github.Andrew6rant.teenycoal.block.TeenyRedstoneWallTorch;
import io.github.Andrew6rant.teenycoal.block.TeenyTorch;
import io.github.Andrew6rant.teenycoal.block.TeenyWallTorch;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.*;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Direction;

import static io.github.Andrew6rant.teenycoal.EnergizedRedstoneCompat.energizedRedstoneCompat;

public class TeenyCoal implements ModInitializer {

	public static final ItemGroup ITEM_GROUP = FabricItemGroup.builder(new Identifier("teenycoal", "general"))
			//.displayName(Text.literal("Example Item Group"))
			.icon(() -> new ItemStack(TeenyCoal.TEENY_TORCH))
			//.entries((enabledFeatures, entries, operatorEnabled) -> {
			//	entries.add(Items.DIAMOND);
			//})
			.build();

	//public static final ItemGroup ITEM_GROUP = FabricItemGroupBuilder.build(
	//		new Identifier("teenycoal", "general"),
	//		() -> new ItemStack(TeenyCoal.TEENY_TORCH));

	public static void registerItem(String itemName, Item item) {
		Registry.register(Registries.ITEM, new Identifier("teenycoal", itemName), item);
		ItemGroupEvents.modifyEntriesEvent(TeenyCoal.ITEM_GROUP).register(entries -> entries.add(item));
	}
	public static void registerTorch(String torchName, Block torch, String wallTorchName, Block wallTorch) {
		Registry.register(Registries.BLOCK, new Identifier("teenycoal", torchName), torch);
		Registry.register(Registries.BLOCK, new Identifier("teenycoal", wallTorchName), wallTorch);
		Registry.register(Registries.ITEM, new Identifier("teenycoal", torchName), new VerticallyAttachableBlockItem(torch, wallTorch, new FabricItemSettings(), Direction.DOWN));
		ItemGroupEvents.modifyEntriesEvent(TeenyCoal.ITEM_GROUP).register(entries -> entries.add(torch));
	}
	public static void registerFuel(Item item, int value) {
		FuelRegistry.INSTANCE.add(item, value);
	}

	public static final TeenyTorch TEENY_TORCH = new TeenyTorch(FabricBlockSettings.of(Material.DECORATION).nonOpaque().noCollision().luminance(10), ParticleTypes.FLAME);
	public static final TeenyWallTorch TEENY_WALL_TORCH = new TeenyWallTorch(FabricBlockSettings.of(Material.DECORATION).nonOpaque().noCollision().luminance(10), ParticleTypes.FLAME);
	public static final TeenyRedstoneTorch TEENY_REDSTONE_TORCH = new TeenyRedstoneTorch(FabricBlockSettings.of(Material.DECORATION).nonOpaque().noCollision().luminance(4));
	public static final TeenyRedstoneWallTorch TEENY_REDSTONE_WALL_TORCH = new TeenyRedstoneWallTorch(FabricBlockSettings.of(Material.DECORATION).nonOpaque().noCollision().luminance(4));
	public static final TeenyTorch TEENY_SOUL_TORCH = new TeenyTorch(FabricBlockSettings.of(Material.DECORATION).nonOpaque().noCollision().luminance(8), ParticleTypes.SOUL_FIRE_FLAME);
	public static final TeenyWallTorch TEENY_SOUL_WALL_TORCH = new TeenyWallTorch(FabricBlockSettings.of(Material.DECORATION).nonOpaque().noCollision().luminance(8), ParticleTypes.SOUL_FIRE_FLAME);
	public static final Item TEENY_COAL = new Item(new Item.Settings());
	public static final Item TEENY_CHARCOAL = new Item(new Item.Settings());
	public static final Item TEENY_STICK = new Item(new Item.Settings());
	public static final Item SOUL_DUST = new Item(new Item.Settings());
	public static final Item TEENY_REDSTONE_DUST = new Item(new Item.Settings());

	@Override
	public void onInitialize() {
		registerTorch(Names.TEENY_TORCH, TEENY_TORCH, Names.TEENY_WALL_TORCH, TEENY_WALL_TORCH);
		registerTorch(Names.TEENY_REDSTONE_TORCH, TEENY_REDSTONE_TORCH, Names.TEENY_REDSTONE_WALL_TORCH, TEENY_REDSTONE_WALL_TORCH);
		registerTorch(Names.TEENY_SOUL_TORCH, TEENY_SOUL_TORCH, Names.TEENY_SOUL_WALL_TORCH, TEENY_SOUL_WALL_TORCH);
		registerItem(Names.TEENY_CHARCOAL, TEENY_CHARCOAL);	registerFuel(TEENY_CHARCOAL, 200);
		registerItem(Names.TEENY_COAL, TEENY_COAL);			registerFuel(TEENY_COAL, 200);
		registerItem(Names.TEENY_STICK, TEENY_STICK);		registerFuel(TEENY_STICK, 15);
		registerItem(Names.SOUL_DUST, SOUL_DUST);
		registerItem(Names.TEENY_REDSTONE_DUST, TEENY_REDSTONE_DUST);

		if (FabricLoader.getInstance().isModLoaded("energized_redstone")) {
			energizedRedstoneCompat();
		}
	}
}