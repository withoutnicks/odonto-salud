package wts.dev.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import wts.dev.entity.Receptionists;
import wts.dev.interfaceService.IReceptionistsService;
import wts.dev.interfaces.IReceptionists;

@Service
public class ReceptionistsService implements IReceptionistsService {
	
	@Autowired
	private IReceptionists data;

	@Override
	public List<Receptionists> listReceptionists() {
		return data.findByEstRec(Receptionists.EstRec.activo);
	}

	@Override
	public Optional<Receptionists> listIdRec(int idRec) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public int saveRec(Receptionists r) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void deleteRec(int idRec) {
		// TODO Auto-generated method stub
		
	}

}
