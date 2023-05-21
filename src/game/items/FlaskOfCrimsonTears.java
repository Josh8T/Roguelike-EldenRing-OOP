package game.items;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import game.Consumable;
import game.Resettable;

/**
 * A class that represents a Flask of Crimson Tears item.
 * Created by:
 * @author Josh Hernett Tan
 * Modified by:
 * @author Aflah Hanif Amarlyadi
 */
public class FlaskOfCrimsonTears extends Item implements Consumable, Resettable {

    private int amount;
    private int maxAmount;

    public int getMaxAmount() {
        return maxAmount;
    }

    public void setMaxAmount(int maxAmount) {
        this.maxAmount = maxAmount;
    }

    /**
     * Constructor.
     *
     * @param amount the amount of Flask of Crimson Tears left
     */
    public FlaskOfCrimsonTears(int amount) {
        super("Flask of Crimson Tears", 'F',false);
        this.amount = amount;
        this.maxAmount = amount;
    }

    /**
     * Getter method for the amount of Flask Of Crimson Tears
     *
     * @return amount
     */
    public int getAmount() {
        return this.amount;
    }

    /**
     * Setter method for the amount of Flask Of Crimson Tears
     */
    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return super.toString() + " (" + this.getAmount() + "/" + this.getMaxAmount() + ")";
    }


    /**
     * Decrease the amount of Flask of Crimson Tears by one, and heals the actor that is consuming it.
     *
     * @param actor the one that consumes the Flask of Crimson Tears
     */
    @Override
    public void consume(Actor actor){
        actor.heal(250);
        this.amount -= 1;
    }

    @Override
    public boolean isEmpty() {
        return !(getAmount() > 0);
    }

    @Override
    public void reset(GameMap map) {
        this.setAmount(this.getMaxAmount());
    }
}
