package game.grounds;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
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
     * Name of the destination of the Golden Fog Door
     */
    private String destinationName;

    /**
     * GameMap of the destination of the Golden Fog Door
     */
    private GameMap destinationMap;

    /**
     * Location of the destination of the Golden Fog Door
     */
    private Location destinationLocation;

    /**
     * Constructor
     * @param destinationName Name of the destination of the Golden Fog Door
     * @param destinationMap GameMap of the destination of the Golden Fog Door
     * @param destinationLocation Location of the destination of the Golden Fog Door
     */
    public GoldenFogDoor(String destinationName, GameMap destinationMap, Location destinationLocation) {
        super('D');
        this.destinationName = destinationName;
        this.destinationMap = destinationMap;
        this.destinationLocation = destinationLocation;
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
        actions.add(new TravelAction(destinationName, destinationMap, destinationLocation));
        return actions;
    }
}
