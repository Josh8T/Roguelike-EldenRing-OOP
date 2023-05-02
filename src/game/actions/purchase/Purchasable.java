package game.actions.purchase;

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
    RuneManager runeManager = RuneManager.getInstance();

    /**
     * Checks if the item being purchased is affordable.
     * @return
     */
    boolean isAffordable();

    /**
     * Deduct runes from the buyer.
     */
    void giveRunes();
}