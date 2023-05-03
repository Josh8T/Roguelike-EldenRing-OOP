package game.weapons;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.actions.purchase.Purchasable;
import game.actions.sell.SellUchigatana;
import game.actions.sell.Sellable;
import game.actions.UnsheatheAction;
import game.enums.Status;
import game.items.RuneManager;

/**
 * A class that represents the Uchigatana weapon.
 * Created by:
 * @author Aflah Hanif Amarlyadi
 * Modified by:
 * @author David Lee
 */
public class Uchigatana extends WeaponItem implements Purchasable, Sellable {

    private final int PURCHASE_VALUE = 5000;
    private final int SELL_VALUE = 500;
    private SellUchigatana sellUchigatana = new SellUchigatana(this);

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
        boolean traderNearby = false;
        for (Exit exit : currentLocation.getExits()) {
            Actor otherActor = exit.getDestination().getActor();
            if (otherActor != null && otherActor.hasCapability(Status.WILLING_TO_TRADE)) {
                if (!this.getAllowableActions().contains(sellUchigatana)) {
                    this.addAction(sellUchigatana);
                }
                traderNearby = true;
            }
        }
        if (!traderNearby) {
            this.removeAction(sellUchigatana);
        }
    }

    @Override
    public Action getSkill(Actor target, String direction) {
        return new UnsheatheAction(target, direction, this, 60);
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
