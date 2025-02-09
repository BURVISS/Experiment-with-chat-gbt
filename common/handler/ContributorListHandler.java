/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.util.DefaultUncaughtExceptionHandler
 */
package com.meteor.extrabotany.common.handler;

import com.meteor.extrabotany.ExtraBotany;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import net.minecraft.util.DefaultUncaughtExceptionHandler;

public class ContributorListHandler {
    public static volatile Map<String, Integer> contributorsMap = Collections.emptyMap();
    private static boolean startedLoading = false;

    public static void firstStart() {
        if (!startedLoading) {
            Thread thread = new Thread(ContributorListHandler::fetch);
            thread.setName("ExtraBotany Contributor Thread");
            thread.setDaemon(true);
            thread.setUncaughtExceptionHandler((Thread.UncaughtExceptionHandler)new DefaultUncaughtExceptionHandler(ExtraBotany.LOGGER));
            thread.start();
            ExtraBotany.LOGGER.info("Start Loading Contributors' List");
            startedLoading = true;
        }
    }

    private static void load(Properties props) {
        HashMap<String, Integer> m = new HashMap<String, Integer>();
        for (String key : props.stringPropertyNames()) {
            String value = props.getProperty(key);
            int i = 0;
            try {
                i = Integer.parseInt(value);
            }
            catch (NumberFormatException numberFormatException) {
                // empty catch block
            }
            m.put(key, i);
        }
        contributorsMap = m;
    }

    public static boolean isSupporter(String name) {
        return contributorsMap.containsKey(name);
    }

    public static boolean isDeveloper(String name) {
        return ContributorListHandler.isSupporter(name) && contributorsMap.get(name) == 0;
    }

    public static boolean isArtist(String name) {
        return ContributorListHandler.isSupporter(name) && contributorsMap.get(name) == 1;
    }

    public static boolean isContributor(String name) {
        return ContributorListHandler.isSupporter(name) && contributorsMap.get(name) == 2;
    }

    public static boolean isPatreoner(String name) {
        return ContributorListHandler.isSupporter(name) && contributorsMap.get(name) == 3;
    }

    public static String getRole(String name) {
        if (!ContributorListHandler.isSupporter(name)) {
            return "No Role";
        }
        if (ContributorListHandler.isDeveloper(name)) {
            return "Developer";
        }
        if (ContributorListHandler.isArtist(name)) {
            return "Artist";
        }
        if (ContributorListHandler.isContributor(name)) {
            return "Contributor";
        }
        if (ContributorListHandler.isPatreoner(name)) {
            return "Patreoner";
        }
        return "Supporter";
    }

    private static void fetch() {
        try {
            URL url = new URL("https://raw.githubusercontent.com/ExtraMeteorP/ExtraBotany1.16.5/main/contributors.properties");
            URLConnection conn = url.openConnection();
            conn.setConnectTimeout(15000);
            conn.setReadTimeout(15000);
            Properties props = new Properties();
            try (InputStreamReader reader = new InputStreamReader(url.openStream(), StandardCharsets.UTF_8);){
                props.load(reader);
                ContributorListHandler.load(props);
            }
        }
        catch (IOException e) {
            ExtraBotany.LOGGER.info("Could not load contributors list.");
        }
    }
}
