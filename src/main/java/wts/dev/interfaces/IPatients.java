package wts.dev.interfaces;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import wts.dev.entity.Patients;
import wts.dev.entity.Patients.EstUsu;

@Repository
public interface IPatients extends CrudRepository<Patients, String>{

	@Query("SELECT p FROM Patients p WHERE p.estUsu = ?1")
    List<Patients> findByEstUsu(EstUsu estado);
}
