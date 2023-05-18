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

    private String destinationName;
    private GameMap destinationMap;
    private Location destinationLocation;

    /**
     * Constructor.
     */
    public GoldenFogDoor(String destinationName, GameMap destinationMap, Location destinationLocation) {
        super('D');
        this.destinationName = destinationName;
        this.destinationMap = destinationMap;
        this.destinationLocation = destinationLocation;
    }

    /**
     * Returns an empty Action list.
     *
     * @param actor the Actor acting
     * @param location the current Location
     * @param direction the direction of the Ground from the Actor
     * @return a new, empty collection of Actions
     */
    public ActionList allowableActions(Actor actor, Location location, String direction){
        ActionList actions = new ActionList();
        actions.add(new TravelAction(destinationName, destinationMap, destinationLocation));
        return actions;
    }
}
