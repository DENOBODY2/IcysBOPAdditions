package net.denobody2.icysbopadditions.registry;

import net.denobody2.icysbopadditions.IcysBOPAdditions;
import net.denobody2.icysbopadditions.common.item.ModToolTiers;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SwordItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, IcysBOPAdditions.MOD_ID);
    public static final RegistryObject<Item> DEIRUM = ITEMS.register("deirum",
            () -> new Item(new Item.Properties().fireResistant()));
    public static final RegistryObject<Item> DEIRUM_SWORD = ITEMS.register("deirum_sword",
            () -> new SwordItem(ModToolTiers.DEIRUM, 3, -2.2f, new Item.Properties().fireResistant()));
    public static final RegistryObject<Item> DEIRUM_WARAXE = ITEMS.register("deirum_waraxe",
            () -> new AxeItem(ModToolTiers.DEIRUM, 4.5f, -2.7f, new Item.Properties().fireResistant()));
    public static void register(IEventBus eventBus){

        ITEMS.register(eventBus);

    }
}
