package DataClasses;

import java.util.ArrayList;

//Abstract class for games, each game hardcode a concrete class, each user will store a list of
//instances of the games they play
//roles and rank are optional, must hardcode avail_ranks/roles if game offers them, to be used for
//reference for droplist
//Contructor only takes in username (compulsory)
//Use methods to setRank and setRoles
abstract public class AbstractGame {
    public String username, rank;
    public ArrayList<String> roles;
    public String[] avail_ranks, avail_roles;

    public String getUsername() {
        return username;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getRank() {
        return rank;
    }

    public ArrayList<String> getRoles() {
        return roles;
    }

    public void setRoles(String[] roles) {
        for (String role: roles) {
            this.roles.add(role);
        }
    }
}
