package game;

import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;

/**
 * The Destination of a travel.
 */
public class Destination {
    /**
     * Name of the destination of the Golden Fog Door
     */
    private final String name;

    /**
     * GameMap of the destination of the Golden Fog Door
     */
    private final GameMap map;

    /**
     * Location of the destination of the Golden Fog Door
     */
    private final Location location;

    public Destination(String name, GameMap map, Location location) {
        this.name = name;
        this.map = map;
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public GameMap getMap() {
        return map;
    }

    public Location getLocation() {
        return location;
    }

    @Override
    public String toString() {
        return name;
    }
}
