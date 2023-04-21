package game.actors.enemies;

import game.Resettable;
import game.behaviours.WanderBehaviour;
import game.weapons.Scimitar;

/**
 * A class that represents the Skeletal Bandit.
 * Created by:
 * @author Aflah Hanif Amarlyadi
 * Modified by:
 * @author David Lee
 */
public class SkeletalBandit extends Enemy implements Resettable {

    public SkeletalBandit() {
        super("Skeletal Bandit", 'b', 102);
        this.getBehaviours().put(999, new WanderBehaviour());
        this.addWeaponToInventory(new Scimitar());
    }

    @Override
    public void reset() {

    }
}
