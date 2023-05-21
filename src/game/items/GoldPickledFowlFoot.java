package game.items;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.DropAction;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.Location;
import game.Consumable;
import game.actions.ConsumeAction;
import game.enums.Status;
/**
 * An item class that represents the Gold Pickled Fowl Foot consumable item
 * Created by:
 * @author Josh Hernett Tan
 * Modified by:
 *
 */
public class GoldPickledFowlFoot extends Item implements Consumable {

    private ConsumeAction consumeGoldPickled = new ConsumeAction(this);

    /***
     * Constructor.
     */
    public GoldPickledFowlFoot() {
        super("Gold Pickled Fowl Foot", 'ç', true);
    }

    /**
     * If actor pickup the item then the consume action will be added to the list of allowable actions
     *
     * @param currentLocation the current location of the item
     * @param actor the actor who picked up the item
     */
    @Override
    public void tick(Location currentLocation, Actor actor) {
        if (!this.getAllowableActions().contains(consumeGoldPickled)) {
            this.addAction(consumeGoldPickled);
        }
    }

    /**
     * Consume method from consumable interface
     * adds Status called RUNE_BOOST when the actor decides to consume the item
     *
     * @param actor the actor who consume the item
     */
    @Override
    public void consume(Actor actor) {
        actor.addCapability(Status.RUNE_BOOST);
        actor.removeItemFromInventory(this);
    }

    @Override
    public boolean isEmpty() {
        return Consumable.super.isEmpty();
    }

    @Override
    public DropAction getDropAction(Actor actor) {
        this.removeAction(consumeGoldPickled);
        return super.getDropAction(actor);
    }
}
