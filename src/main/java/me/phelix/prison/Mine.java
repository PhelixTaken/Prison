package me.phelix.prison;

import me.phelix.prison.utils.FLocation;

import java.util.HashSet;
import java.util.Set;

public final class Mine {

    private final String name;
    private final int value;
    private transient Set<FLocation> chunks = new HashSet<>();

    public Mine(String name, int value) {
        this.name = name;
        this.value = value;
    }

    public Set<FLocation> getChunks(){
        return chunks;
    }

    public void addChunk(final FLocation fLocation) {
        chunks.add(fLocation);
    }

    public void removeChunk(final FLocation fLocation){
        chunks.remove(fLocation);
    }

    public int getValue(){
        return value;
    }

}
