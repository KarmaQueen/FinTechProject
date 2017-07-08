package paraverity.com.fintechproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
	}

	public void sendSMS(View view){
		Toast.makeText(LoginActivity.this, "Your SMS is on the way!", Toast.LENGTH_SHORT).show();
	}


	public void doLogin(View view) {
		Intent i = new Intent(this, DashboardActivity.class);
		startActivity(i);
	}
}
