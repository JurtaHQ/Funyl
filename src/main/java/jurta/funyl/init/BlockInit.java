package jurta.funyl.init;

import jurta.funyl.Funyl;
import jurta.funyl.objects.items.FunylItemGroup;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.registries.ObjectHolder;

@ObjectHolder(Funyl.MOD_ID)
@Mod.EventBusSubscriber(modid = Funyl.MOD_ID, bus = Bus.MOD)
public class BlockInit {
	public static final Block SEMENITE_ORE = null;
	public static final Block SEMENITE_BLOCK = null;
	
	@SubscribeEvent
	public static void registerBlocks(final RegistryEvent.Register<Block> event)
	{
		event.getRegistry().register(new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(4.5f, 3.0f).sound(SoundType.STONE).harvestLevel(3).harvestTool(ToolType.PICKAXE)).setRegistryName("semenite_ore"));
		event.getRegistry().register(new Block(Block.Properties.create(Material.IRON).hardnessAndResistance(6.0f, 30.0f).sound(SoundType.METAL).harvestLevel(3).harvestTool(ToolType.PICKAXE)).setRegistryName("semenite_block"));
	}
	
	@SubscribeEvent
	public static void registerBlockItems(final RegistryEvent.Register<Item> event)
	{
		event.getRegistry().register(new BlockItem(SEMENITE_ORE, new Item.Properties().group(FunylItemGroup.FUNYL)).setRegistryName("semenite_ore"));
		event.getRegistry().register(new BlockItem(SEMENITE_BLOCK, new Item.Properties().group(FunylItemGroup.FUNYL)).setRegistryName("semenite_block"));
	}
}
