
package alemni.gl4.insat.tn.alemni;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class QuizActivity extends MainActivity {
    LinearLayout dynamicContent,bottonNavBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_chat);


        View wizard = getLayoutInflater().inflate(R.layout.activity_quiz, null);
        dynamicContent.addView(wizard);




    }
}


