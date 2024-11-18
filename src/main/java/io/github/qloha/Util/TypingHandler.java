package io.github.qloha.Util;

import io.github.qloha.BetterEmotes;
import net.minecraftforge.client.event.GuiScreenEvent.KeyboardInputEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiChat;
import net.minecraft.client.gui.GuiTextField;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class TypingHandler {
    private static final Map<String, String> emoteMap = new HashMap<>();

    static {
        emoteMap.put("<3", "❤");
        emoteMap.put(":star:", "✮");
        emoteMap.put(":yes:", "✔");
        emoteMap.put(":no:", "✖");
        emoteMap.put(":java:", "☕");
        emoteMap.put(":arrow:", "➜");
        emoteMap.put(":shrug:", "¯\\_(ツ)_/¯");
        emoteMap.put(":tableflip:", "(╯°□°）╯︵ ┻━┻");
        emoteMap.put("o/", "( ﾟ◡ﾟ)/");
        emoteMap.put(":123:", "123");
        emoteMap.put(":totem:", "◎_◎");
        emoteMap.put(":typing:", "✎...");
        emoteMap.put(":maths:", "√(π+x)=L");
        emoteMap.put(":snail:", "@'-'");
        emoteMap.put(":thinking:", "(0.o?)");
        emoteMap.put(":gimme:", "༼つ ◕_◕ ༽つ");
        emoteMap.put(":wizard:", "('-')⊃━☆ﾟ.*･｡ﾟ");
        emoteMap.put(":pvp:", "⚔");
        emoteMap.put(":peace:", "✌");
        emoteMap.put(":oof:", "OOF");
        emoteMap.put(":puffer:", "<('O')>");
        emoteMap.put(":snow:", "☃");
        emoteMap.put(":dog:", "(ᵔᴥᵔ)");
        emoteMap.put(":sloth:", "( ⬩ ⊝ ⬩ )");
        emoteMap.put("^_^", "^_^");
        emoteMap.put(":dab:", "<o/");
        emoteMap.put(":cat:", "= ＾● ⋏ ●＾ =");
        emoteMap.put(":yey:", "ヽ (◕◡◕) ﾉ");
        emoteMap.put("h/", "ヽ(^◇^*)/");
        emoteMap.put(":dj:", "ヽ(⌐■_■)ノ♬");
        emoteMap.put(":cute:", "(✿ᴖ‿ᴖ)");
        emoteMap.put("^-^", "^-^");
    }

    @SubscribeEvent
    public void onKeyboardInput(KeyboardInputEvent.Post event) {
        if (!(Minecraft.getMinecraft().currentScreen instanceof GuiChat)) return;

        GuiChat chatScreen = (GuiChat) Minecraft.getMinecraft().currentScreen;

        try {
            Field[] fields = GuiChat.class.getDeclaredFields();
            for (Field field : fields) {
                if (field.getType() == GuiTextField.class) {
                    field.setAccessible(true);

                    GuiTextField guiTextField = (GuiTextField) field.get(chatScreen);

                    String currentText = guiTextField.getText();
                    String updatedText = replaceEmotes(currentText);

                    if (!currentText.equals(updatedText)) {
                        guiTextField.setText(updatedText);
                    }
                    break; // Exit after finding the correct field
                }
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            System.out.println("Failed to access GuiTextField in GuiChat.");
        }
    }

    private String replaceEmotes(String text) {
        if (!BetterEmotes.emotesEnabled) return text;

        for (Map.Entry<String, String> entry : emoteMap.entrySet()) {
            text = text.replace(entry.getKey(), entry.getValue());
        }
        return text;
    }
}