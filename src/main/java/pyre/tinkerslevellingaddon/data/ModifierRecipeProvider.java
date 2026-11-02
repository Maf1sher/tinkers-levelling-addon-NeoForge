package pyre.tinkerslevellingaddon.data;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;
import pyre.tinkerslevellingaddon.TinkersLevellingAddon;
import pyre.tinkerslevellingaddon.util.ModUtil;
import slimeknights.mantle.recipe.data.IRecipeHelper;
import slimeknights.tconstruct.library.modifiers.ModifierId;
import slimeknights.tconstruct.library.recipe.modifiers.adding.ModifierRecipeBuilder;
import slimeknights.tconstruct.library.tools.SlotType;

import java.util.concurrent.CompletableFuture;

public class ModifierRecipeProvider extends RecipeProvider implements IConditionBuilder, IRecipeHelper {

    public ModifierRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    @Override
    protected void buildRecipes(RecipeOutput consumer) {
        String abilityFolder = "tools/modifiers/ability/";
        String abilitySalvage = "tools/modifiers/salvage/ability/";

        ModifierId improvableId = new ModifierId(ModUtil.getResource("improvable"));
        ModifierRecipeBuilder.modifier(improvableId)
                .addInput(Items.EXPERIENCE_BOTTLE)
                .addInput(Items.NETHER_STAR)
                .addInput(Items.EXPERIENCE_BOTTLE)
                .addInput(Items.EXPERIENCE_BOTTLE)
                .addInput(Items.EXPERIENCE_BOTTLE)
                .setSlots(SlotType.ABILITY, 1)
                .setMaxLevel(1)
                .saveSalvage(consumer, prefix(improvableId.getLocation(), abilitySalvage))
                .save(consumer, prefix(improvableId.getLocation(), abilityFolder));
    }

    /* IRecipeHelper helpers */
    @Override
    public ResourceLocation prefix(ResourceLocation location, String prefix) {
        return ResourceLocation.fromNamespaceAndPath(location.getNamespace(), prefix + location.getPath());
    }

    @Override
    public String getModId() {
        return TinkersLevellingAddon.MOD_ID;
    }
}
