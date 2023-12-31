package game.actors.enemies;

import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.enums.EnemyType;
import game.utils.RandomNumberGenerator;

/**
 * BEHOLD, DOG!
 * Created by:
 * @author Adrian Kristanto
 * Modified by:
 * @author David Lee, Aflah Hanif Amarlyadi
 */
public class LoneWolf extends Enemy {

    /**
     * The constructor.
     */
    public LoneWolf() {
        super("Lone Wolf", 'h', 102);
        this.addCapability(EnemyType.BEAST);
    }

    @Override
    public IntrinsicWeapon getIntrinsicWeapon() {
        return new IntrinsicWeapon(97, "bites", 95);
    }

    /**
     * Generates a random value between 55-1470
     * @return a random value of runes
     */
    @Override
    public int generateRuneValue() {
        return RandomNumberGenerator.getRandomInt(55, 1470);
    }
}
