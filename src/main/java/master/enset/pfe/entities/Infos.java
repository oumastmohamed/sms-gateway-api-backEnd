package master.enset.pfe.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
public class Infos implements Serializable{
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String batterie;
	private String wifi;
	private String last_seen;
	
	@ManyToOne()
	@JoinColumn(name="id_device")
	private Device device;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBatterie() {
		return batterie;
	}

	public void setBatterie(String batterie) {
		this.batterie = batterie;
	}

	public String getWifi() {
		return wifi;
	}

	public void setWifi(String wifi) {
		this.wifi = wifi;
	}

	public String getLast_seen() {
		return last_seen;
	}

	public void setLast_seen(String last_seen) {
		this.last_seen = last_seen;
	}

	@JsonIgnore
	public Device getDevice() {
		return device;
	}
	
	public void setDevice(Device device) {
		this.device = device;
	}

	public Infos() {
		super();
		// TODO Auto-generated constructor stub
	}
}
