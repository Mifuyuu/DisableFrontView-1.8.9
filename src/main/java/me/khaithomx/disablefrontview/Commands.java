package me.khaithomx.disablefrontview;

import net.minecraft.client.Minecraft;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class Commands extends CommandBase {

    @Override
    public String getCommandName() {
        return "disablefrontview";
    }

    @Override
    public String getCommandUsage(ICommandSender sender) {
        return "/disablefrontview - Opens the Mod Config GUI";
    }

    @Override
    public void processCommand(ICommandSender sender, String[] args) {
        if (sender instanceof EntityPlayer) {
            Minecraft mc = Minecraft.getMinecraft();
//            EntityPlayer player = (EntityPlayer) sender;

            mc.displayGuiScreen(new ModConfigGui(null));

//            player.addChatMessage(new ChatComponentText(EnumChatFormatting.GREEN + "Debug: Opened Mod Config GUI."));
        } else {
            sender.addChatMessage(new ChatComponentText(EnumChatFormatting.RED + "Error: This command can only be used by a player."));
        }
    }

    @Override
    public int getRequiredPermissionLevel() {
        return 0;
    }
}