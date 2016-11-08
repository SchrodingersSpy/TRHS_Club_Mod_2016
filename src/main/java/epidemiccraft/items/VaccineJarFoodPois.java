package epidemiccraft.items;

import cpw.mods.fml.common.registry.GameRegistry;
import epidemiccraft.com.EpidemicCraft;
import epidemiccraft.lib.Constants;
import net.minecraft.item.Item;

public class VaccineJarFoodPois extends Item {

private String name = "VaccineJarFoodPois";
	
	public VaccineJarFoodPois(){
		
		setUnlocalizedName(Constants.MODID + "_" + name);
		setTextureName(Constants.MODID + ":" + name);
		GameRegistry.registerItem(this, name);
		setCreativeTab(EpidemicCraft.EpidemicCraftTab);
		setContainerItem(ModItems.VaccineJarUsed);
	}
	
	
}
