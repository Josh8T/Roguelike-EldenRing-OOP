package game.actors.enemies;

import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.enums.EnemyType;
import game.weapons.GiantCrabPincer;

/**
 * A class that represents the Giant Crab enemy.
 * Created by:
 * @author Josh Hernett Tan
 * Modified by:
 * 
 */
public class GiantCrab extends Enemy{
    public GiantCrab() {
        super("Giant Crab", 'C', 407);
        this.addCapability(EnemyType.CRUSTACEAN);
        this.addWeaponToInventory(new GiantCrabPincer());
    }

    @Override
    public IntrinsicWeapon getIntrinsicWeapon() {
        return new IntrinsicWeapon(208, "slams", 90);
    }
}
