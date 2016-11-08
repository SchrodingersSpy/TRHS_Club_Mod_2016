package epidemiccraft.com;

import ibxm.Player;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import epidemiccraft.mobs.EntityGiardiaCowMob;
import epidemiccraft.mobs.ModEntities;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.RecipesArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.stats.Achievement;
import net.minecraftforge.common.AchievementPage;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.event.entity.player.PlayerUseItemEvent;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import epidemiccraft.blocks.ModBlocks;
import epidemiccraft.items.ModItems;
import epidemiccraft.lib.Constants;
import epidemiccraft.proxy.ClientProxy;
import epidemiccraft.proxy.CommonProxy;
import epidemiccraft.com.EpidemicCraftTab;

//© SchrodingersSpy 2015
//Written by SchrodingersSpy from February 2014 to ...
//If you see this mod posted anywhere other than the original Minecraft Forums thread or the Github linked in said thread, it is not maintained by me and could contain malware.

@Mod(modid = "epidemiccraft", name = "EpidemicCraft", version = "1.0.0")

public class EpidemicCraft {
			
public static CreativeTabs EpidemicCraftTab = new EpidemicCraftTab(CreativeTabs.getNextID(), "EpidemicCraftTab");	

	@Mod.Instance(Constants.MODID)
	public static EpidemicCraft instance;

	@SidedProxy(clientSide = Constants.CLIENT_PROXY_CLASS, serverSide = Constants.SERVER_PROXY_CLASS)
	public static CommonProxy proxy;
	
	
	public static Potion potionBiosuit;
	public static Potion potionFlu;
	public static Potion potionMeningitis;
	public static Potion potionCPox;
	public static Potion potionPolio;
	public static Potion potionRabies;
	public static Potion potionFoodPois;
	public static Potion potionEColi;
	public static Potion potionGiardia;
	public static Potion potionFluVaccine;
	public static Potion potionMeningitisVaccine;
	public static Potion potionCPoxVaccine;
	public static Potion potionPolioVaccine;
	public static Potion potionRabiesVaccine;
	public static Potion potionFoodPoisVaccine;
	public static Potion potionEColiVaccine;
	public static Potion potionGiardiaVaccine;
	
	public static ArmorMaterial enumArmorMaterialBioSuit = EnumHelper.addArmorMaterial("BioSuit", 5, new int[]{1, 3, 2, 1}, 15);
		
	public static Item helmetBioSuit;
	int helmetBioSuitID = 500;
	public static Item chestplateBioSuit;
	int chestplateBioSuitID = 501;
	public static Item legsBioSuit;
	int legsBioSuitID = 502;
	public static Item bootsBioSuit;
	int bootsBioSuitID = 503;
	
	public static Achievement achievementCraftFlu;
	public static Achievement achievementCraftMeningitis;
	public static Achievement achievementCraftCPox;
	public static Achievement achievementCraftPolio;
	public static Achievement achievementCraftRabies;
	public static Achievement achievementCraftFoodPois;
	public static Achievement achievementCraftEColi;
	public static Achievement achievementCraftGiardia;
	public static Achievement achievementBiosuit;
	public static Achievement achievementAutoclave;
	public static Achievement achievementIncubator;
	public static Achievement achievementMilk;
	
	
	@Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
		
		proxy.preInit();
		proxy.registerTileEntities();
		ModEntities.preInit();
		
		Potion[] potionTypes = null;

		for (Field f : Potion.class.getDeclaredFields()) {
		f.setAccessible(true);
		try {
		if (f.getName().equals("potionTypes") || f.getName().equals("field_76425_a")) {
		Field modfield = Field.class.getDeclaredField("modifiers");
		modfield.setAccessible(true);
		modfield.setInt(f, f.getModifiers() & ~Modifier.FINAL);

		potionTypes = (Potion[])f.get(null);
		final Potion[] newPotionTypes = new Potion[256];
		System.arraycopy(potionTypes, 0, newPotionTypes, 0, potionTypes.length);
		f.set(null, newPotionTypes);
		}
		}
		catch (Exception e) {
		System.err.println("Severe error, please report this to the mod author:");
		System.err.println(e);
		}
		}
		
		potionBiosuit = (new PotionBiosuit(32, false, 0)).setIconIndex(0, 0).setPotionName("EpidemicCraft.potionBiosuit");
		potionFlu = (new PotionFlu(33, false, 0)).setIconIndex(1, 0).setPotionName("EpidemicCraft.potionFlu");
		potionMeningitis = (new PotionMeningitis(34, false, 0)).setIconIndex(2, 0).setPotionName("EpidemicCraft.potionMeningitis");
		potionCPox = (new PotionCPox(35, false, 0)).setIconIndex(3, 0).setPotionName("EpidemicCraft.potionCPox");
		potionPolio = (new PotionPolio(36, false, 0)).setIconIndex(4, 0).setPotionName("EpidemicCraft.potionPolio");
		potionRabies = (new PotionRabies(37, false, 0)).setIconIndex(5, 0).setPotionName("EpidemicCraft.potionRabies");
		potionFoodPois = (new PotionFoodPois(38, false, 0)).setIconIndex(6, 0).setPotionName("EpidemicCraft.potionFoodPois");
		potionEColi = (new PotionEColi(39, false, 0)).setIconIndex(1, 1).setPotionName("EpidemicCraft.potionEColi");
		potionGiardia = (new PotionGiardia(40, false, 0)).setIconIndex(2, 1).setPotionName("EpidemicCraft.potionGiardia");
		potionFluVaccine = (new PotionFluVaccine(41, false, 0)).setIconIndex(3, 1).setPotionName("EpidemicCraft.potionFluVaccine");
		potionMeningitisVaccine = (new PotionMeningitisVaccine(42, false, 0)).setIconIndex(4, 1).setPotionName("EpidemicCraft.potionMeningitisVaccine");
		potionCPoxVaccine = (new PotionCPoxVaccine(43, false, 0)).setIconIndex(5, 1).setPotionName("EpidemicCraft.potionCPoxVaccine");
		potionPolioVaccine = (new PotionPolioVaccine(44, false, 0)).setIconIndex(6, 1).setPotionName("EpidemicCraft.potionPolioVaccine");
		potionRabiesVaccine = (new PotionRabiesVaccine(45, false, 0)).setIconIndex(7, 1).setPotionName("EpidemicCraft.potionRabiesVaccine");
		potionFoodPoisVaccine = (new PotionFoodPoisVaccine(46, false, 0)).setIconIndex(0, 2).setPotionName("EpidemicCraft.potionFoodPoisVaccine");
		potionEColiVaccine = (new PotionEColiVaccine(47, false, 0)).setIconIndex(1, 2).setPotionName("EpidemicCraft.potionEColiVaccine");
		potionGiardiaVaccine = (new PotionGiardiaVaccine(48, false, 0)).setIconIndex(2, 2).setPotionName("EpidemicCraft.potionGiardiaVaccine");

		
		MinecraftForge.EVENT_BUS.register(new EventAchievements());
		MinecraftForge.EVENT_BUS.register(new EventMilk());
		MinecraftForge.EVENT_BUS.register(new EventPotionZero());
		MinecraftForge.EVENT_BUS.register(new EventTransmission());

    }
		//BLOCKS
			
	@Mod.EventHandler
			
    public void init(FMLInitializationEvent event) {
		ModBlocks.init();
		ModItems.init();
		proxy.init();
		proxy.registerNetworkStuff();
		
		//TILE ENTITIES
		
		
			
		//ARMOR
		if(event.getSide().isClient()){
			 RenderingRegistry.addNewArmourRendererPrefix("5");
			}

		helmetBioSuit = new BioSuitArmor(EpidemicCraft.enumArmorMaterialBioSuit, 5, 0).setUnlocalizedName("helmetBioSuit").setCreativeTab(EpidemicCraft.EpidemicCraftTab);
		chestplateBioSuit = new BioSuitArmor(EpidemicCraft.enumArmorMaterialBioSuit, 5, 1).setUnlocalizedName("chestplateBioSuit").setCreativeTab(EpidemicCraft.EpidemicCraftTab);
		legsBioSuit = new BioSuitArmor(EpidemicCraft.enumArmorMaterialBioSuit, 5, 2).setUnlocalizedName("legsBioSuit").setCreativeTab(EpidemicCraft.EpidemicCraftTab);
		bootsBioSuit = new BioSuitArmor(EpidemicCraft.enumArmorMaterialBioSuit, 5, 3).setUnlocalizedName("bootsBioSuit").setCreativeTab(EpidemicCraft.EpidemicCraftTab);
		
		GameRegistry.registerItem(helmetBioSuit, "helmetBioSuit");
		GameRegistry.registerItem(chestplateBioSuit, "chestplateBioSuit");
		GameRegistry.registerItem(legsBioSuit, "legsBioSuit");
		GameRegistry.registerItem(bootsBioSuit, "bootsBioSuit");
		//END OF ARMOR
		
    	//SHAPELESS RECIPES
		GameRegistry.addShapelessRecipe (new ItemStack(ModItems.Agar, 8), Items.beef, Items.reeds, Items.slime_ball);
		GameRegistry.addShapelessRecipe (new ItemStack(ModItems.Antibiotic, 2), Items.reeds, Items.wheat_seeds, Items.pumpkin_seeds);
		GameRegistry.addShapelessRecipe (new ItemStack(ModItems.Antiviral, 2), Items.apple, Items.wheat_seeds, Items.pumpkin_seeds);
    	
    	//END OF SHAPELESS RECIPES
    	//SHAPED RECIPES
    	
    	GameRegistry.addRecipe (new ItemStack(EpidemicCraft.helmetBioSuit, 1), new Object [] {"XXX", "XYX", "XXX", 'X', ModItems.Rubber, 'Y', ModItems.ThinGlass});
    	GameRegistry.addRecipe (new ItemStack(EpidemicCraft.chestplateBioSuit, 1), new Object [] {"X X", "XXX", "XXX", 'X', ModItems.Rubber});
    	GameRegistry.addRecipe (new ItemStack(EpidemicCraft.legsBioSuit, 1), new Object [] {"XXX", "X X", "X X", 'X', ModItems.Rubber});
    	GameRegistry.addRecipe (new ItemStack(EpidemicCraft.bootsBioSuit, 1), new Object [] {"X X", "X X", "Y Y", 'X', ModItems.Rubber, 'Y', Items.iron_ingot});
    	
    	GameRegistry.addRecipe (new ItemStack(ModItems.CystGiardia, 1), new Object [] {"  X", " Y ", "   ", 'X', ModItems.Scalpel, 'Y', ModItems.TissueGiardia});
    	GameRegistry.addRecipe (new ItemStack(ModItems.BacteriaFoodPois, 1), new Object [] {"  X", " Y ", "   ", 'X', ModItems.Scalpel, 'Y', Items.beef});
    	GameRegistry.addRecipe (new ItemStack(ModItems.BacteriaFoodPois, 1), new Object [] {"  X", " Y ", "   ", 'X', ModItems.Scalpel, 'Y', Items.porkchop});
    	GameRegistry.addRecipe (new ItemStack(ModItems.BacteriaFoodPois, 1), new Object [] {"  X", " Y ", "   ", 'X', ModItems.Scalpel, 'Y', Items.chicken});
    	GameRegistry.addRecipe (new ItemStack(ModItems.BacteriaFoodPois, 1), new Object [] {"  X", " Y ", "   ", 'X', ModItems.Scalpel, 'Y', Items.fish});
    	GameRegistry.addRecipe (new ItemStack(ModItems.FluidEColi, 1), new Object [] {"  X", " Y ", "   ", 'X', ModItems.Scalpel, 'Y', ModItems.TissueEColi});
    	
    	
    	
    	GameRegistry.addRecipe (new ItemStack(ModItems.SyringeSampleCPox, 1), new Object [] {"  X", " Y ", "   ", 'X', ModItems.Syringe, 'Y', ModItems.FluidCPox});
    	GameRegistry.addRecipe (new ItemStack(ModItems.SyringeSampleFlu, 1), new Object [] {"  X", " Y ", "   ", 'X', ModItems.Syringe, 'Y', ModItems.FluidFlu});
    	GameRegistry.addRecipe (new ItemStack(ModItems.SyringeSamplePolio, 1), new Object [] {"  X", " Y ", "   ", 'X', ModItems.Syringe, 'Y', ModItems.FluidPolio});
    	GameRegistry.addRecipe (new ItemStack(ModItems.SyringeSampleRabies, 1), new Object [] {"  X", " Y ", "   ", 'X', ModItems.Syringe, 'Y', ModItems.FluidRabies});
    	
    	GameRegistry.addRecipe (new ItemStack(ModItems.EggCPoxRaw, 1), new Object [] {"  X", " Y ", "   ", 'X', ModItems.SyringeSampleCPox, 'Y', Items.egg});
    	GameRegistry.addRecipe (new ItemStack(ModItems.EggFluRaw, 1), new Object [] {"  X", " Y ", "   ", 'X', ModItems.SyringeSampleFlu, 'Y', Items.egg});
    	GameRegistry.addRecipe (new ItemStack(ModItems.EggPolioRaw, 1), new Object [] {"  X", " Y ", "   ", 'X', ModItems.SyringeSamplePolio, 'Y', Items.egg});
    	GameRegistry.addRecipe (new ItemStack(ModItems.EggRabiesRaw, 1), new Object [] {"  X", " Y ", "   ", 'X', ModItems.SyringeSampleRabies, 'Y', Items.egg});
    	GameRegistry.addRecipe (new ItemStack(ModItems.ThinGlass, 8), new Object [] {"   ", "XXX", "   ", 'X', Blocks.glass});
    	
    	GameRegistry.addRecipe (new ItemStack(ModItems.PetriDishUsed ,1), new Object [] {"   ", "YXY", "YYY", 'X', ModItems.Agar, 'Y', ModItems.ThinGlass});
    	GameRegistry.addRecipe (new ItemStack(ModItems.PetriDishFoodPoisRaw, 1), new Object [] {" Y ", " X ", "   ", 'X', ModItems.PetriDish, 'Y', ModItems.BacteriaFoodPois});
    	GameRegistry.addRecipe (new ItemStack(ModItems.PetriDishEColiRaw ,1), new Object [] {" Y ", " X ", "   ", 'X', ModItems.PetriDish, 'Y', ModItems.FluidEColi});
    	GameRegistry.addRecipe (new ItemStack(ModItems.PetriDishGiardiaRaw ,1), new Object [] {" Y ", " X ", "   ", 'X', ModItems.PetriDish, 'Y', ModItems.CystGiardia});
    	GameRegistry.addRecipe (new ItemStack(ModItems.PetriDishMeningitisRaw, 1), new Object [] {" Y ", " X ", "   ", 'X', ModItems.PetriDish, 'Y', ModItems.SpinalTapSyringeFull });
    	GameRegistry.addRecipe (new ItemStack(ModItems.VaccineJarUsed, 1), new Object [] {"XXX", "Y Y", "YYY", 'X', Items.iron_ingot, 'Y', ModItems.ThinGlass});
    	GameRegistry.addRecipe (new ItemStack(ModItems.TestTubeUsed, 1), new Object [] {"X X", "X X", " X ", 'X', ModItems.ThinGlass});    	
    	
    	GameRegistry.addRecipe (new ItemStack(ModItems.UsedNeedle, 3), new Object [] {"  X", " X ", "   ", 'X',Items.iron_ingot });
    	GameRegistry.addRecipe (new ItemStack(ModItems.IronRodUsed, 3), new Object [] {" X ", " X ", " X ", 'X',Items.iron_ingot });
    	GameRegistry.addRecipe (new ItemStack(ModItems.UsedNeedleLong, 1), new Object [] {"  X", " X ", "X  ", 'X', ModItems.UsedNeedle});
    	GameRegistry.addRecipe (new ItemStack(ModItems.SyringeTubeUsed, 1), new Object [] {"XYX", "X X", "X X", 'X', ModItems.ThinGlass, 'Y', ModItems.SyringePlungerUsed});
    	GameRegistry.addRecipe (new ItemStack(ModItems.SyringePlungerUsed, 1), new Object [] {" X ", " X ", " Y ", 'X', ModItems.IronRodUsed, 'Y', ModItems.Rubber});
    	GameRegistry.addRecipe (new ItemStack(ModItems.Syringe, 1), new Object [] {"  X", " Y ", "Z  ", 'X', Items.iron_ingot, 'Y', ModItems.SyringeTube, 'Z', ModItems.Needle});
    	GameRegistry.addRecipe (new ItemStack(ModItems.SpinalTapSyringe, 1), new Object [] {"  X", " Y ", "Z  ", 'X', Items.iron_ingot, 'Y', ModItems.SyringeTube, 'Z', ModItems.NeedleLong});
    	GameRegistry.addRecipe (new ItemStack(ModItems.SyringeFlu, 1), new Object [] {" Y ", " X ", "   ", 'X', ModItems.VaccineJarFlu, 'Y', ModItems.Syringe});
    	GameRegistry.addRecipe (new ItemStack(ModItems.SyringeMeningitis, 1), new Object [] {" Y ", " X ", "   ", 'X', ModItems.VaccineJarMeningitis, 'Y', ModItems.Syringe});
    	GameRegistry.addRecipe (new ItemStack(ModItems.SyringeCPox, 1), new Object [] {" Y ", " X ", "   ", 'X', ModItems.VaccineJarCPox, 'Y', ModItems.Syringe});
    	GameRegistry.addRecipe (new ItemStack(ModItems.SyringePolio, 1), new Object [] {" Y ", " X ", "   ", 'X', ModItems.VaccineJarPolio, 'Y', ModItems.Syringe});
    	GameRegistry.addRecipe (new ItemStack(ModItems.SyringeRabies, 1), new Object [] {" Y ", " X ", "   ", 'X', ModItems.VaccineJarRabies, 'Y', ModItems.Syringe});
    	GameRegistry.addRecipe (new ItemStack(ModItems.SyringeFoodPois, 1), new Object [] {" Y ", " X ", "   ", 'X', ModItems.VaccineJarFoodPois, 'Y', ModItems.Syringe});
    	GameRegistry.addRecipe (new ItemStack(ModItems.SyringeEColi, 1), new Object [] {" Y ", " X ", "   ", 'X', ModItems.VaccineJarEColi, 'Y', ModItems.Syringe});
    	GameRegistry.addRecipe (new ItemStack(ModItems.SyringeGiardia, 1), new Object [] {" Y ", " X ", "   ", 'X', ModItems.VaccineJarGiardia, 'Y', ModItems.Syringe});
    
    	GameRegistry.addRecipe (new ItemStack(ModItems.TestTubeFlu, 1), new Object [] {" X ", " Y ", " Z ", 'X', ModItems.Purifier, 'Y', ModItems.EggFlu, 'Z', ModItems.TestTube});
    	GameRegistry.addRecipe (new ItemStack(ModItems.TestTubeMeningitis, 1), new Object [] {" X ", " Y ", " Z ", 'X', ModItems.Purifier, 'Y', ModItems.SpinalTapSyringeFull, 'Z', ModItems.TestTube});
    	GameRegistry.addRecipe (new ItemStack(ModItems.TestTubeCPox, 1), new Object [] {" X ", " Y ", " Z ", 'X', ModItems.Purifier, 'Y', ModItems.EggCPox, 'Z', ModItems.TestTube});
    	GameRegistry.addRecipe (new ItemStack(ModItems.TestTubePolio, 1), new Object [] {" X ", " Y ", " Z ", 'X', ModItems.Purifier, 'Y', ModItems.EggPolio, 'Z', ModItems.TestTube});
    	GameRegistry.addRecipe (new ItemStack(ModItems.TestTubeRabies, 1), new Object [] {" X ", " Y ", " Z ", 'X', ModItems.Purifier, 'Y', ModItems.EggRabies, 'Z', ModItems.TestTube});
    	GameRegistry.addRecipe (new ItemStack(ModItems.TestTubeFoodPois, 1), new Object [] {" X ", " Y ", " Z ", 'X', ModItems.Purifier, 'Y', ModItems.PetriDishFoodPois, 'Z', ModItems.TestTube});
    	GameRegistry.addRecipe (new ItemStack(ModItems.TestTubeEColi, 1), new Object [] {" X ", " Y ", " Z ", 'X', ModItems.Purifier, 'Y', ModItems.PetriDishEColi, 'Z', ModItems.TestTube});
    	GameRegistry.addRecipe (new ItemStack(ModItems.TestTubeGiardia, 1), new Object [] {" X ", " Y ", " Z ", 'X', ModItems.Purifier, 'Y', ModItems.PetriDishGiardia, 'Z', ModItems.TestTube});
    	GameRegistry.addRecipe (new ItemStack(ModItems.TestTubeMeningitis, 1), new Object [] {" X ", " Y ", " Z ", 'X', ModItems.Purifier, 'Y', ModItems.PetriDishMeningitis, 'Z', ModItems.TestTube});
    	
    	GameRegistry.addRecipe (new ItemStack(ModItems.VaccineJarFlu, 1), new  Object [] {"W X", " Y ", " Z ", 'W', ModItems.Adjuvant, 'X', ModItems.Preservative, 'Y', ModItems.TestTubeFlu, 'Z', ModItems.VaccineJar});
    	GameRegistry.addRecipe (new ItemStack(ModItems.VaccineJarMeningitis, 1), new  Object [] {"W X", " Y ", " Z ", 'W', ModItems.Adjuvant, 'X', ModItems.Preservative, 'Y', ModItems.TestTubeMeningitis, 'Z', ModItems.VaccineJar});
    	GameRegistry.addRecipe (new ItemStack(ModItems.VaccineJarCPox, 1), new  Object [] {"W X", " Y ", " Z ", 'W', ModItems.Adjuvant, 'X', ModItems.Preservative, 'Y', ModItems.TestTubeCPox, 'Z', ModItems.VaccineJar});
    	GameRegistry.addRecipe (new ItemStack(ModItems.VaccineJarPolio, 1), new  Object [] {"W X", " Y ", " Z ", 'W', ModItems.Adjuvant, 'X', ModItems.Preservative, 'Y', ModItems.TestTubePolio, 'Z', ModItems.VaccineJar});
    	GameRegistry.addRecipe (new ItemStack(ModItems.VaccineJarRabies, 1), new  Object [] {"W X", " Y ", " Z ", 'W', ModItems.Adjuvant, 'X', ModItems.Preservative, 'Y', ModItems.TestTubeRabies, 'Z', ModItems.VaccineJar});
    	GameRegistry.addRecipe (new ItemStack(ModItems.VaccineJarFoodPois, 1), new  Object [] {"W X", " Y ", " Z ", 'W', ModItems.Adjuvant, 'X', ModItems.Preservative, 'Y', ModItems.TestTubeFoodPois, 'Z', ModItems.VaccineJar});
    	GameRegistry.addRecipe (new ItemStack(ModItems.VaccineJarEColi, 1), new  Object [] {"W X", " Y ", " Z ", 'W', ModItems.Adjuvant, 'X', ModItems.Preservative, 'Y', ModItems.TestTubeEColi, 'Z', ModItems.VaccineJar});
    	GameRegistry.addRecipe (new ItemStack(ModItems.VaccineJarGiardia, 1), new  Object [] {"W X", " Y ", " Z ", 'W', ModItems.Adjuvant, 'X', ModItems.Preservative, 'Y', ModItems.TestTubeGiardia, 'Z', ModItems.VaccineJar});
    	
    	GameRegistry.addRecipe (new ItemStack(ModItems.Purifier, 1), new Object [] {"YYY", " Z ", "   ", 'Y', Blocks.brown_mushroom, 'Z', Items.glass_bottle});
    	GameRegistry.addRecipe (new ItemStack(ModItems.Adjuvant, 1), new Object [] {"XXX", " Y ", "   ", 'X', Items.melon_seeds, 'Y', Items.glass_bottle});//REDO
    	GameRegistry.addRecipe (new ItemStack(ModItems.Preservative, 1), new Object [] {"XXX", " Y ", "   ", 'X', ModItems.Mercury, 'Y', Items.glass_bottle});
    	GameRegistry.addRecipe (new ItemStack(ModItems.Scalpel, 1), new Object [] {"  X", " X ", "X  ", 'X', Items.iron_ingot});
    	
    	GameRegistry.addRecipe (new ItemStack(ModBlocks.Autoclave, 1), new Object [] {"XXX", "XYX", "XZX", 'X', Blocks.iron_block, 'Y', Blocks.furnace, 'Z', Items.bucket});
    	GameRegistry.addRecipe (new ItemStack(ModBlocks.Incubator, 1), new Object [] {"XXX", "XYX", "XZX", 'X', Blocks.iron_block, 'Y', Blocks.iron_bars, 'Z', Blocks.netherrack});

    	//END OF SHAPED RECIPES
    	//FURNACE RECIPES 
    	GameRegistry.addSmelting(ModItems.TissueFlu, new ItemStack(Items.rotten_flesh), 0F);
    	GameRegistry.addSmelting(ModItems.TissueCPox, new ItemStack(Items.rotten_flesh), 0F);
    	GameRegistry.addSmelting(ModItems.TissuePolio, new ItemStack(Items.rotten_flesh), 0F);
    	GameRegistry.addSmelting(ModItems.TissueRabies, new ItemStack(Items.rotten_flesh), 0F);
    	GameRegistry.addSmelting(ModItems.TissueEColi, new ItemStack(Items.rotten_flesh), 0F);
    	GameRegistry.addSmelting(ModItems.TissueGiardia, new ItemStack(Items.rotten_flesh), 0F);
    	GameRegistry.addSmelting(Blocks.yellow_flower, new ItemStack(ModItems.Rubber), 0F);
    	GameRegistry.addSmelting(Items.cooked_fished, new ItemStack(ModItems.Mercury), 0F);
    	    	
    	//END OF FURNACE RECIPES
    	//ACHIEVEMENTS
    	
       	achievementCraftFlu = new Achievement("achievement.craftFlu", "craftFlu", 1, 0, new ItemStack(ModItems.SyringeFlu), null).initIndependentStat().registerStat();
       	achievementCraftMeningitis = new Achievement("achievement.craftMeningitis", "craftMeningitis", 1, 2, new ItemStack(ModItems.SyringeMeningitis), null).initIndependentStat().registerStat();
       	achievementCraftCPox = new Achievement("achievement.craftCPox", "craftCPox", 3, 1, new ItemStack(ModItems.SyringeCPox), null).initIndependentStat().registerStat();
       	achievementCraftPolio = new Achievement("achievement.craftPolio", "craftPolio", 5, 1, new ItemStack(ModItems.SyringePolio), null).initIndependentStat().registerStat();
       	achievementCraftRabies = new Achievement("achievement.craftRabies", "craftRabies", 2, 4, new ItemStack(ModItems.SyringeRabies), null).initIndependentStat().registerStat();
       	achievementCraftFoodPois = new Achievement("achievement.craftFoodPois", "craftFoodPois", 0, 4, new ItemStack(ModItems.SyringeFoodPois), null).initIndependentStat().registerStat();
       	achievementCraftEColi = new Achievement("achievement.craftEColi", "craftEColi", 2, -1, new ItemStack(ModItems.SyringeEColi), null).initIndependentStat().registerStat();
       	achievementCraftGiardia = new Achievement("achievement.craftGiardia", "craftGiardia", 0, -2, new ItemStack(ModItems.SyringeGiardia), null).initIndependentStat().registerStat();
       	achievementBiosuit = new Achievement("achievement.biosuit", "biosuit", -1, 2, new ItemStack(EpidemicCraft.helmetBioSuit), null).initIndependentStat().registerStat();
       	achievementAutoclave = new Achievement("achievement.autoclave", "autoclave", -1, 4, new ItemStack(ModBlocks.Autoclave), null).initIndependentStat().registerStat();
       	achievementIncubator = new Achievement("achievement.incubator", "incubator", -1, 4, new ItemStack(ModBlocks.Incubator), null).initIndependentStat().registerStat();
       	achievementMilk = new Achievement("achievement.milk", "milk", -3, 3, new ItemStack(Items.milk_bucket), null).initIndependentStat().registerStat();
       	
    	AchievementPage.registerAchievementPage(new AchievementPage("EpidemicCraft", new Achievement[]{achievementCraftFlu, achievementCraftMeningitis, achievementCraftCPox, achievementCraftPolio, achievementCraftRabies, achievementCraftFoodPois, achievementCraftEColi, achievementCraftGiardia, achievementBiosuit, achievementAutoclave, achievementIncubator, achievementMilk}));
    		
    	FMLCommonHandler.instance().bus().register(new EventTransmission());
    	FMLCommonHandler.instance().bus().register(new EventMilk());
    	FMLCommonHandler.instance().bus().register(new EventPotionZero());
    	FMLCommonHandler.instance().bus().register(new EventAchievements());
    	//END OF ACHIEVEMENTS
    }
 
    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {
    	proxy.postInit();
 
    }


}
