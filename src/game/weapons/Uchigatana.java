package game.weapons;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.Purchasable;
import game.actions.SellAction;
import game.Sellable;
import game.actions.UnsheatheAction;
import game.enums.Status;

/**
 * A class that represents the Uchigatana weapon.
 * Created by:
 * @author Aflah Hanif Amarlyadi
 * Modified by:
 * @author David Lee
 */
public class Uchigatana extends WeaponItem implements Purchasable, Sellable {

    private SellAction sellUchigatana = new SellAction(this, 500);
    /**
     * Constructor.
     */
    public Uchigatana() {
        super("Uchigatana", ')', 115, "slashes", 80);
    }

    /**
     * Checks whether a trader is nearby and gives the player an action to sell the weapon.
     * @param currentLocation The location of the actor carrying this Item.
     * @param actor The actor carrying this Item.
     */
    @Override
    public void tick(Location currentLocation, Actor actor) {
        if (traderNearby(currentLocation) && !this.getAllowableActions().contains(sellUchigatana)) {
            this.addAction(sellUchigatana);
        }
        if (!traderNearby(currentLocation)) {
            this.removeAction(sellUchigatana);
        }
    }

    @Override
    public Action getSkill(Actor target, String direction) {
        return new UnsheatheAction(target, direction, this, 60);
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
