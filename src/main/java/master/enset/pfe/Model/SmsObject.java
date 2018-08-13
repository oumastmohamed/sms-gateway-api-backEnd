package master.enset.pfe.Model;

import java.io.Serializable;

public class SmsObject implements Serializable{
	 private String phone;
	 private String message;
	 private String date;
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public SmsObject() {
		super();
		// TODO Auto-generated constructor stub
	}
	 
}
