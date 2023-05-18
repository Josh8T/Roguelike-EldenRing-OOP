package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.ResetManager;

public class ResetAction extends Action {
    private boolean rest;

    public ResetAction(boolean restStatus) {
        this.rest = restStatus;
    }

    @Override
    public String execute(Actor actor, GameMap map) {
        if (rest) {
            ResetManager.getInstance().restRun(map);
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
