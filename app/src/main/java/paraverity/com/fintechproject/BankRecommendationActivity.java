package paraverity.com.fintechproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;

public class BankRecommendationActivity extends AppCompatActivity {

    private RadioGroup chooseFilter;
    private Button buttonClicked;
    private RadioButton selectedBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bank_recommendation);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        addListenerOnChoice();

        Intent i = getIntent();
        String amount = i.getStringExtra("amount");
        String months = i.getStringExtra("months");
		int amt = 0, prd = 0;
		try{
			amt = Integer.parseInt(amount);
			prd = Integer.parseInt(months);
		} catch(Exception e){
			e.printStackTrace();
		}

		initShittyDatabase();

		ArrayList<LoanInfoBean> possibleLoans = new ArrayList<>();
		for(LoanInfoBean bean : loans){
			if(bean.isValid(amt,prd)) possibleLoans.add(bean);
		}
		Collections.sort(possibleLoans);

		ListView lv = (ListView)findViewById(R.id.listView_apr);
		APRListAdapter customAdapter = new APRListAdapter(this, R.layout.item_apr_bank, possibleLoans);
		lv.setAdapter(customAdapter);

		ArrayList<GuarantorBean> possibleGuarantors = new ArrayList<>();
		for(GuarantorBean bean : guarantors){
			if(bean.isValid(amt)) possibleGuarantors.add(bean);
		}

		int hsbc = 0, bea = 0, sg = 0, boc = 0, citi = 0;

		for(GuarantorBean bean : possibleGuarantors){
			switch(bean.getBank()){
				case "HSBC": hsbc++; break;
				case "Bank of East Asia": bea++; break;
				case "Societe Generale": sg++; break;
				case "Bank of China": boc++; break;
				case "Citibank": citi++; break;
			}
		}

		ArrayList<GuarantorSummaryBean> summaryList = new ArrayList<>();

		String s = "Premier";
		if(amt < 200000) s += ", Advance";
		if(amt < 5000) s += ", Basic";
		summaryList.add(new GuarantorSummaryBean("HSBC", hsbc, s));

		s = "Citigold Private";
		if(amt < 1500000) s += ", Citigold";
		if(amt < 500000) s += ", Citi Priority";
		if(amt < 10000) s+= ", Citibanking";
		summaryList.add(new GuarantorSummaryBean("Citibank", citi, s));

		s = "BIA Plus";
		if(amt < 75000) s += ", BIA Elite";
		if(amt < 50000) s += ", BIA";
		if(amt < 1000) s += "Savings Account";
		summaryList.add(new GuarantorSummaryBean("Bank of China HK", boc, s));

		s = "SupremeGold";
		if(amt < 100000) s += ", Supreme";
		if(amt < 100) s += ", iAccount";
		summaryList.add(new GuarantorSummaryBean("Bank of East Asia", bea, s));

		s = "Super Server";
		if( amt < 4550) s += ", Flexiplus";
		if(amt < 228) s += ", My First";
		if(amt < 114) s+=", Student";
		summaryList.add(new GuarantorSummaryBean("Societe Generale", sg, s));

		ListView lv2 = (ListView)findViewById(R.id.listView_most);
		PossibleGuarantorListAdapter customAdapter2 = new PossibleGuarantorListAdapter(this, R.layout.item_nums_bank, summaryList);
		lv2.setAdapter(customAdapter2);

		lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				Intent i = new Intent(BankRecommendationActivity.this, FindFriendActivity.class);
				startActivity(i);
			}
		});
		lv2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				Intent i = new Intent(BankRecommendationActivity.this, FindFriendActivity.class);
				startActivity(i);
			}
		});
    }

    private void addListenerOnChoice() {

    }

    private ArrayList<LoanInfoBean> loans;
	private ArrayList<GuarantorBean> guarantors;

    private void initShittyDatabase(){
		loans = new ArrayList<>();
		guarantors = new ArrayList<>();

		loans.add(new LoanInfoBean("HSBC",	5000	,	49999	,	1	,	12	,	12.42	));
		loans.add(new LoanInfoBean("HSBC",	5000	,	49999	,	13	,	18	,	12.63	));
		loans.add(new LoanInfoBean("HSBC",	5000	,	49999	,	19	,	24	,	12.67	));
		loans.add(new LoanInfoBean("HSBC",	5000	,	49999	,	25	,	36	,	12.6	));
		loans.add(new LoanInfoBean("HSBC",	5000	,	49999	,	37	,	48	,	12.47	));
		loans.add(new LoanInfoBean("HSBC",	5000	,	49999	,	49	,	60	,	12.3	));
		loans.add(new LoanInfoBean("HSBC",	50000	,	99999	,	1	,	12	,	8.65	));
		loans.add(new LoanInfoBean("HSBC",	50000	,	99999	,	13	,	18	,	8.82	));
		loans.add(new LoanInfoBean("HSBC",	50000	,	99999	,	19	,	24	,	8.87	));
		loans.add(new LoanInfoBean("HSBC",	50000	,	99999	,	25	,	36	,	8.87	));
		loans.add(new LoanInfoBean("HSBC",	50000	,	99999	,	37	,	48	,	8.82	));
		loans.add(new LoanInfoBean("HSBC",	50000	,	99999	,	49	,	60	,	8.73	));
		loans.add(new LoanInfoBean("HSBC",	100000	,	199999	,	1	,	12	,	7.03	));
		loans.add(new LoanInfoBean("HSBC",	100000	,	199999	,	13	,	18	,	7.17	));
		loans.add(new LoanInfoBean("HSBC",	100000	,	199999	,	19	,	24	,	7.22	));
		loans.add(new LoanInfoBean("HSBC",	100000	,	199999	,	25	,	36	,	7.24	));
		loans.add(new LoanInfoBean("HSBC",	100000	,	199999	,	37	,	48	,	7.21	));
		loans.add(new LoanInfoBean("HSBC",	100000	,	199999	,	49	,	60	,	7.16	));
		loans.add(new LoanInfoBean("HSBC",	200000	,	299999	,	1	,	12	,	6.11	));
		loans.add(new LoanInfoBean("HSBC",	200000	,	299999	,	13	,	18	,	6.23	));
		loans.add(new LoanInfoBean("HSBC",	200000	,	299999	,	19	,	24	,	6.28	));
		loans.add(new LoanInfoBean("HSBC",	200000	,	299999	,	25	,	36	,	6.3	));
		loans.add(new LoanInfoBean("HSBC",	200000	,	299999	,	37	,	48	,	6.29	));
		loans.add(new LoanInfoBean("HSBC",	200000	,	299999	,	49	,	60	,	6.25	));
		loans.add(new LoanInfoBean("HSBC",	300000	,	499999	,	1	,	12	,	5.65	));
		loans.add(new LoanInfoBean("HSBC",	300000	,	499999	,	13	,	18	,	5.77	));
		loans.add(new LoanInfoBean("HSBC",	300000	,	499999	,	19	,	24	,	5.81	));
		loans.add(new LoanInfoBean("HSBC",	300000	,	499999	,	25	,	36	,	5.84	));
		loans.add(new LoanInfoBean("HSBC",	300000	,	499999	,	37	,	48	,	5.83	));
		loans.add(new LoanInfoBean("HSBC",	300000	,	499999	,	49	,	60	,	5.8	));
		loans.add(new LoanInfoBean("HSBC",	500000	,	799999	,	1	,	12	,	3.37	));
		loans.add(new LoanInfoBean("HSBC",	500000	,	799999	,	13	,	18	,	3.45	));
		loans.add(new LoanInfoBean("HSBC",	500000	,	799999	,	19	,	24	,	3.48	));
		loans.add(new LoanInfoBean("HSBC",	500000	,	799999	,	25	,	36	,	3.51	));
		loans.add(new LoanInfoBean("HSBC",	500000	,	799999	,	37	,	48	,	3.52	));
		loans.add(new LoanInfoBean("HSBC",	500000	,	799999	,	49	,	60	,	3.51	));
		loans.add(new LoanInfoBean("HSBC",	800000	,	999999999	,	1	,	12	,	2.7	));
		loans.add(new LoanInfoBean("HSBC",	800000	,	999999999	,	13	,	18	,	2.76	));
		loans.add(new LoanInfoBean("HSBC",	800000	,	999999999	,	19	,	24	,	2.78	));
		loans.add(new LoanInfoBean("HSBC",	800000	,	999999999	,	25	,	36	,	2.81	));
		loans.add(new LoanInfoBean("HSBC",	800000	,	999999999	,	37	,	48	,	2.82	));
		loans.add(new LoanInfoBean("HSBC",	800000	,	999999999	,	49	,	60	,	2.81	));
		loans.add(new LoanInfoBean("Bank of East Asia",	5000	,	49999	,	1	,	12	,	7.97	));
		loans.add(new LoanInfoBean("Bank of East Asia",	5000	,	49999	,	13	,	24	,	8.18	));
		loans.add(new LoanInfoBean("Bank of East Asia",	5000	,	49999	,	25	,	36	,	8.58	));
		loans.add(new LoanInfoBean("Bank of East Asia",	5000	,	49999	,	37	,	48	,	8.53	));
		loans.add(new LoanInfoBean("Bank of East Asia",	5000	,	49999	,	49	,	60	,	8.46	));
		loans.add(new LoanInfoBean("Bank of East Asia",	50000	,	199999	,	1	,	12	,	6.61	));
		loans.add(new LoanInfoBean("Bank of East Asia",	50000	,	199999	,	13	,	24	,	6.8	));
		loans.add(new LoanInfoBean("Bank of East Asia",	50000	,	199999	,	25	,	36	,	7.31	));
		loans.add(new LoanInfoBean("Bank of East Asia",	50000	,	199999	,	37	,	48	,	7.28	));
		loans.add(new LoanInfoBean("Bank of East Asia",	50000	,	199999	,	49	,	60	,	7.23	));
		loans.add(new LoanInfoBean("Bank of East Asia",	200000	,	449999	,	1	,	12	,	5.65	));
		loans.add(new LoanInfoBean("Bank of East Asia",	200000	,	449999	,	13	,	24	,	5.82	));
		loans.add(new LoanInfoBean("Bank of East Asia",	200000	,	449999	,	25	,	36	,	6.33	));
		loans.add(new LoanInfoBean("Bank of East Asia",	200000	,	449999	,	37	,	48	,	6.31	));
		loans.add(new LoanInfoBean("Bank of East Asia",	200000	,	449999	,	49	,	60	,	6.28	));
		loans.add(new LoanInfoBean("Bank of East Asia",	450000	,	1200000	,	1	,	12	,	4.59	));
		loans.add(new LoanInfoBean("Bank of East Asia",	450000	,	1200000	,	13	,	24	,	4.74	));
		loans.add(new LoanInfoBean("Bank of East Asia",	450000	,	1200000	,	25	,	36	,	5.65	));
		loans.add(new LoanInfoBean("Bank of East Asia",	450000	,	1200000	,	37	,	48	,	5.64	));
		loans.add(new LoanInfoBean("Bank of East Asia",	450000	,	1200000	,	49	,	60	,	5.61	));
		loans.add(new LoanInfoBean("Citibank",0,999999999,0,60,12.24));
		loans.add(new LoanInfoBean("Bank of China HK",0,3000000,0,60,2.75));
		loans.add(new LoanInfoBean("Société Générale", 2275, 137500, 10, 120, 9.65));

		guarantors.add(new GuarantorBean("Citibank","Citibanking",10000));
		guarantors.add(new GuarantorBean("Bank of China","Savings Account",1000));
		guarantors.add(new GuarantorBean("HSBC","Advance",200000));
		guarantors.add(new GuarantorBean("Bank of China","Business Integrated Account Elite",75000));
		guarantors.add(new GuarantorBean("HSBC","Advance",200000));
		guarantors.add(new GuarantorBean("Citibank","Citi Priority",500000));
		guarantors.add(new GuarantorBean("Bank of East Asia","Business Integrated Account",50000));
		guarantors.add(new GuarantorBean("HSBC","Basic",5000));
		guarantors.add(new GuarantorBean("Societe Generale","My First Account",228));
		guarantors.add(new GuarantorBean("HSBC","Premier",1000000));
		guarantors.add(new GuarantorBean("Bank of East Asia","SupremeGold Account",500000));
		guarantors.add(new GuarantorBean("Societe Generale","Super Server Account",11375));
		guarantors.add(new GuarantorBean("Citibank","Citibanking",10000));
		guarantors.add(new GuarantorBean("Societe Generale","Flexiplus",4550));
		guarantors.add(new GuarantorBean("HSBC","Advance",200000));
		guarantors.add(new GuarantorBean("Citibank","Citi Priority",500000));
		guarantors.add(new GuarantorBean("Bank of East Asia","Business Integrated Account",50000));
		guarantors.add(new GuarantorBean("HSBC","Basic",5000));
		guarantors.add(new GuarantorBean("Societe Generale","My First Account",228));
		guarantors.add(new GuarantorBean("HSBC","Premier",1000000));
		guarantors.add(new GuarantorBean("Bank of East Asia","SupremeGold Account",500000));
		guarantors.add(new GuarantorBean("Societe Generale","Super Server Account",11375));
		guarantors.add(new GuarantorBean("Citibank","Citibanking",10000));
		guarantors.add(new GuarantorBean("Societe Generale","Flexiplus",4550));
		guarantors.add(new GuarantorBean("Bank of East Asia","Supreme Account",100000));
		guarantors.add(new GuarantorBean("Citibank","Citi Priority",500000));
		guarantors.add(new GuarantorBean("Societe Generale","My First Account",228));
		guarantors.add(new GuarantorBean("HSBC","Premier",1000000));
		guarantors.add(new GuarantorBean("Bank of East Asia","SupremeGold Account",500000));
		guarantors.add(new GuarantorBean("Bank of China","Savings Account",1000));
		guarantors.add(new GuarantorBean("Societe Generale","My First Account",228));
		guarantors.add(new GuarantorBean("HSBC","Premier",1000000));
		guarantors.add(new GuarantorBean("Bank of China","Business Integrated Account Elite",75000));
		guarantors.add(new GuarantorBean("HSBC","Advance",200000));
		guarantors.add(new GuarantorBean("Bank of China","Savings Account",1000));
	}
}