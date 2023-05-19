package game.grounds;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.actions.SummonAction;
import game.enums.Status;

/**
 * A class that represents a Summon Sign.
 * Created by:
 * @author David Lee
 * Modified by:
 *
 */
public class SummonSign extends Ground {

    /**
     * Constructor.
     */
    public SummonSign() {
        super('=');
    }

    /**
     * This method allows the player to perform certain actions when in the exits of the Summon Sign.
     * Player can perform SummonAction when in the exits of the Summon Sign.
     * @param actor the Actor acting
     * @param location the current Location
     * @param direction the direction of the Ground from the Actor
     * @return a collection of Actions that the player can perform
     */
    @Override
    public ActionList allowableActions(Actor actor, Location location, String direction) {
        return new ActionList(new SummonAction(location));
    }

    /**
     * This method checks if an Actor can step on the Summon Sign. It makes sure that only player can step on it.
     * @param actor the Actor to check
     * @return true if the Actor can step on the Summon Sign
     */
    @Override
    public boolean canActorEnter(Actor actor) {
        return actor.hasCapability(Status.HOSTILE_TO_ENEMY);
    }
}
