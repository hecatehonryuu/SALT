package Utils;

import android.util.Log;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

import DataClasses.GameObject;

public class Update {
    private static final String logcattag = "MeowUpdate";
    private static final String logcaterror = "MeowError";

    //User
    //Update active user's username, takes in new username string, check validity of username before calling
    public static void UpdateUserUsername (FirebaseDatabase mDatabase, FirebaseAuth mAuth, String username) {
        String Uid = mAuth.getCurrentUser().getUid();
        DatabaseReference ref = mDatabase.getReference("Users").child(Uid);

        Map<String, Object> childUpdates = new HashMap<>();
        childUpdates.put("/username", username);

        ref.updateChildren(childUpdates);
        Log.i(logcattag, "Updated " + Uid + " Username to " + username);
    }

    //Update active user's email, takes in new email string
    //To be used after updating email in auth, presumably will be checked valid
    public static void UpdateUserEmail (FirebaseDatabase mDatabase, FirebaseAuth mAuth, String email) {
        String Uid = mAuth.getCurrentUser().getUid();
        DatabaseReference ref = mDatabase.getReference("Users").child(Uid);

        Map<String, Object> childUpdates = new HashMap<>();
        childUpdates.put("/email", email);

        ref.updateChildren(childUpdates);
        Log.i(logcattag, "Updated " + Uid + " Email to " + email);
    }

    //Update active user's password, takes in new password string
    //To be used after updating passwprd in auth, presumably will be checked valid
    public static void UpdateUserPassword (FirebaseDatabase mDatabase, FirebaseAuth mAuth, String password) {
        String Uid = mAuth.getCurrentUser().getUid();
        DatabaseReference ref = mDatabase.getReference("Users").child(Uid);

        Map<String, Object> childUpdates = new HashMap<>();
        childUpdates.put("/password", password);

        ref.updateChildren(childUpdates);
        Log.i(logcattag, "Updated " + Uid + " Password to " + password);
    }

    //Update active user's bio, takes in new bio string, check validity of bio before calling (max length?)
    public static void UpdateUserBio (FirebaseDatabase mDatabase, FirebaseAuth mAuth, String bio) {
        String Uid = mAuth.getCurrentUser().getUid();
        DatabaseReference ref = mDatabase.getReference("Users").child(Uid);

        Map<String, Object> childUpdates = new HashMap<>();
        childUpdates.put("/bio", bio);

        ref.updateChildren(childUpdates);
        Log.i(logcattag, "Updated " + Uid + " Bio to " + bio);
    }

    //Adds a new gameobject instance to user.games using gamename as key, takes in GameObject
    //Used for Gameobject instantiation
    public static void UpdateUserGames (FirebaseDatabase mDatabase, FirebaseAuth mAuth, GameObject game) {
        String Uid = mAuth.getCurrentUser().getUid();
        DatabaseReference ref = mDatabase.getReference("Users").child(Uid);
        String gamename = game.getGamename();

        Map<String, Object> childUpdates = new HashMap<>();
        childUpdates.put("/games/" + gamename, game);

        ref.updateChildren(childUpdates);
        Log.i(logcattag, "added " +gamename + "to "+ Uid + " games");
    }

    //Adds friend, key= friend username, value = friend uid
    //Requires fetching required info to feed in, no fetching in func to avoid unnecessary fetches
    public static void UpdateUserFriends (FirebaseDatabase mDatabase, FirebaseAuth mAuth, String selfusername, String otherid, String otherusername) {
        String selfid = mAuth.getCurrentUser().getUid();
        DatabaseReference ref = mDatabase.getReference("Users");

        Map<String, Object> childUpdates = new HashMap<>();
        childUpdates.put("/" + selfid + "/friends/" + otherusername, otherid);
        childUpdates.put("/" + otherid + "/friends/" + selfusername, selfid);

        ref.updateChildren(childUpdates);
        Log.i(logcattag, "added " + otherusername + " to " + selfusername + "'s friend list\n" + "added " + selfusername + " to " + otherusername + "'s friend list");
    }

    //Adds current user's userid to target user's pending list
    //To be used after accepting a non-pending match (part 2)
    public static void UpdateUserPending (FirebaseDatabase mDatabase, FirebaseAuth mAuth, String otherid) {
        String Uid = mAuth.getCurrentUser().getUid();
        DatabaseReference ref = mDatabase.getReference("Users").child(otherid);

        String key = ref.push().getKey();
        Map<String, Object> childUpdates = new HashMap<>();
        childUpdates.put("/pending/" +key, Uid);

        ref.updateChildren(childUpdates);
        Log.i(logcattag, "added " + otherid + " to " + Uid + " pending list");
    }

    //Adds current user's userid to target user's matched list
    //To be used after accepting a pending match (part 1)
    public static void UpdateUserMatched (FirebaseDatabase mDatabase, FirebaseAuth mAuth, String otherid) {
        String Uid = mAuth.getCurrentUser().getUid();
        DatabaseReference ref = mDatabase.getReference("Users").child(otherid);

        String key = ref.push().getKey();
        Map<String, Object> childUpdates = new HashMap<>();
        childUpdates.put("/matched/" + key, Uid);

        ref.updateChildren(childUpdates);
        Log.i(logcattag, "added " + otherid + " to " + Uid + " matched list");
    }

    //Games
    //TODO test
    //Adds a new gameobject instance to game.players using userid as key, takes in GameObject
    //Used for Gameobject instantiation
    public static void UpdateGamePlayers (FirebaseDatabase mDatabase, FirebaseAuth mAuth, GameObject game) {
        String Uid = mAuth.getCurrentUser().getUid();
        String gamename = game.getGamename();
        DatabaseReference ref = mDatabase.getReference("Games").child(gamename);

        Map<String, Object> childUpdates = new HashMap<>();
        childUpdates.put("/players/" + Uid, game);

        ref.updateChildren(childUpdates);
        Log.i(logcattag, "added " +Uid + " to "+ gamename + " players");
    }

    //GameObject
    //Updates ign of gameobject instance stored under user and game, check ign valid before calling
    //To be used in updating profile? gamename should be loaded already
    //TODO test
    public static void UpdateGameObjectIgn (FirebaseDatabase mDatabase, FirebaseAuth mAuth, String gamename, String ign) {
        String Uid = mAuth.getCurrentUser().getUid();
        DatabaseReference ref = mDatabase.getReference();

        Map<String, Object> childUpdates = new HashMap<>();
        childUpdates.put("/Users/" + Uid + "/games/" + gamename + "/ign/", ign);
        childUpdates.put("/Games/" + gamename + "/players/" + Uid + "/ign/", ign);

        ref.updateChildren(childUpdates);
        Log.i(logcattag, "Updated " + Uid + "ign for " + gamename);
    }

    //Updates comment of gameobject instance stored under user and game, check ign valid before calling
    //To be used in updating profile? gamename should be loaded already
    //TODO test
    public static void UpdateGameObjectComment (FirebaseDatabase mDatabase, FirebaseAuth mAuth, String gamename, String comment) {
        String Uid = mAuth.getCurrentUser().getUid();
        DatabaseReference ref = mDatabase.getReference();

        Map<String, Object> childUpdates = new HashMap<>();
        childUpdates.put("/Users/" + Uid + "/games/" + gamename + "/comment/", comment);
        childUpdates.put("/Games/" + gamename + "/players/" + Uid + "/comment/", comment);

        ref.updateChildren(childUpdates);
        Log.i(logcattag, "Updated " + Uid + "Comment for " + gamename);
    }

    //Updates rank of gameobject instance stored under user and game
    //check rank valid using gametemplate before calling
    //To be used in updating profile? gamename should be loaded already
    //TODO test
    public static void UpdateGameObjectRank (FirebaseDatabase mDatabase, FirebaseAuth mAuth, String gamename, String rank) {
        String Uid = mAuth.getCurrentUser().getUid();
        DatabaseReference ref = mDatabase.getReference();

        Map<String, Object> childUpdates = new HashMap<>();
        childUpdates.put("/Users/" + Uid + "/games/" + gamename + "/rank/", rank);
        childUpdates.put("/Games/" + gamename + "/players/" + Uid + "/rank/", rank);

        ref.updateChildren(childUpdates);
        Log.i(logcattag, "Updated " + Uid + "rank for " + gamename);
    }

    //Updates role of gameobject instance stored under user and game
    //check role valid using gametemplate before calling
    //To be used in updating profile? gamename should be loaded already
    //TODO test
    public static void UpdateGameObjectRole (FirebaseDatabase mDatabase, FirebaseAuth mAuth, String gamename, String role) {
        String Uid = mAuth.getCurrentUser().getUid();
        DatabaseReference ref = mDatabase.getReference();

        Map<String, Object> childUpdates = new HashMap<>();
        childUpdates.put("/Users/" + Uid + "/games/" + gamename + "/role/", role);
        childUpdates.put("/Games/" + gamename + "/players/" + Uid + "/role/", role);

        ref.updateChildren(childUpdates);
        Log.i(logcattag, "Updated " + Uid + "role for " + gamename);
    }

    //Updates region of gameobject instance stored under user and game
    //check region valid using gametemplate before calling
    //To be used in updating profile? gamename should be loaded already
    //TODO test
    public static void UpdateGameObjectRegion (FirebaseDatabase mDatabase, FirebaseAuth mAuth, String gamename, String region) {
        String Uid = mAuth.getCurrentUser().getUid();
        DatabaseReference ref = mDatabase.getReference();

        Map<String, Object> childUpdates = new HashMap<>();
        childUpdates.put("/Users/" + Uid + "/games/" + gamename + "/region/", region);
        childUpdates.put("/Games/" + gamename + "/players/" + Uid + "/region/", region);

        ref.updateChildren(childUpdates);
        Log.i(logcattag, "Updated " + Uid + "region for " + gamename);
    }
}
