package game;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.Location;
import game.enums.Status;

/**
 * An Exchangeable interface.
 * Created by:
 * @author Aflah Hanif Amarlyadi
 * Modified by:
 *
 */
public interface Exchangeable {
    /**
     * Checks if an actor is willing to exchange nearby.
     * @return true if an actor is willing to exchange is nearby.
     */
    default boolean exchangeNearby(Location currentLocation) {
        for (Exit exit : currentLocation.getExits()) {
            Actor otherActor = exit.getDestination().getActor();
            if (otherActor != null && otherActor.hasCapability(Status.WILLING_TO_EXCHANGE)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Remove exchangeable from actor's inventory.
     */
    void giveExchangeable(Actor actor);
}
