package cbm.itic.m12.controller;

import java.util.*;
import org.springframework.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import cbm.itic.m12.model.Oferta;
import cbm.itic.m12.repository.OfertaRepository;

@RequestMapping("/api")
@RestController
public class OfertaController {
	@Autowired
	public OfertaRepository ofertaRepository;
	
	@GetMapping("/oferta")
	public Iterable<Oferta> buscaTots() {
		return ofertaRepository.findAll() ;
	}
	@GetMapping("/oferta/{id}")
	public Optional<Oferta> buscaPerId(@PathVariable long id) {
 	return ofertaRepository.findById(id);
	}
	@PostMapping("/oferta")
	@ResponseStatus(HttpStatus.CREATED)
	public Oferta afegeix(@RequestBody Oferta oferta) {
		Oferta oferta1 = ofertaRepository.save(oferta);
		return oferta1;
	}
	@DeleteMapping("/oferta/{id}")
	public void esborra(@PathVariable long id) {
		ofertaRepository.deleteById(id);
	}
	
	@PutMapping("/oferta/{id}")
    public Oferta modificaOferta(@RequestBody Oferta oferta, @PathVariable long id) {
        return ofertaRepository.findById(id).map(oferta1 -> {
            oferta1.setOferta(oferta.getOferta());
            oferta1.setJornada(oferta.getJornada());
            oferta1.setLloc(oferta.getLloc());
            return ofertaRepository.save(oferta1);
        }).orElseGet(() -> {
            oferta.setId(id);
            return ofertaRepository.save(oferta);
        });
    }

}
