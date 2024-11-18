package io.github.qloha;

import io.github.qloha.Util.ChatHandler;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.event.ClickEvent;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.ChatStyle;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.IChatComponent;

import java.util.Map;

public class Command extends CommandBase {
    @Override
    public String getCommandName() {
        return "emotes";
    }

    @Override
    public String getCommandUsage(ICommandSender sender) {
        return "/emotes [enable|disable]";
    }

    @Override
    public void processCommand(ICommandSender sender, String[] args) {
        if (args.length == 0) {
            // List available emotes
            IChatComponent emoteList = new ChatComponentText("§a" + "Available Emotes:\n");

            for (Map.Entry<String, String> entry : ChatHandler.getEmoteMap().entrySet()) {
                String emoteTrigger = entry.getKey();
                String emoteValue = entry.getValue();

                IChatComponent emoteEntry = new ChatComponentText(
                        "§b" + emoteTrigger +
                                "§7" + " - " +
                                "§e" + emoteValue
                );

                // Add click event to send emote to chat
                emoteEntry.setChatStyle(new ChatStyle()
                        .setChatClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, emoteValue))
                        .setUnderlined(true)
                );

                emoteList.appendSibling(emoteEntry).appendText("\n");
            }

            sender.addChatMessage(emoteList);
        } else if (args[0].equalsIgnoreCase("disable")) {
            BetterEmotes.emotesEnabled = false;
            sender.addChatMessage(new ChatComponentText("§c" + "Emotes disabled."));
        } else if (args[0].equalsIgnoreCase("enable")) {
            BetterEmotes.emotesEnabled = true;
            sender.addChatMessage(new ChatComponentText("§a" + "Emotes enabled."));
        } else {
            sender.addChatMessage(new ChatComponentText("§4" + "Invalid usage. Try /emotes or /emotes enable|disable"));
        }
    }

    @Override
    public int getRequiredPermissionLevel() {
        return 0; // Allow all players to execute the command.
    }
}