package game.weapons;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.actions.SellAction;
import game.Purchasable;
import game.actions.QuickStepAction;
import game.Sellable;
import game.enums.Status;

/**
 * A class that represents the Great Knife weapon.
 * Created by:
 * @author Aflah Hanif Amarlyadi
 * Modified by:
 * @author David Lee
 */
public class GreatKnife extends WeaponItem implements Purchasable, Sellable {

    private SellAction sellGreatKnife = new SellAction(this, 350);

    /**
     * Constructor.
     */
    public GreatKnife() {
        super("Great Knife", '/', 75, "stabs", 70);
    }

    @Override
    public Action getSkill(Actor target, String direction) {
        return new QuickStepAction(target, direction, this);
    }

    /**
     * Checks whether a trader is nearby and gives the player an action to sell the weapon.
     * @param currentLocation The location of the actor carrying this Item.
     * @param actor The actor carrying this Item.
     */
    @Override
    public void tick(Location currentLocation, Actor actor) {
        if (traderNearby(currentLocation) && !this.getAllowableActions().contains(sellGreatKnife)) {
            this.addAction(sellGreatKnife);
        }
        if (!traderNearby(currentLocation)) {
            this.removeAction(sellGreatKnife);
        }
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