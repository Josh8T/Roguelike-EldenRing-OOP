package game.weapons;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.actions.AreaAttackAction;
import game.Purchasable;
import game.actions.SellAction;
import game.Sellable;
import game.enums.Status;

/**
 * A class that represents the Scimitar weapon.
 * Created by:
 * @author Aflah Hanif Amarlyadi
 * Modified by:
 * @author David Lee
 */
public class Scimitar extends WeaponItem implements Purchasable, Sellable {

    private SellAction sellScimitar = new SellAction(this, 100);

    /**
     * Constructor.
     */
    public Scimitar() {
        super("Scimitar", 's', 118, "slashes", 88);
    }

    /**
     * Checks whether a trader is nearby and gives the player an action to sell the weapon.
     * @param currentLocation The location of the actor carrying this Item.
     * @param actor The actor carrying this Item.
     */
    @Override
    public void tick(Location currentLocation, Actor actor) {
        if (traderNearby(currentLocation) && !this.getAllowableActions().contains(sellScimitar)) {
            this.addAction(sellScimitar);
        }
        if (!traderNearby(currentLocation)) {
            this.removeAction(sellScimitar);
        }
    }

    @Override
    public Action getSkill(Actor target, String direction) {
        return new AreaAttackAction(this);
    }

    @Override
    public void takePurchasable(Actor actor) {
        actor.addWeaponToInventory(this);
    }

    @Override
    public void giveSellable(Actor actor) {
        actor.removeWeaponFromInventory(this);
    }
}
