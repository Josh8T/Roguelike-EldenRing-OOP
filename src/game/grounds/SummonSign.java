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

    @Override
    public ActionList allowableActions(Actor actor, Location location, String direction) {
        return new ActionList(new SummonAction(location));
    }

    @Override
    public boolean canActorEnter(Actor actor) {
        return actor.hasCapability(Status.HOSTILE_TO_ENEMY);
    }
}
