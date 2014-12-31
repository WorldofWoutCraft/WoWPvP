package com.woutwoot.wowpvp.commands;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Wout on 4/12/2014 - 12:03.
 */
public abstract class WoWPvPCommand {

    protected List<String> aliases = new ArrayList<>();

    public boolean match(String s) {
        if (this.getName().equalsIgnoreCase(s) || this.getAliases().contains(s)) {
            return true;
        } else {
            return false;
        }
    }

    public String getPermission() {
        return "wowpvp.command." + getName();
    }

    public abstract String getName();

    public abstract List<String> getAliases();

    public abstract String getDescription();
}
