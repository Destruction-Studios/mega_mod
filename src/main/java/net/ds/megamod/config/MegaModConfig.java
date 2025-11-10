package net.ds.megamod.config;

import com.google.gson.JsonObject;
import com.supermartijn642.configlib.api.ConfigBuilders;
import com.supermartijn642.configlib.api.IConfigBuilder;
import net.ds.megamod.MegaMod;

import java.util.List;
import java.util.function.Supplier;


public class MegaModConfig {
    public static final int CONFIG_VERSION = 1;

    public static final Supplier<Boolean> netherEnabled;
    public static final Supplier<Boolean> endEnabled;
    public static final Supplier<Boolean> enderEyesEnabled;
    public static final Supplier<Boolean> villagerDeathMessages;

    static {
        IConfigBuilder builder = ConfigBuilders.newTomlConfig("mega_mod", "mega_mod_config", true);

        builder.push("Feature Toggles").categoryComment("Vanilla features that can be turned off");
        netherEnabled = builder.comment("Whether or not nether portals can be entered !! CURRENTLY DISABLED DUE TO GAMERULE !!").define("netherEnabled", true);
        endEnabled = builder.comment("Whether or not end portals can be entered").define("endEnabled", true);
        enderEyesEnabled = builder.comment("Whether or not a player can throw/place Eyes of Ender").define("enderEyesEnabled", true);
        builder.pop();

        builder.push("Mega Mod Features").categoryComment("Megamod added Features");
        villagerDeathMessages = builder.comment("Weather a message is sent when a villager dies").define("villagerDeathMessages", false);
        builder.pop();
    }

    public static void reload() {
        MegaMod.LOGGER.info("Reloading MegaMod Config");


    }
}
