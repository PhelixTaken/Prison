package me.phelix.prison.handler;

import me.phelix.prison.Mine;

import java.util.HashMap;
import java.util.Map;

public final class MineHandler {

    private final Map<String, Mine> mineMap = new HashMap<>();

    public Map<String, Mine> getMineMap(){
        return mineMap;
    }

    public Mine getByName(String name) {
        return mineMap.get(name);
    }

    public boolean mineExists(String name) {
        return mineMap.containsKey(name);
    }

    public Mine getFirstMine(){
        return mineMap.get("first");
    }

}
