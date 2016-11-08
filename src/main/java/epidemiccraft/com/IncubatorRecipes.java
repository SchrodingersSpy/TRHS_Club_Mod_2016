package epidemiccraft.com;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import epidemiccraft.items.ModItems;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class IncubatorRecipes {

	private static final IncubatorRecipes SMELTING_BASE = new IncubatorRecipes();
	private Map smeltingList = new HashMap();
	private Map experienceList = new HashMap();
	
	public static IncubatorRecipes smelting(){
		return SMELTING_BASE;
	}
	
	private IncubatorRecipes(){
		this.addRecipe(ModItems.PetriDishFoodPoisRaw, new ItemStack(ModItems.PetriDishFoodPois), 0.5F);
		this.addRecipe(ModItems.PetriDishEColiRaw, new ItemStack(ModItems.PetriDishEColi), 0.5F);
		this.addRecipe(ModItems.PetriDishGiardiaRaw, new ItemStack(ModItems.PetriDishGiardia), 0.5F);
		this.addRecipe(ModItems.PetriDishMeningitisRaw, new ItemStack(ModItems.PetriDishMeningitis), 0.5F);
		this.addRecipe(ModItems.EggFluRaw, new ItemStack(ModItems.EggFlu), 0.5F);
		this.addRecipe(ModItems.EggCPoxRaw, new ItemStack(ModItems.EggCPox), 0.5F);
		this.addRecipe(ModItems.EggPolioRaw, new ItemStack(ModItems.EggPolio), 0.5F);
		this.addRecipe(ModItems.EggRabiesRaw, new ItemStack(ModItems.EggRabies), 0.5F);
		
	}
	
	public void addRecipe(Item item, ItemStack itemstack, float experience){
		this.addLists(item, itemstack, experience);
	}
	
	public void addLists(Item item, ItemStack itemstack, float experience){
		this.putLists(new ItemStack(item, 1, 32767), itemstack, experience);
	}
	
	public void putLists(ItemStack itemstack, ItemStack itemstack2, float experience){
		this.smeltingList.put(itemstack, itemstack2);
		this.experienceList.put(itemstack, Float.valueOf(experience));
	}
	
	public ItemStack getSmeltingResult(ItemStack itemstack){
		Iterator iterator = this.smeltingList.entrySet().iterator();
		Entry entry;
		do{
			if(!iterator.hasNext()){
				return null;
			}
			entry = (Entry) iterator.next();
		}
		while(!canBeSmelted(itemstack, (ItemStack)entry.getKey()));
		return (ItemStack)entry.getValue();
	}

	private boolean canBeSmelted(ItemStack itemstack, ItemStack itemstack2) {
		return itemstack2.getItem() == itemstack.getItem() && itemstack2.getItemDamage() == 32767 || itemstack2.getItemDamage() == itemstack.getItemDamage();
	}
	
	public float giveExperience(ItemStack itemstack){
		Iterator iterator = this.experienceList.entrySet().iterator();
		Entry entry;
		
		do{
			if(!iterator.hasNext()){
				return 0.0f;
			}
			
			entry = (Entry) iterator.next();
		}
		while(!canBeSmelted(itemstack, (ItemStack)entry.getKey()));
		
		if(itemstack.getItem().getSmeltingExperience(itemstack) != -1){
			return itemstack.getItem().getSmeltingExperience(itemstack);
		}
		
		return ((Float)entry.getValue()).floatValue();
	}

}
