package paraverity.com.fintechproject;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Button;

public class bankRecommendation extends AppCompatActivity {

    private RadioGroup chooseFilter;
    private Button buttonClicked;
    private RadioButton selectedBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bank_recommendation);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        addListenerOnChoice();
    }

    private void addListenerOnChoice() {
        chooseFilter = (RadioGroup) findViewById(R.id.filterLoan);
        buttonClicked = (Button) findViewById(R.id.sortBtn);

        buttonClicked.setOnClickListener(new OnClickListener(){
            public void onClick(View v){
                int selectedID = chooseFilter.getCheckedRadioButtonId();
                selectedBtn = (RadioButton) findViewById(selectedID);
                // rank data differently
            }
        });
    }
}