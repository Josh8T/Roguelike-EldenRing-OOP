package game.weapons;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.actions.AreaAttackAction;
import game.actions.purchase.Purchasable;
import game.actions.sell.SellScimitar;
import game.actions.sell.Sellable;
import game.enums.Status;
import game.items.RuneManager;

/**
 * A class that represents the Scimitar weapon.
 * Created by:
 * @author Aflah Hanif Amarlyadi
 * Modified by:
 * @author David Lee
 */
public class Scimitar extends WeaponItem implements Purchasable, Sellable {

    private final int PURCHASE_VALUE = 600;
    private final int SELL_VALUE = 100;

    /**
     * Constructor.
     */
    public Scimitar() {
        super("Scimitar", 's', 118, "slashes", 88);
    }

    @Override
    public void tick(Location currentLocation) {
        for (Exit exit : currentLocation.getExits()) {
            Actor actor = exit.getDestination().getActor();
            if (actor != null && actor.hasCapability(Status.WILLING_TO_TRADE)) {
                this.addAction(new SellScimitar(this));
            }
        }
    }

    @Override
    public Action getSkill(Actor target, String direction) {
        return new AreaAttackAction(this);
    }

    @Override
    public boolean isAffordable() {
        return RuneManager.getInstance().getRune().getValue() >= PURCHASE_VALUE;
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
