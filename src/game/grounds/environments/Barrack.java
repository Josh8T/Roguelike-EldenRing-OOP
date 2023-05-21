package game.grounds.environments;

import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.ResetManager;
import game.actors.enemies.Dog;
import game.actors.enemies.GodrickSoldier;
import game.utils.RandomNumberGenerator;

/**
 * A class that represents Barrack, where Godrick Soldier spawns.
 * Created by:
 * @author Josh Hernett Tan
 * Modified by:
 *
 */
public class Barrack extends Ground {
    /**
     * Constructor.
     **/
    public Barrack() {
        super('B');
    }

    /**
     * Spawns a Godrick Soldier at every turn when there is no Godrick Soldier at the location.
     * @param location The location of the Ground
     */
    @Override
    public void tick(Location location){
        if (!location.containsAnActor()){
            if(RandomNumberGenerator.getRandomInt(100) <= 45){
                GodrickSoldier newSoldier = new GodrickSoldier();
                location.addActor(newSoldier);
                ResetManager.getInstance().registerResettable(newSoldier);
            }
        }
    }
}
