package game.behaviours;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.actions.DespawnAction;

import java.util.Random;

public class DespawnBehaviour implements Behaviour{
    private Random rand = new Random();

    @Override
    public Action getAction(Actor actor, GameMap map) {
        if (rand.nextInt(100) <= 10){
            return new DespawnAction();
        }
        return null;
    }
}
