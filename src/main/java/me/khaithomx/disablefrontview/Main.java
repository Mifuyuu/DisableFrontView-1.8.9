package me.khaithomx.disablefrontview;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.io.File;

@Mod(modid = Main.MODID, name = Main.NAME, version = Main.VERSION, guiFactory = "me.khaithomx.disablefrontview.ConfigGuiFactory", clientSideOnly = true)
public class Main {
    public static final String MODID = "disablefrontview";
    public static final String NAME = "DisableFrontView";
    public static final String VERSION = "1.0.0";

    public static Configuration config;
    public static boolean disableFrontView = true;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        File configFile = new File(event.getModConfigurationDirectory(), "disablefrontview.cfg");
        config = new Configuration(configFile);
        syncConfig();
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        MinecraftForge.EVENT_BUS.register(this);
        MinecraftForge.EVENT_BUS.register(new CameraViewHandler());
    }

    @Mod.EventHandler
    public void onServerStarting(FMLServerStartingEvent event) {
        event.registerServerCommand(new Commands());
    }

    @SubscribeEvent
    public void onConfigChanged(ConfigChangedEvent.OnConfigChangedEvent event) {
        if (event.modID.equals(MODID)) {
            syncConfig();
        }
    }

    private static void syncConfig() {
        disableFrontView = config.getBoolean("Enabled", Configuration.CATEGORY_GENERAL, true, "Set to true to disable the front perspective view.");
        if (config.hasChanged()) {
            config.save();
        }
    }
}