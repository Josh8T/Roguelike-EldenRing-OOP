package game.actors.enemies;

import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;

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
    }

    @Override
    public IntrinsicWeapon getIntrinsicWeapon() {
        return new IntrinsicWeapon(314, "head slams", 90);
    }

}

