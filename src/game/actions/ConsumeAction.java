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
 *
 */
public class ConsumeAction extends Action {
    private Consumable consumable;
    private StartingClass player;

    public ConsumeAction(Consumable consumable, StartingClass player){
        this.consumable = consumable;
        this.player = player;
    }

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
        if (consumable.amountLeft() > 0) {
            consumable.consume(player);
            return player + " has been healed successfully!";
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
        return actor + " consume Flask of Crimson Tears (" + consumable.amountLeft() + ")";
    }
}
