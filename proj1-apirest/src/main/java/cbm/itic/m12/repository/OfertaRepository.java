package cbm.itic.m12.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import cbm.itic.m12.model.Oferta;

@Repository
public interface OfertaRepository extends CrudRepository<Oferta, Long> {
	
	List<Oferta> findByJornada(String jornada);
	
	@Query("SELECT o FROM Oferta o WHERE o.empresa.id = :empresaId")
    List<Oferta> findByEmpresa(@Param("empresaId") Long empresaId);
}
	