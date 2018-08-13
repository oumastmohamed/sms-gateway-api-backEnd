package master.enset.pfe.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import master.enset.pfe.entities.Compte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CompteRepository extends JpaRepository<Compte, Integer>{
	@Query("select c from Compte c where c.email like :x and c.password like :y")
	public Compte getCompteEmailPass(@Param("x") String email, @Param("y") String pass);
}
