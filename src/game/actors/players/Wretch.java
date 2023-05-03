package game.actors.players;

import game.weapons.Club;

public class Wretch extends Player{
    /**
     * Constructor.
     */
    public Wretch() {
        super(414);
        this.addWeaponToInventory(new Club());
    }

    @Override
    public String toString() {
        return "Wretch";
    }
}
