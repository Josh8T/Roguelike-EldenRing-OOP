package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.Consumable;
import game.actors.players.StartingClass;

/**
 * A class that represents the consume action when using Flask of Crimson Tears.
 * Created by:
 * @author Josh Hernett Tan
 * Modified by:
 * @author Aflah Hanif Amarlyadi
 */
public class ConsumeAction extends Action {
    private Consumable consumable;

    public ConsumeAction(Consumable consumable){
        this.consumable = consumable;
    }

    /**
     * When executed, the actor heals up to 250 hit points
     * and decrease the amount of Flask of Crimson Tears in the actor Inventory.
     *
     * @param actor The actor performing the consume action.
     * @param map The map the actor is on.
     * @return the result of the consume action, e.g. whether the Flask is used or not.
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        if (!consumable.isEmpty()) {
            consumable.consume(actor);
            return actor + " consumed " + consumable;
        }
        return consumable + " is empty";
    }

    /**
     * Describes which consumable the actor is consuming
     *
     * @param actor The actor performing the action.
     * @return a description used for the menu UI
     */
    @Override
    public String menuDescription(Actor actor) {
        return actor + " consumes " + consumable;
    }
}
