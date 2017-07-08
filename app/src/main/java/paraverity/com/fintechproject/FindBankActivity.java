package paraverity.com.fintechproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class FindBankActivity extends AppCompatActivity {

	public static final int RESULT_SELECTED = 1;
	public static final int RESULT_CANCEL = 2;
	public static final int REQUEST_SELECT = 149;

	private ArrayList<BankBean> banksList;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_find_bank);

		banksList = new ArrayList<>();
		banksList.add(new BankBean("HSBC", R.drawable.ic_hsbc));
		banksList.add(new BankBean("Societe Generale", R.drawable.ic_soge));
		banksList.add(new BankBean("Bank of China HK", R.drawable.ic_bochk));
		banksList.add(new BankBean("Citi Bank", R.drawable.ic_citi));

		ListView lv = (ListView)findViewById(R.id.list_bank);
		BankListAdapter customAdapter = new BankListAdapter(this, R.layout.item_bank, banksList);
		lv.setAdapter(customAdapter);

		lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				BankBean selectedBank = banksList.get(position);
				Intent data = new Intent();
				data.putExtra("bank_name", selectedBank.getName());
				setResult(RESULT_SELECTED, data);
				finish();
			}
		});

	}

}
