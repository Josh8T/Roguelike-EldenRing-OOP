package game.grounds.environments;

import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.RandomNumberGenerator;

/**
 * A class that represents Puddle of Water, where Giant Crab and Giant Crayfish spawns.
 * Created by:
 * @author Aflah Hanif Amarlyadi
 * Modified by:
 *
 */
public class PuddleOfWater extends Ground {

    public PuddleOfWater() {
        super('~');
    }

    @Override
    public void tick(Location location) {
        if (!location.containsAnActor()) {
            if (location.x() < 38) {    // TODO: replace hard coded value to find the center x value of the map
                if (RandomNumberGenerator.getRandomInt(1) < 0.02) {
                    // TODO: create new GiantCrab
                }
            }
            else {
                if (RandomNumberGenerator.getRandomInt(1) < 0.01) {
                    // TODO: create new GiantCrayfish
                }
            }
        }
    }
}
