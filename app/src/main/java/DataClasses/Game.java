package DataClasses;

import java.util.Map;

//For each game template added, initiate one of these, serves to track all players of a game
//When player adds a game, they are also added here
//players map stores gameobject for easy access/sorting purposes (?)

public class Game {
    private String gamename;
    private Map<String, GameObject> players;

    public Game() {
    }

    public Game(String gamename) {
        this.gamename = gamename;
    }

    public String getGamename() {
        return gamename;
    }

    public Map<String, GameObject> getPlayers() {
        return players;
    }
}
