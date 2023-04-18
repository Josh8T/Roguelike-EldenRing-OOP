package game.actions;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.weapons.Club;

public class PurchaseClub extends PurchaseAction {

    @Override
    public String execute(Actor actor, GameMap map) {
        actor.addWeaponToInventory(new Club());
        return menuDescription(actor);
    }

    @Override
    public String menuDescription(Actor actor) {
        return actor + " purchases Club for 600 runes.";
    }
}
