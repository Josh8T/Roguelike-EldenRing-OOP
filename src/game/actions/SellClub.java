package game.actions;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.items.Runes;
import game.weapons.Club;

public class SellClub extends SellAction {

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
            if (weapon instanceof Club) {
                actor.removeWeaponFromInventory(weapon);
                for (Item item: actor.getItemInventory()) {
                    if (item instanceof Runes) {
                        ((Runes) item).increaseValue(100);
                    }
                }
                return actor + " sells Club for 100 runes successfully.";
            }
        }
        return actor + " does not have Club in their inventory.";
    }

    /**
     * Describes which weapon the actor can sell
     *
     * @param actor The actor performing the action.
     * @return a description used for the menu UI
     */
    @Override
    public String menuDescription(Actor actor) {
        return actor + " sells Club for 100 runes";
    }
}
