package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import game.items.FlaskOfCrimsonTears;
/**
 * A class that represents the consume action when using Flask of Crimson Tears.
 * Created by:
 * @author Josh Hernett Tan
 * Modified by:
 *
 */
public class ConsumeAction extends Action {
    /**
     * When executed, the actor heals up to 250 hit points
     * and decrease the amount of Flask of Crimson Tears in the actor Inventory .
     *
     * @param actor The actor performing the consume action.
     * @param map The map the actor is on.
     * @return the result of the consume action, e.g. whether the Flask is used or not.
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        for (Item item : actor.getItemInventory()){
            if (item instanceof FlaskOfCrimsonTears){
                if (((FlaskOfCrimsonTears) item).getAmount() > 0){
                    ((FlaskOfCrimsonTears) item).consume(actor);
                    return actor + " has heals successfully";
                }
            }
        }
        return actor + " has no Flask of Crimson Tears left";
    }

    /**
     * Describes which item the actor is consuming and its effect
     *
     * @param actor The actor performing the action.
     * @return a description used for the menu UI
     */
    @Override
    public String menuDescription(Actor actor) {
        return actor + " heals by consuming Flask of Crimson Tears";
    }
}
