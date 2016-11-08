package epidemiccraft.items;

import cpw.mods.fml.common.registry.GameRegistry;
import epidemiccraft.com.EpidemicCraft;
import epidemiccraft.lib.Constants;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class Antiviral extends ItemFood {

private String name = "Antiviral";
	
	public Antiviral(int heal, float saturation, boolean wolfMeat){
		
		super(heal, saturation, wolfMeat);
		setUnlocalizedName(Constants.MODID + "_" + name);
		setTextureName(Constants.MODID + ":" + name);
		GameRegistry.registerItem(this, name);
		setCreativeTab(EpidemicCraft.EpidemicCraftTab);
		this.maxStackSize = 64;
	}
	public EnumAction getItemUseAction(ItemStack p_77661_1_)
    {
        return EnumAction.eat;
    }
	
	public int getMaxItemUseDuration(ItemStack p_77626_1_)
    {
        return 32;
    }
	
}
