package com.bzmliy.Vivero.Model;

public class TablaHistorial {
	private String id;
	private String fecha;
	private String imagen;
	
	public TablaHistorial(String id, String fecha, String imagen) {
		this.id = id;
		this.fecha = fecha;
		this.imagen = imagen;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	
	public String getId() {
		return id;
	}
	
	public String getFecha() {
		return fecha;
	}
	
	public String getImagen() {
		return imagen;
	}
}
