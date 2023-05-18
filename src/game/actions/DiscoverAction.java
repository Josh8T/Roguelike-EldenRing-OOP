package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.FancyMessage;
import game.grounds.environments.SiteOfLostGrace;

public class DiscoverAction extends Action {
    private SiteOfLostGrace siteOfLostGrace;

    public DiscoverAction(SiteOfLostGrace siteOfLostGrace) {
        this.siteOfLostGrace = siteOfLostGrace;
    }

    @Override
    public String execute(Actor actor, GameMap map) {
        this.siteOfLostGrace.discover();
        return FancyMessage.LOST_GRACE_DISCOVERED;
    }

    @Override
    public String menuDescription(Actor actor) {
        return "Discover " + this.siteOfLostGrace.getName();
    }
}
