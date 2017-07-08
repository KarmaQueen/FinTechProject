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

public class PossibleGuarantorListAdapter extends ArrayAdapter<GuarantorSummaryBean> {

	public PossibleGuarantorListAdapter(@NonNull Context context, @LayoutRes int resource, ArrayList<GuarantorSummaryBean> guarantorList){
		super(context, resource, guarantorList);
	}

	@NonNull
	@Override
	public View getView(int position, View convertView, ViewGroup parent){

		View v = convertView;

		if(v == null){
			LayoutInflater vi = LayoutInflater.from(getContext());
			v = vi.inflate(R.layout.item_nums_bank, null);
		}

		GuarantorSummaryBean bean = getItem(position);

		if(bean != null){
			TextView itemAccountTypes = (TextView)v.findViewById(R.id.item_account_types);
			TextView itemNumGuarantors = (TextView)v.findViewById(R.id.item_num_people);
			ImageView itemBankImage = (ImageView)v.findViewById(R.id.item_aprbank_icon);

			String numPeople = bean.getNumGuarantors() + " possible guarantors";
			String accountTypes = bean.getAccounts();

			itemNumGuarantors.setText(numPeople);
			itemAccountTypes.setText(accountTypes);

			String bankName = bean.getBank();
			int id;

 			switch(bankName){
				case "HSBC":				id = R.drawable.ic_hsbc; 	break;
				case "Bank of East Asia": 	id= R.drawable.ic_bea; 		break;
				case "Societe Generale":
				case "Société Générale": 	id = R.drawable.ic_soge; 	break;
				case "Bank of China":
				case "Bank of China HK": 	id = R.drawable.ic_bochk; 	break;
				case "Citibank":			id = R.drawable.ic_citi;	break;
				default: id = R.drawable.ic_soge;
			}
			itemBankImage.setImageResource(id);
		}

		return v;
	}
}
