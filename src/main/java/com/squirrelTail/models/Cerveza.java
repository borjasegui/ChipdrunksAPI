package com.squirrelTail.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="cerveza")
public class Cerveza {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int zid;
	@Column(name="nombre")
	private String nombre;
	@Column(name="porcentaje_alcohol")
	private double porcentaje_alcohol;
	@Column(name="descripcion")
	private String descripcion;
	
	public Cerveza() {
		
	}

	public Cerveza(int zid, String nombre, double porcentaje_alcohol, String descripcion) {
		super();
		this.zid = zid;
		this.nombre = nombre;
		this.porcentaje_alcohol = porcentaje_alcohol;
		this.descripcion = descripcion;
	}

	public int getZid() {
		return zid;
	}

	public void setZid(int zid) {
		this.zid = zid;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getAlcohol() {
		return porcentaje_alcohol;
	}

	public void setAlcohol(double alcohol) {
		this.porcentaje_alcohol = alcohol;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public boolean validate() {
		boolean isValid=true;
		
		if(this.nombre==null || this.nombre.equals("")) isValid=false;
		if(this.porcentaje_alcohol<=0) isValid=false;
		
		return isValid;
	}
	
}