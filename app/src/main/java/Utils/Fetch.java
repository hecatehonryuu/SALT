package Utils;

import android.util.Log;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.FirebaseDatabase;

import DataClasses.GameTemplate;
import DataClasses.User;

public class Fetch {
    private static final String logcattag = "MeowFetch";
    private static final String logcaterror = "MeowError";

    //User
    //TODO test
    //Fetches own data, returns user class object, use related class method getters to get attributes
    //Primarily for profile page (home page?)
    public static User FetchOwnUser (FirebaseDatabase mDatabase, FirebaseAuth mAuth) {
        User user;
        String Uid = mAuth.getCurrentUser().getUid();
        Task<DataSnapshot> task = mDatabase.getReference("Users").child(Uid).get();
        if (task.isSuccessful()) {
            user = task.getResult().getValue(User.class);
            Log.i(logcattag, user.toString());
        }
        else {
            Log.e(logcaterror, "Failed to retrieve own user");
            user = new User();
        }

        return user;
    }

    //TODO test, current copy paste of above
    //Fetches target user data using userid, returns user class object, use getters for related attributes
    //Primarily for matching page
    public static User FetchOtherUser (FirebaseDatabase mDatabase, String Uid) {
        User user;
        Task<DataSnapshot> task = mDatabase.getReference("Users").child(Uid).get();
        if (task.isSuccessful()) {
            user = task.getResult().getValue(User.class);
            Log.i(logcattag, user.toString());
        }
        else {
            Log.e(logcaterror, "Failed to retrieve own user");
            user = new User();
        }

        return user;
    }

    //TODO maybe smth to fetch games/friends? necessary?
    //TODO fetch pending/matched, may need onEventValueListener tho

}
