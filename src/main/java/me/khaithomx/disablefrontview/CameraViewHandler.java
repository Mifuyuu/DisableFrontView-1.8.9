package me.khaithomx.disablefrontview;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import net.minecraft.client.Minecraft;

public class CameraViewHandler {
    private final Minecraft mc = Minecraft.getMinecraft();

    public CameraViewHandler() {
        MinecraftForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    public void onClientTick(TickEvent.ClientTickEvent event) {

        if (event.phase == TickEvent.Phase.END && mc.thePlayer != null && mc.theWorld != null) {

            if (mc.gameSettings.thirdPersonView == 2 && Main.disableFrontView) {

                mc.gameSettings.thirdPersonView = 0;
            }
        }
    }
}