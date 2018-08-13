package master.enset.pfe.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import master.enset.pfe.dao.SMSRepository;

@RestController
@CrossOrigin("*")
public class SMSRestService {
	@Autowired
	public SMSRepository rs;
	/*
	@RequestMapping(value="/sms",method=RequestMethod.GET)
	public List<SmsEnvoyer> getActualites(){
		return rs.findAll();
	}
	@RequestMapping(value="/sms/{id}",method=RequestMethod.GET)
	public SmsEnvoyer getActualite(@PathVariable int id){
		return rs.findOne(id);
	}
	@RequestMapping(value="/sms",method=RequestMethod.POST)
	public SmsEnvoyer save(@RequestBody SmsEnvoyer actualite){
		return rs.save(actualite);
	}
	@RequestMapping(value="/sms/{id}",method=RequestMethod.PUT)
	public SmsEnvoyer update(@RequestBody SmsEnvoyer actualite,@PathVariable int id){
		actualite.setId(id);
		return rs.save(actualite);
	}
	@RequestMapping(value="/sms/{id}",method=RequestMethod.DELETE)
	public boolean delete(@PathVariable int id){
		SmsEnvoyer actualite=rs.findOne(id);
		if(actualite!=null){
			rs.delete(id);
			return true;
		}	
		else 
			return false;
	}
	/*
	@RequestMapping(value="/chercher",method=RequestMethod.GET)
	public Page<Actualite> search(@RequestParam(name="titre",defaultValue="") String titre,@RequestParam(name="page",defaultValue="0") int page,@RequestParam(name="size",defaultValue="4") int size){
		return actualiteRepository.rechercher("%"+titre+"%", new PageRequest(page, size));
	}
	*/
}
