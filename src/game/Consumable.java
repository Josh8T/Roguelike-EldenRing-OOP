package game;

import edu.monash.fit2099.engine.actors.Actor;

/**
 * A Consumable interface for consumable items.
 * Created by:
 * @author Josh Hernett Tan
 * Modified by:
 * @author Aflah Hanif Amarlyadi
 */
public interface Consumable {
    /**
     * @param actor consumes the consumable
     */
    void consume(Actor actor);

    /**
     * @return true if the consumable is empty, otherwise false
     */
    default boolean isEmpty() {
        return false;
    }
}
