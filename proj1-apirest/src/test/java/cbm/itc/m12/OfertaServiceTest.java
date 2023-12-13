package cbm.itc.m12;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import cbm.itic.m12.model.Oferta;
import cbm.itic.m12.repository.OfertaRepository;

@RunWith(MockitoJUnitRunner.class)
public class OfertaServiceTest {

    @InjectMocks
    private OfertaService ofertaService;

    @Mock
    private OfertaRepository ofertaRepository;

    @Test
    public void testGetAllOfertas() {
        List<Oferta> ofertaList = new ArrayList<>();


        when(ofertaRepository.findAll()).thenReturn(ofertaList);

        Iterable<Oferta> result = ofertaService.getAllOfertas();

        assertEquals(ofertaList, result);
    }

}