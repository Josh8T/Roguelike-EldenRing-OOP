package game.weapons;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.Purchasable;
import game.actions.SellAction;
import game.Sellable;

/**
 * A simple weapon that can be used to attack the enemy.
 * It deals 103 damage with 80% hit rate
 * Created by:
 * @author Adrian Kristanto
 * Modified by:
 * @author Aflah Hanif Amarlyadi
 */
public class Club extends WeaponItem implements Purchasable, Sellable {

    private SellAction sellClub = new SellAction(this, 100);

    /**
     * Constructor
     */
    public Club() {
        super("Club", '!', 103, "bonks", 80);
    }

    /**
     * Checks whether a trader is nearby and gives the player an action to sell the weapon.
     * @param currentLocation The location of the actor carrying this Item.
     * @param actor The actor carrying this Item.
     */
    @Override
    public void tick(Location currentLocation, Actor actor) {
        if (traderNearby(currentLocation) && !this.getAllowableActions().contains(sellClub)) {
            this.addAction(sellClub);
        }
        if (!traderNearby(currentLocation)) {
            this.removeAction(sellClub);
        }
    }

    @Override
    public Action getSkill(Actor target, String direction) {
        return null;
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
