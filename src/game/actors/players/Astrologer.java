package game.actors.players;

import game.weapons.AstrologersStaff;

/**
 * A class that represents the Astrologer starting class.
 * Created by:
 * @author David Lee
 * Modified by:
 *
 */
public class Astrologer extends StartingClass {
    /**
     * Constructor.
     */
    public Astrologer() {
        super(396);
        this.addWeaponToInventory(new AstrologersStaff());
    }
}
