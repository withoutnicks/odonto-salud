package wts.dev.interfaces;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import wts.dev.entity.Doctors;
import wts.dev.entity.Doctors.EstDoc;;

@Repository
public interface IDoctors extends CrudRepository<Doctors, Integer>{
	
	@Query("SELECT d FROM Doctors d WHERE d.estDoc = ?1")
    List<Doctors> findByEstDoc(EstDoc estado);

}
