package game.items;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
/**
 * A class that represents a Flask of Crimson Tears item.
 * Created by:
 * @author Josh Hernett Tan
 * Modified by:
 *
 */
public class FlaskOfCrimsonTears extends Item {

    private int amount;
    /**
     * Constructor.
     *
     * @param amount the amount of Flask of Crimson Tears left
     */
    public FlaskOfCrimsonTears(int amount) {
        //TODO Shouldn't have a display char, might need to change later
        super("Flask of Crimson Tears", 'F',false);
        this.amount = amount;
    }

    /**
     * Getter.
     *
     * @return amount
     */
    public int getAmount() {
        return amount;
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
}
