package jurta.funyl.init;

import jurta.funyl.Funyl;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BlockInit {
	public static final DeferredRegister<Block> BLOCKS = new DeferredRegister<>(ForgeRegistries.BLOCKS, Funyl.MOD_ID);

	public static final RegistryObject<Block> SEMENITE_ORE = BLOCKS.register("semenite_ore", () -> new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(4.5f, 3.0f).sound(SoundType.STONE).harvestLevel(3).harvestTool(ToolType.PICKAXE)));
	public static final RegistryObject<Block> SEMENITE_BLOCK = BLOCKS.register("semenite_block", () -> new Block(Block.Properties.create(Material.IRON).hardnessAndResistance(6.0f, 30.0f).sound(SoundType.METAL).harvestLevel(3).harvestTool(ToolType.PICKAXE)));
}
