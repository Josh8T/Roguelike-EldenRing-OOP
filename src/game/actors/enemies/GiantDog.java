package game.actors.enemies;

import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.EnemyType;

/**
 * A class that represents the Giant Dog enemy.
 * Created by:
 * @author Josh Hernett Tan
 * Modified by:
 *
 */
public class GiantDog extends Enemy {
    public GiantDog() {
        super("Giant Dog", 'G', 693);
        this.addCapability(EnemyType.BEAST);
    }

    @Override
    public IntrinsicWeapon getIntrinsicWeapon() {
        return new IntrinsicWeapon(314, "scratch", 90);
    }

}

