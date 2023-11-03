package com.camerarental.cameraapp;

import java.util.Scanner;

import com.camerarental.camera.Camera;
import com.camerarental.camera.CameraList;
import com.camerarental.user.User;

public class RentAndWallet {
	static Scanner sc=new Scanner(System.in);
	public static void rent(User customer) {
		System.out.println("FOLLOWING IS THE LIST OF AVAILABLE CAMERA(S) -");
		if(CameraList.viewAvailableCameras()) {
		System.out.println("ENTER THE CAMERA ID YOU WANT TO RENT - ");
		int rentCameraID=sc.nextInt();
		for(Camera cam: CameraList.AllCameraList)
		{
			if(cam.getCameraID()==rentCameraID) {
				if(cam.getCameraStatus().equals("Available")) {
					if(customer.getBalance()>=cam.getCameraPerDayPrice()) {
						customer.setBalance(customer.getBalance()-cam.getCameraPerDayPrice());
						System.out.println("YOUR TRANSACTION FOR CAMERA - "+cam.getCameraBrand()+" "+cam.getCameraModel()+" with rent INR."+cam.getCameraPerDayPrice()+" HAS SUCCESSFULLY COMPLETED.");
						cam.setCameraStatus("Rented");
						return;
					}
					else {
						System.out.println("ERROR: TRANSACTION FAILED DUE TO INSUFFICIENT WALLET BALANCE. PLEASE DEPOSIT THE AMOUNT TO YOUR WALLET.");
						return;
					}
					
				}
				else {
					System.out.println("CAMERA RENTED / NOT AVAILABLE");
					return;
				}
			}
		}
		}
		else {
			System.out.println("SORRY!! CURRENTLY WE DON'T HAVE ANY CAMERA AVAILABLE");
			return;
		}
		
	}
	public static void wallet(User customer) {
		System.out.println("YOUR CURRENT WALLET BALANCE IS - INR."+ customer.getBalance());
		System.out.println("DO YOU WANT TO DEPOSIT MORE AMOUNT TO YOUR WALLET?(1.YES 2.NO) - ");
		int choice=sc.nextInt();
		if(choice==1) {
			System.out.println("ENTER THE AMOUNT (INR) - ");
			float depositAmount=sc.nextFloat();
			customer.setBalance(customer.getBalance()+depositAmount);
			System.out.println("YOUR WALLET BALANCE UPDATED SUCCESSFULLY. CURRENT WALLET BALANCE - INR."+customer.getBalance());
		}
		else {
			return;
		}
		
	}

}
