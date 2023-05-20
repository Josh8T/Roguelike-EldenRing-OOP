package game.grounds;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.Destination;
import game.actions.TravelAction;
/**
 * A class that represents the Golden Fog Door, used to move between maps.
 * Created by:
 * @author Aflah Hanif Amarlyadi
 * Modified by:
 *
 */
public class GoldenFogDoor extends Ground {

    /**
     * The Destination of the Golden Fog Door
     */
    private Destination destination;

    /**
     * Constructor.
     * @param destination
     */
    public GoldenFogDoor(Destination destination) {
        super('D');
        this.destination = destination;
    }

    /**
     * This method allows the player to perform certain actions when in the exits of the Golden Fog Door.
     * Player can perform TravelAction when in the exits of the Golden Fog Door.
     * @param actor the Actor acting
     * @param location the current Location
     * @param direction the direction of the Ground from the Actor
     * @return a collection of Actions that the player can perform
     */
    public ActionList allowableActions(Actor actor, Location location, String direction){
        ActionList actions = new ActionList();
        actions.add(new TravelAction(destination));
        return actions;
    }
}
