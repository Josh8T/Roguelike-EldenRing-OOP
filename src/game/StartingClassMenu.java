package game;

import edu.monash.fit2099.engine.displays.Display;
import game.actors.players.*;

import java.util.ArrayList;

/**
 * A menu GUI implementation to choose the starting class of the player.
 * Created by:
 * @author David Lee
 * Modified by:
 *
 */
public class StartingClassMenu {

    /**
     * The instance of the Starting Menu Class
     */
    private static StartingClassMenu instance;

    private Display display;

    /**
     * An arraylist of starting classes
     */
    private ArrayList<Player> choices = new ArrayList<>();

    /**
     * An arraylist of first characters if starting classes
     */
    private ArrayList<Character> choicesChar = new ArrayList<>();

    /**
     * Constructor
     */
    private StartingClassMenu() {
        this.display = new Display();
        choices.add(new Samurai());
        choices.add(new Bandit());
        choices.add(new Wretch());
        choices.add(new Astrologer());
        for (Player choice: choices) {
            choicesChar.add(choice.getClassName().toLowerCase().charAt(0));
        }
    }

    /**
     * This method gets input from the user, if the input is a valid choice, a player with the chosen starting class is returned
     * @return new player with chosen starting class
     */
    public Player chooseStartingClass() {
        display.println("Select your starting class: ");
        for (Player choice: choices) {
            display.println(choice.getClassName().toLowerCase().charAt(0) + ": " + choice.getClassName());
        }

        char mChoice;
        do {
            mChoice = display.readChar();
        } while (!choicesChar.contains(mChoice));

        for (int i = 0; i < choicesChar.size(); i++) {
            if (mChoice == choicesChar.get(i)) {
                return choices.get(i);
            }
        }

        return null;
    }

    /**
     * This method returns an instance of Starting Class menu. It makes sure that there is only one instance of Starting Class Menu.
     * @return the instance of the Starting Class Menu
     */
    public static StartingClassMenu getInstance(){
        if (instance == null){
            instance = new StartingClassMenu();
        }
        return instance;
    }
}
