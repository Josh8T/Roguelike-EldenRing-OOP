package game.items;

import edu.monash.fit2099.engine.items.Item;
import game.enums.ItemType;

/**
 * A class that represents a Rune item, used to trade with the Trader.
 * Created by:
 * @author Aflah Hanif Amarlyadi
 * Modified by:
 *
 */
public class Rune extends Item {

    private int value;

    /**
     * Constructor.
     *
     * @param value the value of the Runes
     */
    public Rune(int value) {
        super("Rune", '$', true);
        this.value = value;
        this.addCapability(ItemType.DROPPABLE);
    }

    /**
     * Getter.
     *
     * @return value
     */
    public int value() {
        return value;
    }

    /**
     * Increase the value of the Runes by the given value.
     *
     * @param value the value to be increased
     */
    public void increaseValue(int value) {
        this.value += value;
    }

    /**
     * Decrease the value of the Runes by the given value.
     *
     * @param value the value to be decreased
     */
    public void decreaseValue(int value) {
        this.value -= value;
    }
}
