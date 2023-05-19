package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.enums.Status;

/**
 * An action executed if the player rests.
 * Created by:
 * @author Josh Hernett Tan
 * Modified by:
 * @author David Lee
 */
public class RestAction extends Action {

    /**
     * When executed, the actor gets a resting status and resets the game
     * @param actor The actor performing the action.
     * @param map The map the actor is on.
     * @return result of the action to be displayed on the UI
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        String result = "";
        actor.addCapability(Status.RESTING);
        result += new ResetAction().execute(actor, map);
        return result;
    }

    @Override
    public String menuDescription(Actor actor) {
        return actor + " rests at" + " Lost Site of Grace";
    }
}
