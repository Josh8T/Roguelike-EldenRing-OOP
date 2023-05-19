package game.grounds;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.actions.DeathAction;
import game.enums.Status;

/**
 * A class that represents a Cliff.
 * Created by:
 * @author David Lee
 * Modified by:
 *
 */
public class Cliff extends Ground {

    /**
     * Constructor.
     */
    public Cliff() {
        super('+');
    }

    /**
     * Cliff can also experience the joy of time.
     * If player steps on the Cliff, call DeathAction on the player.
     * @param location The location of the Ground
     */
    @Override
    public void tick(Location location) {
        if (location.containsAnActor() && location.getActor().hasCapability(Status.HOSTILE_TO_ENEMY)) {
            new Display().println(new DeathAction(null).execute(location.getActor(), location.map()));
        }
    }

    /**
     * This method checks if an Actor can step on the Cliff. It makes sure that only player can step on it.
     * @param actor the Actor to check
     * @return true if the Actor can step on the Cliff
     */
    @Override
    public boolean canActorEnter(Actor actor) {
        return actor.hasCapability(Status.HOSTILE_TO_ENEMY);
    }
}
