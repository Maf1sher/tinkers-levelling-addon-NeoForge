package pyre.tinkerslevellingaddon.setup;

import net.neoforged.bus.api.IEventBus;
import pyre.tinkerslevellingaddon.ImprovableModifier;
import pyre.tinkerslevellingaddon.TinkersLevellingAddon;
import slimeknights.tconstruct.library.modifiers.util.ModifierDeferredRegister;
import slimeknights.tconstruct.library.modifiers.util.StaticModifier;

import net.minecraft.core.registries.Registries;
import net.minecraft.sounds.SoundEvent;
import net.neoforged.neoforge.registries.DeferredRegister;

public class Registration {

    private static final ModifierDeferredRegister MODIFIERS = ModifierDeferredRegister.create(TinkersLevellingAddon.MOD_ID);
    public static final DeferredRegister<SoundEvent> SOUNDS = DeferredRegister.create(Registries.SOUND_EVENT, TinkersLevellingAddon.MOD_ID);
    
    public static final StaticModifier<ImprovableModifier> IMPROVABLE =
            MODIFIERS.register("improvable", ImprovableModifier::new);

    public static void init(IEventBus bus) {
        MODIFIERS.register(bus);
        SOUNDS.register(bus);
    }
}
