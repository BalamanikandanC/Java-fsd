package com.camerarental.camera;

import java.util.ArrayList;

import com.camerarental.user.User;

public class CameraList {
	public static ArrayList<Camera>AllCameraList=new ArrayList<>();
	public static void InitializeList() {
		AllCameraList.add(new Camera(1,"Samsung","DS123",500f,"Available" ));
		AllCameraList.add(new Camera(2,"Sony","HD124",500f,"Available"));
		AllCameraList.add(new Camera(3,"Panasonic","XC",500f,"Available"));
		
	}
	static void TableHeadTemplate() {
		System.out.println("===========================================================================");
		System.out.printf("%-15s%-15s%-15s%-15s   %-20s\n", "CAMERA ID", "BRAND", "MODEL","PRICE(PER DAY)","STATUS");
		System.out.println("===========================================================================");
	}
	static void TableContent(Camera cam) {
		System.out.printf("%-15d%-15s%-15s%-15.2f   %-15s\n",cam.getCameraID(),cam.getCameraBrand(),cam.getCameraModel(),cam.getCameraPerDayPrice(),cam.getCameraStatus() );
	}
	public static void viewMyCameras(User customer) {
		TableHeadTemplate();
		for(Camera cam: AllCameraList) {
			if(customer.UserCameraIDArray.contains(cam.getCameraID())) TableContent(cam);
		}
	}
	public static void viewAllCameras() {
		TableHeadTemplate();
		for(Camera cam: AllCameraList) {
			TableContent(cam);
		}
	}
	public static boolean viewAvailableCameras() {
		TableHeadTemplate();
		boolean flag=true;
		for(Camera cam: AllCameraList) {
			if(cam.getCameraStatus().equals("Available")) {
				TableContent(cam);
				flag=false;
			}
		}
		if(flag) {
			System.out.println("NO CAMERA AVAILABLE FOR RENT ");
			return false;
		}
		return true;
	}
}
