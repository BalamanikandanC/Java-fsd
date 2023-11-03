package com.camerarental.cameraapp;
import java.util.Scanner;

import com.camerarental.camera.CameraList;
import com.camerarental.user.User;

public class UserLoginMain {

	public static void main(String[] args) {
		final String USERNAME="Admin";
		final String PASSWORD="Admin123";
		Scanner sc=new Scanner(System.in);
		System.out.println("+--------------------------------+");
		System.out.println("|  WELCOME TO CAMERA RENTAL APP  |");
		System.out.println("+--------------------------------+");
		System.out.println("                                -- Developer Name: C Balamanikandan");
		System.out.println("PLEASE LOGIN TO CONTINUE");
		System.out.println("USERNAME: ");
		String InputUserName=sc.nextLine();
		System.out.println("PASSWORD: ");
		String InputPassword=sc.nextLine();
		if(InputUserName.equals(USERNAME) && InputPassword.equals(PASSWORD)) {
			CameraList.InitializeList();
			User customer=new User();
			MainMenu menu=new MainMenu();
			menu.AppMenu(customer);
		}
		else {
			System.out.println("INVALID USERNAME OR PASSWORD");
		}
		sc.close();
	}
}
