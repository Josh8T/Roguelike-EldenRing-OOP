package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.Exchangeable;

/**
 * A class that represents the exchange action between actors.
 * Created by:
 * @author Aflah Hanif Amarlyadi
 * Modified by:
 *
 */
public class ExchangeAction extends Action {
    private Exchangeable exchangeable;
    private WeaponItem weapon;

    public ExchangeAction(Exchangeable exchangeable, WeaponItem weapon) {
        this.exchangeable = exchangeable;
        this.weapon = weapon;
    }

    /**
     * When executed, the weapon is added to the actor's inventory and the actor loses runes.
     *
     * @param actor The actor performing the purchase action.
     * @param map The map the actor is on.
     * @return the result of the purchase action, e.g. whether the weapon is purchased or not.
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        exchangeable.giveExchangeable(actor);
        actor.addWeaponToInventory(weapon);
        return actor + " exchanges " + exchangeable + " for " + weapon;
    }

    /**
     * Describes which weapon the actor can purchase
     *
     * @param actor The actor performing the action.
     * @return a description used for the menu UI
     */
    @Override
    public String menuDescription(Actor actor) {
        return actor + " exchanges " + exchangeable + " for " + weapon;
    }
}
