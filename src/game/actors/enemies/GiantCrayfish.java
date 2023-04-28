package game.actors.enemies;

import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.EnemyType;
import game.Status;
import game.weapons.GiantCrayfishPincer;

/**
 * A class that represents the Giant Crayfish.
 * Created by:
 * @author David Lee
 * Modified by:
 *
 */
public class GiantCrayfish extends Enemy{
    public GiantCrayfish() {
        super("Giant Crayfish", 'R', 4803);
        this.addCapability(EnemyType.CRUSTACEAN);
        this.addCapability(Status.SLAMS);
        this.addWeaponToInventory(new GiantCrayfishPincer());
    }

    @Override
    public IntrinsicWeapon getIntrinsicWeapon() {
        return new IntrinsicWeapon(527, "pinch", 100);
    }
}
