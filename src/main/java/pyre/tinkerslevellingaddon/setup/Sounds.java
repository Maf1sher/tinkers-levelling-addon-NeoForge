package pyre.tinkerslevellingaddon.setup;

import net.minecraft.sounds.SoundEvent;
import net.neoforged.neoforge.registries.DeferredHolder;
import pyre.tinkerslevellingaddon.util.ModUtil;

import java.util.function.Supplier;

public enum Sounds implements Supplier<SoundEvent> {
    CHIME("tool_level_up_chime"),
    SNARE_DRUM("tool_level_up_snare_drum"),
    YAY("tool_level_up_yay");

    private final DeferredHolder<SoundEvent, SoundEvent> holder;

    Sounds(String name) {
        this.holder = Registration.SOUNDS.register(name, () -> SoundEvent.createVariableRangeEvent(ModUtil.getResource(name)));
    }

    @Override
    public SoundEvent get() {
        return holder.get();
    }

    public SoundEvent getSound() {
        return get();
    }
}
