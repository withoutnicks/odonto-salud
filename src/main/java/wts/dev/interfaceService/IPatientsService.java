package wts.dev.interfaceService;

import java.util.List;
import java.util.Optional;

import wts.dev.entity.Patients;

public interface IPatientsService {
	public List<Patients> listPatients();
	public Optional<Patients> listIdCli(String idCli);
	public int saveCli(Patients p);
}
