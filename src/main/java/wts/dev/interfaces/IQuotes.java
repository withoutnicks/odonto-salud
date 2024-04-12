package wts.dev.interfaces;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import wts.dev.entity.Quotes;
import wts.dev.entity.Quotes.EstCit;

@Repository
public interface IQuotes extends CrudRepository<Quotes,Integer>{

	@Query("SELECT q FROM Quotes q WHERE q.estCit = ?1")
    List<Quotes> findByEstCit(EstCit estado);
}
