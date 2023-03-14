package DataClasses;
import androidx.annotation.NonNull;

import java.util.List;
import java.util.Map;

//User class for storing user data

public class User {
    private String username, email, password, bio;
    private Map<String, GameObject> games;
    private Map<String, String> friends;
    private List<String> pending, matched;

    public User() {
    }

    public User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    @NonNull
    @Override
    public String toString() {
        String s1 = "Username: " + this.username + "\n";;
        String s2 = "Games: " + this.games.keySet().toString() + "\n";;
        String s3 = (this.bio == "") ?  "" : "Bio:" + this.bio + "\n";
        String s4 = "No. of friends: " + this.friends.size();
        String s5 = "No. of pending: " + this.pending.size();
        String s6 = "No. of matched: " + this.matched.size();
        return s1 + s2 + s3 + s4 + s5 + s6;
    }

    //Getters

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
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

