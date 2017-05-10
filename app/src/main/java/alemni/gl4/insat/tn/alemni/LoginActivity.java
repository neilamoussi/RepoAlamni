package alemni.gl4.insat.tn.alemni;
import android.os.Build;
import android.view.Gravity;
import android.widget.ImageButton;
import android.widget.PopupWindow;
import android.view.LayoutInflater;
import android.content.Context;
import android.view.ViewGroup.LayoutParams;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.RelativeLayout;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;
import android.content.Intent;

import java.util.ArrayList;
import java.util.List;

import alemni.gl4.insat.tn.alemni.model.NotificationE;
import alemni.gl4.insat.tn.alemni.model.Student;

public class LoginActivity extends AppCompatActivity {
    private Context mContext;

    EditText edt_name,edt_pass;
    TextView linke,linkp;
    Button btn_signin;
    Firebase ref;
    String Login;
    private List<NotificationE> movieList = new ArrayList<>();
    private PopupWindow mPopupWindow;
    ProgressDialog PD;
    String prof = "";
    String grpnom = "";
    String matiere = "";
    String date = "";
    String GroupEtud = "";
    String Desc;
    Intent intent0;
    String notifee;
    String keypostquiz;
    private RelativeLayout mRelativeLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = getApplicationContext();
        setContentView(R.layout.activity_login);
        Firebase.setAndroidContext(this);
        ref = new Firebase("https://myproject-bf8ad.firebaseio.com/");
        PD = new ProgressDialog(this);
        PD.setMessage("Loading...");

        edt_name = (EditText)findViewById(R.id.edt_name);
        edt_pass = (EditText)findViewById(R.id.edt_pass);
        btn_signin = (Button)findViewById(R.id.btn_reg);

        linke = (TextView)findViewById(R.id.link_Etudiant);
        linkp = (TextView)findViewById(R.id.link_prof);
        linke.setPaintFlags(linke.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        linke.setText("Compte Etudiant");
        linke.setTypeface(null, Typeface.BOLD);
        linkp.setPaintFlags(linkp.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        linkp.setText("Compte Professeur");
        linkp.setTypeface(null, Typeface.BOLD);




        linke.setOnClickListener (new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                intent.putExtra("cle", "1");
                startActivity(intent);
                overridePendingTransition(R.anim.push_left_in, R.anim.push_left_out);
            }
        });


        linkp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                intent.putExtra("cle", "2");
                startActivity(intent);
                overridePendingTransition(R.anim.push_left_in, R.anim.push_left_out);
            }
        });

        btn_signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PD.show();


                final String name = edt_name.getText().toString();
                final String pass = edt_pass.getText().toString();

        if (pass.isEmpty() ) { edt_pass.setError("Vous devez entrer un mot de passe valide");  }
                if (name.isEmpty() ) { edt_name.setError("Vous devez entrer un login valide");  }
                if (name.isEmpty() && pass.isEmpty() ) { edt_name.setError("Vous devez entrer un login  valide");edt_pass.setError("Vous devez entrer un mot de passe valide");  }

                PD.dismiss();
            if (!name.isEmpty() && !pass.isEmpty() ) {
                ref.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {

                        if (name.equals(dataSnapshot.child("professeurs").child(name).child("login").getValue())
                                && pass.equals(dataSnapshot.child("professeurs").child(name).child("password").getValue())) {
                            startActivity(new Intent(getApplicationContext(), MainActivity.class));


                        } else if (name.equals(dataSnapshot.child("etudiants").child(name).child("login").getValue())
                                && pass.equals(dataSnapshot.child("etudiants").child(name).child("password").getValue())
                                && dataSnapshot.child("etudiants").child(name).child("accepte").getValue().equals("oui")) {
           Student etu0 = new Student("", name, "", "", pass, "oui");
                            Login=name;

                           // Toast.makeText(getApplicationContext(), Login, Toast.LENGTH_SHORT).show();

                            ohhquiz();

                          //  Toast.makeText(getApplicationContext(), Desc, Toast.LENGTH_SHORT).show();











                        } else if (name.equals(dataSnapshot.child("etudiants").child(name).child("login").getValue())
                                && pass.equals(dataSnapshot.child("etudiants").child(name).child("password").getValue())
                                && dataSnapshot.child("etudiants").child(name).child("accepte").getValue().equals("non"))
                        {
                          Toast.makeText(getApplicationContext(),"Not accepted Yet",Toast.LENGTH_LONG).show();


                        } else {
                            Toast.makeText(getApplicationContext(), "Données incorrectes", Toast.LENGTH_SHORT).show();
                        }
                        PD.dismiss();
                    }

                    @Override
                    public void onCancelled(FirebaseError firebaseError) {

                    }
                });
            }


            }
        });


    }


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
                        Desc="le prof "+ prof +" a publié un quiz dans le groupe " +grpnom+" ";
                        //Toast.makeText(getApplicationContext(), date, Toast.LENGTH_SHORT).show();
                        //Toast.makeText(getApplicationContext(), grpnom, Toast.LENGTH_SHORT).show();
                    //    Toast.makeText(getApplicationContext(), Desc, Toast.LENGTH_SHORT).show();
                    // Toast.makeText(getApplicationContext(), Desc, Toast.LENGTH_SHORT).show();

                        intent0 = new Intent(getApplicationContext(), AcceuilEtudActivity.class);
                        intent0.putExtra("des", Desc);
                        startActivity(intent0);



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



}