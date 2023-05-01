package game.items;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import game.Consumable;

/**
 * A class that represents a Flask of Crimson Tears item.
 * Created by:
 * @author Josh Hernett Tan
 * Modified by:
 *
 */
public class FlaskOfCrimsonTears extends Item implements Consumable {

    private int amount;
    /**
     * Constructor.
     *
     * @param amount the amount of Flask of Crimson Tears left
     */
    public FlaskOfCrimsonTears(int amount) {
        super("Flask of Crimson Tears", 'F',false);
        this.amount = amount;
    }

    /**
     * Decrease the amount of Flask of Crimson Tears by one, and heals the actor that is consuming it.
     *
     * @param actor the one that consumes the Flask of Crimson Tears
     */
    public void consume(Actor actor){
        actor.heal(250);
        this.amount -= 1;
    }

    /**
     * Getter method for amount attribute
     *
     * @return amount
     */
    @Override
    public int amountLeft() {
        return this.amount;
    }



}
