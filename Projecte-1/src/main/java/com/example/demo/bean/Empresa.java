package com.example.demo.bean;

public class Empresa {
	
	private int idEmpresa;
	private String nombre;
	private int	telefono;
	private String ciudad;
	private String direccion;
	private String ofertaTrabajo;
	private String modeloTrabajo;
	
	public int getIdEmpresa() {
		return idEmpresa;
	}
	public void setIdEmpresa(int idEmpresa) {
		this.idEmpresa = idEmpresa;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getTelefono() {
		return telefono;
	}
	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}
	public String getCiudad() {
		return ciudad;
	}
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getOfertaTrabajo() {
		return ofertaTrabajo;
	}
	public void setOfertaTrabajo(String ofertaTrabajo) {
		this.ofertaTrabajo = ofertaTrabajo;
	}
	public String getModeloTrabajo() {
		return modeloTrabajo;
	}
	public void setModeloTrabajo(String modeloTrabajo) {
		this.modeloTrabajo = modeloTrabajo;
	}
	public Empresa(int idEmpresa, String nombre, int telefono, String ciudad, String direccion, String ofertaTrabajo,
			String modeloTrabajo) {
		super();
		this.idEmpresa = idEmpresa;
		this.nombre = nombre;
		this.telefono = telefono;
		this.ciudad = ciudad;
		this.direccion = direccion;
		this.ofertaTrabajo = ofertaTrabajo;
		this.modeloTrabajo = modeloTrabajo;
	}
	
}	