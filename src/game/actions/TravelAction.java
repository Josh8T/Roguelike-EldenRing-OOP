package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import game.Destination;

/**
 * The TravelAction class for travelling between maps with the Golden Fog Door.
 */
public class TravelAction extends Action {

    /**
     * The Destination of the travel
     */
    private Destination destination;

    /**
     * Constructor.
     * @param destination of the travel
     */
    public TravelAction(Destination destination) {
        this.destination = destination;
    }

    /**
     * Move the actor to the destination.
     * @param actor The actor performing the action.
     * @param map The map the actor is on.
     * @return the action description
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        destination.getMap().moveActor(actor, destination.getLocation());
        return actor + " travels to " + destination;
    }

    @Override
    public String menuDescription(Actor actor) {
        return actor + " travels to " + destination;
    }
}
