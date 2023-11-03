package com.example.demo.repository;

import java.util.ArrayList;
import java.util.Iterator;

import com.example.demo.bean.Empresa;

public class BaseDades {
	ArrayList<Empresa> empresas= new ArrayList<Empresa>();
	
	public BaseDades() {
		empresas.add(new Empresa(1,"EVERIS",966666678,"BARCELONA","P.º DE LA CASTELLANA, 77","Helpdesk Windows","PRESENCIAL"));
		empresas.add(new Empresa(2,"LOGITECH",926666678,"BARCELONA","CALLE CARAVEL·LA LA NIÑA, 12","TÉCNICO JUNIOR MICROINFORMATICA","REMOT"));
		empresas.add(new Empresa(3,"ACCENTURE",962666678,"BARCELONA","CALLE DE MARIA ZAMBRANO, 31","ANALISTA PROGRAMADOR JAVA","REMOT"));
		empresas.add(new Empresa(4,"MICROSOFT",966546678,"BARCELONA","CALLE SANT MARTI, 390","DESAROLLADOR DE APLICACIONES MOBIL","HIBRID"));
		empresas.add(new Empresa(5,"ITICBCN",966666678,"VALENCIA","AV DIAGONAL, 10","ADMINISTRADOR DE SISTEMAS","HIBRID"));
		empresas.add(new Empresa(6,"GOOGLE",966666678,"MADRID","CALLE MURCIA, 37","BILING SPECIALIST","PRESENCIAL"));
	}
	
	public void inserta(Empresa empresa) {
		empresas.add(empresa);		
	}
	public ArrayList<Empresa> getEmpresas() {
		return empresas;
	}
	
	public Empresa getEmpresa(int idEmpresa){
		return empresas.get(idEmpresa);
	}
	
	public void setEmpreses(ArrayList<Empresa> empresa) {
		this.empresas = empresa;
	}
	
	public void borrar(int idEmpresa) {
		Iterator<Empresa> it = empresas.iterator();
		while(it.hasNext()) {
			Empresa li = it.next();
			if(li.getIdEmpresa()==idEmpresa) {
				it.remove();
				break;
			}
		}
	}
	
	public void modifica(Empresa empresa) {
		Iterator<Empresa> it = empresas.iterator();
		while(it.hasNext()) {
			Empresa li = it.next();
			if(li.getIdEmpresa()==empresa.getIdEmpresa()) {
				li.setNombre(empresa.getNombre());
				li.setTelefono(empresa.getTelefono());
				li.setCiudad(empresa.getCiudad());
				li.setOfertaTrabajo(empresa.getOfertaTrabajo());
				li.setModeloTrabajo(empresa.getModeloTrabajo());
				break;
			}
		}
	}
	
}

