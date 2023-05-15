package game.grounds;

import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.ResetManager;
import game.actors.enemies.Dog;
import game.utils.RandomNumberGenerator;

/**
 * A class that represents Cage, where Dog spawns.
 * Created by:
 * @author Josh Hernett Tan
 * Modified by:
 *
 */
public class Cage extends Ground {
    /**
     * Constructor.
     *
     */
    public Cage() {
        super('<');
    }
    /**
     * Spawns a Dog at every turn when there is no Dog at the location.
     * @param location The location of the Ground
     */
    @Override
    public void tick(Location location){
        if (!location.containsAnActor()){
            if(RandomNumberGenerator.getRandomInt(100) <= 37){
                Dog newDog = new Dog();
                location.addActor(newDog);
                ResetManager.getInstance().registerResettable(newDog);
            }
        }
    }
}
