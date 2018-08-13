package master.enset.pfe.Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;


public class Model implements Serializable{
	private Object name;
	private Object value;
	public Object getName() {
		return name;
	}
	public void setName(Object name) {
		this.name = name;
	}
	public Object getValue() {
		return value;
	}
	public void setValue(Object value) {
		this.value = value;
	}
	public Model() {
		super();
		this.name=null;
		this.value=null;
		// TODO Auto-generated constructor stub
	}
	
}
