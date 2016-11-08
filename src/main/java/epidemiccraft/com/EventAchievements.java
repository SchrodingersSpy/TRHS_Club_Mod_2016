package epidemiccraft.com;

import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent;
import epidemiccraft.blocks.ModBlocks;
import epidemiccraft.items.ModItems;

public class EventAchievements {

	
	@SubscribeEvent
	public void acquireFluSyringe(PlayerEvent.ItemPickupEvent e){
		if(e.pickedUp.getEntityItem().isItemEqual(new ItemStack(ModItems.SyringeFlu))){
			e.player.addStat(EpidemicCraft.achievementCraftFlu, 1);
		}
	}

	@SubscribeEvent
	public void acquireMeningitisSyringe(PlayerEvent.ItemPickupEvent e){
		if(e.pickedUp.getEntityItem().isItemEqual(new ItemStack(ModItems.SyringeMeningitis))){
			e.player.addStat(EpidemicCraft.achievementCraftMeningitis, 1);
		}
	}
	
	@SubscribeEvent
	public void acquireCPoxSyringe(PlayerEvent.ItemPickupEvent e){
		if(e.pickedUp.getEntityItem().isItemEqual(new ItemStack(ModItems.SyringeCPox))){
			e.player.addStat(EpidemicCraft.achievementCraftCPox, 1);
		}
	}
	
	@SubscribeEvent
	public void acquirePolioSyringe(PlayerEvent.ItemPickupEvent e){
		if(e.pickedUp.getEntityItem().isItemEqual(new ItemStack(ModItems.SyringePolio))){
			e.player.addStat(EpidemicCraft.achievementCraftPolio, 1);
		}
	}
	
	@SubscribeEvent
	public void acquireRabiesSyringe(PlayerEvent.ItemPickupEvent e){
		if(e.pickedUp.getEntityItem().isItemEqual(new ItemStack(ModItems.SyringeRabies))){
			e.player.addStat(EpidemicCraft.achievementCraftRabies, 1);
		}
	}
	
	@SubscribeEvent
	public void acquireFoodPoisSyringe(PlayerEvent.ItemPickupEvent e){
		if(e.pickedUp.getEntityItem().isItemEqual(new ItemStack(ModItems.SyringeFoodPois))){
			e.player.addStat(EpidemicCraft.achievementCraftFoodPois, 1);
		}
	}
	
	@SubscribeEvent
	public void acquireEColiSyringe(PlayerEvent.ItemPickupEvent e){
		if(e.pickedUp.getEntityItem().isItemEqual(new ItemStack(ModItems.SyringeEColi))){
			e.player.addStat(EpidemicCraft.achievementCraftEColi, 1);
		}
	}
	
	@SubscribeEvent
	public void acquireBiosuit(PlayerEvent.ItemPickupEvent e){
		if(e.pickedUp.getEntityItem().isItemEqual(new ItemStack(EpidemicCraft.helmetBioSuit))){
			e.player.addStat(EpidemicCraft.achievementBiosuit, 1);
		}
	}
	
	@SubscribeEvent
	public void acquireAutoclave(PlayerEvent.ItemPickupEvent e){
		if(e.pickedUp.getEntityItem().isItemEqual(new ItemStack(ModBlocks.Autoclave))){
			e.player.addStat(EpidemicCraft.achievementAutoclave, 1);
		}
	}
	
	@SubscribeEvent
	public void acquireIncubator(PlayerEvent.ItemPickupEvent e){
		if(e.pickedUp.getEntityItem().isItemEqual(new ItemStack(ModBlocks.Incubator))){
			e.player.addStat(EpidemicCraft.achievementIncubator, 1);
		}
	}
	

	
}
