package game.weapons;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.actions.purchase.Purchasable;
import game.actions.sell.SellClub;
import game.actions.sell.Sellable;
import game.enums.Status;
import game.items.RuneManager;

/**
 * A simple weapon that can be used to attack the enemy.
 * It deals 103 damage with 80% hit rate
 * Created by:
 * @author Adrian Kristanto
 * Modified by:
 * @author Aflah Hanif Amarlyadi
 */
public class Club extends WeaponItem implements Purchasable, Sellable {

    private SellClub sellClub = new SellClub(this, 100);

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
        boolean traderNearby = false;
        for (Exit exit : currentLocation.getExits()) {
            Actor otherActor = exit.getDestination().getActor();
            if (otherActor != null && otherActor.hasCapability(Status.WILLING_TO_TRADE)) {
                if (!this.getAllowableActions().contains(sellClub)) {
                    this.addAction(sellClub);
                }
                traderNearby = true;
            }
        }
        if (!traderNearby) {
            this.removeAction(sellClub);
        }
    }

    @Override
    public boolean isAffordable(int price) {
        return RuneManager.getInstance().getRune().value() >= price;
    }

    @Override
    public void giveRunes(int price) {
        RuneManager.getInstance().getRune().decreaseValue(price);
    }

    @Override
    public void receiveRunes(int price) {
        RuneManager.getInstance().getRune().increaseValue(price);
    }
}
