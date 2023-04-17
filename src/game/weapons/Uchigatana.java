package game.weapons;

import edu.monash.fit2099.engine.weapons.WeaponItem;

/**
 * A class that represents the Uchigatana weapon.
 * Created by:
 * @author Aflah Hanif Amarlyadi
 * Modified by:
 *
 */
public class Uchigatana extends WeaponItem {

    /**
     * Constructor.
     */
    public Uchigatana(String name, char displayChar, int damage, String verb, int hitRate) {
        super("Uchigatana", ')', 115, "slashes", 80);
    }
}
