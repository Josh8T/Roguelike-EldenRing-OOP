package game;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.Location;
import game.enums.Status;
import game.items.RuneManager;

/**
 * A Sellable interface.
 * Created by:
 * @author Aflah Hanif Amarlyadi
 * Modified by:
 *
 */
public interface Sellable {

    /**
     * Checks if a trader is nearby.
     * @return true if a trader is nearby.
     */
    default boolean traderNearby(Location currentLocation) {
        for (Exit exit : currentLocation.getExits()) {
            Actor otherActor = exit.getDestination().getActor();
            if (otherActor != null && otherActor.hasCapability(Status.WILLING_TO_PURCHASE)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Add runes to the player.
     */
    default void takeRune(int sellValue) {
        RuneManager.getInstance().getRune().increaseValue(sellValue);
    }

    /**
     * Remove sellable from actor's inventory.
     */
    void giveSellable(Actor actor);
}
