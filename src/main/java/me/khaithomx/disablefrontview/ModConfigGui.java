package me.khaithomx.disablefrontview;

import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.fml.client.config.GuiConfig;
import net.minecraftforge.fml.client.config.IConfigElement;
import net.minecraftforge.common.config.ConfigElement;

import java.util.List;

public class ModConfigGui extends GuiConfig {

    public ModConfigGui(GuiScreen parentScreen) {
        super(parentScreen,
                getConfigElements(),
                Main.MODID,
                false,
                false,
                "DisableFrontView Settings");
    }

    private static List<IConfigElement> getConfigElements() {
        return new ConfigElement(Main.config.getCategory("general")).getChildElements();
    }

    @Override
    public void initGui() {
        super.initGui();
        this.mc.mouseHelper.ungrabMouseCursor();
    }

    @Override
    public boolean doesGuiPauseGame() {
        return true;
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        super.drawScreen(mouseX, mouseY, partialTicks);
    }
}
