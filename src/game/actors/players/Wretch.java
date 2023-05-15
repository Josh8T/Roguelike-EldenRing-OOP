package game.actors.players;

import game.weapons.Club;

/**
 * A class that represents the Wretch starting class.
 * Created by:
 * @author David Lee
 * Modified by:
 *
 */
public class Wretch extends StartingClass {
    /**
     * Constructor.
     */
    public Wretch() {
        super(414);
        this.addWeaponToInventory(new Club());
    }

    /**
     * This method returns the name of the starting class
     * @return name of the starting class as a string
     */
    @Override
    public String getClassName() {
        return "Wretch";
    }
}
