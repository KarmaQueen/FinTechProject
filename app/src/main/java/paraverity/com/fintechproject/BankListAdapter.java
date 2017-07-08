package paraverity.com.fintechproject;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by David on 08-Jul-17.
 */

public class BankListAdapter extends ArrayAdapter<BankBean> {

	public BankListAdapter(@NonNull Context context, @LayoutRes int resource, ArrayList<BankBean> banksList) {
		super(context, resource, banksList);
	}

	@NonNull
	@Override
	public View getView(int position, View convertView, ViewGroup parent){
		View v = convertView;

		if(v == null){
			LayoutInflater vi;
			vi = LayoutInflater.from(getContext());
			v = vi.inflate(R.layout.item_bank, null);
		}

		BankBean bank = getItem(position);

		if(bank != null){
			TextView itemBankName = (TextView)v.findViewById(R.id.item_bank_name);
			ImageView itemBankImage = (ImageView)v.findViewById(R.id.item_bank_icon);

			itemBankName.setText(bank.getName());
			itemBankImage.setImageResource(bank.getIconID());
		}

		return v;

	}
}
