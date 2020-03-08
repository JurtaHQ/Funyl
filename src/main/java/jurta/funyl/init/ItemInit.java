package jurta.funyl.init;

import java.util.function.Supplier;

import jurta.funyl.Funyl;
import jurta.funyl.objects.items.FunylItemGroup;
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
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.registries.ObjectHolder;

@Mod.EventBusSubscriber(modid = Funyl.MOD_ID, bus = Bus.MOD)
@ObjectHolder(Funyl.MOD_ID)
public class ItemInit {
	public static final Item SEMENITE = null;
	
	//Tools
	public static final Item SEMENITE_SWORD = null;
	public static final Item SEMENITE_PICKAXE = null;
	public static final Item SEMENITE_SHOVEL = null;
	public static final Item SEMENITE_AXE = null;
	public static final Item SEMENITE_HOE = null;
	
	//Armour
	public static final Item SEMENITE_HELMET = null;
	public static final Item SEMENITE_CHESTPLATE = null;
	public static final Item SEMENITE_LEGGINGS = null;
	public static final Item SEMENITE_BOOTS = null;
	
	@SubscribeEvent
	public static void registerItems(final RegistryEvent.Register<Item> event) {
		event.getRegistry().register(new Item(new Item.Properties().group(FunylItemGroup.FUNYL)).setRegistryName("semenite"));
		
		//Tools
		event.getRegistry().register(new SwordItem(ModItemTier.SEMENITE, 8, 1.6f, new Item.Properties().group(FunylItemGroup.FUNYL)).setRegistryName("semenite_sword"));
		event.getRegistry().register(new PickaxeItem(ModItemTier.SEMENITE, 6, 1.6f, new Item.Properties().group(FunylItemGroup.FUNYL)).setRegistryName("semenite_pickaxe"));
		event.getRegistry().register(new ShovelItem(ModItemTier.SEMENITE, 6.0f, 1.0f, new Item.Properties().group(FunylItemGroup.FUNYL)).setRegistryName("semenite_shovel"));
		event.getRegistry().register(new AxeItem(ModItemTier.SEMENITE, 10.0f, 1.0f, new Item.Properties().group(FunylItemGroup.FUNYL)).setRegistryName("semenite_axe"));
		event.getRegistry().register(new HoeItem(ModItemTier.SEMENITE, 4.0f, new Item.Properties().group(FunylItemGroup.FUNYL)).setRegistryName("semenite_hoe"));
		
		//Armour
		event.getRegistry().register(new ArmorItem(ModArmorMaterial.SEMENITE, EquipmentSlotType.HEAD, new Item.Properties().group(FunylItemGroup.FUNYL)).setRegistryName("semenite_helmet"));
		event.getRegistry().register(new ArmorItem(ModArmorMaterial.SEMENITE, EquipmentSlotType.CHEST, new Item.Properties().group(FunylItemGroup.FUNYL)).setRegistryName("semenite_chestplate"));
		event.getRegistry().register(new ArmorItem(ModArmorMaterial.SEMENITE, EquipmentSlotType.LEGS, new Item.Properties().group(FunylItemGroup.FUNYL)).setRegistryName("semenite_leggings"));
		event.getRegistry().register(new ArmorItem(ModArmorMaterial.SEMENITE, EquipmentSlotType.FEET, new Item.Properties().group(FunylItemGroup.FUNYL)).setRegistryName("semenite_boots"));

	}
	
	public enum ModItemTier implements IItemTier {
		SEMENITE(4, 1827, 9.0f, 4.0f, 12, () -> {
			return Ingredient.fromItems(ItemInit.SEMENITE);
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
		SEMENITE(Funyl.MOD_ID + ":semenite", 42, new int[]{4, 8, 9, 5}, 12, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 3.0F, () -> {
			return Ingredient.fromItems(ItemInit.SEMENITE);
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
