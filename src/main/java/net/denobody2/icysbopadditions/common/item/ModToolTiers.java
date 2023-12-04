package net.denobody2.icysbopadditions.common.item;

import biomesoplenty.init.ModTags;
import net.denobody2.icysbopadditions.IcysBOPAdditions;
import net.denobody2.icysbopadditions.registry.ModItems;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.TierSortingRegistry;

import java.util.List;

public class ModToolTiers {
    public static final Tier DEIRUM = TierSortingRegistry.registerTier(
            new ForgeTier(4, 1800, 8.5f, 3.5f, 22,
                    Tags.Blocks.NEEDS_NETHERITE_TOOL, () -> Ingredient.of(ModItems.DEIRUM.get())),
            new ResourceLocation(IcysBOPAdditions.MOD_ID, "deruim"), List.of(Tiers.DIAMOND), List.of());
}
