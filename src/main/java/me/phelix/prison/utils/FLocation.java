package me.phelix.prison.utils;

import java.util.Objects;

public final class FLocation {

    private final int x;
    private final int z;
    private final String worldUUID;
    private int minHeight;
    private int maxHeight;

    public FLocation(int x, int z, String worldUUID) {
        this.x = x;
        this.z = z;
        this.worldUUID = worldUUID;
    }

    public int getX() {
        return x;
    }

    public int getZ() {
        return z;
    }

    public String getWorldUUID() {
        return worldUUID;
    }

    public int getMinHeight() {
        return minHeight;
    }

    public int getMaxHeight() {
        return maxHeight;
    }

    public void setMinHeight(int minHeight) {
        this.minHeight = minHeight;
    }

    public void setMaxHeight(int maxHeight) {
        this.maxHeight = maxHeight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FLocation fLocation = (FLocation) o;
        return x == fLocation.x &&
                z == fLocation.z &&
                worldUUID.equals(fLocation.worldUUID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, z, worldUUID);
    }
}
