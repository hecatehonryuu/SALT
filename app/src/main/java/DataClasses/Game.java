package DataClasses;

import androidx.annotation.NonNull;

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

    @NonNull
    @Override
    public String toString() {
        String s1 = "Game: " + this.gamename + "\n";
        String s2 = "No. of players: " + players.size();
        return s1 + s2;
    }

    public String getGamename() {
        return gamename;
    }

    public Map<String, GameObject> getPlayers() {
        return players;
    }
}
