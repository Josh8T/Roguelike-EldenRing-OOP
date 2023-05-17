package game.items;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import game.Sellable;

/**
 * A class that represents the Remembrance of the Grafted item.
 * Created by:
 * @author Aflah Hanif Amarlyadi
 * Modified by:
 *
 */
public class RemembranceOfTheGrafted extends Item implements Sellable {
    /***
     * Constructor.
     */
    public RemembranceOfTheGrafted() {
        super("Remembrance Of The Grafted", 'O', true);
    }

    @Override
    public void giveSellable(Actor actor) {
        actor.removeItemFromInventory(this);
    }
}
