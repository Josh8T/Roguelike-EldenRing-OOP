package game.grounds.environments;

import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.ResetManager;
import game.actors.enemies.HeavySkeletalSwordsman;
import game.actors.enemies.SkeletalBandit;
import game.utils.RandomNumberGenerator;

/**
 * A class that represents Graveyard, where Heavy Skeletal Swordsman and Skeletal Bandit spawns.
 * Created by:
 * @author Aflah Hanif Amarlyadi
 * Modified by:
 *
 */
public class Graveyard extends Ground {

    /**
     * The constructor.
     */
    public Graveyard() {
        super('n');
    }

    /**
     * Spawns a Heavy Skeletal Swordsman on the west side of the map/a Skeletal Bandit on the east side of the map at every turn.
     * @param location The location of the Ground
     */
    @Override
    public void tick(Location location) {
        if (!location.containsAnActor()) {
            if (location.x() < location.map().getXRange().max() / 2) {
                if (RandomNumberGenerator.getRandomInt(100) <= 27) {
                    HeavySkeletalSwordsman newHeavySkeletalSwordsman = new HeavySkeletalSwordsman();
                    location.addActor(newHeavySkeletalSwordsman);
                    ResetManager.getInstance().registerResettable(newHeavySkeletalSwordsman);
                }
            }
            else {
                if (RandomNumberGenerator.getRandomInt(100) <= 27) {
                    SkeletalBandit newSkeletalBandit = new SkeletalBandit();
                    location.addActor(newSkeletalBandit);
                    ResetManager.getInstance().registerResettable(newSkeletalBandit);
                }
            }
        }
    }
}
