package game.actions.sell;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.actions.sell.SellAction;
import game.weapons.Uchigatana;

/**
 * A class that represents the sell action for Uchigatana between actors.
 * Created by:
 * @author Aflah Hanif Amarlyadi
 * Modified by:
 *
 */
public class SellUchigatana extends SellAction {

    private Uchigatana uchigatana;

    /**
     * Constructor.
     * @param uchigatana being sold
     */
    public SellUchigatana(Uchigatana uchigatana) {
        this.uchigatana = uchigatana;
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
        uchigatana.receiveRunes();
        actor.removeWeaponFromInventory(uchigatana);
        return actor + " sells Uchigatana for 500 runes successfully";
    }

    /**
     * Describes which weapon the actor can sell
     *
     * @param actor The actor performing the action.
     * @return a description used for the menu UI
     */
    @Override
    public String menuDescription(Actor actor) {
        return actor + " sells Uchigatana for 500 runes";
    }
}
