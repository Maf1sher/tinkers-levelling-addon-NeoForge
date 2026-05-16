package pyre.tinkerslevellingaddon.network;

import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.sounds.SimpleSoundInstance;
import net.minecraft.network.chat.Component;
import pyre.tinkerslevellingaddon.config.Config;
import pyre.tinkerslevellingaddon.util.ModUtil;

public class ClientPacketHandler {
    public static void handleLevelUpMessage(int level, Component toolName) {
        if (Config.enableLevelUpMessage.get()) {
            Minecraft.getInstance().gui.getChat().addMessage(ModUtil.makeTranslation("chat", "level_up", toolName, level));
        }
        Config.LevelUpSound sound = Config.levelUpSound.get();
        if (sound != Config.LevelUpSound.NONE) {
            Minecraft.getInstance().getSoundManager().play(SimpleSoundInstance.forUI(sound.getSoundEvent(), 1.0F));
        }
    }
}
