package me.phelix.prison.handler;

import me.phelix.prison.Mine;
import me.phelix.prison.utils.FLocation;

import java.util.HashMap;
import java.util.Map;

public final class ChunkHandler {

    private Map<FLocation, Mine> mineMap = new HashMap<>();

    public Map<FLocation, Mine> getMineMap(){
        return mineMap;
    }

    public Mine getFromChunk (FLocation fLocation) {
        if(mineMap.get(fLocation) == null) return null;
        return mineMap.get(fLocation);
    }

    public FLocation getFLocation(FLocation fLocation) {
        for(final FLocation fLocation1 : mineMap.keySet()) {
            if(fLocation1.equals(fLocation))
                return fLocation1;
        }
        return null;
    }

}
