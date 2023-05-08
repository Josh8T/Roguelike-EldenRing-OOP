package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.Sellable;

/**
 * A base class that represents the sell action between actors.
 * Created by:
 * @author Aflah Hanif Amarlyadi
 * Modified by:
 *
 */
public class SellAction extends Action {
    private Sellable sellable;
    private final int sellValue;

    /**
     * Constructor.
     * @param sellable being sold
     */
    public SellAction (Sellable sellable, int sellValue) {
        this.sellable = sellable;
        this.sellValue = sellValue;
    }

    /**
     * When executed, the weapon is removed from the inventory and the actor receives runes.
     *
     * @param actor The actor performing the sell action.
     * @param map The map the actor is on.
     * @return the result of the sell action, e.g. whether the weapon is sold or not.
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        sellable.takeRune(sellValue);
        sellable.giveSellable(actor);
        return actor + " sells " + sellable + " for " + sellValue + " runes successfully";
    }

    /**
     * Describes which weapon the actor can sell
     *
     * @param actor The actor performing the action.
     * @return a description used for the menu UI
     */
    @Override
    public String menuDescription(Actor actor) {
        return actor + " sells " + sellable + " for " + sellValue + " runes";
    }
}
