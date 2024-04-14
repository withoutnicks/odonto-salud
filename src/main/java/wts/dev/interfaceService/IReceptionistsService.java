package wts.dev.interfaceService;

import java.util.List;
import java.util.Optional;

import wts.dev.entity.Receptionists;

public interface IReceptionistsService {
	public List<Receptionists> listReceptionists();
	public List<Receptionists> listRecepIna();
	public Optional<Receptionists> listIdRec(int idRec);
	public int saveRec(Receptionists r);
}
