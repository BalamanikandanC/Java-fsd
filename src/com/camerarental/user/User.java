package com.camerarental.user;

import java.util.ArrayList;

public class User {
	float Balance;
	public static ArrayList<Integer> UserCameraIDArray=new ArrayList<>();
	
	public User() {
		super();
		Balance = 2000;
		User.UserCameraIDArray.add(2);
	}
	
	public float getBalance() {
		return Balance;
	}
	public void setBalance(float balance) {
		Balance = balance;
	}

}
