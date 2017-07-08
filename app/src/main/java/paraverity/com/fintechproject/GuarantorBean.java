package paraverity.com.fintechproject;

/**
 * Created by David on 08-Jul-17.
 */

public class GuarantorBean {

	private String bank;
	private String level;
	private int minimum;

	public GuarantorBean(String bank, String level, int minimum) {
		this.bank = bank;
		this.level = level;
		this.minimum = minimum;
	}

	public boolean isValid(int amt){
		return minimum > amt;
	}

	public String getBank() {
		return bank;
	}

	public void setBank(String bank) {
		this.bank = bank;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public int getMinimum() {
		return minimum;
	}

	public void setMinimum(int minimum) {
		this.minimum = minimum;
	}
}
