package game.grounds.environments;

import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.ResetManager;
import game.actors.enemies.GiantCrab;
import game.actors.enemies.GiantCrayfish;
import game.utils.RandomNumberGenerator;

/**
 * A class that represents Puddle of Water, where Giant Crab and Giant Crayfish spawns.
 * Created by:
 * @author Aflah Hanif Amarlyadi
 * Modified by:
 *
 */
public class PuddleOfWater extends Ground {

    /**
     * The constructor.
     */
    public PuddleOfWater() {
        super('~');
    }

    /**
     * Spawns a Giant Crab on the west side of the map/a Giant Crayfish on the east side of the map at every turn.
     * @param location The location of the Ground
     */
    @Override
    public void tick(Location location) {
        if (!location.containsAnActor()) {
            if (location.x() < location.map().getXRange().max() / 2) {
                if (RandomNumberGenerator.getRandomInt(100) <= 2) {
                    GiantCrab newGiantCrab = new GiantCrab();
                    location.addActor(newGiantCrab);
                    ResetManager.getInstance().registerResettable(newGiantCrab);
                }
            }
            else {
                if (RandomNumberGenerator.getRandomInt(100) <= 1) {
                    GiantCrayfish newGiantCrayfish = new GiantCrayfish();
                    location.addActor(newGiantCrayfish);
                    ResetManager.getInstance().registerResettable(newGiantCrayfish);
                }
            }
        }
    }
}
