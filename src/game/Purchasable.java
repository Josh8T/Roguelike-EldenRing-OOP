package game;

import edu.monash.fit2099.engine.actors.Actor;
import game.items.RuneManager;

/**
 * A Purchasable interface.
 * Created by:
 * @author Aflah Hanif Amarlyadi
 * Modified by:
 *
 */
public interface Purchasable {

    /**
     * Checks if the item being purchased is affordable.
     * @return
     */
    default boolean isAffordable(int purchaseValue) {
        return RuneManager.getInstance().getRune().value() >= purchaseValue;
    }

    /**
     * Deduct runes from the player.
     */
    default void giveRune(int purchaseValue) {
        RuneManager.getInstance().getRune().decreaseValue(purchaseValue);
    }

    /**
     * Add purchasable to actor's inventory.
     */
    void takePurchasable(Actor actor);
}
