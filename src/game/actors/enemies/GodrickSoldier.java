package game.actors.enemies;

import game.enums.EnemyType;
import game.utils.RandomNumberGenerator;

import java.util.Random;
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
        // TODO add a weapon for Godrick Soldier (supposedly a Heavy Crossbow)
        // this.addWeaponToInventory( );
    }

    @Override
    public int generateRuneValue() {
        return RandomNumberGenerator.getRandomInt(38,70);
    }
}
