package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;

import java.util.Random;

public class DeSpawnAction extends Action {
    private Random rand = new Random();

    @Override
    public String execute(Actor actor, GameMap map) {
        if (rand.nextInt(100) <= 10){
            map.removeActor(actor);
        }
        return menuDescription(actor);
    }

    @Override
    public String menuDescription(Actor actor) {
        return actor + " has despawned.";
    }
}
