package game.weapons;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.Sellable;
import game.actions.SellAction;

/**
 * A class that represents the Axe Of Godrick weapon.
 * Created by:
 * @author Aflah Hanif Amarlyadi
 * Modified by:
 *
 */
public class AxeOfGodrick extends WeaponItem implements Sellable {

    private SellAction sellAxeOfGodrick = new SellAction(this, 100);
    /**
     * Constructor.
     */
    public AxeOfGodrick() {
        super("Axe of Godrick", 'T', 142, "chops", 84);
    }

    /**
     * Checks whether a trader is nearby and gives the player an action to sell the weapon.
     * @param currentLocation The location of the actor carrying this Item.
     * @param actor The actor carrying this Item.
     */
    @Override
    public void tick(Location currentLocation, Actor actor) {
        if (traderNearby(currentLocation) && !this.getAllowableActions().contains(sellAxeOfGodrick)) {
            this.addAction(sellAxeOfGodrick);
        }
        if (!traderNearby(currentLocation)) {
            this.removeAction(sellAxeOfGodrick);
        }
    }

    @Override
    public void giveSellable(Actor actor) {
        actor.removeWeaponFromInventory(this);
    }
}
