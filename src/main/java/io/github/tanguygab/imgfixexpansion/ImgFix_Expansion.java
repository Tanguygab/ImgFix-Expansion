package io.github.tanguygab.imgfixexpansion;

import me.clip.placeholderapi.PlaceholderAPI;
import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import org.bukkit.OfflinePlayer;
import org.jetbrains.annotations.NotNull;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class ImgFix_Expansion extends PlaceholderExpansion {

    private static final Pattern pattern = Pattern.compile(":[^%:]+:");

    @Override
    public @NotNull String getIdentifier() {
        return "imgfix";
    }

    @Override
    public @NotNull String getAuthor() {
        return "Tanguygab";
    }

    @Override
    public @NotNull String getVersion() {
        return "1.0.0";
    }

    @Override
    public String onRequest(OfflinePlayer player, @NotNull String params) {
        params = PlaceholderAPI.setBracketPlaceholders(player,params);
        String output = params;
        Matcher m = pattern.matcher(params);
        while (m.find()) {
            String g = m.group();
            output = output.replace(g,"{img_"+g.substring(1,g.length()-1)+"}");
        }
        return PlaceholderAPI.setBracketPlaceholders(player,output);
    }
}
