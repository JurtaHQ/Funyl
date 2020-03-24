package jurta.funyl.init;

import jurta.funyl.Funyl;
import net.minecraft.block.Block;
import net.minecraft.block.LeavesBlock;
import net.minecraft.block.LogBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BlockInit {
	public static final DeferredRegister<Block> BLOCKS = new DeferredRegister<>(ForgeRegistries.BLOCKS, Funyl.MOD_ID);

	public static final RegistryObject<Block> NETHER_SEMENITE_ORE = BLOCKS.register("nether_semenite_ore", () -> new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(4.5f, 0.4f).sound(SoundType.STONE).harvestLevel(3).harvestTool(ToolType.PICKAXE)));
	public static final RegistryObject<Block> SEMENITE_BLOCK = BLOCKS.register("semenite_block", () -> new Block(Block.Properties.create(Material.IRON).hardnessAndResistance(6.0f, 30.0f).sound(SoundType.METAL).harvestLevel(3).harvestTool(ToolType.PICKAXE)));
	
	public static final RegistryObject<Block> END_BEAMSTONE_ORE = BLOCKS.register("end_beamstone_ore", () -> new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(4.5f, 45.0f).sound(SoundType.STONE).lightValue(9).harvestLevel(2).harvestTool(ToolType.PICKAXE)));
	public static final RegistryObject<Block> BEAMSTONE_BLOCK = BLOCKS.register("beamstone_block", () -> new Block(Block.Properties.create(Material.IRON).hardnessAndResistance(6.0f, 30.0f).sound(SoundType.METAL).lightValue(9).harvestLevel(2).harvestTool(ToolType.PICKAXE)));
	
	public static final RegistryObject<Block> CEDAR_LOG = BLOCKS.register("cedar_log", () -> new LogBlock(MaterialColor.WOOD, Block.Properties.create(Material.WOOD).hardnessAndResistance(2.0f, 2.0f).sound(SoundType.WOOD).harvestLevel(0).harvestTool(ToolType.AXE)));
	public static final RegistryObject<Block> CEDAR_PLANKS = BLOCKS.register("cedar_planks", () -> new Block(Block.Properties.create(Material.WOOD).hardnessAndResistance(2.0f, 3.0f).sound(SoundType.WOOD).harvestLevel(0).harvestTool(ToolType.AXE)));
	public static final RegistryObject<Block> CEDAR_LEAVES = BLOCKS.register("cedar_leaves", () -> new LeavesBlock(Block.Properties.create(Material.LEAVES).hardnessAndResistance(0.2f).sound(SoundType.PLANT).tickRandomly().sound(SoundType.PLANT).notSolid()));
	
	public static final RegistryObject<Block> GROMAR_ORE = BLOCKS.register("gromar_ore", () -> new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(2.0f, 3.0f).sound(SoundType.STONE).harvestLevel(0).harvestTool(ToolType.PICKAXE)));
	public static final RegistryObject<Block> GROMAR_PLANKS = BLOCKS.register("gromar_planks", () -> new Block(Block.Properties.create(Material.WOOD).hardnessAndResistance(2.0f, 3.0f).sound(SoundType.WOOD).harvestLevel(0).harvestTool(ToolType.AXE)));
}
