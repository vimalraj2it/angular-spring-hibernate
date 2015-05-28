package com.cracker.domain;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Quantity {
	
	@Expose
	@SerializedName("quan")
	private int quan;
	
	
	
	@Expose
	@SerializedName("tot")
	private int tot;
	
	public int getQuan() {
		return quan;
	}
	public void setQuan(int quan) {
		this.quan = quan;
	}
	public int getTot() {
		return tot;
	}
	public void setTot(int tot) {
		this.tot = tot;
	}
	
}
