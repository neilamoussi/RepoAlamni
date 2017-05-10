package alemni.gl4.insat.tn.alemni;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import java.util.ArrayList;
import java.util.List;
import com.firebase.client.Firebase;

import alemni.gl4.insat.tn.alemni.model.Group;
import alemni.gl4.insat.tn.alemni.model.Quiz;
import alemni.gl4.insat.tn.alemni.model.Student;

public class ChatActivity extends MainActivity {
    public  List<Group> allGroupdeLogin;
    LinearLayout dynamicContent, bottonNavBar;
    Button btn_chat;

    Firebase ref;
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("etudiants");
    DatabaseReference myreff;
     String Login;
     String prof="";
    String grpnom="";
    String matiere="";
    String date="";
    String GroupEtud="";
    String notifee;
    String keypostquiz;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
        Firebase.setAndroidContext(this);
        ref = new Firebase("https://myproject-bf8ad.firebaseio.com/");

        Intent intent7 = getIntent();
       Login = getIntent().getStringExtra("etudacceuil");
        myreff = myRef.child(Login).child("groupes");

        btn_chat = (Button) findViewById(R.id.btn_chat);

        btn_chat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ohhquiz();

            }
        });


    }

   /* public void ohhquestion() {
        ref.addListenerForSingleValueEvent(new ValueEventListener() {

            @Override
            public void onDataChange(com.firebase.client.DataSnapshot dataSnapshot) {
                ohhquiz();


                for (com.firebase.client.DataSnapshot datamat : dataSnapshot.child("question").getChildren()) {


                    if (GroupEtud.equals(datamat.child("groupe").getValue().toString()) && "non".equals(datamat.child("notifiee").getValue().toString()))

                    {
                        keypostquiz = datamat.child("quiz").getValue().toString();
                        prof=datamat.child("professeur").getValue().toString();
                        // Toast.makeText(getApplicationContext(), prof, Toast.LENGTH_SHORT).show();

                    }





                }
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });


    }*/




/////******************pour trouvez i'id de quiz publié **********************


    public void ohhquiz() {
        ref.addListenerForSingleValueEvent(new ValueEventListener() {

            @Override
            public void onDataChange(com.firebase.client.DataSnapshot dataSnapshot) {
             ohhgroup();
                //j'ai maintenant*********************** GroupEtud******************

                    for (com.firebase.client.DataSnapshot datamat : dataSnapshot.child("postquiz").getChildren()) {


                        if (GroupEtud.equals(datamat.child("groupe").getValue().toString()) && "non".equals(datamat.child("notifiee").getValue().toString()))

                        {
                            keypostquiz = datamat.child("quiz").getValue().toString();
                            prof=datamat.child("professeur").getValue().toString();
                            date=datamat.child("datecreation").getValue().toString();
                            grpnom=datamat.child("groupenom").getValue().toString();
                            matiere=datamat.child("matiere").getValue().toString();
                            Toast.makeText(getApplicationContext(), prof, Toast.LENGTH_SHORT).show();
                            Toast.makeText(getApplicationContext(), prof, Toast.LENGTH_SHORT).show();
                           // Toast.makeText(getApplicationContext(), keypostquiz, Toast.LENGTH_SHORT).show();

                        }





                }
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });


    }

//****************************


//***********************Pour trouvez le groupe de l'etudiant connecté***********************
    public void ohhgroup() {
        ref.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(com.firebase.client.DataSnapshot dataSnapshot) {
                for (com.firebase.client.DataSnapshot datamat : dataSnapshot.child("etudiants").child(Login).child("groupes").getChildren()) {

                    GroupEtud=datamat.getKey().toString();
                }
            }
            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
    }
    //*************************GroupEtud****************************

}
