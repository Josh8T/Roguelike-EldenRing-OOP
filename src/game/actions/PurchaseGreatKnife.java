package game.actions;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import game.items.Runes;
import game.weapons.GreatKnife;

/**
 * A class that represents the purchase action for Great Knife between actors.
 * Created by:
 * @author Aflah Hanif Amarlyadi
 * Modified by:
 *
 */
public class PurchaseGreatKnife extends PurchaseAction {

    /**
     * When executed, the weapon is added to the actor's inventory and the actor loses runes.
     *
     * @param actor The actor performing the purchase action.
     * @param map The map the actor is on.
     * @return the result of the purchase action, e.g. whether the weapon is purchased or not.
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        for (Item item : actor.getItemInventory()) {
            if (item instanceof Runes) {
                if (((Runes) item).getValue() >= 3500) {
                    ((Runes) item).decreaseValue(3500);
                    actor.addWeaponToInventory(new GreatKnife());
                    return actor + " purchases Great Knife for 3500 runes successfully.";
                }
            }
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
        return actor + " purchases Great Knife for 3500 runes.";
    }
}
