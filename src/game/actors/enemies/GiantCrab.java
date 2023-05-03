package game.actors.enemies;

import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.enums.EnemyType;
import game.utils.RandomNumberGenerator;
import game.weapons.GiantCrabPincer;

/**
 * A class that represents the Giant Crab enemy.
 * Created by:
 * @author Josh Hernett Tan
 * Modified by:
 * @author Aflah Hanif Amarlyadi
 */
public class GiantCrab extends Enemy{
    /**
     * The constructor.
     */
    public GiantCrab() {
        super("Giant Crab", 'C', 407);
        this.addCapability(EnemyType.CRUSTACEAN);
        this.addWeaponToInventory(new GiantCrabPincer());
    }

    @Override
    public IntrinsicWeapon getIntrinsicWeapon() {
        return new IntrinsicWeapon(208, "slams", 90);
    }

    /**
     * Generates a random value between 318-4961
     * @return a random value of runes
     */
    @Override
    public int generateRuneValue() {
        return RandomNumberGenerator.getRandomInt(318, 4961);
    }
}
