package master.enset.pfe.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import master.enset.pfe.entities.Compte;
import master.enset.pfe.entities.SMS;

public interface SMSRepository extends JpaRepository<SMS, Integer>{
	@Query("select s from SMS s where s.status like :x")
	public List<SMS> getSMSStatus(@Param("x") String status);

}
