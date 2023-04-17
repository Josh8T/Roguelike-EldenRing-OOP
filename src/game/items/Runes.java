package game.items;

import edu.monash.fit2099.engine.items.Item;

public class Runes extends Item {

    private int value;

    /**
     * Constructor.
     *
     * @param value the value of the Runes
     */
    public Runes(int value) {
        super("Runes", '$', true);
        this.value = value;
    }

    /**
     * Getter.
     *
     * @return value
     */
    public int getValue() {
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
