package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;

public class TravelAction extends Action {

    private String destinationName;
    private GameMap destinationMap;
    private Location destinationLocation;

    public TravelAction(String destinationName, GameMap destinationMap, Location destinationLocation) {
        this.destinationName = destinationName;
        this.destinationMap = destinationMap;
        this.destinationLocation = destinationLocation;
    }

    @Override
    public String execute(Actor actor, GameMap map) {
        destinationMap.moveActor(actor, destinationLocation);
        return actor + " travels to " + destinationName;
    }

    @Override
    public String menuDescription(Actor actor) {
        return actor + " travels to " + destinationName;
    }
}
