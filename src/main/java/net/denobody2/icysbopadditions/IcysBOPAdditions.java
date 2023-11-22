package net.denobody2.icysbopadditions;

import com.mojang.logging.LogUtils;
import net.denobody2.icysbopadditions.registry.ModBlocks;
import net.denobody2.icysbopadditions.registry.ModCreativeTabs;
import net.denobody2.icysbopadditions.registry.ModItems;
import net.minecraft.SharedConstants;
import net.minecraft.network.chat.Component;
import net.minecraft.server.packs.PackType;
import net.minecraft.server.packs.PathPackResources;
import net.minecraft.server.packs.metadata.pack.PackMetadataSection;
import net.minecraft.server.packs.repository.Pack;
import net.minecraft.server.packs.repository.PackSource;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.AddPackFindersEvent;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.resource.DelegatingPackResources;
import org.slf4j.Logger;

import java.nio.file.Path;
import java.util.List;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(IcysBOPAdditions.MOD_ID)
public class IcysBOPAdditions
{
    // Define mod id in a common place for everything to reference
    public static final String MOD_ID = "icysbopadditions";
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();
    // Create a Deferred Register to hold Blocks which will all be registered under the "examplemod" namespace

    public IcysBOPAdditions()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        // Register the commonSetup method for modloading
        modEventBus.addListener(this::commonSetup);
        modEventBus.addListener(this::packSetup);
        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
        ModItems.ITEMS.register(modEventBus);
        ModBlocks.BLOCKS.register(modEventBus);
        ModCreativeTabs.CREATIVE_MODE_TABS.register(modEventBus);




    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {

    }
    public void packSetup(AddPackFindersEvent event) {
        // Resource Packs
        this.setupAdditionsPack(event);
    }
    private void setupAdditionsPack(AddPackFindersEvent event) {
        if (event.getPackType() == PackType.CLIENT_RESOURCES) {
            Path resourcePath = ModList.get().getModFileById(IcysBOPAdditions.MOD_ID).getFile().findResource("packs/icysretextures");
            PathPackResources pack = new PathPackResources(ModList.get().getModFileById(IcysBOPAdditions.MOD_ID).getFile().getFileName() + ":" + resourcePath, resourcePath, false);
            //System.out.println("System.out.println READ THIS DENOBODY2!" + pack);
            Path baseResourcePath = ModList.get().getModFileById(IcysBOPAdditions.MOD_ID).getFile().findResource("packs/icysretextures");
            PathPackResources basePack = new PathPackResources(ModList.get().getModFileById(IcysBOPAdditions.MOD_ID).getFile().getFileName() + ":" + baseResourcePath, baseResourcePath, false);
            String name = "builtin/icysretextures";
            String title = "pack.icysbopadditions.icysretextures.title";
            String description = "pack.icysbopadditions.icysretextures.description";
            List<PathPackResources> mergedPacks = List.of(pack,basePack);
            Pack.ResourcesSupplier resourcesSupplier =(string) -> new DelegatingPackResources(name, true, new PackMetadataSection(Component.translatable(description), SharedConstants.getCurrentVersion().getPackVersion(PackType.CLIENT_RESOURCES)), mergedPacks);
            Pack.Info info = Pack.readPackInfo(name, resourcesSupplier);
            if (info != null) {
                event.addRepositorySource((source) ->
                        source.accept(Pack.create(
                                name,
                                Component.translatable(title),
                                false,
                                resourcesSupplier,
                                info,
                                PackType.CLIENT_RESOURCES,
                                Pack.Position.TOP,
                                false,
                                PackSource.BUILT_IN)
                        ));
            }
        }
    }
    // Add the example block item to the building blocks tab
    private void addCreative(BuildCreativeModeTabContentsEvent event)
    {
        if (event.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS){

        }
            //event.accept(EXAMPLE_BLOCK_ITEM);
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {

    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {

        }
    }
}
