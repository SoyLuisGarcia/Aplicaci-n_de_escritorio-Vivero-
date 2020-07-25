package com.bzmliy.Vivero.Model;

public class Tabla {
	String id;
	String nombre;
	String tipo;
	String fecha;
	String id_riego;
	String foto;
	
	
	public Tabla(String id,String nombre,String tipo,String fecha)
	{
		this.id=id;
		this.nombre=nombre;
		this.tipo=tipo;
		this.fecha=fecha;
	}
	public Tabla(String id,String id_riego,String nombre,String tipo,String fecha)
	{
		this.id=id;
		this.id_riego=id_riego;
		this.nombre=nombre;
		this.tipo=tipo;
		this.fecha=fecha;
	}
	public Tabla(String id,String foto,String fecha)
	{
		this.id=id;
		this.fecha=fecha;
		this.foto=foto;
	}
	
	public void setId(String id)
	{
		this.id=id;
	}
	public void setNombre(String nombre)
	{
		this.nombre=nombre;
	}
	public void setTipo(String tipo)
	{
		this.tipo=tipo;
	}
	public void setId_riego(String id_riego)
	{
		this.id_riego=id_riego;
	}
	public void setFecha(String fecha)
	{
		this.fecha=fecha;
	}
	public String getId()
	{
		return id;
	}
	public String getNombre()
	{
		return nombre;
	}
	public String getTipo()
	{
		return tipo;
	}
	public String getFecha()
	{
		return fecha;
	}
	public String getId_riego()
	{
		return id_riego;
	}
}
