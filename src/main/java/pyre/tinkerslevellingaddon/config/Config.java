package pyre.tinkerslevellingaddon.config;

import com.electronwill.nightconfig.core.EnumGetMethod;
import net.minecraft.sounds.SoundEvent;
import net.neoforged.fml.ModLoadingContext;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.neoforge.common.ModConfigSpec;
import pyre.tinkerslevellingaddon.setup.Sounds;
import slimeknights.tconstruct.library.tools.stat.FloatToolStat;
import slimeknights.tconstruct.library.tools.stat.ToolStats;

import java.util.List;
import java.util.function.Supplier;

import static pyre.tinkerslevellingaddon.util.ToolLevellingUtil.*;

public class Config {

    private static final List<String> DEFAULT_TOOLS_SLOTS_ORDER = List.of(UPGRADE, UPGRADE, UPGRADE, ABILITY, UPGRADE);
    private static final List<String> DEFAULT_TOOLS_SLOTS_RANDOM_POOL = List.of(UPGRADE, UPGRADE, UPGRADE, UPGRADE, ABILITY);
    private static final List<String> DEFAULT_RANGED_SLOTS_ORDER = List.of(UPGRADE, UPGRADE, UPGRADE, ABILITY, UPGRADE);
    private static final List<String> DEFAULT_RANGED_SLOTS_RANDOM_POOL = List.of(UPGRADE, UPGRADE, UPGRADE, UPGRADE, ABILITY);
    private static final List<String> DEFAULT_ARMOR_SLOTS_ORDER = List.of(UPGRADE, DEFENSE, UPGRADE, ABILITY, DEFENSE);
    private static final List<String> DEFAULT_ARMOR_SLOTS_RANDOM_POOL = List.of(UPGRADE, UPGRADE, DEFENSE, DEFENSE, ABILITY);
    private static final List<String> DEFAULT_STAFF_SLOTS_ORDER = List.of(UPGRADE, UPGRADE, UPGRADE, DEFENSE, ABILITY);
    private static final List<String> DEFAULT_STAFF_SLOTS_RANDOM_POOL = List.of(UPGRADE, UPGRADE, UPGRADE, DEFENSE, ABILITY);
    private static final List<String> DEFAULT_SHIELD_SLOTS_ORDER = List.of(UPGRADE, DEFENSE, UPGRADE, DEFENSE, ABILITY);
    private static final List<String> DEFAULT_SHIELD_SLOTS_RANDOM_POOL = List.of(UPGRADE, DEFENSE, UPGRADE, DEFENSE, ABILITY);

    private static final List<String> DEFAULT_TOOLS_STATS_ORDER = List.of(DURABILITY, ATTACK_DAMAGE, ATTACK_SPEED, MINING_SPEED);
    private static final List<String> DEFAULT_TOOLS_STATS_RANDOM_POOL = List.of(DURABILITY, ATTACK_DAMAGE, ATTACK_SPEED, MINING_SPEED);
    private static final List<String> DEFAULT_RANGED_STATS_ORDER = List.of(DURABILITY, DRAW_SPEED, VELOCITY, ACCURACY, PROJECTILE_DAMAGE);
    private static final List<String> DEFAULT_RANGED_STATS_RANDOM_POOL = List.of(DURABILITY, DRAW_SPEED, VELOCITY, ACCURACY, PROJECTILE_DAMAGE);
    private static final List<String> DEFAULT_ARMOR_STATS_ORDER = List.of(DURABILITY, ARMOR, ARMOR_TOUGHNESS, KNOCKBACK_RESISTANCE);
    private static final List<String> DEFAULT_ARMOR_STATS_RANDOM_POOL = List.of(DURABILITY, ARMOR, ARMOR_TOUGHNESS, KNOCKBACK_RESISTANCE);
    private static final List<String> DEFAULT_STAFF_STATS_ORDER = List.of(DURABILITY, DRAW_SPEED, VELOCITY, ACCURACY, PROJECTILE_DAMAGE, ARMOR);
    private static final List<String> DEFAULT_STAFF_STATS_RANDOM_POOL = List.of(DURABILITY, DRAW_SPEED, VELOCITY, ACCURACY, PROJECTILE_DAMAGE, ARMOR);
    private static final List<String> DEFAULT_SHIELD_STATS_ORDER = List.of(DURABILITY, BLOCK_AMOUNT, BLOCK_ANGLE, ARMOR_TOUGHNESS, KNOCKBACK_RESISTANCE);
    private static final List<String> DEFAULT_SHIELD_STATS_RANDOM_POOL = List.of(DURABILITY, BLOCK_AMOUNT, BLOCK_ANGLE, ARMOR_TOUGHNESS, KNOCKBACK_RESISTANCE);

    public static final ModConfigSpec SERVER_CONFIG;
    public static final ModConfigSpec CLIENT_CONFIG;

    static {
        ModConfigSpec.Builder serverConfigBuilder = new ModConfigSpec.Builder();
        generalConfig(serverConfigBuilder);
        toolLevellingConfig(serverConfigBuilder);
        SERVER_CONFIG = serverConfigBuilder.build();
        ModConfigSpec.Builder clientConfigBuilder = new ModConfigSpec.Builder();
        clientConfig(clientConfigBuilder);
        CLIENT_CONFIG = clientConfigBuilder.build();
    }

    //SERVER
    //General
    public static ModConfigSpec.EnumValue<GainingMethod> toolsSlotGainingMethod;
    public static ModConfigSpec.EnumValue<GainingMethod> toolsStatGainingMethod;
    public static ModConfigSpec.EnumValue<GainingMethod> rangedSlotGainingMethod;
    public static ModConfigSpec.EnumValue<GainingMethod> rangedStatGainingMethod;
    public static ModConfigSpec.EnumValue<GainingMethod> armorSlotGainingMethod;
    public static ModConfigSpec.EnumValue<GainingMethod> armorStatGainingMethod;
    public static ModConfigSpec.EnumValue<GainingMethod> staffSlotGainingMethod;
    public static ModConfigSpec.EnumValue<GainingMethod> staffStatGainingMethod;
    public static ModConfigSpec.EnumValue<GainingMethod> shieldSlotGainingMethod;
    public static ModConfigSpec.EnumValue<GainingMethod> shieldStatGainingMethod;
    public static ModConfigSpec.IntValue maxLevel;
    public static ModConfigSpec.IntValue baseExperience;
    public static ModConfigSpec.DoubleValue requiredXpMultiplier;
    public static ModConfigSpec.DoubleValue broadToolRequiredXpMultiplier;

    //general.slots
    private static ModConfigSpec.ConfigValue<List<? extends String>> toolsSlotTypeRandomPool;
    private static ModConfigSpec.ConfigValue<List<? extends String>> toolsSlotTypeOrder;
    private static ModConfigSpec.ConfigValue<List<? extends String>> rangedSlotTypeRandomPool;
    private static ModConfigSpec.ConfigValue<List<? extends String>> rangedSlotTypeOrder;
    private static ModConfigSpec.ConfigValue<List<? extends String>> armorSlotTypeRandomPool;
    private static ModConfigSpec.ConfigValue<List<? extends String>> armorSlotTypeOrder;
    private static ModConfigSpec.ConfigValue<List<? extends String>> staffSlotTypeRandomPool;
    private static ModConfigSpec.ConfigValue<List<? extends String>> staffSlotTypeOrder;
    private static ModConfigSpec.ConfigValue<List<? extends String>> shieldSlotTypeRandomPool;
    private static ModConfigSpec.ConfigValue<List<? extends String>> shieldSlotTypeOrder;

    //general.stats
    private static ModConfigSpec.ConfigValue<List<? extends String>> toolsStatTypeRandomPool;
    private static ModConfigSpec.ConfigValue<List<? extends String>> toolsStatTypeOrder;
    private static ModConfigSpec.ConfigValue<List<? extends String>> rangedStatTypeRandomPool;
    private static ModConfigSpec.ConfigValue<List<? extends String>> rangedStatTypeOrder;
    private static ModConfigSpec.ConfigValue<List<? extends String>> armorStatTypeRandomPool;
    private static ModConfigSpec.ConfigValue<List<? extends String>> armorStatTypeOrder;
    private static ModConfigSpec.ConfigValue<List<? extends String>> staffStatTypeRandomPool;
    private static ModConfigSpec.ConfigValue<List<? extends String>> staffStatTypeOrder;
    private static ModConfigSpec.ConfigValue<List<? extends String>> shieldStatTypeRandomPool;
    private static ModConfigSpec.ConfigValue<List<? extends String>> shieldStatTypeOrder;

    //general.stats.toolValues
    public static ModConfigSpec.IntValue toolDurabilityValue;
    public static ModConfigSpec.DoubleValue toolAttackDamageValue;
    public static ModConfigSpec.DoubleValue toolAttackSpeedValue;
    public static ModConfigSpec.DoubleValue toolMiningSpeedValue;
    
    //general.stats.rangedValues
    public static ModConfigSpec.IntValue rangedDurabilityValue;
    public static ModConfigSpec.DoubleValue rangedDrawSpeedValue;
    public static ModConfigSpec.DoubleValue rangedVelocityValue;
    public static ModConfigSpec.DoubleValue rangedAccuracyValue;
    public static ModConfigSpec.DoubleValue rangedProjectileDamageValue;
    public static ModConfigSpec.DoubleValue rangedAttackDamageValue;
    public static ModConfigSpec.DoubleValue rangedAttackSpeedValue;

    //general.stats.armorValues
    public static ModConfigSpec.IntValue armorDurabilityValue;
    public static ModConfigSpec.DoubleValue armorArmorValue;
    public static ModConfigSpec.DoubleValue armorArmorToughnessValue;
    public static ModConfigSpec.DoubleValue armorKnockbackResistanceValue;
    
    //general.stats.staffValues
    public static ModConfigSpec.IntValue staffDurabilityValue;
    public static ModConfigSpec.DoubleValue staffDrawSpeedValue;
    public static ModConfigSpec.DoubleValue staffVelocityValue;
    public static ModConfigSpec.DoubleValue staffAccuracyValue;
    public static ModConfigSpec.DoubleValue staffProjectileDamageValue;
    public static ModConfigSpec.DoubleValue staffArmorValue;

    //general.stats.shieldValues
    public static ModConfigSpec.DoubleValue shieldArmorToughnessValue;
    public static ModConfigSpec.DoubleValue shieldBlockAmountValue;
    public static ModConfigSpec.IntValue shieldBlockAngleValue;
    public static ModConfigSpec.IntValue shieldDurabilityValue;
    public static ModConfigSpec.DoubleValue shieldKnockbackResistanceValue;

    //toolLevelling
    public static ModConfigSpec.BooleanValue damageDealt;
    public static ModConfigSpec.BooleanValue damageTaken;
    public static ModConfigSpec.BooleanValue damageBlocked;
    public static ModConfigSpec.BooleanValue enablePvp;
    public static ModConfigSpec.IntValue flyingTime;

    //toolLevelling.actions
    public static ModConfigSpec.BooleanValue enableMiningXp;
    public static ModConfigSpec.BooleanValue enableHarvestingXp;
    public static ModConfigSpec.BooleanValue enableShearingXp;
    public static ModConfigSpec.BooleanValue enableStrippingXp;
    public static ModConfigSpec.BooleanValue enableScrappingXp;
    public static ModConfigSpec.BooleanValue enableWaxingOffXp;
    public static ModConfigSpec.BooleanValue enableTillingXp;
    public static ModConfigSpec.BooleanValue enablePathMakingXp;
    public static ModConfigSpec.BooleanValue enableAttackingXp;
    public static ModConfigSpec.BooleanValue enableShootingXp;
    public static ModConfigSpec.BooleanValue enableTakingDamageXp;
    public static ModConfigSpec.BooleanValue enableBlockingDamageXp;
    public static ModConfigSpec.BooleanValue enableThornsXp;
    public static ModConfigSpec.BooleanValue enableFlyingXp;
    public static ModConfigSpec.BooleanValue enablePlowingXp;
    public static ModConfigSpec.BooleanValue enablePathMakerXp;
    public static ModConfigSpec.BooleanValue enableSnowdriftXp;
    public static ModConfigSpec.BooleanValue enableFlamewakeXp;
    public static ModConfigSpec.BooleanValue enableFrostWalkerXp;
    public static ModConfigSpec.BooleanValue enableWarpingXp;
    public static ModConfigSpec.BooleanValue enableFlingingXp;
    public static ModConfigSpec.BooleanValue enableSpringingXp;
    public static ModConfigSpec.BooleanValue enableBonkingXp;
    public static ModConfigSpec.BooleanValue enableGlowingXp;
    public static ModConfigSpec.BooleanValue enableFirestarterXp;
    public static ModConfigSpec.BooleanValue enableBrushingXp;
    public static ModConfigSpec.BooleanValue enableBucketingXp;
    public static ModConfigSpec.BooleanValue enableFishingXp;
    public static ModConfigSpec.BooleanValue enableGrapplingXp;
    public static ModConfigSpec.BooleanValue enableMeltingXp;
    public static ModConfigSpec.BooleanValue enableSlimeballXp;
    public static ModConfigSpec.BooleanValue enableSlurpingXp;
    public static ModConfigSpec.BooleanValue enableSpillingXp;
    public static ModConfigSpec.BooleanValue enableSpittingXp;
    public static ModConfigSpec.BooleanValue enableSplashingXp;

    //toolLevelling.bonuses
    public static ModConfigSpec.IntValue bonusMiningXp;
    public static ModConfigSpec.IntValue bonusHarvestingXp;
    public static ModConfigSpec.IntValue bonusShearingXp;
    public static ModConfigSpec.IntValue bonusStrippingXp;
    public static ModConfigSpec.IntValue bonusScrappingXp;
    public static ModConfigSpec.IntValue bonusWaxingOffXp;
    public static ModConfigSpec.IntValue bonusTillingXp;
    public static ModConfigSpec.IntValue bonusPathMakingXp;
    public static ModConfigSpec.IntValue bonusAttackingXp;
    public static ModConfigSpec.IntValue bonusShootingXp;
    public static ModConfigSpec.IntValue bonusTakingDamageXp;
    public static ModConfigSpec.IntValue bonusBlockingDamageXp;
    public static ModConfigSpec.IntValue bonusThornsXp;
    public static ModConfigSpec.IntValue bonusFlyingXp;
    public static ModConfigSpec.IntValue bonusPlowingXp;
    public static ModConfigSpec.IntValue bonusPathMakerXp;
    public static ModConfigSpec.IntValue bonusSnowdriftXp;
    public static ModConfigSpec.IntValue bonusFlamewakeXp;
    public static ModConfigSpec.IntValue bonusFrostWalkerXp;
    public static ModConfigSpec.IntValue bonusWarpingXp;
    public static ModConfigSpec.IntValue bonusFlingingXp;
    public static ModConfigSpec.IntValue bonusSpringingXp;
    public static ModConfigSpec.IntValue bonusBonkingXp;
    public static ModConfigSpec.IntValue bonusGlowingXp;
    public static ModConfigSpec.IntValue bonusFirestarterXp;
    public static ModConfigSpec.IntValue bonusBrushingXp;
    public static ModConfigSpec.IntValue bonusBucketingXp;
    public static ModConfigSpec.IntValue bonusFishingXp;
    public static ModConfigSpec.IntValue bonusGrapplingXp;
    public static ModConfigSpec.IntValue bonusMeltingXp;
    public static ModConfigSpec.IntValue bonusSlimeballXp;
    public static ModConfigSpec.IntValue bonusSlurpingXp;
    public static ModConfigSpec.IntValue bonusSpillingXp;
    public static ModConfigSpec.IntValue bonusSpittingXp;
    public static ModConfigSpec.IntValue bonusSplashingXp;

    //CLIENT
    public static ModConfigSpec.BooleanValue enableLevelUpMessage;
    public static ModConfigSpec.BooleanValue squashLevelPluses;
    public static ModConfigSpec.EnumValue<LevelUpSound> levelUpSound;

    private static void generalConfig(ModConfigSpec.Builder builder) {
        builder.comment("General addon settings").push("general");

        toolsSlotGainingMethod = builder.comment("Method of gaining modifier slots for tools.")
                .translation("config.tinkerslevellingaddon.general.tools_slot_gaining_method")
                .defineEnum("toolsSlotGainingMethod", GainingMethod.PREDEFINED_ORDER, EnumGetMethod.NAME_IGNORECASE, GainingMethod.values());
    
        rangedSlotGainingMethod = builder.comment("Method of gaining modifier slots for ranged weapons.")
                .translation("config.tinkerslevellingaddon.general.ranged_slot_gaining_method")
                .defineEnum("rangedSlotGainingMethod", GainingMethod.PREDEFINED_ORDER, EnumGetMethod.NAME_IGNORECASE, GainingMethod.values());

        armorSlotGainingMethod = builder.comment("Method of gaining modifier slots for armor.")
                .translation("config.tinkerslevellingaddon.general.armor_slot_gaining_method")
                .defineEnum("armorSlotGainingMethod", GainingMethod.PREDEFINED_ORDER, EnumGetMethod.NAME_IGNORECASE, GainingMethod.values());
        
        staffSlotGainingMethod = builder.comment("Method of gaining modifier slots for staffs.")
                .translation("config.tinkerslevellingaddon.general.staff_slot_gaining_method")
                .defineEnum("staffSlotGainingMethod", GainingMethod.PREDEFINED_ORDER, EnumGetMethod.NAME_IGNORECASE, GainingMethod.values());

        shieldSlotGainingMethod = builder.comment("Method of gaining modifier slots for shields.")
                .translation("config.tinkerslevellingaddon.general.shield_slot_gaining_method")
                .defineEnum("shieldSlotGainingMethod", GainingMethod.PREDEFINED_ORDER, EnumGetMethod.NAME_IGNORECASE, GainingMethod.values());

        slotsConfig(builder);

        toolsStatGainingMethod = builder.comment("Method of gaining stats for tools.")
                .translation("config.tinkerslevellingaddon.general.tools_stat_gaining_method")
                .defineEnum("toolsStatGainingMethod", GainingMethod.NONE, EnumGetMethod.NAME_IGNORECASE, GainingMethod.values());
    
        rangedStatGainingMethod = builder.comment("Method of gaining stats for tools.")
                .translation("config.tinkerslevellingaddon.general.ranged_stat_gaining_method")
                .defineEnum("rangedStatGainingMethod", GainingMethod.NONE, EnumGetMethod.NAME_IGNORECASE, GainingMethod.values());

        armorStatGainingMethod = builder.comment("Method of gaining stats for armor.")
                .translation("config.tinkerslevellingaddon.general.armor_stat_gaining_method")
                .defineEnum("armorStatGainingMethod", GainingMethod.NONE, EnumGetMethod.NAME_IGNORECASE, GainingMethod.values());
        
        staffStatGainingMethod = builder.comment("Method of gaining stats for staffs.")
                .translation("config.tinkerslevellingaddon.general.staff_stat_gaining_method")
                .defineEnum("staffStatGainingMethod", GainingMethod.NONE, EnumGetMethod.NAME_IGNORECASE, GainingMethod.values());

        shieldStatGainingMethod = builder.comment("Method of gaining stats for shields.")
                .translation("config.tinkerslevellingaddon.general.shield_stat_gaining_method")
                .defineEnum("shieldStatGainingMethod", GainingMethod.NONE, EnumGetMethod.NAME_IGNORECASE, GainingMethod.values());

        statsConfig(builder);

        maxLevel = builder.comment("Maximum tool level that could be achieved. If set to 0 there is no upper limit.")
                .translation("config.tinkerslevellingaddon.general.max_level")
                .defineInRange("maxLevel", 5, 0, Integer.MAX_VALUE);

        baseExperience = builder.comment("Base amount of experience required to reach next level.")
                .translation("config.tinkerslevellingaddon.general.base_experience")
                .defineInRange("baseExperience", 500, 1, Integer.MAX_VALUE);

        requiredXpMultiplier = builder.comment("How much the amount of experience required to reach next level will be multiplied per level.")
                .translation("config.tinkerslevellingaddon.general.required_xp_multiplier")
                .defineInRange("requiredXpMultiplier", 2D, 1D, 10D);

        broadToolRequiredXpMultiplier = builder.comment("Additional multiplier for broad tools for experience required to level up.")
                .translation("config.tinkerslevellingaddon.general.broad_tool_required_xp_multiplier")
                .defineInRange("broadToolRequiredXpMultiplier", 3D, 1D, 10D);

        builder.pop();
    }

    private static void slotsConfig(ModConfigSpec.Builder builder) {
        builder.comment("Modifier slots settings").push("slots");

        toolsSlotTypeRandomPool = builder.comment("Set of modifier slot types from which random slot will be awarded when leveling up tools.",
                        "If empty default pool will be used (" + String.join(", ", DEFAULT_TOOLS_SLOTS_RANDOM_POOL) + "). 80% chance for upgrade and 20% chance for ability.",
                        "Allowed values: " + String.join(", ", getToolSlotTypes()))
                .translation("config.tinkerslevellingaddon.general.slots.tools_slot_type_random_pool")
                .defineList("toolsSlotTypeRandomPool", DEFAULT_TOOLS_SLOTS_RANDOM_POOL, t -> getToolSlotTypes().contains((String) t));

        toolsSlotTypeOrder = builder.comment("List of modifier slot types (in order) that will be awarded when leveling up tools. If level is higher than list size the mod will start over.",
                        "If empty default order will be used (" + String.join(", ", DEFAULT_TOOLS_SLOTS_ORDER) + ").",
                        "Allowed values: " + String.join(", ", getToolSlotTypes()))
                .translation("config.tinkerslevellingaddon.general.slots.tools_slot_type_order")
                .defineList("toolsSlotTypeOrder", DEFAULT_TOOLS_SLOTS_ORDER, t -> getToolSlotTypes().contains((String) t));
    
        rangedSlotTypeRandomPool = builder.comment("Set of modifier slot types from which random slot will be awarded when leveling up ranged weapons.",
                        "If empty default pool will be used (" + String.join(", ", DEFAULT_RANGED_SLOTS_RANDOM_POOL) + "). 80% chance for upgrade and 20% chance for ability.",
                        "Allowed values: " + String.join(", ", getToolSlotTypes()))
                .translation("config.tinkerslevellingaddon.general.slots.ranged_slot_type_random_pool")
                .defineList("rangedSlotTypeRandomPool", DEFAULT_RANGED_SLOTS_RANDOM_POOL, t -> getRangedSlotTypes().contains((String) t));
    
        rangedSlotTypeOrder = builder.comment("List of modifier slot types (in order) that will be awarded when leveling up ranged weapons. If level is higher than list size the mod will start over.",
                        "If empty default order will be used (" + String.join(", ", DEFAULT_RANGED_SLOTS_ORDER) + ").",
                        "Allowed values: " + String.join(", ", getToolSlotTypes()))
                .translation("config.tinkerslevellingaddon.general.slots.ranged_slot_type_order")
                .defineList("rangedSlotTypeOrder", DEFAULT_RANGED_SLOTS_ORDER, t -> getRangedSlotTypes().contains((String) t));

        armorSlotTypeRandomPool = builder.comment("Set of modifier slot types from which random slot will be awarded when leveling up armor.",
                        "If empty default pool will be used (" + String.join(", ", DEFAULT_ARMOR_SLOTS_RANDOM_POOL) + ").",
                        "Allowed values: " + String.join(", ", getArmorSlotTypes()))
                .translation("config.tinkerslevellingaddon.general.modifiers.armor_slot_type_random_pool")
                .defineList("armorSlotTypeRandomPool", DEFAULT_ARMOR_SLOTS_RANDOM_POOL, t -> getArmorSlotTypes().contains((String) t));

        armorSlotTypeOrder = builder.comment("List of modifier slot types (in order) that will be awarded when leveling up armor. If level is higher than list size the mod will start over.",
                        "If empty default order will be used (" + String.join(", ", DEFAULT_ARMOR_SLOTS_ORDER) + ").",
                        "Allowed values: " + String.join(", ", getArmorSlotTypes()))
                .translation("config.tinkerslevellingaddon.general.slots.armor_slot_type_order")
                .defineList("armorSlotTypeOrder", DEFAULT_ARMOR_SLOTS_ORDER, t -> getArmorSlotTypes().contains((String) t));
        
        staffSlotTypeRandomPool = builder.comment("Set of modifier slot types from which random slot will be awarded when leveling up staffs.",
                        "If empty default pool will be used (" + String.join(", ", DEFAULT_STAFF_SLOTS_RANDOM_POOL) + ").",
                        "Allowed values: " + String.join(", ", getArmorSlotTypes()))
                .translation("config.tinkerslevellingaddon.general.modifiers.staff_slot_type_random_pool")
                .defineList("staffSlotTypeRandomPool", DEFAULT_STAFF_SLOTS_RANDOM_POOL, t -> getStaffSlotTypes().contains((String) t));
        
        staffSlotTypeOrder = builder.comment("List of modifier slot types (in order) that will be awarded when leveling up staffs. If level is higher than list size the mod will start over.",
                        "If empty default order will be used (" + String.join(", ", DEFAULT_STAFF_SLOTS_ORDER) + ").",
                        "Allowed values: " + String.join(", ", getStaffSlotTypes()))
                .translation("config.tinkerslevellingaddon.general.slots.staff_slot_type_order")
                .defineList("staffSlotTypeOrder", DEFAULT_STAFF_SLOTS_ORDER, t -> getStaffSlotTypes().contains((String) t));

        shieldSlotTypeOrder = builder.comment("List of modifier slot types (in order) that will be awarded when leveling up shields. If level is higher than list size the mod will start over.",
                        "If empty default order will be used (" + String.join(", ", DEFAULT_SHIELD_SLOTS_ORDER) + ").",
                        "Allowed values: " + String.join(", ", getShieldSlotTypes()))
                .translation("config.tinkerslevellingaddon.general.slots.shield_slot_type_order")
                .defineList("shieldSlotTypeOrder", DEFAULT_SHIELD_SLOTS_ORDER, t -> getShieldSlotTypes().contains((String) t));

        shieldSlotTypeRandomPool = builder.comment("Set of modifier slot types from which random slot will be awarded when leveling up shields.",
                        "If empty default pool will be used (" + String.join(", ", DEFAULT_SHIELD_SLOTS_RANDOM_POOL) + ").",
                        "Allowed values: " + String.join(", ", getShieldSlotTypes()))
                .translation("config.tinkerslevellingaddon.general.slots.shield_slot_type_random_pool")
                .defineList("shieldSlotTypeRandomPool", DEFAULT_SHIELD_SLOTS_RANDOM_POOL, t -> getShieldSlotTypes().contains((String) t));

        builder.pop();
    }

    private static void statsConfig(ModConfigSpec.Builder builder) {
        builder.comment("Stats settings").push("stats");

        toolsStatTypeRandomPool = builder.comment("Set of stat types from which random stat will be awarded when leveling up tools.",
                        "If empty default pool will be used (" + String.join(", ", DEFAULT_TOOLS_STATS_RANDOM_POOL) + "). 25% chance for every stat.",
                        "Allowed values: " + String.join(", ", getToolStatTypes()))
                .translation("config.tinkerslevellingaddon.general.stats.tools_stat_type_random_pool")
                .defineList("toolsStatTypeRandomPool", DEFAULT_TOOLS_STATS_RANDOM_POOL, t -> getToolStatTypes().contains((String) t));

        toolsStatTypeOrder = builder.comment("List of stat types (in order) that will be awarded when leveling up tools. If level is higher than list size the mod will start over.",
                        "If empty default order will be used (" + String.join(", ", DEFAULT_TOOLS_STATS_ORDER) + ").",
                        "Allowed values: " + String.join(", ", getToolStatTypes()))
                .translation("config.tinkerslevellingaddon.general.stats.tools_stat_type_order")
                .defineList("toolsStatTypeOrder", DEFAULT_TOOLS_STATS_ORDER, t -> getToolStatTypes().contains((String) t));

        toolStatsValuesConfig(builder);
    
    
        rangedStatTypeRandomPool = builder.comment("Set of stat types from which random stat will be awarded when leveling up ranged weapons.",
                        "If empty default pool will be used (" + String.join(", ", DEFAULT_RANGED_STATS_RANDOM_POOL) + ").",
                        "Possible values: " + String.join(", ", getRangedStatTypes()))
                .translation("config.tinkerslevellingaddon.general.stats.ranged_stat_type_random_pool")
                .defineList("rangedStatTypeRandomPool", DEFAULT_RANGED_STATS_RANDOM_POOL, t -> getRangedStatTypes().contains((String) t));
    
        rangedStatTypeOrder = builder.comment("List of stat types (in order) that will be awarded when leveling up ranged weapons. If level is higher than list size the mod will start over.",
                        "If empty default rotation will be used (" + String.join(", ", DEFAULT_RANGED_STATS_ORDER) + ").",
                        "Possible values: " + String.join(", ", getRangedStatTypes()))
                .translation("config.tinkerslevellingaddon.general.stats.ranged_stat_type_order")
                .defineList("rangedStatTypeRotation", DEFAULT_RANGED_STATS_ORDER, t -> getRangedStatTypes().contains((String) t));
    
        rangedStatsValuesConfig(builder);

        armorStatTypeRandomPool = builder.comment("Set of stat types from which random stat will be awarded when leveling up armor.",
                        "If empty default pool will be used (" + String.join(", ", DEFAULT_ARMOR_STATS_RANDOM_POOL) + ").",
                        "Allowed values: " + String.join(", ", getArmorStatTypes()))
                .translation("config.tinkerslevellingaddon.general.stats.armor_stat_type_random_pool")
                .defineList("armorStatTypeRandomPool", DEFAULT_ARMOR_STATS_RANDOM_POOL, t -> getArmorStatTypes().contains((String) t));

        armorStatTypeOrder = builder.comment("List of stat types (in order) that will be awarded when leveling up armor. If level is higher than list size the mod will start over.",
                        "If empty default order will be used (" + String.join(", ", DEFAULT_ARMOR_STATS_ORDER) + ").",
                        "Allowed values: " + String.join(", ", getArmorStatTypes()))
                .translation("config.tinkerslevellingaddon.general.stats.armor_stat_type_order")
                .defineList("armorStatTypeOrder", DEFAULT_ARMOR_STATS_ORDER, t -> getArmorStatTypes().contains((String) t));

        armorStatsValuesConfig(builder);
        
        staffStatTypeRandomPool = builder.comment("Set of stat types from which random stat will be awarded when leveling up staffs.",
                        "If empty default pool will be used (" + String.join(", ", DEFAULT_STAFF_STATS_RANDOM_POOL) + ").",
                        "Allowed values: " + String.join(", ", getStaffStatTypes()))
                .translation("config.tinkerslevellingaddon.general.stats.staff_stat_type_random_pool")
                .defineList("staffStatTypeRandomPool", DEFAULT_STAFF_STATS_RANDOM_POOL, t -> getStaffStatTypes().contains((String) t));
        
        staffStatTypeOrder = builder.comment("List of stat types (in order) that will be awarded when leveling up staffs. If level is higher than list size the mod will start over.",
                        "If empty default order will be used (" + String.join(", ", DEFAULT_STAFF_STATS_ORDER) + ").",
                        "Allowed values: " + String.join(", ", getStaffStatTypes()))
                .translation("config.tinkerslevellingaddon.general.stats.staff_stat_type_order")
                .defineList("staffStatTypeOrder", DEFAULT_STAFF_STATS_ORDER, t -> getStaffStatTypes().contains((String) t));
        
        staffStatsValuesConfig(builder);

        shieldStatTypeOrder = builder.comment("List of stat types (in order) that will be awarded when leveling up shields. If level is higher than list size the mod will start over.",
                        "If empty default order will be used (" + String.join(", ", DEFAULT_SHIELD_STATS_ORDER) + ").",
                        "Allowed values: " + String.join(", ", getShieldStatTypes()))
                .translation("config.tinkerslevellingaddon.general.stats.shield_stat_type_order")
                .defineList("shieldStatTypeOrder", DEFAULT_SHIELD_STATS_ORDER, t -> getShieldStatTypes().contains((String) t));

        shieldStatTypeRandomPool = builder.comment("Set of stat types from which random stat will be awarded when leveling up shields.",
                        "If empty default pool will be used (" + String.join(", ", DEFAULT_SHIELD_STATS_RANDOM_POOL) + ").",
                        "Allowed values: " + String.join(", ", getShieldStatTypes()))
                .translation("config.tinkerslevellingaddon.general.stats.shield_stat_type_random_pool")
                .defineList("shieldStatTypeRandomPool", DEFAULT_SHIELD_STATS_RANDOM_POOL, t -> getShieldStatTypes().contains((String) t));

        shieldStatsValuesConfig(builder);

        builder.pop();
    }

    private static void toolStatsValuesConfig(ModConfigSpec.Builder builder) {
        builder.comment("Tool stat values rewarded on level ups").push("toolValues");

        toolDurabilityValue = builder.translation("tooltip.tinkerslevellingaddon.stats.durability")
                .defineInRange(DURABILITY, 50, 1, 1000);

        toolAttackDamageValue = builder.translation("tooltip.tinkerslevellingaddon.stats.attack_damage")
                .defineInRange(ATTACK_DAMAGE, 0.5D, 0.1D, 10D);

        toolAttackSpeedValue = builder.translation("tooltip.tinkerslevellingaddon.stats.attack_speed")
                .defineInRange(ATTACK_SPEED, 0.25D, 0.1D, 10D);

        toolMiningSpeedValue = builder.translation("tooltip.tinkerslevellingaddon.stats.mining_speed")
                .defineInRange(MINING_SPEED, 1D, 0.1D, 10D);

        builder.pop();
    }
    
    private static void rangedStatsValuesConfig(ModConfigSpec.Builder builder) {
        builder.comment("Ranged weapons stat values rewarded on level ups").push("rangedValues");
        
        rangedDurabilityValue = builder.translation("tooltip.tinkerslevellingaddon.stat.durability")
                .defineInRange(DURABILITY, 30, 1, 1000);
    
        rangedDrawSpeedValue = builder.translation("tooltip.tinkerslevellingaddon.stat.draw_speed")
                .defineInRange(DRAW_SPEED, 0.1D, 0.1D, 10D);
    
        rangedVelocityValue = builder.translation("tooltip.tinkerslevellingaddon.stat.velocity")
                .defineInRange(VELOCITY, 0.1D, 0.1D, 10D);
    
        rangedAccuracyValue = builder.translation("tooltip.tinkerslevellingaddon.stat.accuracy")
                .defineInRange(ACCURACY, 0.01D, 0.01D, 1D);
    
        rangedProjectileDamageValue = builder.translation("tooltip.tinkerslevellingaddon.stat.projectile_damage")
                .defineInRange(PROJECTILE_DAMAGE, 0.1D, 0.1D, 10D);
    
        rangedAttackDamageValue = builder.translation("tooltip.tinkerslevellingaddon.stat.attack_damage")
                .defineInRange(ATTACK_DAMAGE, 0.5D, 0.1D, 10D);
    
        rangedAttackSpeedValue = builder.translation("tooltip.tinkerslevellingaddon.stat.attack_speed")
                .defineInRange(ATTACK_SPEED, 0.25D, 0.1D, 10D);
        
        builder.pop();
    }

    private static void armorStatsValuesConfig(ModConfigSpec.Builder builder) {
        builder.comment("Armor stat values rewarded on level ups").push("armorValues");

        armorDurabilityValue = builder.translation("tooltip.tinkerslevellingaddon.stats.durability")
                .defineInRange(DURABILITY, 50, 1, 1000);

        armorArmorValue = builder.translation("tooltip.tinkerslevellingaddon.stats.armor")
                .defineInRange(ARMOR, 0.25D, 0.1D, 10D);

        armorArmorToughnessValue = builder.translation("tooltip.tinkerslevellingaddon.stats.armor_toughness")
                .defineInRange(ARMOR_TOUGHNESS, 0.1D, 0.1D, 10D);

        armorKnockbackResistanceValue = builder.translation("tooltip.tinkerslevellingaddon.stats.knockback_resistance")
                .defineInRange(KNOCKBACK_RESISTANCE, 0.1D, 0.1D, 1D);

        builder.pop();
    }
    
    private static void shieldStatsValuesConfig(ModConfigSpec.Builder builder) {
        builder.comment("Shield stat values rewarded on level ups").push("shieldValues");

        shieldDurabilityValue = builder.translation("tooltip.tinkerslevellingaddon.stat.durability")
                .defineInRange(DURABILITY, 30, 1, 1000);

        shieldBlockAmountValue = builder.translation("tooltip.tinkerslevellingaddon.stat.block_amount")
                .defineInRange(BLOCK_AMOUNT, 5.0D, 0.1D, 100D);

        shieldBlockAngleValue = builder.translation("tooltip.tinkerslevellingaddon.stat.block_angle")
                .defineInRange(BLOCK_ANGLE, 2, 1, 360);

        shieldArmorToughnessValue = builder.translation("tooltip.tinkerslevellingaddon.stat.armor_toughness")
                .defineInRange(ARMOR_TOUGHNESS, 0.1D, 0.1D, 10D);

        shieldKnockbackResistanceValue = builder.translation("tooltip.tinkerslevellingaddon.stat.knockback_resistance")
                .defineInRange(KNOCKBACK_RESISTANCE, 0.1D, 0.1D, 1D);

        builder.pop();
    }

    private static void staffStatsValuesConfig(ModConfigSpec.Builder builder) {
        builder.comment("Staff stat values rewarded on level ups").push("staffValues");
        
        staffDurabilityValue = builder.translation("tooltip.tinkerslevellingaddon.stat.durability")
                .defineInRange(DURABILITY, 30, 1, 1000);
        
        staffDrawSpeedValue = builder.translation("tooltip.tinkerslevellingaddon.stat.draw_speed")
                .defineInRange(DRAW_SPEED, 0.1D, 0.1D, 10D);
        
        staffVelocityValue = builder.translation("tooltip.tinkerslevellingaddon.stat.velocity")
                .defineInRange(VELOCITY, 0.1D, 0.1D, 10D);
        
        staffAccuracyValue = builder.translation("tooltip.tinkerslevellingaddon.stat.accuracy")
                .defineInRange(ACCURACY, 0.01D, 0.01D, 1D);
        
        staffProjectileDamageValue = builder.translation("tooltip.tinkerslevellingaddon.stat.projectile_damage")
                .defineInRange(PROJECTILE_DAMAGE, 0.1D, 0.1D, 10D);
        
        staffArmorValue = builder.translation("tooltip.tinkerslevellingaddon.stats.armor")
                .defineInRange(ARMOR, 0.25D, 0.1D, 10D);
        
        builder.pop();
    }

    private static void toolLevellingConfig(ModConfigSpec.Builder builder) {
        builder.comment("Tool levelling settings").push("toolLevelling");

        damageDealt = builder.comment("Melee only!", "If true, base experience value gained for attacking is equal to damage dealt (rounded to whole number), otherwise 1.")
                .translation("config.tinkerslevellingaddon.levelling.damage_dealt")
                .define("damageDealt", true);
        damageTaken = builder.comment("If true, base experience value gained for taking damage is equal to damage taken (rounded to whole number), otherwise 1.")
                .translation("config.tinkerslevellingaddon.levelling.damage_taken")
                .define("damageTaken", true);
        damageBlocked = builder.comment("If true, base experience value gained for blocking damage is equal to damage blocked (rounded to whole number), otherwise 1.")
                .translation("config.tinkerslevellingaddon.levelling.damage_blocked")
                .define("damageBlocked", true);
        enablePvp = builder.comment("If true, allows to gain experience from dealing damage to or taking damage from other players.")
                .translation("config.tinkerslevellingaddon.levelling.enable_pvp")
                .define("pvp", true);
        flyingTime = builder.comment("The time (in ticks) of continuous flight using an elytra after which experience points will be awarded.",
                        "20 ticks = 1 second")
                .translation("config.tinkerslevellingaddon.levelling.flying_time")
                .defineInRange("flyingTime", 300, 1, 1200);

        actionsConfig(builder);
        bonusesConfig(builder);

        builder.pop();
    }

    private static void actionsConfig(ModConfigSpec.Builder builder) {
        builder.comment("If true, given action will yield tool experience.").push("actions");

        enableMiningXp = builder.translation("config.tinkerslevellingaddon.levelling.mining")
                .define("mining", true);

        enableHarvestingXp = builder.translation("config.tinkerslevellingaddon.levelling.harvesting")
                .define("harvesting", true);

        enableShearingXp = builder.translation("config.tinkerslevellingaddon.levelling.shearing")
                .define("shearing", true);

        enableStrippingXp = builder.translation("config.tinkerslevellingaddon.levelling.stripping")
                .define("stripping", true);

        enableScrappingXp = builder.translation("config.tinkerslevellingaddon.levelling.scrapping")
                .define("scrapping", true);

        enableWaxingOffXp = builder.translation("config.tinkerslevellingaddon.levelling.waxing_off")
                .define("waxingOff", true);

        enableTillingXp = builder.translation("config.tinkerslevellingaddon.levelling.tilling")
                .define("tilling", true);

        enablePathMakingXp = builder.translation("config.tinkerslevellingaddon.levelling.path_making")
                .define("pathMaking", true);

        enableAttackingXp = builder.translation("config.tinkerslevellingaddon.levelling.attacking")
                .define("attacking", true);

        enableShootingXp = builder.comment("Applies to ranged weapons like longbows and crossbows.")
                .translation("config.tinkerslevellingaddon.levelling.shooting")
                .define("shooting", true);

        enableTakingDamageXp = builder.comment("Applies to armor only.")
                .translation("config.tinkerslevellingaddon.levelling.taking_damage")
                .define("takingDamage", true);
        
        enableBlockingDamageXp = builder.translation("config.tinkerslevellingaddon.levelling.blocking_damage")
                .define("blockingDamage", true);

        enableThornsXp = builder.comment("Applies to armor only. Thorns modifier gives 15% chance per level to gain experience.")
                .translation("config.tinkerslevellingaddon.levelling.thorns")
                .define("thorns", true);
        
        enableFlyingXp = builder.translation("config.tinkerslevellingaddon.levelling.flying")
                .define("flying", true);
        
        enablePlowingXp = builder.translation("config.tinkerslevellingaddon.levelling.plowing")
                .define("plowing", true);
        
        enablePathMakerXp = builder.translation("config.tinkerslevellingaddon.levelling.path_maker")
                .define("path_maker", true);
        
        enableSnowdriftXp = builder.translation("config.tinkerslevellingaddon.levelling.snowdrift")
                .define("snowdrift", true);
        
        enableFlamewakeXp = builder.translation("config.tinkerslevellingaddon.levelling.flamewake")
                .define("flamewake", true);
        
        enableFrostWalkerXp = builder.translation("config.tinkerslevellingaddon.levelling.frost_walker")
                .define("frost_walker", true);
        
        enableWarpingXp = builder.translation("config.tinkerslevellingaddon.levelling.warping")
                .define("warping", true);
        
        enableFlingingXp = builder.translation("config.tinkerslevellingaddon.levelling.flinging")
                .define("flinging", true);
        
        enableSpringingXp = builder.translation("config.tinkerslevellingaddon.levelling.springing")
                .define("springing", true);
        
        enableBonkingXp = builder.translation("config.tinkerslevellingaddon.levelling.bonking")
                .define("bonking", true);
        
        enableGlowingXp = builder.translation("config.tinkerslevellingaddon.levelling.glowing")
                .define("glowing", true);
        
        enableFirestarterXp = builder.translation("config.tinkerslevellingaddon.levelling.firestarter")
                .define("firestarter", true);

        enableBrushingXp = builder.translation("config.tinkerslevellingaddon.levelling.brushing")
                .define("brushing", true);

        enableBucketingXp = builder.comment("Placing fluids in world only, no container filling, no fluid pickup.")
                .translation("config.tinkerslevellingaddon.levelling.bucketing")
                .define("bucketing", true);

        enableFishingXp = builder.translation("config.tinkerslevellingaddon.levelling.fishing")
                .define("fishing", true);

        enableGrapplingXp = builder.translation("config.tinkerslevellingaddon.levelling.grappling")
                .define("grappling", true);

        enableMeltingXp = builder.translation("config.tinkerslevellingaddon.levelling.melting")
                .define("melting", true);

        enableSlimeballXp = builder.translation("config.tinkerslevellingaddon.levelling.slimeball")
                .define("slimeball", true);

        enableSlurpingXp = builder.translation("config.tinkerslevellingaddon.levelling.slurping")
                .define("slurping", true);

        enableSpillingXp = builder.translation("config.tinkerslevellingaddon.levelling.spilling")
                .define("spilling", true);

        enableSpittingXp = builder.translation("config.tinkerslevellingaddon.levelling.spitting")
                .define("spitting", true);

        enableSplashingXp = builder.translation("config.tinkerslevellingaddon.levelling.splashing")
                .define("splashing", true);

        builder.pop();
    }

    private static void bonusesConfig(ModConfigSpec.Builder builder) {
        builder.comment("Amount of bonus experience for performing actions. If set to 0 there is no bonus experience.").push("bonuses");

        bonusMiningXp = builder.translation("config.tinkerslevellingaddon.levelling.mining")
                .defineInRange("mining", 0, 0, Integer.MAX_VALUE);

        bonusHarvestingXp = builder.translation("config.tinkerslevellingaddon.levelling.harvesting")
                .defineInRange("harvesting", 0, 0, Integer.MAX_VALUE);

        bonusShearingXp = builder.translation("config.tinkerslevellingaddon.levelling.shearing")
                .defineInRange("shearing", 0, 0, Integer.MAX_VALUE);

        bonusStrippingXp = builder.translation("config.tinkerslevellingaddon.levelling.stripping")
                .defineInRange("stripping", 0, 0, Integer.MAX_VALUE);

        bonusScrappingXp = builder.translation("config.tinkerslevellingaddon.levelling.scrapping")
                .defineInRange("scrapping", 0, 0, Integer.MAX_VALUE);

        bonusWaxingOffXp = builder.translation("config.tinkerslevellingaddon.levelling.waxing_off")
                .defineInRange("waxingOff", 0, 0, Integer.MAX_VALUE);

        bonusTillingXp = builder.translation("config.tinkerslevellingaddon.levelling.tilling")
                .defineInRange("tilling", 0, 0, Integer.MAX_VALUE);

        bonusPathMakingXp = builder.translation("config.tinkerslevellingaddon.levelling.path_making")
                .defineInRange("pathMaking", 0, 0, Integer.MAX_VALUE);

        bonusAttackingXp = builder.translation("config.tinkerslevellingaddon.levelling.attacking")
                .defineInRange("attacking", 0, 0, Integer.MAX_VALUE);

        bonusShootingXp = builder.translation("config.tinkerslevellingaddon.levelling.shooting")
                .defineInRange("shooting", 0, 0, Integer.MAX_VALUE);

        bonusTakingDamageXp = builder.translation("config.tinkerslevellingaddon.levelling.taking_damage")
                .defineInRange("takingDamage", 0, 0, Integer.MAX_VALUE);
        
        bonusBlockingDamageXp = builder.translation("config.tinkerslevellingaddon.levelling.blocking_damage")
                .defineInRange("blockingDamage", 0, 0, Integer.MAX_VALUE);

        bonusThornsXp = builder.comment("As with Thorns damage calculations, this is the upper bound of the bonus experience that could be granted.",
                        "For example, for the value of 3 (default), we get: 1 (base xp) + 0 to 3 (bonus xp) = 1 to 4 (result xp)")
                .translation("config.tinkerslevellingaddon.levelling.thorns")
                .defineInRange("thorns", 3, 0, Integer.MAX_VALUE);
        
        bonusFlyingXp = builder.translation("config.tinkerslevellingaddon.levelling.flying")
                .defineInRange("flying", 0, 0, Integer.MAX_VALUE);
        
        bonusPlowingXp = builder.translation("config.tinkerslevellingaddon.levelling.plowing")
                .defineInRange("plowing", 0, 0, Integer.MAX_VALUE);
        
        bonusPathMakerXp = builder.translation("config.tinkerslevellingaddon.levelling.path_maker")
                .defineInRange("path_maker", 0, 0, Integer.MAX_VALUE);
        
        bonusSnowdriftXp = builder.translation("config.tinkerslevellingaddon.levelling.snowdrift")
                .defineInRange("snowdrift", 0, 0, Integer.MAX_VALUE);
        
        bonusFlamewakeXp = builder.translation("config.tinkerslevellingaddon.levelling.flamewake")
                .defineInRange("flamewake", 0, 0, Integer.MAX_VALUE);
        
        bonusFrostWalkerXp = builder.translation("config.tinkerslevellingaddon.levelling.frost_walker")
                .defineInRange("frost_walker", 0, 0, Integer.MAX_VALUE);
        
        bonusWarpingXp = builder.translation("config.tinkerslevellingaddon.levelling.warping")
                .defineInRange("warping", 0, 0, Integer.MAX_VALUE);
        
        bonusFlingingXp = builder.translation("config.tinkerslevellingaddon.levelling.flinging")
                .defineInRange("flinging", 0, 0, Integer.MAX_VALUE);
        
        bonusSpringingXp = builder.translation("config.tinkerslevellingaddon.levelling.springing")
                .defineInRange("springing", 0, 0, Integer.MAX_VALUE);
        
        bonusBonkingXp = builder.translation("config.tinkerslevellingaddon.levelling.bonking")
                .defineInRange("bonking", 0, 0, Integer.MAX_VALUE);
        
        bonusGlowingXp = builder.translation("config.tinkerslevellingaddon.levelling.glowing")
                .defineInRange("glowing", 0, 0, Integer.MAX_VALUE);
        
        bonusFirestarterXp = builder.translation("config.tinkerslevellingaddon.levelling.firestarter")
                .defineInRange("firestarter", 0, 0, Integer.MAX_VALUE);

        bonusBrushingXp = builder.translation("config.tinkerslevellingaddon.levelling.brushing")
                .defineInRange("brushing", 0, 0, Integer.MAX_VALUE);

        bonusBucketingXp = builder.translation("config.tinkerslevellingaddon.levelling.bucketing")
                .defineInRange("bucketing", 0, 0, Integer.MAX_VALUE);

        bonusFishingXp = builder.translation("config.tinkerslevellingaddon.levelling.fishing")
                .defineInRange("fishing", 0, 0, Integer.MAX_VALUE);

        bonusGrapplingXp = builder.translation("config.tinkerslevellingaddon.levelling.grappling")
                .defineInRange("grappling", 0, 0, Integer.MAX_VALUE);

        bonusMeltingXp = builder.translation("config.tinkerslevellingaddon.levelling.melting")
                .defineInRange("melting", 0, 0, Integer.MAX_VALUE);

        bonusSlimeballXp = builder.translation("config.tinkerslevellingaddon.levelling.slimeball")
                .defineInRange("slimeball", 0, 0, Integer.MAX_VALUE);

        bonusSlurpingXp = builder.translation("config.tinkerslevellingaddon.levelling.slurping")
                .defineInRange("slurping", 0, 0, Integer.MAX_VALUE);

        bonusSpillingXp = builder.translation("config.tinkerslevellingaddon.levelling.spilling")
                .defineInRange("spilling", 0, 0, Integer.MAX_VALUE);

        bonusSpittingXp = builder.translation("config.tinkerslevellingaddon.levelling.spitting")
                .defineInRange("spitting", 0, 0, Integer.MAX_VALUE);

        bonusSplashingXp = builder.translation("config.tinkerslevellingaddon.levelling.splashing")
                .defineInRange("splashing", 0, 0, Integer.MAX_VALUE);

        builder.pop();
    }

    private static void clientConfig(ModConfigSpec.Builder builder) {
        builder.comment("Client only settings").push("client");

        enableLevelUpMessage = builder.comment("If true, shows chat message on tool level ups.")
                .translation("config.tinkerslevellingaddon.client.messages")
                .define("message", true);

        squashLevelPluses = builder.comment("If true, uses alternative level name suffix for high level tools.",
                "Instead of appending '+' signs for each consecutive level appearance, +1, +2, +3, etc. notation will be used.")
                .translation("config.tinkerslevellingaddon.client.squash_pluses")
                .define("squashPluses", false);

        levelUpSound = builder.comment("")
                .translation("config.tinkerslevellingaddon.client.sound")
                .defineEnum("sound", LevelUpSound.SNARE_DRUM, EnumGetMethod.NAME_IGNORECASE, LevelUpSound.values());
    }

    public static void init() {
        ModLoadingContext.get().getActiveContainer().registerConfig(ModConfig.Type.SERVER, SERVER_CONFIG);
        ModLoadingContext.get().getActiveContainer().registerConfig(ModConfig.Type.CLIENT, CLIENT_CONFIG);
    }

    public static List<String> getToolsSlotsOrder() {
        List<? extends String> slotsOrder = toolsSlotTypeOrder.get();
        if (slotsOrder.isEmpty()) {
            slotsOrder = DEFAULT_TOOLS_SLOTS_ORDER;
        }
        return (List<String>) slotsOrder;
    }

    public static List<String> getToolsSlotsRandomPool() {
        List<? extends String> slotsRandomPool = toolsSlotTypeRandomPool.get();
        if (slotsRandomPool.isEmpty()) {
            slotsRandomPool = DEFAULT_TOOLS_SLOTS_RANDOM_POOL;
        }
        return (List<String>) slotsRandomPool;
    }

    public static List<String> getToolsStatsOrder() {
        List<? extends String> statsOrder = toolsStatTypeOrder.get();
        if (statsOrder.isEmpty()) {
            statsOrder = DEFAULT_TOOLS_STATS_ORDER;
        }
        return (List<String>) statsOrder;
    }

    public static List<String> getToolsStatsRandomPool() {
        List<? extends String> statsRandomPool = toolsStatTypeRandomPool.get();
        if (statsRandomPool.isEmpty()) {
            statsRandomPool = DEFAULT_TOOLS_STATS_RANDOM_POOL;
        }
        return (List<String>) statsRandomPool;
    }

    public static List<String> getArmorSlotsOrder() {
        List<? extends String> slotsOrder = armorSlotTypeOrder.get();
        if (slotsOrder.isEmpty()) {
            slotsOrder = DEFAULT_ARMOR_SLOTS_ORDER;
        }
        return (List<String>) slotsOrder;
    }

    public static List<String> getArmorSlotsRandomPool() {
        List<? extends String> slotsRandomPool = armorSlotTypeRandomPool.get();
        if (slotsRandomPool.isEmpty()) {
            slotsRandomPool = DEFAULT_ARMOR_SLOTS_RANDOM_POOL;
        }
        return (List<String>) slotsRandomPool;
    }

    public static List<String> getArmorStatsOrder() {
        List<? extends String> statsOrder = armorStatTypeOrder.get();
        if (statsOrder.isEmpty()) {
            statsOrder = DEFAULT_ARMOR_STATS_ORDER;
        }
        return (List<String>) statsOrder;
    }

    public static List<String> getArmorStatsRandomPool() {
        List<? extends String> statsRandomPool = armorStatTypeRandomPool.get();
        if (statsRandomPool.isEmpty()) {
            statsRandomPool = DEFAULT_ARMOR_STATS_RANDOM_POOL;
        }
        return (List<String>) statsRandomPool;
    }
    
    public static List<String> getRangedSlotsOrder() {
        List<? extends String> slotsOrder = rangedSlotTypeOrder.get();
        if (slotsOrder.isEmpty()) {
            slotsOrder = DEFAULT_RANGED_SLOTS_ORDER;
        }
        return (List<String>) slotsOrder;
    }
    
    public static List<String> getRangedSlotsRandomPool() {
        List<? extends String> slotsRandomPool = rangedSlotTypeRandomPool.get();
        if (slotsRandomPool.isEmpty()) {
            slotsRandomPool = DEFAULT_RANGED_SLOTS_RANDOM_POOL;
        }
        return (List<String>) slotsRandomPool;
    }

    public static List<String> getRangedStatsOrder() {
        List<? extends String> statsOrder = rangedStatTypeOrder.get();
        if (statsOrder.isEmpty()) {
            statsOrder = DEFAULT_RANGED_STATS_ORDER;
        }
        return (List<String>) statsOrder;
    }

    public static List<String> getRangedStatsRandomPool() {
        List<? extends String> statsRandomPool = rangedStatTypeRandomPool.get();
        if (statsRandomPool.isEmpty()) {
            statsRandomPool = DEFAULT_RANGED_STATS_RANDOM_POOL;
        }
        return (List<String>) statsRandomPool;
    }
    
    public static List<String> getStaffSlotsOrder() {
        List<? extends String> slotsOrder = staffSlotTypeOrder.get();
        if (slotsOrder.isEmpty()) {
            slotsOrder = DEFAULT_STAFF_SLOTS_ORDER;
        }
        return (List<String>) slotsOrder;
    }
    
    public static List<String> getStaffSlotsRandomPool() {
        List<? extends String> slotsRandomPool = staffSlotTypeRandomPool.get();
        if (slotsRandomPool.isEmpty()) {
            slotsRandomPool = DEFAULT_STAFF_SLOTS_RANDOM_POOL;
        }
        return (List<String>) slotsRandomPool;
    }
    
    public static List<String> getStaffStatsOrder() {
        List<? extends String> statsOrder = staffStatTypeOrder.get();
        if (statsOrder.isEmpty()) {
            statsOrder = DEFAULT_STAFF_STATS_ORDER;
        }
        return (List<String>) statsOrder;
    }
    
    public static List<String> getStaffStatsRandomPool() {
        List<? extends String> statsRandomPool = staffStatTypeRandomPool.get();
        if (statsRandomPool.isEmpty()) {
            statsRandomPool = DEFAULT_STAFF_STATS_RANDOM_POOL;
        }
        return (List<String>) statsRandomPool;
    }

    public static List<String> getShieldSlotsOrder() {
        List<? extends String> slotsOrder = shieldSlotTypeOrder.get();
        if (slotsOrder.isEmpty()) {
            slotsOrder = DEFAULT_SHIELD_SLOTS_ORDER;
        }
        return (List<String>) slotsOrder;
    }

    public static List<String> getShieldSlotsRandomPool() {
        List<? extends String> slotsRandomPool = shieldSlotTypeRandomPool.get();
        if (slotsRandomPool.isEmpty()) {
            slotsRandomPool = DEFAULT_SHIELD_SLOTS_RANDOM_POOL;
        }
        return (List<String>) slotsRandomPool;
    }

    public static List<String> getShieldStatsOrder() {
        List<? extends String> statsOrder = shieldStatTypeOrder.get();
        if (statsOrder.isEmpty()) {
            statsOrder = DEFAULT_SHIELD_STATS_ORDER;
        }
        return (List<String>) statsOrder;
    }

    public static List<String> getShieldStatsRandomPool() {
        List<? extends String> statsRandomPool = shieldStatTypeRandomPool.get();
        if (statsRandomPool.isEmpty()) {
            statsRandomPool = DEFAULT_SHIELD_STATS_RANDOM_POOL;
        }
        return (List<String>) statsRandomPool;
    }

    public static double getToolStatValue(FloatToolStat stat) {
        if (stat.equals(ToolStats.DURABILITY)) {
            return toolDurabilityValue.get();
        }
        if (stat.equals(ToolStats.ATTACK_DAMAGE)) {
            return toolAttackDamageValue.get();
        }
        if (stat.equals(ToolStats.ATTACK_SPEED)) {
            return toolAttackSpeedValue.get();
        }
        if (stat.equals(ToolStats.MINING_SPEED)) {
            return toolMiningSpeedValue.get();
        }
        return 0;
    }
    
    public static double getRangedStatValue(FloatToolStat stat) {
        if (stat.equals(ToolStats.DRAW_SPEED)) {
            return rangedDrawSpeedValue.get();
        }
        if (stat.equals(ToolStats.VELOCITY)) {
            return rangedVelocityValue.get();
        }
        if (stat.equals(ToolStats.ACCURACY)) {
            return rangedAccuracyValue.get();
        }
        if (stat.equals(ToolStats.PROJECTILE_DAMAGE)) {
            return rangedProjectileDamageValue.get();
        }
        if (stat.equals(ToolStats.DURABILITY)) {
            return rangedDurabilityValue.get();
        }
        if (stat.equals(ToolStats.ATTACK_DAMAGE)) {
            return rangedAttackDamageValue.get();
        }
        if (stat.equals(ToolStats.ATTACK_SPEED)) {
            return rangedAttackSpeedValue.get();
        }
        return 0;
    }

    public static double getArmorStatValue(FloatToolStat stat) {
        if (stat.equals(ToolStats.DURABILITY)) {
            return armorDurabilityValue.get();
        }
        if (stat.equals(ToolStats.ARMOR)) {
            return armorArmorValue.get();
        }
        if (stat.equals(ToolStats.ARMOR_TOUGHNESS)) {
            return armorArmorToughnessValue.get();
        }
        if (stat.equals(ToolStats.KNOCKBACK_RESISTANCE)) {
            return armorKnockbackResistanceValue.get();
        }
        return 0;
    }
    
    public static double getStaffStatValue(FloatToolStat stat) {
        if (stat.equals(ToolStats.DRAW_SPEED)) {
            return staffDrawSpeedValue.get();
        }
        if (stat.equals(ToolStats.VELOCITY)) {
            return staffVelocityValue.get();
        }
        if (stat.equals(ToolStats.ACCURACY)) {
            return staffAccuracyValue.get();
        }
        if (stat.equals(ToolStats.PROJECTILE_DAMAGE)) {
            return staffProjectileDamageValue.get();
        }
        if (stat.equals(ToolStats.DURABILITY)) {
            return staffDurabilityValue.get();
        }
        if (stat.equals(ToolStats.ARMOR)) {
            return staffArmorValue.get();
        }
        return 0;
    }

    public static double getShieldStatValue(FloatToolStat stat) {
        if (stat.equals(ToolStats.DURABILITY)) {
            return shieldDurabilityValue.get();
        }
        if (stat.equals(ToolStats.BLOCK_AMOUNT)) {
            return shieldBlockAmountValue.get();
        }
        if (stat.equals(ToolStats.BLOCK_ANGLE)) {
            return shieldBlockAngleValue.get();
        }
        if (stat.equals(ToolStats.ARMOR_TOUGHNESS)) {
            return shieldArmorToughnessValue.get();
        }
        if (stat.equals(ToolStats.KNOCKBACK_RESISTANCE)) {
            return shieldKnockbackResistanceValue.get();
        }
        return 0;
    }

    public enum LevelUpSound {
        NONE(() -> null),
        CHIME(Sounds.CHIME::getSound),
        SNARE_DRUM(Sounds.SNARE_DRUM::getSound),
        YAY(Sounds.YAY::getSound),
        BONK(slimeknights.tconstruct.common.Sounds.BONK::getSound);

        private final Supplier<SoundEvent> soundEvent;

        LevelUpSound(Supplier<SoundEvent> soundEvent) {
            this.soundEvent = soundEvent;
        }

        public SoundEvent getSoundEvent() {
            return soundEvent.get();
        }
    }

    public enum GainingMethod {
        NONE,
        PREDEFINED_ORDER,
        RANDOM
    }
}
