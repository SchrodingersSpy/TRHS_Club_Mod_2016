package epidemiccraft.com;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import akka.japi.Function;

import com.google.common.collect.Ordering;

import epidemiccraft.items.ModItems;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class EpidemicCraftTab extends CreativeTabs {

	public EpidemicCraftTab(int p_i1853_1_, String p_i1853_2_) {
		super(p_i1853_1_, p_i1853_2_);
	}

	@Override
	public Item getTabIconItem() {
		return ModItems.Syringe;
	}

}
