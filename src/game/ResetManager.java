package game;

import edu.monash.fit2099.engine.positions.GameMap;

import java.util.concurrent.CopyOnWriteArrayList;

/**
 * A reset manager class that manages a list of resettables.
 * Created by:
 * @author Adrian Kristanto
 * Modified by:
 * @author Josh Hernett Tan, David Lee
 */
public class ResetManager {
    /**
     * An array list of resettables
     */
    private CopyOnWriteArrayList<Resettable> resettables;

    /**
     * An array list of resettables that will reset only if player dies
     */
    private CopyOnWriteArrayList<Resettable> deathResettables;

    /**
     * An instance of the reset manager
     */
    private static ResetManager instance;

    /**
     * Constructor
     */
    private ResetManager() {
        this.resettables = new CopyOnWriteArrayList<>();
        this.deathResettables = new CopyOnWriteArrayList<>();
    }

    /**
     * This method makes sure that there is only one instance of the reset manager
     * @return the instance of the reset manager
     */
    public static ResetManager getInstance(){
        if(instance == null){
            instance = new ResetManager();
        }
        return instance;
    }

    /**
     * This method resets all resettables
     * @param map The map the resettable is on
     */
    public void run(GameMap map) {
        for (Resettable resettable: resettables) {
            resettable.reset(map);
        }
        for (Resettable deathResettable: deathResettables) {
            deathResettable.reset(map);
        }
    }

    /**
     * This method resets all resettables except the resettables that will reset only if player dies
     * @param map The map the resettable is on
     */
    public void restRun(GameMap map) {
        for (Resettable resettable: resettables) {
            resettable.reset(map);
        }
    }

    /**
     * This method adds resettables to the array list
     * @param resettable resettable that is to be added
     */
    public void registerResettable(Resettable resettable) {
        resettables.add(resettable);
    }

    /**
     * This method adds resettables that will reset only if player dies to the array list
     * @param deathResettable resettable that will reset only if player dies that is to be added
     */
    public void registerDeathResettable(Resettable deathResettable) {
        deathResettables.add(deathResettable);
    }

    /**
     * This method removes resettables from the arraylist
     * @param resettable resettable that is to be removed
     */
    public void removeResettable(Resettable resettable) {
        resettables.remove(resettable);
        deathResettables.remove(resettable);
    }
}
