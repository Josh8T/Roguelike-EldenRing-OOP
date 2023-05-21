package game.items;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.Location;
import game.Consumable;
import game.actions.ConsumeAction;
import game.enums.Status;

public class GoldPickledFowlFoot extends Item implements Consumable {

    private ConsumeAction consumeGoldPickled = new ConsumeAction(this);

    /***
     * Constructor.
     */
    public GoldPickledFowlFoot() {
        super("Gold Pickled Fowl Foot", '\'', true);
    }

    @Override
    public void tick(Location currentLocation, Actor actor) {
        if (!this.getAllowableActions().contains(consumeGoldPickled)) {
            this.addAction(consumeGoldPickled);
        }
    }

    @Override
    public void consume(Actor actor) {
        actor.addCapability(Status.RUNE_BOOST);
        actor.removeItemFromInventory(this);
    }

    @Override
    public boolean isEmpty() {
        return Consumable.super.isEmpty();
    }
}
