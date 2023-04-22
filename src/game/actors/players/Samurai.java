package game.actors.players;

import game.weapons.Uchigatana;

public class Samurai extends Player{
    /**
     * Constructor.
     *
     * @param name        Name to call the player in the UI
     * @param displayChar Character to represent the player in the UI
     */
    public Samurai(String name, char displayChar) {
        super(name, displayChar, 455);
        this.addWeaponToInventory(new Uchigatana());
    }
}
