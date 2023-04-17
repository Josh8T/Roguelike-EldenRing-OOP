package game.grounds.environments;

import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.RandomNumberGenerator;

/**
 * A class that represents Graveyard, where Heavy Skeletal Swordsman and Skeletal Bandit spawns.
 * Created by:
 * @author Aflah Hanif Amarlyadi
 * Modified by:
 *
 */
public class Graveyard extends Ground {

    public Graveyard() {
        super('n');
    }

    @Override
    public void tick(Location location) {
        if (!location.containsAnActor()) {
            if (location.x() < 38) {    // TODO: replace hard coded value to find the center x value of the map
                if (RandomNumberGenerator.getRandomInt(1) < 0.27) {
                    // TODO: create new HeavySkeletalSwordsman
                }
            }
            else {
                if (RandomNumberGenerator.getRandomInt(1) < 0.27) {
                    // TODO: create new SkeletalBandit
                }
            }
        }
    }
}
