package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.ArrayList;
import com.example.demo.bean.Empresa;
import com.example.demo.bean.Usuario;
import com.example.demo.repository.BaseDades;


@Controller 
@RequestMapping("")
public class Controlador {

	BaseDades bd = new BaseDades();
	Usuario usuario;

	
	@GetMapping("/") 
	public String iniciar(Model model) {
		model.addAttribute("titulo","EMPRESAS");
		return "login";
	}
	
	@PostMapping("/")
	public String login(Usuario usuario, Model model) {
		if(usuario.getNombre().equals("edu")&&usuario.getPassword().equals("edu")) {
			ArrayList<Empresa> empresas = bd.getEmpresas();
			model.addAttribute("usuario",usuario);
			this.usuario=usuario;
			model.addAttribute("empresas",empresas);
			return "consulta";
	}else
			return "login";
	}
	
	@PostMapping("/insertar")
	public String insertar(Empresa empresa, Model model) {
		bd.inserta(empresa);
		ArrayList<Empresa> empresas = bd.getEmpresas();
		model.addAttribute("usuario",this.usuario);
		model.addAttribute("empresas",empresas);
		model.addAttribute("boton","Añadir empresa");
		model.addAttribute("action","/insertar");
		model.addAttribute("empresa",null);
		return "consulta";
	}
	
	@GetMapping("/borrado/{id}")
	public String borrar(@PathVariable int id, Model model) {
		bd.borrar(id);
		ArrayList<Empresa> empresas = bd.getEmpresas();
		model.addAttribute("empresas",empresas);
		model.addAttribute("usuario",this.usuario);
		model.addAttribute("boton","Añadir empresa");
		model.addAttribute("action","/insertar");
		return "consulta";
	}
	
	@GetMapping("/modificar/{id}")
	public String modificar(@PathVariable int id, Model model) {
		Empresa empresa = bd.getEmpresa(id);
		ArrayList<Empresa> empresas = bd.getEmpresas();
		model.addAttribute("empresas",empresa);
		model.addAttribute("usuario",this.usuario);
		model.addAttribute("boton","Actualizar empresa");
		model.addAttribute("action","/modificar");
		return "consulta";
	}
	
	@PostMapping("/modificar")
	public String modificar(Empresa empresa, Model model) {
		bd.modifica(empresa);
		ArrayList<Empresa> empresas = bd.getEmpresas();
		model.addAttribute("usuario",this.usuario);
		model.addAttribute("empresas",empresas);
		model.addAttribute("empresa",null);
		model.addAttribute("boton","Inserta empresa");
		model.addAttribute("action","/insertar");
		return "consulta";
	}
	
}
