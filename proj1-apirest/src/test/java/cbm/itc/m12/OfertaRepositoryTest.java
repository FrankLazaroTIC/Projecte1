package cbm.itc.m12;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.jdbc.Sql;

import cbm.itic.m12.model.Empresa;
import cbm.itic.m12.model.Oferta;
import cbm.itic.m12.repository.OfertaRepository;

@DataJpaTest
class OfertaRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private OfertaRepository ofertaRepo;
    private Oferta insertarOferta() {
        Empresa empresa = new Empresa(10, "Movistar", "ASDFG12");
        Oferta oferta = new Oferta(80, "Test Oferta feina", "Completa", "Barcelona", empresa);
        entityManager.persist(oferta);
        entityManager.flush();
        return oferta;
    }

    @Test
    void saveOfertaTest() {
        Oferta oferta = insertarOferta();

        assertNotNull(oferta.getId());
        assertEquals(80, oferta.getOferta());
        assertEquals("Test Oferta feina", oferta.getJornada());
        assertEquals("Completa", oferta.getLloc());
    }

    @Test
    void findByIdTest() {
        Oferta oferta = insertarOferta();

        Optional<Oferta> result = ofertaRepo.findById(oferta.getId());

        assertTrue(result.isPresent());
        assertEquals(oferta.getId(), result.get().getId());
    }

    @Test
    void findAllTest() {
        insertarOferta();

        List<Oferta> ofertas = (List<Oferta>) ofertaRepo.findAll();

        assertFalse(ofertas.isEmpty());
    }

    @Test
    void deleteOfertaTest() {
        Oferta oferta = insertarOferta();

        ofertaRepo.deleteById(oferta.getId());

        assertFalse(ofertaRepo.findById(oferta.getId()).isPresent());
    }
}
    
