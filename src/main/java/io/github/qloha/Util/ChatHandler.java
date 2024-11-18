package io.github.qloha.Util;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class ChatHandler {
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

    public static Map<String, String> getEmoteMap() {
        return Collections.unmodifiableMap(emoteMap);
    }
}