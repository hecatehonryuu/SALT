package Utils;

import android.util.Log;

import com.example.authapp.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.DatabaseReference;

import android.content.res.Resources;

import DataClasses.Game;
import DataClasses.User;
import DataClasses.GameTemplate;
import DataClasses.GameObject;

//Generally takes in DatabaseReference and required info to construct

public class Create {
    private static final String logcattag = "MeowCreate";
    private static final String logcaterror = "MeowError";

    //Register a new user, use after successful registration through auth
    public static void RegisterNewUser(FirebaseDatabase mDatabase, FirebaseAuth mAuth, String username, String email, String password) {
        User user = new User(username, email, password);
        String Uid = mAuth.getCurrentUser().getUid();
        mDatabase.getReference("Users").child(Uid).setValue(user);
        Log.i(logcattag, username + " created with id " + Uid);
    }

    //Used to register a new game, currently hardcoded to call specific static factory method
    //TODO make this more general, take in func maybe? not sure how that will work. Allow for inapp adjustment?
    public static void RegisterNewGameTemplate(FirebaseDatabase mDatabase) {
        GameTemplate gameTemplate = GameTemplate.Valorant(); //specific static factory method
        String gamename = gameTemplate.getGamename();
        mDatabase.getReference("GameTemplates").child(gamename).setValue(gameTemplate);
        Game game = new Game(gamename);
        mDatabase.getReference("Games").child(gamename).setValue(game);
        Log.i(logcattag, "Game Template created for " + gamename);
    }

    //TODO test after testing each update func
    //Creates new game object and added under user.games and game.players using game and user as key respectively
    //Ensure gamename exists among registered games before calling this method
    public static void RegisterNewGame(FirebaseDatabase mDatabase, FirebaseAuth mAuth, String gamename, String ign) {
        GameObject gameObject = new GameObject(gamename, ign);
        Update.UpdateUserGames(mDatabase, mAuth, gameObject);
        Update.UpdateGamePlayers(mDatabase, mAuth, gameObject);
        Log.i(logcattag, "Game Object " + gamename + " created");
    }
}
