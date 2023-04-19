package game.actions;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.items.Runes;
import game.weapons.GreatKnife;

/**
 * A class that represents the sell action for Great Knife between actors.
 * Created by:
 * @author Aflah Hanif Amarlyadi
 * Modified by:
 *
 */
public class SellGreatKnife extends SellAction {

    /**
     * When executed, the weapon is removed from the inventory and the actor receives runes.
     *
     * @param actor The actor performing the sell action.
     * @param map The map the actor is on.
     * @return the result of the sell action, e.g. whether the weapon is sold or not.
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        for (WeaponItem weapon: actor.getWeaponInventory()) {
            if (weapon instanceof GreatKnife) {
                actor.removeWeaponFromInventory(weapon);
                for (Item item: actor.getItemInventory()) {
                    if (item instanceof Runes) {
                        ((Runes) item).increaseValue(350);
                    }
                }
                return actor + " sells Great Knife for 350 runes successfully.";
            }
        }
        return actor + " does not have Great Knife in their inventory.";
    }

    /**
     * Describes which weapon the actor can sell
     *
     * @param actor The actor performing the action.
     * @return a description used for the menu UI
     */
    @Override
    public String menuDescription(Actor actor) {
        return actor + " sells Great Knife for 350 runes";
    }
}
