package jurta.funyl.item;

import jurta.funyl.init.ItemInit;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public abstract class FunylItemGroup extends ItemGroup {
	private FunylItemGroup(int index, String label) {
		super(index, label);
	}
	
	public static final ItemGroup FUNYL = (new ItemGroup(ItemGroup.GROUPS.length, "funyl") {
		@OnlyIn(Dist.CLIENT)
		public ItemStack createIcon() {
			return new ItemStack(ItemInit.SEMENITE.get());
		}
	}).setTabPath("funyl");
}
