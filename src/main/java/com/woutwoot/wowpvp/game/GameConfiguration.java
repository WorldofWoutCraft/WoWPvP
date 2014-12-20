package com.woutwoot.wowpvp.game;

import com.woutwoot.wowpvp.Main;

import java.io.*;
import java.util.Properties;

/**
 * Class to store all game rules, settings, ...
 */
public class GameConfiguration {

    private GameRules rules;
    private File file;
    private Properties props;

    /**
     * Creates a new configuration object which will load the configurations when available.
     *
     * @param filePath Path to configuration file for this GameConfiguration
     */
    public GameConfiguration(String filePath) {
        this.rules = new GameRules();
        this.file = new File(filePath);
        this.props = new Properties();
        loadConfiguration();
    }

    public void saveConfiguration() {
        props.putAll(rules.toMap());
        saveConfigurationFile();
    }

    public void loadConfiguration() {
        //TODO: Load
        loadConfigurationFile();
        saveConfigurationFile();
    }

    private void loadConfigurationFile() {
        InputStream is;
        try {
            is = new FileInputStream(file);
        } catch (Exception e) {
            is = null;
        }

        try {
            if (is == null) {
                // Try loading default game settings from classpath
                is = getClass().getResourceAsStream("game.properties");
            }
            // Try loading properties from the file (if found)
            props.load(is);
        } catch (Exception e) {
        }
    }

    private void saveConfigurationFile() {
        try {
            OutputStream out = new FileOutputStream(file);
            props.store(out, null);
        } catch (Exception e) {
            Main.log("Failed to save configuration file at " + file);
        }
    }

}
