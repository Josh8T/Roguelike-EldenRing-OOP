package game.grounds.environments;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.actions.RestAction;
import game.actors.players.Player;
import game.enums.GroundType;
import game.enums.Status;

import java.nio.file.StandardCopyOption;

/**
 * A class that represents a unique ground that allows the player to rest on it. Reset the game when it happens.
 * Created by:
 * @author Josh Hernett Tan
 * Modified by:
 *
 */
public class SiteOfLostGrace extends Ground {

    public SiteOfLostGrace() {
        super('U');
        this.addCapability(GroundType.SLG);
    }

    @Override
    public ActionList allowableActions(Actor actor, Location location, String direction) {
        ActionList actions = new ActionList();
        if (actor.hasCapability(Status.PLAYER)) {
            actions.add(new RestAction());
        }
        return actions;
    }
}
