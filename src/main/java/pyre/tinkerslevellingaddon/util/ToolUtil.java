package pyre.tinkerslevellingaddon.util;

import net.minecraft.world.item.ItemStack;
import pyre.tinkerslevellingaddon.setup.AddonModifierIds;
import slimeknights.tconstruct.library.tools.helper.ModifierUtil;

public class ToolUtil {

    public static boolean hasImprovable(ItemStack activeStack) {
        return ModifierUtil.getModifierLevel(activeStack, AddonModifierIds.IMPROVABLE) > 0;
    }

    private ToolUtil() {
        // hide constructor
    }
}
