package alemni.gl4.insat.tn.alemni;
import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.firebase.client.Firebase;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import java.util.ArrayList;
import java.util.List;
import alemni.gl4.insat.tn.alemni.model.NotificationE;
import android.support.v7.widget.DefaultItemAnimator;
import android.widget.Toast;

public class AcceuilEtudActivity extends AppCompatActivity {

    private List<NotificationE> movieList = new ArrayList<>();
    private RecyclerView recyclerView;
    private NotifAdapter mAdapter;
    // NotificationE movie1;
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("etudiants");
    String Login;
    String prof = "";
    String grpnom = "";
    String matiere = "";
    String date = "";
    String GroupEtud = "";
    String notifee;
    String keypostquiz;


    Firebase ref;
String oh;
    ProgressDialog PD;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acceuil_etud);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        Firebase.setAndroidContext(this);
        ref = new Firebase("https://myproject-bf8ad.firebaseio.com/");
        PD = new ProgressDialog(this);
        PD.setMessage("Loading...");
        Intent intent2 = getIntent();
        String Desc = getIntent().getStringExtra("des");
        oh=Desc;
        //Toast.makeText(getApplicationContext(), Desc, Toast.LENGTH_SHORT).show();
        mAdapter = new NotifAdapter(movieList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);
        prepareMovieData();

    }

    private void prepareMovieData() {
       // Toast.makeText(getApplicationContext(), oh +"okiiiiiiiiiiiiii", Toast.LENGTH_SHORT).show();

        NotificationE movie = new NotificationE(oh);
        movieList.add(movie);
        movie=new NotificationE(oh);
        movieList.add(movie);


        mAdapter.notifyDataSetChanged();
    }}








