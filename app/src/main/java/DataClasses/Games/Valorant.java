package DataClasses.Games;

import DataClasses.AbstractGame;

public class Valorant extends AbstractGame {
    public String[] avail_ranks = {"Iron", "Bronze", "Silver", "Gold", "Platinum", "Diamond", "Ascendant", "Immortal", "Radiant"};
    public String[] avail_roles = {"Sova", "Phoenix", "Jett", "Brimstone", "Sage"}; //to add the rest of the agents

    public Valorant(String username) {
        this.username = username;
    }
}
