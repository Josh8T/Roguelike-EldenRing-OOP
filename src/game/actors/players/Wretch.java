package game.actors.players;

import game.weapons.Club;

public class Wretch extends Player{
    /**
     * Constructor.
     *
     * @param name        Name to call the player in the UI
     * @param displayChar Character to represent the player in the UI
     */
    public Wretch(String name, char displayChar) {
        super(name, displayChar, 414);
        this.addWeaponToInventory(new Club());
    }
}
