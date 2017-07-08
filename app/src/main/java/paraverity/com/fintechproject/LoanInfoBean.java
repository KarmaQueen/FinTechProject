package paraverity.com.fintechproject;

import android.support.annotation.NonNull;

/**
 * Created by David on 08-Jul-17.
 * JavaBean that contains loan info
 */

public class LoanInfoBean implements Comparable<LoanInfoBean>{

	private String bank;
	private int minimumAmt;
	private int maximumAmt;
	private int minimumPeriod;
	private int maximumPeriod;
	private double APR;

	public boolean isValid(int amt, int period){
		return minimumAmt <= amt &&  amt <= maximumAmt &&
				minimumPeriod <= period && period <= maximumPeriod;
	}

	public LoanInfoBean(String bank, int mia, int maa, int mip, int map, double aprr){
		this.bank = bank;
		minimumAmt = mia;
		maximumAmt = maa;
		minimumPeriod = mip;
		maximumPeriod = map;
		APR = aprr;
	}

	@Override
	public int compareTo(@NonNull LoanInfoBean o) {
		return Double.compare(APR, o.APR);
	}

	public double getAPR(){
		return APR;
	}

	public String getBank(){
		return bank;
	}
}
