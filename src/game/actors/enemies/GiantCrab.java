package game.actors.enemies;

import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.actions.AreaAttackAction;
import game.behaviours.WanderBehaviour;

/**
 * A class that represents the Giant Crab enemy.
 * Created by:
 * @author Josh Hernett Tan
 * Modified by:
 * 
 */
public class GiantCrab extends Enemy{
    public GiantCrab() {
        super("GiantCrab", 'C', 407);
        this.getBehaviours().put(999, new WanderBehaviour());

    }

    @Override
    public IntrinsicWeapon getIntrinsicWeapon() {
        return new IntrinsicWeapon(208, "slams", 90);
    }

}
