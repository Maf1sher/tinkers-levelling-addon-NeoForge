package pyre.tinkerslevellingaddon.data;

import net.minecraft.data.PackOutput;
import pyre.tinkerslevellingaddon.ImprovableModifier;
import pyre.tinkerslevellingaddon.TinkersLevellingAddon;
import pyre.tinkerslevellingaddon.data.generator.MantleColorGenerator;
import pyre.tinkerslevellingaddon.setup.AddonModifierIds;

public class ColorProvider extends MantleColorGenerator {

    public ColorProvider(PackOutput packOutput) {
        super(packOutput, TinkersLevellingAddon.MOD_ID);
    }

    @Override
    protected void addColors() {
        addModifier(AddonModifierIds.IMPROVABLE, ImprovableModifier.IMPROVABLE_MODIFIER_COLOR.toString());
    }

    @Override
    public String getName() {
        return "Tinkers' Levelling Addon Mantle Colors";
    }
}
