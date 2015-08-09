package me.jimmyx.gcm;

//POJO model class for form binding objects with gcm.jsp view
public class GCMMessage {
	private String message;
	private String regId;

	public String getRegId() {
		return regId;
	}

	public void setRegId(String regId) {
		this.regId = regId;
	}

	public void setMessage(String m) {
		this.message = m;
	}

	public String getMessage() {
		return message;
	}

}
