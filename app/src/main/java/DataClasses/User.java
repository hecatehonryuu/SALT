package DataClasses;
import java.util.List;
import java.util.Map;

//User class for storing user data

public class User {
    private String username, email, bio;
    private Map<String, GameObject> games;
    private Map<String, String> friends;
    private List<String> pending, matched;

    public User() {
    }

    public User(String username, String email) {
        this.username = username;
        this.email = email;
    }

    //Getters

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getBio() {
        return bio;
    }

    public Map<String, GameObject> getGames() {
        return games;
    }

    public Map<String, String> getFriends() {
        return friends;
    }

    public List<String> getPending() {
        return pending;
    }

    public List<String> getMatched() {
        return matched;
    }
}

