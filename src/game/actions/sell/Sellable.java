package game.actions.sell;

import game.items.RuneManager;

/**
 * A Sellable interface.
 * Created by:
 * @author Aflah Hanif Amarlyadi
 * Modified by:
 *
 */
public interface Sellable {
    RuneManager runeManager = RuneManager.getInstance();

    /**
     * Add runes to the seller.
     */
    void receiveRunes();
}
