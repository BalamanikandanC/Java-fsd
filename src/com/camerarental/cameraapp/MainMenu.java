package com.camerarental.cameraapp;

import java.util.Scanner;

import com.camerarental.camera.CameraList;
import com.camerarental.mycamera.MainMenu2;
import com.camerarental.user.User;

public class MainMenu {
	 public void AppMenu(User customer){
		int choice;
		Scanner sc= new Scanner(System.in);
		while(true)
		{
		System.out.println("1. MY CAMERA"
				+ "\n2. RENT A CAMERA"
				+ "\n3. VIEW ALL CAMERAS"
				+ "\n4. MY WALLET"
				+ "\n5. EXIT");
		choice=sc.nextInt();
		switch(choice){
		case 1:
		    MainMenu2.myCameraMenu(customer);
			break;
		case 2:
			RentAndWallet.rent(customer);
			break;
		case 3:
			CameraList.viewAllCameras();
			break;
		case 4:
			RentAndWallet.wallet(customer);
			break;
		case 5:
			System.out.println("LOGGING OUT...\nTHANKS FOR USING THIS APP.");
			return;
		default:
			System.out.println("ENTER VALID CHOICE");
		}
		
		}
	}

}
