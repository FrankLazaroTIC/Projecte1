package cbm.itc.m12;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cbm.itic.m12.model.Oferta;
import cbm.itic.m12.repository.OfertaRepository;

import java.util.Optional;

@Service
public class OfertaService {

    @Autowired
    private OfertaRepository ofertaRepository;

    public Iterable<Oferta> getAllOfertas() {
        return ofertaRepository.findAll();
    }

    public Optional<Oferta> getOfertaById(long id) {
        return ofertaRepository.findById(id);
    }

    public Oferta addOferta(Oferta oferta) {
        return ofertaRepository.save(oferta);
    }

    public void deleteOferta(long id) {
        ofertaRepository.deleteById(id);
    }

    public Oferta updateOferta(Oferta oferta, long id) {
        return ofertaRepository.findById(id)
                .map(existingOferta -> {
                    existingOferta.setOferta(oferta.getOferta());
                    existingOferta.setJornada(oferta.getJornada());
                    existingOferta.setLloc(oferta.getLloc());
                    return ofertaRepository.save(existingOferta);
                })
                .orElseGet(() -> {
                    oferta.setId(id);
                    return ofertaRepository.save(oferta);
                });
    }
}