package net.denobody2.icysbopadditions.registry;

import net.denobody2.icysbopadditions.IcysBOPAdditions;
import net.denobody2.icysbopadditions.common.block.DeenCactusBlock;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, IcysBOPAdditions.MOD_ID);
    public static final RegistryObject<Block> DEEN_CACTUS = registerBlock("deen_cactus", () -> new DeenCactusBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG)
            .sound(SoundType.WOOD)));
    private static <T extends Block>RegistryObject<T> registerBlock(String name, Supplier<T> block){
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        if(name.equals("example")){
            registerBlockItemWithFireRes(name, toReturn);
        } else {
            registerBlockItem(name, toReturn);
        }
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block){
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }
    private static <T extends Block>RegistryObject<Item> registerBlockItemWithFireRes(String name, RegistryObject<T> block){
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().fireResistant()));
    }

}
