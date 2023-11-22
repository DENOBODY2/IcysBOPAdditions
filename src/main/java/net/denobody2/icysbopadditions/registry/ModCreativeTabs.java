package net.denobody2.icysbopadditions.registry;

import net.denobody2.icysbopadditions.IcysBOPAdditions;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, IcysBOPAdditions.MOD_ID);

    public static final RegistryObject<CreativeModeTab> TAB = CREATIVE_MODE_TABS.register("icysbopadditions", () -> CreativeModeTab.builder()
            .icon(() -> new ItemStack(ModBlocks.DEEN_CACTUS.get()))
            .title(Component.translatable("itemGroup.icysbopadditions"))
            .displayItems((pParameters, pOutput) -> {
                for (var item : ModItems.ITEMS.getEntries()) {
                    pOutput.accept(item.get());
                }
                /*for (var block: ModBlocks.BLOCKS.getEntries()){
                    pOutput.accept(block.get());
                }*/
            }).build());
}
