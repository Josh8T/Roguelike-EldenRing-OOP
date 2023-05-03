package game.actions.sell;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.weapons.Club;

/**
 * A class that represents the sell action for Club between actors.
 * Created by:
 * @author Aflah Hanif Amarlyadi
 * Modified by:
 *
 */
public class SellClub extends SellAction {

    private Club club;
    private final int sellValue;

    /**
     * Constructor.
     * @param club being sold
     */
    public SellClub (Club club, int sellValue) {
        this.club = club;
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
        club.receiveRunes(sellValue);
        actor.removeWeaponFromInventory(club);
        return actor + " sells Club for 100 runes successfully";
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
