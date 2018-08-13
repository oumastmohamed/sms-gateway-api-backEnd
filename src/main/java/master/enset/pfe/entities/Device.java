package master.enset.pfe.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
public class Device implements Serializable{
	// auto increment
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private Long device_id;
	private String name;
	private String mark;
	private String model;
	private String country;
	
	
	@ManyToOne
	@JoinColumn(name="id_compte")
	private Compte compte;
	
	@OneToMany(mappedBy="device",cascade=CascadeType.ALL,fetch=FetchType.LAZY,orphanRemoval=true)
	private Collection<Defaut> defauts;
	@OneToMany(mappedBy="device",cascade=CascadeType.ALL,fetch=FetchType.LAZY,orphanRemoval=true)
	private Collection<SMS> sms;
	
	@OneToMany(mappedBy="device",cascade=CascadeType.ALL,fetch=FetchType.LAZY,orphanRemoval=true)
	private Collection<Infos> infos;
	
	public int getId() {
		return id;
	}
	public Collection<Infos> getInfos() {
		return infos;
	}



	public void setInfos(Collection<Infos> infos) {
		this.infos = infos;
	}



	public Collection<Defaut> getDefauts() {
		return defauts;
	}



	public void setDefauts(Collection<Defaut> defauts) {
		this.defauts = defauts;
	}


	public Collection<SMS> getSms() {
		return sms;
	}



	public void setSms(Collection<SMS> sms) {
		this.sms = sms;
	}



	public void setId(int id) {
		this.id = id;
	}


	public Long getDevice_id() {
		return device_id;
	}


	public void setDevice_id(Long device_id) {
		this.device_id = device_id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getMark() {
		return mark;
	}


	public void setMark(String mark) {
		this.mark = mark;
	}


	public String getModel() {
		return model;
	}


	public void setModel(String model) {
		this.model = model;
	}


	public String getCountry() {
		return country;
	}


	public void setCountry(String country) {
		this.country = country;
	}


	@JsonIgnore
	public Compte getCompte() {
		return compte;
	}

	
	public void setCompte(Compte compte) {
		this.compte = compte;
	}


	public Device() {
		super();
		// TODO Auto-generated constructor stub
		this.id=0;
	}	
}
