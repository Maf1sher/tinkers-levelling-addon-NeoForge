package pyre.tinkerslevellingaddon.setup;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.RegisterEvent;
import pyre.tinkerslevellingaddon.ImprovableModule;
import pyre.tinkerslevellingaddon.TinkersLevellingAddon;
import slimeknights.tconstruct.library.modifiers.modules.ModifierModule;

public class Registration {

    public static final DeferredRegister<SoundEvent> SOUNDS = DeferredRegister.create(Registries.SOUND_EVENT, TinkersLevellingAddon.MOD_ID);

    public static void init(IEventBus bus) {
        bus.addListener(Registration::registerSerializers);
        SOUNDS.register(bus);
    }

    private static void registerSerializers(RegisterEvent event) {
        if (event.getRegistryKey() == Registries.RECIPE_SERIALIZER) {
            ModifierModule.LOADER.register(
                    ResourceLocation.fromNamespaceAndPath(TinkersLevellingAddon.MOD_ID, "improvable"),
                    ImprovableModule.LOADER);
        }
    }

    private Registration() {
        // hide constructor
    }
}
