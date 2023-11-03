package com.camerarental.mycamera;

import java.util.Scanner;

import com.camerarental.camera.Camera;
import com.camerarental.camera.CameraList;
import com.camerarental.user.*;

public class MyCam {
	
	public static void add(User customer) {
		Scanner sc=new Scanner(System.in);
		System.out.println("ENTER THE CAMERA BRAND - ");
		String brand=sc.nextLine();
		System.out.println("ENTER THE CAMERA MODEL - ");
		String model=sc.nextLine();
		System.out.println("ENTER THE PER DAY PRICE (INR) - ");
		float pdp= sc.nextFloat();
		Camera temp=CameraList.AllCameraList.get(CameraList.AllCameraList.size()-1);
		int newCamId=temp.getCameraID()+1;
		Camera newCamera=new Camera(newCamId,brand,model,pdp,"Available");
		CameraList.AllCameraList.add(newCamera);
		customer.UserCameraIDArray.add(newCamId);
		System.out.println("YOUR CAMERA HAS BEEN SUCCESSFULLY ADDED TO THE LIST.");
		return;
	}
	
	public static void remove(User customer) {
		Scanner sc=new Scanner(System.in);
		CameraList.viewMyCameras(customer);
		System.out.println("ENTER THE CAMERA ID TO REMOVE - ");
		int removeID=sc.nextInt();
		boolean flag=false;
	    for(Camera cam: CameraList.AllCameraList) {
	    	if(cam.getCameraID()==removeID) {
	    		CameraList.AllCameraList.remove(cam);
	    		customer.UserCameraIDArray.remove(Integer.valueOf(removeID));
	    		System.out.println("CAMERA SUCCESSFULLY REMOVED FROM THE LIST.");
	    		flag=true;
	    		break;
	    	}
	    }
	    if(!flag) {
	    	System.out.println("NO SUCH CAMERA ID FOUND"
	    			+ "\nENTER CORRECT CAMERA ID");
	    }
	    return;
	}
}
