package game.actors.players;

import game.weapons.GreatKnife;

/**
 * A class that represents the Bandit starting class.
 * Created by:
 * @author David Lee
 * Modified by:
 *
 */
public class Bandit extends StartingClass {
    /**
     * Constructor.
     */
    public Bandit() {
        super(414);
        this.addWeaponToInventory(new GreatKnife());
    }

    /**
     * This method returns the name of the starting class
     * @return name of the starting class as a string
     */
    @Override
    public String getClassName() {
        return "Bandit";
    }
}
