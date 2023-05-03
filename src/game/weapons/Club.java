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

    private final int PURCHASE_VALUE = 600;
    private final int SELL_VALUE = 100;
    private SellClub sellClub = new SellClub(this);

    /**
     * Constructor
     */
    public Club() {
        super("Club", '!', 103, "bonks", 80);
    }

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
    public boolean isAffordable() {
        return RuneManager.getInstance().getRune().value() >= PURCHASE_VALUE;
    }

    @Override
    public void giveRunes() {
        RuneManager.getInstance().getRune().decreaseValue(PURCHASE_VALUE);
    }

    @Override
    public void receiveRunes() {
        RuneManager.getInstance().getRune().increaseValue(SELL_VALUE);
    }
}
