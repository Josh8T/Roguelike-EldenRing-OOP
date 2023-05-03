package game.weapons;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.actions.AreaAttackAction;
import game.actions.sell.SellGrossmesser;
import game.actions.sell.Sellable;
import game.enums.Status;
import game.items.RuneManager;

/**
 * A class that represents the Grossmesser weapon.
 * Created by:
 * @author Aflah Hanif Amarlyadi
 * Modified by:
 * @author David Lee
 */
public class Grossmesser extends WeaponItem implements Sellable {

    private final int SELL_VALUE = 100;
    private SellGrossmesser sellGrossmesser = new SellGrossmesser(this);

    /**
     * Constructor.
     */
    public Grossmesser() {
        super("Grossmesser", '?', 115, "slashes", 85);
    }

    @Override
    public void tick(Location currentLocation, Actor actor) {
        boolean traderNearby = false;
        for (Exit exit : currentLocation.getExits()) {
            Actor otherActor = exit.getDestination().getActor();
            if (otherActor != null && otherActor.hasCapability(Status.WILLING_TO_TRADE)) {
                if (!this.getAllowableActions().contains(sellGrossmesser)) {
                    this.addAction(sellGrossmesser);
                }
                traderNearby = true;
            }
        }
        if (!traderNearby) {
            this.removeAction(sellGrossmesser);
        }
    }

    @Override
    public Action getSkill(Actor holder, String direction) {
        return new AreaAttackAction(this);
    }

    public void receiveRunes() {
        RuneManager.getInstance().getRune().increaseValue(SELL_VALUE);
    }
}
