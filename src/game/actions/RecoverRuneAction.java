package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.PickUpAction;
import edu.monash.fit2099.engine.positions.GameMap;
import game.items.Rune;
import game.items.RuneManager;

public class RecoverRuneAction extends PickUpAction {
    private final Rune rune;

    public RecoverRuneAction(Rune rune) {
        super(rune);
        this.rune = rune;
    }

    /**
     * When executed, remove the item from the location in the game map where the actor is currently standing on
     *
     * @param actor The actor performing the action.
     * @param map The map the actor is on.
     * @return a description of the action suitable for feedback in the UI
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        RuneManager.getInstance().getRune().increaseValue(rune.value());
        map.locationOf(actor).removeItem(rune);
        return menuDescription(actor);
    }

    /**
     * Describe the action in a format suitable for displaying in the menu.
     *
     * @see Action#menuDescription(Actor)
     * @param actor The actor performing the action.
     * @return a string, e.g. "Player picks up the rock"
     */
    @Override
    public String menuDescription(Actor actor) {
        return actor + " recovers " + rune.value() + " Runes";
    }
}
