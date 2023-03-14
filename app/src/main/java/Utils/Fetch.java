package Utils;

import android.util.Log;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.FirebaseDatabase;

import DataClasses.User;

public class Fetch {

    //User
    public static User FetchOwnUser (FirebaseDatabase mDatabase, FirebaseAuth mAuth) {
        String Uid = mAuth.getCurrentUser().getUid();
        mDatabase.getReference("Users").child(Uid).get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DataSnapshot> task) {
                if (task.isSuccessful()) {
                    User user = task.getResult().getValue(User.class);
                    Log.i("Test", user.toString());
                }
                else {
                    Log.e("Error", "Failed to retrieve own user");
                }
            }
        });

        return user;
    }
}
