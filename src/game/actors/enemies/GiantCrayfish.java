package game.actors.enemies;

import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.enums.EnemyType;
import game.utils.RandomNumberGenerator;
import game.weapons.GiantCrayfishPincer;

/**
 * A class that represents the Giant Crayfish.
 * Created by:
 * @author David Lee
 * Modified by:
 * @author Aflah Hanif Amarlyadi
 */
public class GiantCrayfish extends Enemy{
    /**
     * The constructor.
     */
    public GiantCrayfish() {
        super("Giant Crayfish", 'R', 4803);
        this.addCapability(EnemyType.CRUSTACEAN);
        this.addWeaponToInventory(new GiantCrayfishPincer());
    }

    @Override
    public IntrinsicWeapon getIntrinsicWeapon() {
        return new IntrinsicWeapon(527, "pinch", 100);
    }

    /**
     * Generates a random value between 500-2371.
     * @return a random value of runes
     */
    @Override
    public int generateRuneValue() {
        return RandomNumberGenerator.getRandomInt(500, 2374);
    }
}
