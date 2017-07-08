package paraverity.com.fintechproject;

/**
 * Created by David on 09-Jul-17.
 */

public class GuarantorSummaryBean {

	private String bank;
	private int numGuarantors;
	private String accounts;

	public GuarantorSummaryBean(String bank, int numGuarantors, String accounts) {
		this.bank = bank;
		this.numGuarantors = numGuarantors;
		this.accounts = accounts;
	}

	public String getBank() {
		return bank;
	}

	public void setBank(String bank) {
		this.bank = bank;
	}

	public int getNumGuarantors() {
		return numGuarantors;
	}

	public void setNumGuarantors(int numGuarantors) {
		this.numGuarantors = numGuarantors;
	}

	public String getAccounts() {
		return accounts;
	}

	public void setAccounts(String accounts) {
		this.accounts = accounts;
	}
}
