package game.grounds.environments;

import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
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

    public PuddleOfWater() {
        super('~');
    }

    @Override
    public void tick(Location location) {
        if (!location.containsAnActor()) {
            if (location.x() < location.map().getXRange().max() / 2) {
                if (RandomNumberGenerator.getRandomInt(100) <= 2) {
                    location.addActor(new GiantCrab());
                }
            }
            else {
                if (RandomNumberGenerator.getRandomInt(100) <= 1) {
                    location.addActor(new GiantCrayfish());
                }
            }
        }
    }
}
