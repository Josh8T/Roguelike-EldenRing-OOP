package game.actions;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.DropAction;
import edu.monash.fit2099.engine.positions.GameMap;
import game.ResetManager;
import game.items.Rune;
import game.items.RuneManager;

public class DropRuneAction extends DropAction {

    /**
     * The rune to drop
     */
    private final Rune rune;

    /**
     * Constructor.
     * @param rune the rune to drop
     */
    public DropRuneAction(Rune rune) {
        super(rune);
        this.rune = rune;
    }

    /**
     * When executed, new runes of value that the player has will drop at the previous location of the player, the value
     * of runes that the player has will be reset to 0.
     * @param actor The actor performing the action.
     * @param map The map the actor is on.
     * @return result of the action to be displayed on the UI
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        Rune droppedRune = new Rune(rune.value(), rune.getPlayer());
        rune.getPlayer().getLastLocation().addItem(droppedRune);
        droppedRune.setLocation(rune.getPlayer().getLastLocation());
        ResetManager.getInstance().registerDeathResettable(droppedRune);
        RuneManager.getInstance().getRune().resetValue();
        return menuDescription(actor);
    }
}
