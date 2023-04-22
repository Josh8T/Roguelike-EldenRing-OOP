package game.utils;

import edu.monash.fit2099.engine.positions.Location;

/**
 * A calculator to compute the Manhattan distance between two locations
 * Created by:
 * @author David Lee
 * Modified by:
 *
 */
public class DistanceCalculator {
    /**
     * Compute the Manhattan distance between two locations.
     *
     * @param a the first location
     * @param b the first location
     * @return the number of steps between a and b if you only move in the four cardinal directions.
     */
    public static int distance(Location a, Location b) {
        return Math.abs(a.x() - b.x()) + Math.abs(a.y() - b.y());
    }
}
