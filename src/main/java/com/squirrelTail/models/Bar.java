package com.squirrelTail.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "bar")
public class Bar {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int bid;
	@Column(name = "nombre")
	private String nombre;

	@Column(name = "direccion")
	private String direccion;

	@Column(name = "telefono")
	private int telefono;

	@Column(name = "latitud")
	private double latitud;

	@Column(name = "longitud")
	private double longitud;

	@Column(name = "descripcion")
	private String descripcion;

	@ManyToMany(cascade = { CascadeType.ALL }, fetch=FetchType.EAGER)
	@JoinTable(name = "bar_cerveza", joinColumns = { @JoinColumn(name = "bar_id") }, inverseJoinColumns = {
			@JoinColumn(name = "cerveza_id") })

	private List<Cerveza> cervezas;

	public Bar() {
	}

	public Bar(int bid, String nombre, String direccion, int telefono, double latitud, double longitud,
			String descripcion, List<Cerveza> cervezas) {
		super();
		this.bid = bid;
		this.nombre = nombre;
		this.direccion = direccion;
		this.telefono = telefono;
		this.latitud = latitud;
		this.longitud = longitud;
		this.descripcion = descripcion;

	}

	public int getBid() {
		return bid;
	}

	public void setBid(int bid) {
		this.bid = bid;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public int getTelefono() {
		return telefono;
	}

	public List<Cerveza> getCervezas() {
		return cervezas;
	}

	public void setCervezas(List<Cerveza> cervezas) {
		this.cervezas = cervezas;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	public double getLatitud() {
		return latitud;
	}

	public void setLatitud(double latitud) {
		this.latitud = latitud;
	}

	public double getLongitud() {
		return longitud;
	}

	public void setLongitud(double longitud) {
		this.longitud = longitud;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public boolean validate() {
		boolean isValid = true;

		if (this.nombre == null || this.nombre.equals(""))
			isValid = false;
		if (this.telefono <= 0)
			isValid = false;

		return isValid;
	}

}