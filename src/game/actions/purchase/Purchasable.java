package game.actions.purchase;

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
    boolean isAffordable(int purchaseValue);

    /**
     * Deduct runes from the buyer.
     */
    void giveRunes(int purchaseValue);
}
