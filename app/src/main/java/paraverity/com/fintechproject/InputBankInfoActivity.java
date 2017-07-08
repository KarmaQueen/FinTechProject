package paraverity.com.fintechproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;

public class InputBankInfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_bank_info);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    public void confirmInfo(View view){
        EditText amount = (EditText)findViewById(R.id.inputbankinfo_amount);
        EditText months = (EditText)findViewById(R.id.inputbankinfo_months);

        String amt = amount.getText().toString();
        String mths = months.getText().toString();

        Intent i = new Intent(this, BankRecommendationActivity.class);
        i.putExtra("amount", amt);
        i.putExtra("months", mths);
        startActivity(i);

    }

}
