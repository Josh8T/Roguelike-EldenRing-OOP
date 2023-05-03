package game.actors.enemies;

import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.enums.EnemyType;
import game.utils.RandomNumberGenerator;
import game.weapons.GiantDogHead;

/**
 * A class that represents the Giant Dog enemy.
 * Created by:
 * @author Josh Hernett Tan
 * Modified by:
 * @author Aflah Hanif Amarlyadi
 */
public class GiantDog extends Enemy {
    public GiantDog() {
        super("Giant Dog", 'G', 693);
        this.addCapability(EnemyType.BEAST);
        this.addWeaponToInventory(new GiantDogHead());
    }

    @Override
    public IntrinsicWeapon getIntrinsicWeapon() {
        return new IntrinsicWeapon(314, "scratch", 90);
    }

    @Override
    public int generateRuneValue() {
        return RandomNumberGenerator.getRandomInt(313, 1808);
    }
}

