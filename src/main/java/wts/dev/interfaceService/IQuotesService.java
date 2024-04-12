package wts.dev.interfaceService;

import java.util.List;
import java.util.Optional;

import wts.dev.entity.Quotes;

public interface IQuotesService {
	public List<Quotes> listQuotesActives();
	public List<Quotes> listQuotesScheduled();
	public Optional<Quotes> listIdCit(int idCit);
	public int saveCit(Quotes q);
	public void deleteCit(int idCit);
}
