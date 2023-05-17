package game.items;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import game.Consumable;
import game.utils.RandomNumberGenerator;

/**
 * A class that represents the Golden Runes item.
 * Created by:
 * @author Aflah Hanif Amarlyadi
 * Modified by:
 *
 */
public class GoldenRunes extends Item implements Consumable {
    /***
     * Constructor.
     */
    public GoldenRunes() {
        super("Golden Runes", '*', true);
    }

    @Override
    public void consume(Actor actor) {
        RuneManager.getInstance().getRune().increaseValue(RandomNumberGenerator.getRandomInt(200, 10000));
    }

    @Override
    public int amountLeft() {
        return 0;
    }
}
