package game.items;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.DropAction;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.Location;
import game.Exchangeable;
import game.Sellable;
import game.actions.ExchangeAction;
import game.actions.SellAction;
import game.enums.ItemType;
import game.weapons.AxeOfGodrick;
import game.weapons.GraftedDragon;

/**
 * A class that represents the Remembrance of the Grafted item.
 * Created by:
 * @author Aflah Hanif Amarlyadi
 * Modified by:
 *
 */
public class RemembranceOfTheGrafted extends Item implements Sellable, Exchangeable {

    private SellAction sellRemembranceOfTheGrafted = new SellAction(this, 20000);
    private ExchangeAction exchangeForAxeOfGodrick = new ExchangeAction(this, new AxeOfGodrick());
    private ExchangeAction exchangeForGraftedDragon = new ExchangeAction(this, new GraftedDragon());

    /***
     * Constructor.
     */
    public RemembranceOfTheGrafted() {
        super("Remembrance Of The Grafted", 'O', true);
        this.addCapability(ItemType.DROPPABLE);
    }

    @Override
    public void tick(Location currentLocation, Actor actor) {
        if (traderNearby(currentLocation) && !this.getAllowableActions().contains(sellRemembranceOfTheGrafted)) {
            this.addAction(sellRemembranceOfTheGrafted);
        }
        if (!traderNearby(currentLocation)) {
            this.removeAction(sellRemembranceOfTheGrafted);
        }

        if (exchangeNearby(currentLocation) && !this.getAllowableActions().contains(exchangeForAxeOfGodrick)) {
            this.addAction(exchangeForAxeOfGodrick);
        }
        if (exchangeNearby(currentLocation) && !this.getAllowableActions().contains(exchangeForGraftedDragon)) {
            this.addAction(exchangeForGraftedDragon);
        }
        if (!exchangeNearby(currentLocation)) {
            this.removeAction(exchangeForAxeOfGodrick);
            this.removeAction(exchangeForGraftedDragon);
        }
    }

    @Override
    public void giveSellable(Actor actor) {
        actor.removeItemFromInventory(this);
    }

    @Override
    public void giveExchangeable(Actor actor) {
        actor.removeItemFromInventory(this);
    }

    @Override
    public DropAction getDropAction(Actor actor) {
        this.removeAction(sellRemembranceOfTheGrafted);
        this.removeAction(exchangeForAxeOfGodrick);
        this.removeAction(exchangeForGraftedDragon);
        return super.getDropAction(actor);
    }
}
