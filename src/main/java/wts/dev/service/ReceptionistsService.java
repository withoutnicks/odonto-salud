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
	public List<Receptionists> listRecepIna() {
		return data.findByEstRec(Receptionists.EstRec.inactivo);
	}

	@Override
	public Optional<Receptionists> listIdRec(int idRec) {
		return data.findById(idRec);
	}

	@Override
	public int saveRec(Receptionists r) {
		int res = 0;
		Receptionists recep = data.save(r);
		if(!recep.equals(null)) {
			res = 1;
		}
		
		return res;
	}

}
