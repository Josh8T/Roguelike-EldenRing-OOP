package game.actors.players;

import game.weapons.Uchigatana;

public class Samurai extends Player{
    /**
     * Constructor.
     */
    public Samurai() {
        super(455);
        this.addWeaponToInventory(new Uchigatana());
    }

    @Override
    public String getClassName() {
        return "Samurai";
    }
}
