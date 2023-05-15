package game.actors.enemies;

import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.enums.EnemyType;
import game.utils.RandomNumberGenerator;

/**
 * Dog enemy class
 * Created by:
 * @author Josh Hernett Tan
 * Modified by:
 *
 */
public class Dog extends Enemy{
    /**
     * Constructor.
     */
    public Dog() {
        super("Dog", 'a', 104);
        this.addCapability(EnemyType.STORMVEIL_ENTITIES);
    }

    @Override
    public IntrinsicWeapon getIntrinsicWeapon() {
        return new IntrinsicWeapon(101, "bites", 93);
    }


    @Override
    public int generateRuneValue() {
        return RandomNumberGenerator.getRandomInt(52,1390);
    }
}
