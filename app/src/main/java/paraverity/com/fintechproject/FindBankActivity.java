package paraverity.com.fintechproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Collections;

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
		banksList.add(new BankBean(s(R.string.hsbc), R.drawable.ic_hsbc));
		banksList.add(new BankBean(s(R.string.soge), R.drawable.ic_soge));
		banksList.add(new BankBean(s(R.string.bochk), R.drawable.ic_bochk));
		banksList.add(new BankBean(s(R.string.citibank), R.drawable.ic_citi));
		banksList.add(new BankBean(s(R.string.db), R.drawable.ic_db));
		banksList.add(new BankBean(s(R.string.dbs), R.drawable.ic_dbs));
		banksList.add(new BankBean(s(R.string.icbc), R.drawable.ic_icbc));
		banksList.add(new BankBean(s(R.string.ocbc), R.drawable.ic_ocbc));
		banksList.add(new BankBean(s(R.string.bea), R.drawable.ic_bea));
		banksList.add(new BankBean(s(R.string.cmb), R.drawable.ic_cmb));

		Collections.sort(banksList);

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

	private String s(int id){
		return getResources().getString(id);
	}

}
