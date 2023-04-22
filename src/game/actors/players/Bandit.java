package game.actors.players;

import game.weapons.GreatKnife;

public class Bandit extends Player{
    /**
     * Constructor.
     *
     * @param name        Name to call the player in the UI
     * @param displayChar Character to represent the player in the UI
     */
    public Bandit(String name, char displayChar) {
        super(name, displayChar, 414);
        this.addWeaponToInventory(new GreatKnife());
    }
}
