package cbm.itic.m12.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import cbm.itic.m12.model.Empresa;

@Repository
public interface EmpresaRepository extends CrudRepository<Empresa, Long> {
	
}
	