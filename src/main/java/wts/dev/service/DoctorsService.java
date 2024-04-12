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
	public Optional<Doctors> listIdDoc(int idDoc) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public int saveDoc(Doctors d) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void deleteDoc(int idDoc) {
		// TODO Auto-generated method stub
		
	}

}
