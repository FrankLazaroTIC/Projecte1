package cbm.itc.m12;

import static org.junit.jupiter.api.Assertions.*;


import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

import cbm.itic.m12.Proj1ApirestApplication;
import cbm.itic.m12.model.Empresa;
import cbm.itic.m12.model.Oferta;
import cbm.itic.m12.repository.OfertaRepository;

@RunWith( SpringRunner.class )
@SpringBootTest(classes = OfertaRepository.class )
//@ExtendWith(SpringExtension.class)
class OfertaRepositoryTest {

	@Autowired
	private TestEntityManager entityManager;
	
	@Autowired
	private OfertaRepository ofertaRepo;
	
	//System Under Test
	
	private Oferta insertarOferta() {
		Empresa empresa= new Empresa(10, "Movistar", "ASDFG12");
		Oferta oferta= new Oferta(80,"Test Oferta feina", "Completa", "Barcelona", empresa);
		entityManager.persist(oferta);
		entityManager.flush();
		return oferta;
	}
	
	
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}
	
	

	@Test
	void findAll(){
		//Oferta oferta = insertarOferta();
		List<Oferta> ofertas= (List<Oferta>) ofertaRepo.findAll();
		//Iterable<Oferta> ofertas= ofertaRepo.findAll();
		assertEquals(7,ofertas.size());
	}


}
