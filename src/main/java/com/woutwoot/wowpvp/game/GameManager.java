package com.woutwoot.wowpvp.game;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Wout on 3/12/2014 - 22:20.
 */
public class GameManager {

    private Map<String, Game> games = new HashMap<>();

    public void createGame(String name){
        games.put(name, new Game(name));
    }

    public Game getGame(String name){
        return games.get(name);
    }

}
