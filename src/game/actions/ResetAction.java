package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.ResetManager;
import game.items.RuneManager;

public class ResetAction extends Action {

    @Override
    public String execute(Actor actor, GameMap map) {
        ResetManager.getInstance().run(map);
        return "Game has been reset!";
    }

    @Override
    public String menuDescription(Actor actor) {
        return "Reset Game";
    }
}
