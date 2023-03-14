package Utils;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Remove {

    //User
    //Remove game from user.game, uses gamename
    //To be used when removing game object
    public static void RemoveUserGames(FirebaseDatabase mDatabase, FirebaseAuth mAuth, String gamename) {
        String Uid = mAuth.getCurrentUser().getUid();
        DatabaseReference ref = mDatabase.getReference("Users").child(Uid);

        ref.child("games").child(gamename).removeValue();
    }

    //TODO test
    //Remove friend using friend's username
    public static void RemoveUserFriends(FirebaseDatabase mDatabase, FirebaseAuth mAuth, String friendusername) {
        String Uid = mAuth.getCurrentUser().getUid();
        DatabaseReference ref = mDatabase.getReference("Users").child(Uid);

        ref.child("friends").child(friendusername).removeValue();
    }

    //Remove user from active user's pending after accepted/denied in part 1, uses key (need to fetch)
    public static void RemoveUserPending(FirebaseDatabase mDatabase, FirebaseAuth mAuth, String key) {
        String Uid = mAuth.getCurrentUser().getUid();
        DatabaseReference ref = mDatabase.getReference("Users").child(Uid);

        ref.child("pending").child(key).removeValue();
    }

    //Remove user from active user's matched after ???, uses key (need to fetch)
    public static void RemoveUserMatched(FirebaseDatabase mDatabase, FirebaseAuth mAuth, String key) {
        String Uid = mAuth.getCurrentUser().getUid();
        DatabaseReference ref = mDatabase.getReference("Users").child(Uid);

        ref.child("matched").child(key).removeValue();
    }

    //Remove all users from active user's matched after ???, uses key (need to fetch)
    public static void RemoveUserAllMatched(FirebaseDatabase mDatabase, FirebaseAuth mAuth) {
        String Uid = mAuth.getCurrentUser().getUid();
        DatabaseReference ref = mDatabase.getReference("Users").child(Uid);

        ref.child("matched").removeValue();
    }
}
