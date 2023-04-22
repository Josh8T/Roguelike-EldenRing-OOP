package game.actors.enemies;

import game.behaviours.WanderBehaviour;
import game.weapons.Grossmesser;

public class HeavySkeletalSwordsman extends Enemy {

    public HeavySkeletalSwordsman() {
        super("HeavySkeletalSwordsman", 'q', 153);
        this.getBehaviours().put(999, new WanderBehaviour());
        this.addWeaponToInventory(new Grossmesser());
    }


}
