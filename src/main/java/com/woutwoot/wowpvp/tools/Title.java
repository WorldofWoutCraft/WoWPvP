package com.woutwoot.wowpvp.tools;

import com.woutwoot.wowpvp.Main;
import org.bukkit.ChatColor;
import org.bukkit.Server;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Wout on 30/11/2014.
 */
public class Title {

    public static void showTitle(Player p, String title, String subtitle) {
        Server server = Main.getInstance().getServer();
        server.dispatchCommand(server.getConsoleSender(), "title " + p.getName() + " title " + getJSON(title));
        if (subtitle != null)
            server.dispatchCommand(server.getConsoleSender(), "title " + p.getName() + " subtitle " + getJSON(subtitle));
    }

    public static void showTitleToEveryone(String title, String subtitle) {
        Server server = Main.getInstance().getServer();
        for (Player p : server.getOnlinePlayers()) {
            showTitle(p, title, subtitle);
        }
    }

    /**
     * @param title
     * @return String
     * @author werter318
     */
    private static String getJSON(String title) {
        char colorChar = ChatColor.COLOR_CHAR;

        String template = "{text:\"TEXT\",color:COLOR,bold:BOLD,underlined:UNDERLINED,italic:ITALIC,strikethrough:STRIKETHROUGH,obfuscated:OBFUSCATED,extra:[EXTRA]}";
        String json = "";

        List<String> parts = new ArrayList<String>();

        int first = 0;
        int last = 0;

        while ((first = title.indexOf(colorChar, last)) != -1) {
            int offset = 2;
            while ((last = title.indexOf(colorChar, first + offset)) - 2 == first) {
                offset += 2;
            }

            if (last == -1) {
                parts.add(title.substring(first));
                break;
            } else {
                parts.add(title.substring(first, last));
            }
        }

        if (parts.isEmpty()) {
            parts.add(title);
        }

        Pattern colorFinder = Pattern.compile("(" + colorChar + "([a-f0-9]))");
        for (String part : parts) {
            json = (json.isEmpty() ? template : json.replace("EXTRA", template));

            Matcher matcher = colorFinder.matcher(part);
            ChatColor color = (matcher.find() ? ChatColor.getByChar(matcher.group().charAt(1)) : ChatColor.WHITE);

            json = json.replace("COLOR", color.name().toLowerCase());
            json = json.replace("BOLD", String.valueOf(part.contains(ChatColor.BOLD.toString())));
            json = json.replace("ITALIC", String.valueOf(part.contains(ChatColor.ITALIC.toString())));
            json = json.replace("UNDERLINED", String.valueOf(part.contains(ChatColor.UNDERLINE.toString())));
            json = json.replace("STRIKETHROUGH", String.valueOf(part.contains(ChatColor.STRIKETHROUGH.toString())));
            json = json.replace("OBFUSCATED", String.valueOf(part.contains(ChatColor.MAGIC.toString())));

            json = json.replace("TEXT", part.replaceAll("(" + colorChar + "([a-z0-9]))", ""));
        }

        json = json.replace(",extra:[EXTRA]", "");

        return json;
    }
}
