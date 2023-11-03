package com.camerarental.mycamera;
import java.util.Scanner;

import com.camerarental.camera.CameraList;
import com.camerarental.user.User;


public class MainMenu2 {
	public static void myCameraMenu(User customer){
		int choice;
		Scanner sc= new Scanner(System.in);
		while(true)
		{
		System.out.println("1. ADD"
				+ "\n2. REMOVE"
				+ "\n3. VIEW MY CAMERAS"
				+ "\n4. GO TO PREVIOUS MENU");
		choice=sc.nextInt();
		switch(choice){
		case 1:
			MyCam.add(customer);
			break;
		case 2:
			MyCam.remove(customer);
			break;
		case 3:
			CameraList.viewMyCameras(customer);
			break;
		case 4:
			return;
		default:
			System.out.println("ENTER VALID CHOICE");
		}
		}
	}

}
