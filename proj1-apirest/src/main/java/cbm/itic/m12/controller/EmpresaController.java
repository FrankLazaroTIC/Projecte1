package cbm.itic.m12.controller;

import java.util.*;
import org.springframework.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


import cbm.itic.m12.model.Empresa;
import cbm.itic.m12.repository.EmpresaRepository;

@RestController
@RequestMapping("/api")
public class EmpresaController {
	@Autowired
	private EmpresaRepository empresaRepository;

	@GetMapping("/empresa")
	public Iterable<Empresa> buscaTots() {
		return empresaRepository.findAll() ;
	}
	@GetMapping("/empresa/{id}")
	public Optional<Empresa> buscaPerId(@PathVariable long id) {
 	return empresaRepository.findById(id);
	}
	@PostMapping("/empresa")
	@ResponseStatus(HttpStatus.CREATED)
	public Empresa afegeix(@RequestBody Empresa empresa) {
		Empresa empresa1 = empresaRepository.save(empresa);
		return empresa1;
	}
	@DeleteMapping("/empresa/{id}")
	public void esborra(@PathVariable long id) {
		empresaRepository.deleteById(id);
	}
}
