package Utils;

import android.util.Log;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.DatabaseReference;

import DataClasses.Game;
import DataClasses.User;
import DataClasses.GameTemplate;
import DataClasses.GameObject;

//Generally takes in DatabaseReference and required info to construct

public class Create {
    public static void RegisterNewUser(FirebaseDatabase mDatabase, FirebaseAuth mAuth, String username, String email, String password) {
        User user = new User(username, email, password);
        mDatabase.getReference("Users").child(mAuth.getCurrentUser().getUid()).setValue(user);
    }

//    public static void RegisterNewGame(FirebaseDatabase mDatabase, FirebaseAuth mAuth, ) {
//        Game game = new Game(gamename);
//        mDatabase.getReference("Games").child(gamename).setValue(game);
//    }
}
