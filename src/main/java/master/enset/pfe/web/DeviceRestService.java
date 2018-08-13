package master.enset.pfe.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import master.enset.pfe.dao.DeviceRepository;
import master.enset.pfe.dao.SMSRepository;
import master.enset.pfe.entities.Device;

@RestController
@CrossOrigin("*")
public class DeviceRestService {
	@Autowired
	public DeviceRepository rs;
	/*
	@RequestMapping(value="/device",method=RequestMethod.GET)
	public List<Device> getActualites(){
		return rs.findAll();
	}
	@RequestMapping(value="/device/{id}",method=RequestMethod.GET)
	public Device getActualite(@PathVariable int id){
		return rs.findOne(id);
	}
	@RequestMapping(value="/device",method=RequestMethod.POST)
	public Device save(@RequestBody Device actualite){
		return rs.save(actualite);
	}
	@RequestMapping(value="/device/{id}",method=RequestMethod.PUT)
	public Device update(@RequestBody Device actualite,@PathVariable int id){
		actualite.setId(id);
		return rs.save(actualite);
	}
	@RequestMapping(value="/device/{id}",method=RequestMethod.DELETE)
	public boolean delete(@PathVariable int id){
		Device actualite=rs.findOne(id);
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
