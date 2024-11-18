package io.github.qloha;

import io.github.qloha.Util.TypingHandler;
import net.minecraftforge.client.ClientCommandHandler;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

@Mod(modid = BetterEmotes.MODID, version = BetterEmotes.VERSION, clientSideOnly = true)
public class BetterEmotes {
    public static final String MODID = "betteremotes";
    public static final String VERSION = "1.0";

    public static boolean emotesEnabled = true;

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        System.out.println("BetterEmotes joined the game.");
        MinecraftForge.EVENT_BUS.register(new TypingHandler());
        ClientCommandHandler.instance.registerCommand(new Command());
    }
}
