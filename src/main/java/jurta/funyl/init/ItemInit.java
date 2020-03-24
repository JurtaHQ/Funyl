package jurta.funyl.init;

import java.util.function.Supplier;

import jurta.funyl.Funyl;
import jurta.funyl.item.FunylItemGroup;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.AxeItem;
import net.minecraft.item.HoeItem;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.SwordItem;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.LazyValue;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ItemInit {
	public static final DeferredRegister<Item> ITEMS = new DeferredRegister<>(ForgeRegistries.ITEMS, Funyl.MOD_ID);

	public static final RegistryObject<Item> SEMENITE = ITEMS.register("semenite", () -> new Item(new Item.Properties().group(FunylItemGroup.FUNYL)));

	public static final RegistryObject<Item> SEMENITE_SWORD = ITEMS.register("semenite_sword", () -> new SwordItem(ModItemTier.SEMENITE, 10, 2.0f, new Item.Properties().group(FunylItemGroup.FUNYL)));
	public static final RegistryObject<Item> SEMENITE_PICKAXE = ITEMS.register("semenite_pickaxe", () -> new PickaxeItem(ModItemTier.SEMENITE, 8, 2.0f, new Item.Properties().group(FunylItemGroup.FUNYL)));
	public static final RegistryObject<Item> SEMENITE_SHOVEL = ITEMS.register("semenite_shovel", () -> new ShovelItem(ModItemTier.SEMENITE, 8.5f, 1.2f, new Item.Properties().group(FunylItemGroup.FUNYL)));
	public static final RegistryObject<Item> SEMENITE_AXE = ITEMS.register("semenite_axe", () -> new AxeItem(ModItemTier.SEMENITE, 12.5f, 1.2f, new Item.Properties().group(FunylItemGroup.FUNYL)));
	public static final RegistryObject<Item> SEMENITE_HOE = ITEMS.register("semenite_hoe", () -> new HoeItem(ModItemTier.SEMENITE, 6.0f, new Item.Properties().group(FunylItemGroup.FUNYL)));

	public static final RegistryObject<Item> SEMENITE_HELMET = ITEMS.register("semenite_helmet", () -> new ArmorItem(ModArmorMaterial.SEMENITE, EquipmentSlotType.HEAD, new Item.Properties().group(FunylItemGroup.FUNYL)));
	public static final RegistryObject<Item> SEMENITE_CHESTPLATE = ITEMS.register("semenite_chestplate", () -> new ArmorItem(ModArmorMaterial.SEMENITE, EquipmentSlotType.CHEST, new Item.Properties().group(FunylItemGroup.FUNYL)));
	public static final RegistryObject<Item> SEMENITE_LEGGINGS = ITEMS.register("semenite_leggings", () -> new ArmorItem(ModArmorMaterial.SEMENITE, EquipmentSlotType.LEGS, new Item.Properties().group(FunylItemGroup.FUNYL)));
	public static final RegistryObject<Item> SEMENITE_BOOTS = ITEMS.register("semenite_boots", () -> new ArmorItem(ModArmorMaterial.SEMENITE, EquipmentSlotType.FEET, new Item.Properties().group(FunylItemGroup.FUNYL)));
	
	public static final RegistryObject<Item> BEAMSTONE = ITEMS.register("beamstone", () -> new Item(new Item.Properties().group(FunylItemGroup.FUNYL)));
	
	public static final RegistryObject<Item> GROMAR_SHARD = ITEMS.register("gromar_shard", () -> new Item(new Item.Properties().group(FunylItemGroup.FUNYL)));
	
	public enum ModItemTier implements IItemTier {
		SEMENITE(4, 3078, 11.5f, 6.0f, 20, () -> {
			return Ingredient.fromItems(ItemInit.SEMENITE.get());
		});
		
		private final int harvestLevel;
		private final int maxUses;
		private final float efficiency;
		private final float attackDamage;
		private final int enchantability;
		private final LazyValue<Ingredient> repairMaterial;
		
		private ModItemTier(int harvestLevel, int maxUses, float efficiency, float attackDamage, int enchantability, Supplier<Ingredient> repairMaterial) {
			this.harvestLevel = harvestLevel;
			this.maxUses = maxUses;
			this.efficiency = efficiency;
			this.attackDamage = attackDamage;
			this.enchantability = enchantability;
			this.repairMaterial = new LazyValue<>(repairMaterial);
		}

		@Override
		public int getMaxUses() {
			return this.maxUses;
		}

		@Override
		public float getEfficiency() {
			return this.efficiency;
		}

		@Override
		public float getAttackDamage() {
			return this.attackDamage;
		}

		@Override
		public int getHarvestLevel() {
			return this.harvestLevel;
		}

		@Override
		public int getEnchantability() {
			return this.enchantability;
		}

		@Override
		public Ingredient getRepairMaterial() {
			return this.repairMaterial.getValue();
		}
	}
	
	public enum ModArmorMaterial implements IArmorMaterial {
		SEMENITE(Funyl.MOD_ID + ":semenite", 42, new int[]{6, 11, 14, 7}, 12, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 4.0F, () -> {
			return Ingredient.fromItems(ItemInit.SEMENITE.get());
		});
		
		private static final int[] MAX_DAMAGE_ARRAY = new int[] {16, 16, 16, 16};
		private final String name;
		private final int maxDamageFactor;
		private final int[] damageReductionAmountArray;
		private final int enchantability;
		private final SoundEvent soundEvent;
		private final float toughness;
		private final LazyValue<Ingredient> repairMaterial;
		
		private ModArmorMaterial(String nameIn, int maxDamageFactorIn, int[] damageReductionAmountIn, int enchantabilityIn, SoundEvent soundEventIn, float toughnessIn, Supplier<Ingredient> repairMaterialIn) {
			this.name = nameIn;
			this.maxDamageFactor = maxDamageFactorIn;
			this.damageReductionAmountArray = damageReductionAmountIn;
			this.enchantability = enchantabilityIn;
			this.soundEvent = soundEventIn;
			this.toughness = toughnessIn;
			this.repairMaterial = new LazyValue<>(repairMaterialIn);
		}

		@Override
		public int getDurability(EquipmentSlotType slotIn) {
			return MAX_DAMAGE_ARRAY[slotIn.getIndex()] * this.maxDamageFactor;
		}

		@Override
		public int getDamageReductionAmount(EquipmentSlotType slotIn) {
			return this.damageReductionAmountArray[slotIn.getIndex()];
		}

		@Override
		public int getEnchantability() {
			return this.enchantability;
		}

		@Override
		public SoundEvent getSoundEvent() {
			return this.soundEvent;
		}

		@Override
		public Ingredient getRepairMaterial() {
			return this.repairMaterial.getValue();
		}
		
		@OnlyIn(Dist.CLIENT)
		@Override
		public String getName() {
			return this.name;
		}

		@Override
		public float getToughness() {
			return this.toughness;
		}
	}
}
