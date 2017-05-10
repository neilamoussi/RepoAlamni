package alemni.gl4.insat.tn.alemni;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import alemni.gl4.insat.tn.alemni.model.Student;

public class CheckQuizActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_quiz);
        Intent intent6 =getIntent();
        final String Login = getIntent().getStringExtra("etudacceuil");

   Toast.makeText(getApplicationContext(), Login, Toast.LENGTH_SHORT).show();
    }
}
