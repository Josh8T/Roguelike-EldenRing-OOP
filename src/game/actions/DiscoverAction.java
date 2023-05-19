package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.FancyMessage;
import game.grounds.environments.SiteOfLostGrace;

/**
 * A class that represents the Discover action that is used to discover a Site of Lost Grace.
 * Created by:
 * @author David Lee
 * Modified by:
 *
 */
public class DiscoverAction extends Action {

    /**
     * The Site of Lost Grace to discover
     */
    private SiteOfLostGrace siteOfLostGrace;

    /**
     * Constructor
     * @param siteOfLostGrace The Site of Lost Grace to discover
     */
    public DiscoverAction(SiteOfLostGrace siteOfLostGrace) {
        this.siteOfLostGrace = siteOfLostGrace;
    }

    /**
     * When executed, the Site of Lost Grace becomes discovered.
     * @param actor The actor performing the action.
     * @param map The map the actor is on.
     * @return fancy message saying "Lost Grace Discovered"
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        this.siteOfLostGrace.discover();
        return FancyMessage.LOST_GRACE_DISCOVERED;
    }

    /**
     * Describes the name of the Site of Lost Grace the actor discovers
     * @param actor The actor performing the action.
     * @return a description used for the menu UI
     */
    @Override
    public String menuDescription(Actor actor) {
        return actor + " discovers " + this.siteOfLostGrace.getName();
    }
}
