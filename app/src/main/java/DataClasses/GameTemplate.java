package DataClasses;

import androidx.annotation.NonNull;

import java.util.Arrays;
import java.util.List;

//Used to add/update games to server
//Not to be accessible from app unless making some admin feature
//Hardcoded static factory method per game, can update by updating factory method and reinstantiating to corresponding key in server
//Static factory method not to take in any args, hardcode all attributes, create empty list if no ranks/roles/regions
//No methods, only getters (currently no plans for update methods, update by reinstantiating as above)

public class GameTemplate {
    private String gamename;
    private boolean has_rank, has_role, has_region;
    private List<String> avail_ranks, avail_roles, avail_regions;

    public GameTemplate() {}

    public GameTemplate(String gamename, boolean has_rank, boolean has_role, boolean has_region, List<String> avail_ranks, List<String> avail_roles, List<String> avail_regions) {
        this.gamename = gamename;
        this.has_rank = has_rank;
        this.has_role = has_role;
        this.has_region = has_region;
        this.avail_ranks = avail_ranks;
        this.avail_roles = avail_roles;
        this.avail_regions = avail_regions;
    }

    //Hardcoded static factory methods
    public static GameTemplate Valorant() {
        String gamename = "Valorant";
        boolean has_rank = true;
        boolean has_role = true;
        boolean has_region = true;
        List<String> avail_ranks = Arrays.asList("Iron", "Bronze", "Silver", "Gold", "Platinum", "Diamond", "Ascendant", "Immortal", "Radiant");
        List<String> avail_roles = Arrays.asList("Controller", "Duelist", "Sentinel", "Initiator");
        List<String> avail_regions = Arrays.asList("Brazil", "Europe", "Korea", "Latin America", "North America", "SEA/AsiaPacific");
        return new GameTemplate(gamename, has_rank, has_role, has_region, avail_ranks, avail_roles, avail_regions);
    }

    @NonNull
    @Override
    public String toString() {
        String s1 = "Game: " + this.gamename + "\n";
        String s2 = (this.has_rank) ? "has_rank = true\n" : "has_rank = false\n";
        String s3 = (this.has_rank) ? "Ranks: " + this.avail_ranks.toString() : "";
        String s4 = (this.has_role) ? "has_role = true\n" : "has_role = false\n";
        String s5 = (this.has_role) ? "Roles: " + this.avail_roles.toString() : "";
        String s6 = (this.has_region) ? "has_region = true\n" : "has_region = false\n";
        String s7 = (this.has_region) ? "Regions: " + this.avail_regions.toString() : "";
        return s1 + s2 + s3 + s4 + s5 + s6 + s7;
    }

    //Getters

    public String getGamename() {
        return gamename;
    }

    public boolean isHas_rank() {
        return has_rank;
    }

    public boolean isHas_role() {
        return has_role;
    }

    public boolean isHas_region() {
        return has_region;
    }

    public List<String> getAvail_ranks() {
        return avail_ranks;
    }

    public List<String> getAvail_roles() {
        return avail_roles;
    }

    public List<String> getAvail_regions() {
        return avail_regions;
    }
}