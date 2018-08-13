package master.enset.pfe.web;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import master.enset.pfe.Model.Model;
import master.enset.pfe.Model.SmsObject;
import master.enset.pfe.dao.CompteRepository;
import master.enset.pfe.dao.DefautRepository;
import master.enset.pfe.dao.DeviceRepository;
import master.enset.pfe.dao.InfosRepository;
import master.enset.pfe.dao.SMSRepository;
import master.enset.pfe.entities.Compte;
import master.enset.pfe.entities.Defaut;
import master.enset.pfe.entities.Device;
import master.enset.pfe.entities.Infos;
import master.enset.pfe.entities.SMS;

@RestController
@CrossOrigin("*")
public class WebServiceRESTFul {
	@Autowired
	private CompteRepository cr;
	@Autowired
	private DeviceRepository dr;
	@Autowired
	private DefautRepository fr;
	@Autowired
	private SMSRepository sr;
	@Autowired
	private InfosRepository ir;
	//--------------------------------------------------------------------
	//------------------Compte Methods---------------------------------------
	@RequestMapping(value="/sms",method=RequestMethod.POST)
	public List<SMS> save(@RequestBody List<SMS> list, @RequestParam(name="email",defaultValue="") String email, 
			@RequestParam(name="password",defaultValue="") String password,
			@RequestParam(name="code",defaultValue="") String code){
		for(SMS s : list){
			Compte c = cr.findOne(1);
			Device d = dr.findOne(1);
			d.setCompte(c);
			s.setDevice(d);
			s.setDate_status(new Date()+"");
			sr.save(s);
		}
		return sr.getSMSStatus("Pending");
	}
	
	
	@RequestMapping(value="/sign_up",method=RequestMethod.POST)
	public Model sign_up(@RequestBody Model m){
		Model resp = new Model();
		resp.setName("code");
		resp.setValue(0);
		System.out.println("Model : "+m.getValue()+"/"+m.getName());
		if(m.getName().equals("email")){
			System.out.println("//"+m.getValue());
				System.out.println(m.getValue());

				Compte c = new Compte(); c.setEmail("oumastmohamed@moteur.ma"); c.setPassword("admin1");
				cr.save(c);
				
				Device d = new Device(); d.setDevice_id(564678477576575L);d.setName("J2-SUMSUNG-1");d.setMark("SUMSUNG");d.setModel("J2");d.setCountry("France");
				d.setCompte(c);
				dr.save(d);
				Date date = new Date();
				Defaut f = new Defaut(); f.setType("no connection");f.setDetail("connection internet is failed");f.setDate_def(new Date(date.getTime()-8000)+"");
				f.setDevice(d);
				fr.save(f);
				
				Infos i = new Infos(); i.setBatterie("80%");i.setWifi("OUI");i.setLast_seen(new Date()+"");
				i.setDevice(d);
				ir.save(i);
				//-----------------------SMS List------------------------------------
				resp.setName("code");
				resp.setValue(d.getId());
				return resp;
		}
		return resp;
	}
	
	@RequestMapping(value="/sign_in",method=RequestMethod.GET)
	public Model sign_in(@RequestParam(name="email",defaultValue="") String email, @RequestParam(name="password",defaultValue="") String password){
		Model resp = new Model();
		resp.setName("id");
		resp.setValue("0");
		System.out.println("Result -> : "+email+"/"+password);
		Compte c = cr.getCompteEmailPass(email, password);
		if(c!=null){
			resp.setValue(c.getId());
			return resp;
		}
		return resp;
	}
	
	@RequestMapping(value="/compte",method=RequestMethod.GET)
	public Compte compte(@RequestParam(name="email",defaultValue="") String email, @RequestParam(name="password",defaultValue="") String password, @RequestParam(name="code",defaultValue="") String code){
		//
		return cr.findOne(1);
	}
	
	@RequestMapping(value="/smsp",method=RequestMethod.GET)
	public List<SMS> pending(@RequestParam(name="email",defaultValue="") String email, 
			@RequestParam(name="password",defaultValue="") String password,
			@RequestParam(name="code",defaultValue="") String code){
		//
		return sr.getSMSStatus("Pending");
	}
	@RequestMapping(value="/smsf",method=RequestMethod.GET)
	public List<SMS> failed(@RequestParam(name="email",defaultValue="") String email, 
			@RequestParam(name="password",defaultValue="") String password,
			@RequestParam(name="code",defaultValue="") String code){
		//
		return sr.getSMSStatus("Failed");
	}
	@RequestMapping(value="/smsr",method=RequestMethod.GET)
	public List<SMS> recus(@RequestParam(name="email",defaultValue="") String email, 
			@RequestParam(name="password",defaultValue="") String password,
			@RequestParam(name="code",defaultValue="") String code){
		//
		return sr.getSMSStatus("Reçus");
	}
	@RequestMapping(value="/smsd",method=RequestMethod.GET)
	public List<SMS> dilivred(@RequestParam(name="email",defaultValue="") String email, 
			@RequestParam(name="password",defaultValue="") String password,
			@RequestParam(name="code",defaultValue="") String code){
		//
		return sr.getSMSStatus("Delivered");
	}
	//pour sms reçus
	@RequestMapping(value="/recus",method=RequestMethod.POST)
	public SMS rec(@RequestBody SmsObject sms){
		Compte c = cr.findOne(1);
		Device d = dr.findOne(1);
		SMS s = new SMS();
		s.setMessage(sms.getMessage());s.setPhone(sms.getPhone());s.setDate_status(sms.getDate()+"");s.setStatus("Reçu");
		d.setCompte(c);
		s.setDevice(d);
		return sr.save(s);
	}
	// pour sms dilivered
	@RequestMapping(value="/updatesms",method=RequestMethod.GET)
	public SMS sup(@RequestParam(name="id",defaultValue="") int id){
		Compte c = cr.findOne(1);
		Device d = dr.findOne(1);
		d.setCompte(c);
		SMS s = sr.findOne(id);
		s.setDevice(d);
		s.setStatus("Delivered");
		s.setDate_status(new Date()+"");
		return sr.save(s);
	}
	//pour sms failed
	@RequestMapping(value="/aaaa",method=RequestMethod.GET)
	public SMS failed(@RequestParam(name="id",defaultValue="") int id){
		Compte c = cr.findOne(1);
		Device d = dr.findOne(1);
		d.setCompte(c);
		SMS s = sr.findOne(id);
		s.setDevice(d);
		s.setStatus("Failed");
		s.setDate_status(new Date()+"");
		return sr.save(s);
	}
	
}