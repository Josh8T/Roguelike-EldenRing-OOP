package game.actors.enemies;

import game.enums.EnemyType;
import game.utils.RandomNumberGenerator;
import game.weapons.GreatKnife;

/**
 * Godrick Soldier enemy class
 * Created by:
 * @author Josh Hernett Tan
 * Modified by:
 *
 */
public class GodrickSoldier extends Enemy{
    /**
     * Constructor.
     */
    public GodrickSoldier() {
        super("Godrick Soldier", 'p',198);
        this.addCapability(EnemyType.STORMVEIL_ENTITIES);
        this.addWeaponToInventory(new GreatKnife());
    }

    /**
     * Generates a random value between 38-70.
     * @return a random value of runes
     */
    @Override
    public int generateRuneValue() {
        return RandomNumberGenerator.getRandomInt(38,70);
    }
}
