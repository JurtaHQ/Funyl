package jurta.funyl.world.gen;

import jurta.funyl.init.BlockInit;
import net.minecraft.block.Blocks;
import net.minecraft.block.pattern.BlockMatcher;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.placement.ConfiguredPlacement;
import net.minecraft.world.gen.placement.CountRangeConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.registries.ForgeRegistries;

public class FunylOreGen {
	@SuppressWarnings("rawtypes")
	public static void generateOre() {
		//Overworld Ores
		for (Biome biome : ForgeRegistries.BIOMES) {
			ConfiguredPlacement customConfig = Placement.COUNT_RANGE
					.configure(new CountRangeConfig(25, 0, 0, 128));
			biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE
					.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, BlockInit.GROMAR_ORE.get().getDefaultState(), 20))
					.withPlacement(customConfig));
		}
		//Nether Ores
		for (Biome biome : ForgeRegistries.BIOMES) {
			ConfiguredPlacement customConfig = Placement.COUNT_RANGE
					.configure(new CountRangeConfig(1, 0, 0, 255));
			biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE
					.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NETHERRACK, BlockInit.NETHER_SEMENITE_ORE.get().getDefaultState(), 4))
					.withPlacement(customConfig));
		}
		//End Ores
		for (Biome biome : ForgeRegistries.BIOMES) {
			ConfiguredPlacement customConfig = Placement.COUNT_RANGE
					.configure(new CountRangeConfig(4, 0, 0, 128));
			biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE
					.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.create("END_STONE", null, new BlockMatcher(Blocks.END_STONE)), BlockInit.END_BEAMSTONE_ORE.get().getDefaultState(), 8))
					.withPlacement(customConfig));
		}
	}
}
