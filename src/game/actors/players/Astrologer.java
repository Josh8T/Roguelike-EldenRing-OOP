package game.actors.players;

import game.weapons.GreatKnife;

/**
 * A class that represents the Astrologer starting class.
 * Created by:
 * @author David Lee
 * Modified by:
 *
 */
public class Astrologer extends Player{
    /**
     * Constructor.
     */
    public Astrologer() {
        super(396);
        this.addWeaponToInventory(new GreatKnife());
    }

    /**
     * This method returns the name of the starting class
     * @return name of the starting class as a string
     */
    @Override
    public String getClassName() {
        return "Astrologer";
    }
}
