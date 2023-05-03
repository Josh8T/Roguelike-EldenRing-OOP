package game.actors.players;

import game.weapons.GreatKnife;

public class Bandit extends Player{
    /**
     * Constructor.
     */
    public Bandit() {
        super(414);
        this.addWeaponToInventory(new GreatKnife());
    }

    @Override
    public String getClassName() {
        return "Bandit";
    }
}
