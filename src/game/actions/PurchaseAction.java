package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.Purchasable;

/**
 * A base class that represents the purchase action between actors.
 * Created by:
 * @author Aflah Hanif Amarlyadi
 * Modified by:
 *
 */
public class PurchaseAction extends Action {
    private Purchasable purchasable;
    private final int purchaseValue;

    public PurchaseAction(Purchasable purchasable, int purchaseValue) {
        this.purchasable = purchasable;
        this.purchaseValue = purchaseValue;
    }

    /**
     * When executed, the weapon is added to the actor's inventory and the actor loses runes.
     *
     * @param actor The actor performing the purchase action.
     * @param map The map the actor is on.
     * @return the result of the purchase action, e.g. whether the weapon is purchased or not.
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        if (purchasable.isAffordable(purchaseValue)) {
            purchasable.giveRune(purchaseValue);
            purchasable.takePurchasable(actor);
            return actor + " purchases " + purchasable + " for " + purchaseValue + " runes successfully";
        }
        return actor + " does not have enough runes.";
    }

    /**
     * Describes which weapon the actor can purchase
     *
     * @param actor The actor performing the action.
     * @return a description used for the menu UI
     */
    @Override
    public String menuDescription(Actor actor) {
        return actor + " purchases " + purchasable + " for " + purchaseValue + " runes";
    }
}
