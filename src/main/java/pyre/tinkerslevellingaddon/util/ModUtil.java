package pyre.tinkerslevellingaddon.util;

import net.minecraft.ChatFormatting;
import net.minecraft.Util;
import net.minecraft.network.chat.*;
import net.minecraft.resources.ResourceLocation;
import pyre.tinkerslevellingaddon.TinkersLevellingAddon;

public class ModUtil {
    
    public static ResourceLocation getResource(String name) {
        return ResourceLocation.fromNamespaceAndPath(TinkersLevellingAddon.MOD_ID, name);
    }
    
    /** Translation key for the given base and name; usable on both sides, unlike a client translation lookup */
    public static String getTranslationKey(String base, String name) {
        return Util.makeDescriptionId(base, getResource(toSnakeCase(name)));
    }
    
    public static MutableComponent makeTranslation(String base, String name) {
        return Component.translatable(getTranslationKey(base, name));
    }
    
    public static MutableComponent makeTranslation(String base, String name, TextColor color) {
        return Component.translatable(getTranslationKey(base, name))
                .withStyle(s -> s.withColor(color));
    }
    
    public static MutableComponent makeTranslation(String base, String name, Object... arguments) {
        return Component.translatable(getTranslationKey(base, name), arguments);
    }
    
    public static MutableComponent makeTranslation(String base, String name, ChatFormatting color, Object... arguments) {
        return Component.translatable(getTranslationKey(base, name), arguments)
                .withStyle(color);
    }
    
    public static MutableComponent makeText(Number value, ChatFormatting color) {
        return Component.literal(value.toString()).withStyle(color);
    }
    
    public static MutableComponent makeText(String text, TextColor color) {
        return Component.literal(text).withStyle(s -> s.withColor(color));
    }
    
    public static MutableComponent makeText(Number value, TextColor color) {
        return Component.literal(value.toString()).withStyle(s -> s.withColor(color));
    }
    
    private static String toSnakeCase(String text) {
        return text.replaceAll("((?!<_)([A-Z]))", "_$1").toLowerCase();
    }
    
    private ModUtil() {
        //hide constructor
    }
}
