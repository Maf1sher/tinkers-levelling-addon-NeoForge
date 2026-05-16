package pyre.tinkerslevellingaddon.command;

import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.exceptions.DynamicCommandExceptionType;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.network.chat.Component;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.RegisterCommandsEvent;
import pyre.tinkerslevellingaddon.TinkersLevellingAddon;

import java.util.function.Consumer;

@EventBusSubscriber(modid = TinkersLevellingAddon.MOD_ID, bus = EventBusSubscriber.Bus.GAME)
public class ModCommands {
    
    /**
     * Permission level that can run standard game commands, used by command blocks and functions
     */
    public static final int PERMISSION_GAME_COMMANDS = 2;
    
    public static final DynamicCommandExceptionType TOOL_VALIDATION_ERROR = new DynamicCommandExceptionType(Component.class::cast);
    
    public static void init() {
        // No longer needed with @EventBusSubscriber, but kept for compatibility if needed
    }
    
    private static void register(LiteralArgumentBuilder<CommandSourceStack> root, String name,
                                 Consumer<LiteralArgumentBuilder<CommandSourceStack>> consumer) {
        LiteralArgumentBuilder<CommandSourceStack> subCommand = Commands.literal(name);
        consumer.accept(subCommand);
        root.then(subCommand);
    }
    
    @SubscribeEvent
    public static void registerCommand(RegisterCommandsEvent event) {
        LiteralArgumentBuilder<CommandSourceStack> builder = Commands.literal(TinkersLevellingAddon.MOD_ID);
        
        // sub commands
        register(builder, "levels", LevelsCommand::register);
        register(builder, "xp", ExperienceCommand::register);
        
        // register final command
        event.getDispatcher().register(builder);
    }
    
    enum Operation {
        ADD,
        SET
    }
}
