package wts.dev.interfaces;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import wts.dev.entity.Receptionists;
import wts.dev.entity.Receptionists.EstRec;

@Repository
public interface IReceptionists extends CrudRepository<Receptionists, Integer>{
	
	@Query("SELECT r FROM Receptionists r WHERE r.estRec = ?1")
    List<Receptionists> findByEstRec(EstRec estado);

}
