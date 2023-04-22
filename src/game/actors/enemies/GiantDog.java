package game.actors.enemies;

import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.behaviours.WanderBehaviour;

/**
 * A class that represents the Giant Dog enemy.
 * Created by:
 * @author Josh Hernett Tan
 * Modified by:
 *
 */
public class GiantDog extends Enemy {
    public GiantDog() {
        super("GiantDog", 'G', 693);
        this.getBehaviours().put(999, new WanderBehaviour());
    }

    @Override
    public IntrinsicWeapon getIntrinsicWeapon() {
        return new IntrinsicWeapon(314, "head slams", 90);
    }

}

