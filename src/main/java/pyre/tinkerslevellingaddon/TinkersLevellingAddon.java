package pyre.tinkerslevellingaddon;

import com.mojang.logging.LogUtils;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.data.event.GatherDataEvent;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.slf4j.Logger;
import pyre.tinkerslevellingaddon.command.ModCommands;
import pyre.tinkerslevellingaddon.config.Config;
import pyre.tinkerslevellingaddon.data.ColorProvider;
import pyre.tinkerslevellingaddon.data.ModifierRecipeProvider;
import pyre.tinkerslevellingaddon.data.ModifierTagProvider;
import pyre.tinkerslevellingaddon.setup.Registration;

@Mod(TinkersLevellingAddon.MOD_ID)
public class TinkersLevellingAddon {

    public static final Logger LOGGER = LogUtils.getLogger();

    public static final String MOD_ID = "tinkerslevellingaddon";

    public TinkersLevellingAddon(IEventBus modEventBus) {
        Config.init();
        Registration.init(modEventBus);
        // Messages.register();
        ModCommands.init();

        modEventBus.addListener(this::gatherData);
    }

    private void gatherData(final GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        PackOutput packOutput = generator.getPackOutput();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();

        generator.addProvider(event.includeServer(), new ModifierTagProvider(packOutput, existingFileHelper));
        generator.addProvider(event.includeServer(), new ModifierRecipeProvider(packOutput, event.getLookupProvider()));
        generator.addProvider(event.includeClient(), new ColorProvider(packOutput));
    }
}
