package DataClasses;

//game object to be instantiated when user adds a game
//Will be added under user.games and game.players using game and user as key respectively
//gamename and ign necessary for construction (no-arg constructor left public for firebase funcs)
//Game name cannot be updated, everything else can
//No methods, only getters (Setting done by firebase update functions)

import androidx.annotation.NonNull;

public class GameObject {
    private String gamename, ign, rank, role, region, comment;

    public GameObject() {
    }

    public GameObject(String gamename, String ign) {
        this.gamename = gamename;
        this.ign = ign;
    }

    @NonNull
    @Override
    public String toString() {
        String s1 = "Game: " + this.gamename + "\n";
        String s2 = "IGN: " + this.ign + "\n";
        String s3 = (this.rank == "") ?  "" : "Rank:" + this.rank + "\n";
        String s4 = (this.role == "") ?  "" : "Role:" + this.role + "\n";
        String s5 = (this.region == "") ?  "" : "Region:" + this.region + "\n";
        String s6 = (this.comment == "") ?  "" : "Comment:" + this.comment + "\n";
        return s1 + s2 + s3 + s4 + s5 + s6;
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

    public String getRole() {
        return role;
    }

    public String getRegion() {
        return region;
    }

    public String getComment() {
        return comment;
    }
}

