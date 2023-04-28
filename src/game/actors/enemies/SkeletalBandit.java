package game.actors.enemies;

import game.EnemyType;
import game.Resettable;
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
        this.addCapability(EnemyType.SKELETON);
        this.addWeaponToInventory(new Scimitar());

    }

    @Override
    public void reset() {

    }
}
