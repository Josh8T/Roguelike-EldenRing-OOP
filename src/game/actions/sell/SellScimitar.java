package game.actions.sell;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.weapons.Scimitar;

/**
 * A class that represents the sell action for Great Knife between actors.
 * Created by:
 * @author Aflah Hanif Amarlyadi
 * Modified by:
 *
 */
public class SellScimitar extends SellAction {

    private Scimitar scimitar;

    /**
     * Constructor.
     * @param scimitar being sold
     */
    public SellScimitar(Scimitar scimitar) {
        this.scimitar = scimitar;
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
        scimitar.receiveRunes();
        actor.removeWeaponFromInventory(scimitar);
        return actor + " sells Scimitar for 100 runes successfully";
    }

    /**
     * Describes which weapon the actor can sell
     *
     * @param actor The actor performing the action.
     * @return a description used for the menu UI
     */
    @Override
    public String menuDescription(Actor actor) {
        return actor + " sells Scimitar for 100 runes";
    }
}
