package DataClasses;

//game object to be instantiated when user adds a game
//Will be added under user.games and game.players using game and user as key respectively
//gamename and ign necessary for construction (no-arg constructor left public for firebase funcs)
//Game name cannot be updated, everything else can
//No methods, only getters (Setting done by firebase update functions)

public class GameObject {
    private String gamename, ign, rank, region, comment;

    public GameObject() {
    }

    public GameObject(String gamename, String ign) {
        this.gamename = gamename;
        this.ign = ign;
    }

    //Getters
    public String getGamename() {
        return gamename;
    }

    public String getIgn() {
        return ign;
    }

    public String getRank() {
        return rank;
    }

    public String getRegion() {
        return region;
    }

    public String getComment() {
        return comment;
    }
}

