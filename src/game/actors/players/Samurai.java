package game.actors.players;

import game.weapons.Uchigatana;

/**
 * A class that represents the Samurai starting class.
 * Created by:
 * @author David Lee
 * Modified by:
 *
 */
public class Samurai extends Player{
    /**
     * Constructor.
     */
    public Samurai() {
        super(455);
        this.addWeaponToInventory(new Uchigatana());
    }

    /**
     * This method returns the name of the starting class
     * @return name of the starting class as a string
     */
    @Override
    public String getClassName() {
        return "Samurai";
    }
}
