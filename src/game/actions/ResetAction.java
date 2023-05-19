package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.ResetManager;
import game.enums.Status;

/**
 * An action executed if the player resets the game.
 * Created by:
 * @author Josh Hernett Tan
 * Modified by:
 * @author David Lee
 */
public class ResetAction extends Action {

    /**
     * When executed, the ResetManager is run to reset the resettables.
     * @param actor The actor performing the action.
     * @param map The map the actor is on.
     * @return result of the action to be displayed on the UI
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        if (actor.hasCapability(Status.RESTING)) {
            ResetManager.getInstance().restRun(map);
            actor.removeCapability(Status.RESTING);
        } else {
            ResetManager.getInstance().run(map);
        }
        return "Game has been reset!";
    }

    @Override
    public String menuDescription(Actor actor) {
        return "Reset Game";
    }
}
