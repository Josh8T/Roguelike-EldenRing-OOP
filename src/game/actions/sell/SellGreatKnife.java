package game.actions.sell;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.weapons.Club;
import game.weapons.GreatKnife;

/**
 * A class that represents the sell action for Great Knife between actors.
 * Created by:
 * @author Aflah Hanif Amarlyadi
 * Modified by:
 *
 */
public class SellGreatKnife extends SellAction {

    private GreatKnife greatKnife;
    private final int sellValue;

    /**
     * Constructor.
     * @param greatKnife being sold
     */
    public SellGreatKnife(GreatKnife greatKnife, int sellValue) {
        this.greatKnife = greatKnife;
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
        greatKnife.receiveRunes(sellValue);
        actor.removeWeaponFromInventory(greatKnife);
        return actor + " sells Great Knife for 350 runes successfully";
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
