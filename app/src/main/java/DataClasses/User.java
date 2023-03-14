package DataClasses;
import java.util.ArrayList;

//User class for storing user data

public class User {
    public String username, email, password;
    public ArrayList<AbstractGame> games;
    public GameSchedule gameschedule;
    public User(){
    }

    public User(String username, String email, String password){
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void add_game(AbstractGame game) {
        this.games.add(game);
    }


}
