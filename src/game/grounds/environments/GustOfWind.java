package game.grounds.environments;

import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.ResetManager;
import game.actors.enemies.GiantDog;
import game.actors.enemies.LoneWolf;
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
            if (location.x() < location.map().getXRange().max() / 2) {
                if (RandomNumberGenerator.getRandomInt(100) <= 33) {
                    LoneWolf newLoneWolf = new LoneWolf();
                    location.addActor(newLoneWolf);
                    ResetManager.getInstance().registerResettable(newLoneWolf);
                }
            }
            else {
                if (RandomNumberGenerator.getRandomInt(100) <= 4) {
                    GiantDog newGiantDog = new GiantDog();
                    location.addActor(newGiantDog);
                    ResetManager.getInstance().registerResettable(newGiantDog);
                }
            }
        }
    }
}
