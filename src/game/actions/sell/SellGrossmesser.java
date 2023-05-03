package game.actions.sell;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.actions.sell.SellAction;
import game.weapons.Grossmesser;

/**
 * A class that represents the sell action for Grossmesser between actors.
 * Created by:
 * @author Aflah Hanif Amarlyadi
 * Modified by:
 *
 */
public class SellGrossmesser extends SellAction {

    private Grossmesser grossmesser;
    private final int sellValue;

    /**
     * Constructor.
     * @param grossmesser being sold
     */
    public SellGrossmesser(Grossmesser grossmesser, int sellValue) {
        this.grossmesser = grossmesser;
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
        grossmesser.receiveRunes(sellValue);
        actor.removeWeaponFromInventory(grossmesser);
        return actor + " sells Grossmesser for 100 runes successfully.";
    }

    /**
     * Describes which weapon the actor can sell
     *
     * @param actor The actor performing the action.
     * @return a description used for the menu UI
     */
    @Override
    public String menuDescription(Actor actor) {
        return actor + " sells Grossmesser for 100 runes";
    }
}
