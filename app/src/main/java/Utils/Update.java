package Utils;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

import DataClasses.GameObject;

public class Update {

    //User
    //Update active user's username, takes in new username string, check validity of username before calling
    public static void UpdateUserUsername (FirebaseDatabase mDatabase, FirebaseAuth mAuth, String username) {
        String Uid = mAuth.getCurrentUser().getUid();
        DatabaseReference ref = mDatabase.getReference("Users").child(Uid);

        Map<String, Object> childUpdates = new HashMap<>();
        childUpdates.put("/username", username);

        ref.updateChildren(childUpdates);
    }

    //Update active user's email, takes in new email string
    //To be used after updating email in auth, presumably will be checked valid
    public static void UpdateUserEmail (FirebaseDatabase mDatabase, FirebaseAuth mAuth, String email) {
        String Uid = mAuth.getCurrentUser().getUid();
        DatabaseReference ref = mDatabase.getReference("Users").child(Uid);

        Map<String, Object> childUpdates = new HashMap<>();
        childUpdates.put("/email", email);

        ref.updateChildren(childUpdates);
    }

    //Update active user's password, takes in new password string
    //To be used after updating passwprd in auth, presumably will be checked valid
    public static void UpdateUserPassword (FirebaseDatabase mDatabase, FirebaseAuth mAuth, String password) {
        String Uid = mAuth.getCurrentUser().getUid();
        DatabaseReference ref = mDatabase.getReference("Users").child(Uid);

        Map<String, Object> childUpdates = new HashMap<>();
        childUpdates.put("/password", password);

        ref.updateChildren(childUpdates);
    }

    //Update active user's bio, takes in new bio string, check validity of bio before calling (max length?)
    public static void UpdateUserBio (FirebaseDatabase mDatabase, FirebaseAuth mAuth, String bio) {
        String Uid = mAuth.getCurrentUser().getUid();
        DatabaseReference ref = mDatabase.getReference("Users").child(Uid);

        Map<String, Object> childUpdates = new HashMap<>();
        childUpdates.put("/bio", bio);

        ref.updateChildren(childUpdates);
    }

    //Adds a new game to user.games using gamename as key, takes in GameObject
    //Used for when GameObject created
    public static void UpdateUserGames (FirebaseDatabase mDatabase, FirebaseAuth mAuth, GameObject game) {
        String Uid = mAuth.getCurrentUser().getUid();
        String gamename = game.getGamename();

        Map<String, Object> childUpdates = new HashMap<>();
        childUpdates.put("/games/" + gamename, game);

        mDatabase.getReference("Users").child(Uid).updateChildren(childUpdates);
    }

    //TODO implement once fetch for user figured out
    //Adds friend, key= friend username, value = friend uid
//    public static void UpdateUserFriends (FirebaseDatabase mDatabase, FirebaseAuth mAuth, ???) {
//        String Uid = mAuth.getCurrentUser().getUid();
//        String friendusername = ???
//        DatabaseReference ref = mDatabase.getReference("Users").child(Uid);
//
//        Map<String, Object> childUpdates = new HashMap<>();
//        childUpdates.put("/friends/" + friendusername, friendid);

//        ref.updateChildren(childUpdates);
//    }

    //TODO figure out proper direction in terms of currentUser vs userid
    //Adds current user's userid to target user's pending list
    //To be used after accepting a non-pending match (part 2)
    public static void UpdateUserPending (FirebaseDatabase mDatabase, FirebaseAuth mAuth, String Userid) {
        String Uid = mAuth.getCurrentUser().getUid();
        DatabaseReference ref = mDatabase.getReference("Users").child(Uid);

        String key = ref.push().getKey();
        Map<String, Object> childUpdates = new HashMap<>();
        childUpdates.put("/pending/" +key, Userid);

        ref.updateChildren(childUpdates);
    }

    //TODO figure out proper direction in terms of currentUser vs userid
    //Adds current user's userid to target user's matched list
    //To be used after accepting a pending match (part 1)
    public static void UpdateUserMatched (FirebaseDatabase mDatabase, FirebaseAuth mAuth, String Userid) {
        String Uid = mAuth.getCurrentUser().getUid();
        DatabaseReference ref = mDatabase.getReference("Users").child(Uid);

        String key = ref.push().getKey();
        Map<String, Object> childUpdates = new HashMap<>();
        childUpdates.put("/matched/" + key, Userid);

        ref.updateChildren(childUpdates);
    }
}
