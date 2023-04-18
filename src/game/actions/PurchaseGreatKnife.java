package game.actions;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.weapons.GreatKnife;

public class PurchaseGreatKnife extends PurchaseAction {

    @Override
    public String execute(Actor actor, GameMap map) {
        actor.addWeaponToInventory(new GreatKnife());
        return menuDescription(actor);
    }

    @Override
    public String menuDescription(Actor actor) {
        return actor + " purchases Great Knife for 3500 runes.";
    }
}
