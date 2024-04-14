package wts.dev.interfaceService;

import java.util.List;
import java.util.Optional;

import wts.dev.entity.Doctors;

public interface IDoctorsService {
	public List<Doctors> listDoctors();
	public List<Doctors> listDoctorsInac();
	public Optional<Doctors> listIdDoc(int idDoc);
	public int saveDoc(Doctors d);
}
