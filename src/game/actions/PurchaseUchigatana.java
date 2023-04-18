package game.actions;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.weapons.Uchigatana;

public class PurchaseUchigatana extends PurchaseAction {

    @Override
    public String execute(Actor actor, GameMap map) {
        actor.addWeaponToInventory(new Uchigatana());
        return menuDescription(actor);
    }

    @Override
    public String menuDescription(Actor actor) {
        return actor + " purchases Uchigatana for 5000 runes.";
    }
}
