package net.denobody2.icysbopadditions.registry;

import net.denobody2.icysbopadditions.IcysBOPAdditions;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, IcysBOPAdditions.MOD_ID);

    public static void register(IEventBus eventBus){

        ITEMS.register(eventBus);

    }
}
