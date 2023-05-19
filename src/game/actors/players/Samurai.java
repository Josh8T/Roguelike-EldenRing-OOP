package game.actors.players;

import game.weapons.Uchigatana;

/**
 * A class that represents the Samurai starting class.
 * Created by:
 * @author David Lee
 * Modified by:
 *
 */
public class Samurai extends StartingClass {
    /**
     * Constructor.
     */
    public Samurai() {
        super(455);
        this.addWeaponToInventory(new Uchigatana());
    }
}
