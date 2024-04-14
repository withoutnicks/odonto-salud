package wts.dev.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import wts.dev.entity.Patients;
import wts.dev.interfaceService.IPatientsService;
import wts.dev.interfaces.IPatients;

@Service
public class PatientsService implements IPatientsService{
	
	@Autowired
	private IPatients data;

	@Override
	public List<Patients> listPatients() {
		return data.findByEstUsu(Patients.EstUsu.activo);
	}
	
	@Override
	public Optional<Patients> listIdCli(String idCli) {
		return data.findById(idCli);
	}

	@Override
	public int saveCli(Patients p) {
		int res = 0;
		Patients cli = data.save(p);
		if(!cli.equals(null)) {
			res = 1;
		}
		
		return res;
	}

}
