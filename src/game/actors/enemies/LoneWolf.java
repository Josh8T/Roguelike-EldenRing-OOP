package game.actors.enemies;

import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.Status;

/**
 * BEHOLD, DOG!
 * Created by:
 * @author Adrian Kristanto
 * Modified by:
 * @author David Lee
 */
public class LoneWolf extends Enemy {

    public LoneWolf() {
        super("Lone Wolf", 'h', 102);
        this.addCapability(Status.BEAST);
    }

    @Override
    public IntrinsicWeapon getIntrinsicWeapon() {
        return new IntrinsicWeapon(97, "bites", 95);
    }
}
