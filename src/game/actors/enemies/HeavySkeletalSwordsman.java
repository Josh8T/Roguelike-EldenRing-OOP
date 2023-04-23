package game.actors.enemies;

import game.weapons.Grossmesser;

/**
 * A class that represents the Heavy Skeletal Swordsman.
 * Created by:
 * @author Josh Hernett Tan
 * Modified by:
 *
 */
public class HeavySkeletalSwordsman extends Enemy{

    public HeavySkeletalSwordsman() {
        super("Heavy Skeletal Swordsman", 'q', 153);
        this.addWeaponToInventory(new Grossmesser());
    }


}
