package paraverity.com.fintechproject;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class FindFriendActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_find_friend);
		Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
		setSupportActionBar(toolbar);

		Button button = (Button)findViewById(R.id.confirmSendRequest);
		button.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				new AlertDialog.Builder(FindFriendActivity.this)
						.setTitle("Get Guaranteed?")
						.setMessage("Please confirm if you want this group to receive your guarantee request")
						.setPositiveButton("CONFIRM",
								new DialogInterface.OnClickListener() {
									@Override
									public void onClick(DialogInterface dialog, int which) {
										Intent i = new Intent(getApplicationContext(), DashboardActivity.class);
										Toast.makeText(getApplicationContext(), "You have sent your request!",Toast.LENGTH_SHORT).show();
										startActivity(i);
									}
								})
						.setNegativeButton("CANCEL",
								new DialogInterface.OnClickListener() {
									@Override
									public void onClick(DialogInterface dialog, int which) {
										dialog.dismiss();
									}
								})
						.show();

				RadioGroup rg = (RadioGroup)findViewById(R.id.radiogroup);
				rg.setOnClickListener(new View.OnClickListener() {
					@Override
					public void onClick(View v) {
						RadioButton radioGroup = (RadioButton)findViewById(R.id.radio_groups);
						CheckBox c1 = (CheckBox)findViewById(R.id.c1);
						CheckBox c2 = (CheckBox)findViewById(R.id.c2);
						CheckBox c3 = (CheckBox)findViewById(R.id.c3);
						CheckBox c4 = (CheckBox)findViewById(R.id.c4);
						if(radioGroup.isChecked()){
							c1.setEnabled(true);
							c2.setEnabled(true);
							c3.setEnabled(true);
							c4.setEnabled(true);
						} else {
							c1.setEnabled(false);
							c2.setEnabled(false);
							c3.setEnabled(false);
							c4.setEnabled(false);
						}
					}
				});
				rg.setOnCheckedChangeListener(
						new RadioGroup.OnCheckedChangeListener() {
					@Override
					public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
						Log.d("AYYY", "" + checkedId);
						RadioButton radioGroup = (RadioButton)findViewById(R.id.radio_groups);
						CheckBox c1 = (CheckBox)findViewById(R.id.c1);
						CheckBox c2 = (CheckBox)findViewById(R.id.c2);
						CheckBox c3 = (CheckBox)findViewById(R.id.c3);
						CheckBox c4 = (CheckBox)findViewById(R.id.c4);
						if(radioGroup.isChecked()){
							c1.setEnabled(true);
							c2.setEnabled(true);
							c3.setEnabled(true);
							c4.setEnabled(true);
						} else {
							c1.setEnabled(false);
							c2.setEnabled(false);
							c3.setEnabled(false);
							c4.setEnabled(false);
						}
					}
				});
			}
		});

	}

}
