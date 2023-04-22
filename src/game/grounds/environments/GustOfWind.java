package game.grounds.environments;

import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.utils.RandomNumberGenerator;

/**
 * A class that represents Gust of Wind, where Lone Wolf and Giant Dog spawns.
 * Created by:
 * @author Aflah Hanif Amarlyadi
 * Modified by:
 *
 */
public class GustOfWind extends Ground {

    public GustOfWind() {
        super('&');
    }

    @Override
    public void tick(Location location) {
        if (!location.containsAnActor()) {
            if (location.x() < 38) {    // TODO: replace hard coded value to find the center x value of the map
                if (RandomNumberGenerator.getRandomInt(1) < 0.33) {
                    // TODO: create new LoneWolf
                }
            }
            else {
                if (RandomNumberGenerator.getRandomInt(1) < 0.04) {
                    // TODO: create new GiantDog
                }
            }
        }
    }
}
