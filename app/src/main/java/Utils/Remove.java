package Utils;

import android.util.Log;

import com.example.authapp.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Remove {
    private static final String logcattag = "MeowRemove";
    private static final String logcaterror = "MeowError";

    //User
    //Remove game from user.game, uses gamename
    //To be used when removing game object
    public static void RemoveUserGames(FirebaseDatabase mDatabase, FirebaseAuth mAuth, String gamename) {
        String Uid = mAuth.getCurrentUser().getUid();
        DatabaseReference ref = mDatabase.getReference("Users").child(Uid);

        ref.child("games").child(gamename).removeValue();
        Log.i(logcattag, "Removed " + gamename + " from " + Uid + "games");
    }

    //TODO test
    //Remove friend using friend's username
    //Should only be done from friend's list where friendusername already loaded
    public static void RemoveUserFriends(FirebaseDatabase mDatabase, FirebaseAuth mAuth, String friendusername) {
        String Uid = mAuth.getCurrentUser().getUid();
        DatabaseReference ref = mDatabase.getReference("Users").child(Uid);

        ref.child("friends").child(friendusername).removeValue();
        Log.i(logcattag, "Removed " + friendusername + " from " + Uid + "friend list");
    }

    //Remove user from active user's pending after accepted/denied in part 1, uses key (should have been obtained when loading pending)
    public static void RemoveUserPending(FirebaseDatabase mDatabase, FirebaseAuth mAuth, String key) {
        String Uid = mAuth.getCurrentUser().getUid();
        DatabaseReference ref = mDatabase.getReference("Users").child(Uid);

        ref.child("pending").child(key).removeValue();
        Log.i(logcattag, "Removed " + key + " from " + Uid + "pending list");
    }

    //Remove user from active user's matched after ???, uses key (should have been obtained when loading matched)
    public static void RemoveUserMatched(FirebaseDatabase mDatabase, FirebaseAuth mAuth, String key) {
        String Uid = mAuth.getCurrentUser().getUid();
        DatabaseReference ref = mDatabase.getReference("Users").child(Uid);

        ref.child("matched").child(key).removeValue();
        Log.i(logcattag, "Removed " + key + " from " + Uid + "matched list");
    }

    //Remove all users from active user's matched after ???, maybe just use this?
    public static void RemoveUserAllMatched(FirebaseDatabase mDatabase, FirebaseAuth mAuth) {
        String Uid = mAuth.getCurrentUser().getUid();
        DatabaseReference ref = mDatabase.getReference("Users").child(Uid);

        ref.child("matched").removeValue();
        Log.i(logcattag, "Cleared " + Uid + "matched list");
    }
}
