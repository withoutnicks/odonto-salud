package wts.dev.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import wts.dev.entity.Doctors;
import wts.dev.interfaceService.IDoctorsService;
import wts.dev.interfaces.IDoctors;

@Service
public class DoctorsService implements IDoctorsService {
	
	@Autowired
	private IDoctors data;

	@Override
	public List<Doctors> listDoctors() {
		return data.findByEstDoc(Doctors.EstDoc.activo);
	}
	
	@Override
	public List<Doctors> listDoctorsInac() {
		return data.findByEstDoc(Doctors.EstDoc.inactivo);
	}

	@Override
	public Optional<Doctors> listIdDoc(int idDoc) {
		return data.findById(idDoc);
	}

	@Override
	public int saveDoc(Doctors d) {
		int res = 0;
		Doctors doc = data.save(d);
		if(!doc.equals(null)) {
			res = 1;
		}
		
		return res;
	}

}
