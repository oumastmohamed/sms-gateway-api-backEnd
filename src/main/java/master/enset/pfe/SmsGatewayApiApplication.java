package master.enset.pfe;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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


@SpringBootApplication
public class SmsGatewayApiApplication implements CommandLineRunner{
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
	public static void main(String[] args) {
		SpringApplication.run(SmsGatewayApiApplication.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception {
		/*
		Compte c = new Compte(); c.setEmail("oumastmohamed14@gmail.com"); c.setPassword("admin");
		cr.save(c);
		
		Device d = new Device(); d.setName("by mohamed");
		d.setCompte(c);
		dr.save(d);
		
		Defaut f = new Defaut(); f.setType("No sim");
		f.setDevice(d);
		fr.save(f);
		
		Infos i = new Infos(); i.setBatterie("80%");
		i.setDevice(d);
		ir.save(i);
		
		SMS sms = new SMS(); sms.setMessage("Bon courage");sms.setPhone("+212777932851");sms.setStatus("Pending");
		sms.setDevice(d);
		sr.save(sms);
		
		/*Compte c = new Compte();
		c = cr.getCompteEmailPass("oumastmohamed14gmail.com", "admin");
		System.out.println("Result -> :" +cr.getCompteEmailPass("oumastmohamed14gmail.com", "admin").toString());*/
	}
}
