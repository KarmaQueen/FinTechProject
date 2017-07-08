package paraverity.com.fintechproject;

import android.support.annotation.NonNull;

/**
 * Created by David on 08-Jul-17.
 */

public class BankBean implements Comparable<BankBean>{

	private String name;
	private int iconID;

	public BankBean(String name, int iconID){
		this.setName(name);
		this.setIcon(iconID);
	}

	public void setName(String name){
		this.name = name;
	}

	public void setIcon(int ID){
		iconID = ID;
	}

	public String getName(){ return name;}
	public int getIconID(){ return iconID;}

	@Override
	public int compareTo(@NonNull BankBean o) {
		return name.compareTo(o.getName());
	}
}
