package com.camerarental.camera;


public class Camera {
	private int CameraID;
	private String CameraBrand;
	private String CameraModel;
	private float CameraPerDayPrice;
	private String CameraStatus;
	public Camera(int cameraID, String cameraBrand, String cameraModel, float cameraPerDayPrice, String cameraStatus) {
		super();
		CameraID = cameraID;
		CameraBrand = cameraBrand;
		CameraModel = cameraModel;
		CameraPerDayPrice = cameraPerDayPrice;
		CameraStatus = cameraStatus;
	}
	public int getCameraID() {
		return CameraID;
	}
	public void setCameraID(int cameraID) {
		CameraID = cameraID;
	}
	public String getCameraBrand() {
		return CameraBrand;
	}
	public void setCameraBrand(String cameraBrand) {
		CameraBrand = cameraBrand;
	}
	public String getCameraModel() {
		return CameraModel;
	}
	public void setCameraModel(String cameraModel) {
		CameraModel = cameraModel;
	}
	public float getCameraPerDayPrice() {
		return CameraPerDayPrice;
	}
	public void setCameraPerDayPrice(float cameraPerDayPrice) {
		CameraPerDayPrice = cameraPerDayPrice;
	}
	public String getCameraStatus() {
		return CameraStatus;
	}
	public void setCameraStatus(String cameraStatus) {
		CameraStatus = cameraStatus;
	}
	@Override
	public String toString() {
		return "Camera [CameraID=" + CameraID + ", CameraBrand=" + CameraBrand + ", CameraModel=" + CameraModel
				+ ", CameraPerDayPrice=" + CameraPerDayPrice + ", CameraStatus=" + CameraStatus + "]";
	}
	public Camera() {
		super();
	}

}
