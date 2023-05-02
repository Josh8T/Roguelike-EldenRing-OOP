package game;

import edu.monash.fit2099.engine.positions.GameMap;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * A reset manager class that manages a list of resettables.
 * Created by:
 * @author Adrian Kristanto
 * Modified by:
 * @author Josh Hernett Tan
 */
public class ResetManager {
    private List<Resettable> resettables;
    private static ResetManager instance;

    /**
     * HINT 1: where have we seen a private constructor before?
     * HINT 2: see the instance attribute above.
     */
    private ResetManager() {
        this.resettables = new ArrayList<>();
    }

    public static ResetManager getInstance(){
        if(instance == null){
            instance = new ResetManager();
        }
        return instance;
    }

    public void run(GameMap map) {
        for(Resettable resettable : resettables){
            resettable.reset(map);
        }
    }

    public void registerResettable(Resettable resettable) {resettables.add(resettable);}

    public void removeResettable(Resettable resettable) {resettables.remove(resettable);}
}
