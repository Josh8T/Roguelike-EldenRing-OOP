package game.actions.purchase;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.weapons.Uchigatana;

/**
 * A class that represents the purchase action for Uchigatana between actors.
 * Created by:
 * @author Aflah Hanif Amarlyadi
 * Modified by:
 *
 */
public class PurchaseUchigatana extends PurchaseAction {

    /**
     * When executed, the weapon is added to the actor's inventory and the actor loses runes.
     *
     * @param actor The actor performing the purchase action.
     * @param map The map the actor is on.
     * @return the result of the purchase action, e.g. whether the weapon is purchased or not.
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        Uchigatana uchigatana = new Uchigatana();
        if (uchigatana.isAffordable()) {
            uchigatana.giveRunes();
            actor.addWeaponToInventory(uchigatana);
            return actor + " purchases Uchigatana for 5000 runes successfully";
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
        return actor + " purchases Uchigatana for 5000 runes";
    }
}
