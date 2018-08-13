package master.enset.pfe.entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
public class Defaut implements Serializable{
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String type;
	private String detail;
	private String date_def;
	
	@ManyToOne
	@JoinColumn(name="id_device")
	private Device device;
	
	public int getId() {
		return id;
	}
	@JsonIgnore
	public Device getDevice() {
		return device;
	}
	
	public void setDevice(Device device) {
		this.device = device;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public String getDate_def() {
		return date_def;
	}

	public void setDate_def(String date_def) {
		this.date_def = date_def;
	}


	public Defaut() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
