package game.items;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.DropAction;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.Location;
import game.Consumable;
import game.actions.ConsumeAction;
import game.utils.RandomNumberGenerator;

/**
 * A class that represents the Golden Runes item.
 * Created by:
 * @author Aflah Hanif Amarlyadi
 * Modified by:
 *
 */
public class GoldenRunes extends Item implements Consumable {

    private ConsumeAction consumeGoldenRunes = new ConsumeAction(this);

    /**
     * Constructor.
     */
    public GoldenRunes() {
        super("Golden Runes", '*', true);
    }

    @Override
    public void tick(Location currentLocation, Actor actor) {
        if (!this.getAllowableActions().contains(consumeGoldenRunes)) {
            this.addAction(consumeGoldenRunes);
        }
    }

    @Override
    public void consume(Actor actor) {
        RuneManager.getInstance().getRune().increaseValue(RandomNumberGenerator.getRandomInt(200, 10000));
        actor.removeItemFromInventory(this);
    }

    @Override
    public DropAction getDropAction(Actor actor) {
        this.removeAction(consumeGoldenRunes);
        return super.getDropAction(actor);
    }
}
