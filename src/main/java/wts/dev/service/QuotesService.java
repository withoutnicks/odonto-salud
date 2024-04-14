package wts.dev.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import wts.dev.entity.Quotes;
import wts.dev.interfaceService.IQuotesService;
import wts.dev.interfaces.IQuotes;

@Service
public class QuotesService implements IQuotesService{
	
	@Autowired
	private IQuotes data;
	
	@Override
	public List<Quotes> listQuotesActives() {
		return data.findByEstCit(Quotes.EstCit.activa);
	}

	@Override
	public List<Quotes> listQuotesScheduled() {
		return data.findByEstCit(Quotes.EstCit.programada);
	}

	@Override
	public Optional<Quotes> listIdCit(int idCit) {
		return data.findById(idCit);
	}

	@Override
	public int saveCit(Quotes q) {
		int res = 0;
		Quotes cita = data.save(q);
		if(!cita.equals(null)) {
			res = 1;
		}
		
		return res;
	}

	@Override
	public void deleteCit(int idCit) {
		// TODO Auto-generated method stub
		
	}

}
