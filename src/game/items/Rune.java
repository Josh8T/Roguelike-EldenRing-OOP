package game.items;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.DropAction;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.items.PickUpAction;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import game.Resettable;
import game.actions.DropRuneAction;
import game.actions.RecoverRuneAction;
import game.actors.players.StartingClass;
import game.enums.ItemType;

/**
 * A class that represents a Rune item, used to trade with the Trader.
 * Created by:
 * @author Aflah Hanif Amarlyadi
 * Modified by:
 *
 */
public class Rune extends Item implements Resettable {

    /**
     * Value of the Runes
     */
    private int value;

    /**
     * Player that has the Runes
     */
    private StartingClass player;

    /**
     * Dropped location of the Runes
     */
    private Location location;

    /**
     * Constructor.
     * @param value the value of the Runes
     * @param player Player that has the Runes
     */
    public Rune(int value, StartingClass player) {
        super("Rune", '$', true);
        this.value = value;
        this.player = player;
        this.addCapability(ItemType.DROPPABLE);
    }

    /**
     * Getter of the value of the Runes.
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

    /**
     * Reset the value of the Runes to 0.
     */
    public void resetValue() {
        this.value = 0;
    }

    /**
     * Setter for dropped location of the Runes
     * @param location dropped location of the Runes
     */
    public void setLocation(Location location) {
        this.location = location;
    }

    @Override
    public PickUpAction getPickUpAction(Actor actor) {
        return new RecoverRuneAction(this);
    }

    @Override
    public DropAction getDropAction(Actor actor) {
        return new DropRuneAction(this, player);
    }

    @Override
    public void reset(GameMap map) {
        location.removeItem(this);
    }
}
