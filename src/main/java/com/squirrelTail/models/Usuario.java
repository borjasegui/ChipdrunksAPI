package com.squirrelTail.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="usuario")
public class Usuario {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int nid;
	@Column(name="nombre")
	private String nombre;
	@Column(name="cp")
	private int codigopostal;
	@Column(name="email")
	private String email;
	
	@Column(name="password")
	private String password;
	@Column(name="n_bares")
	private int nbares;
	
	
	public Usuario() {

	}

	public Usuario(int nid, String nombre, String email, int codigopostal, String password, int nbares) {
		super();
		this.nid = nid;
		this.nombre = nombre;
		this.email = email;
		this.codigopostal = codigopostal;
		this.password = password;
		this.nbares = nbares;
	}

	public int getNid() {
		return nid;
	}

	public void setNid(int nid) {
		this.nid = nid;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getCodigopostal() {
		return codigopostal;
	}

	public void setCodigopostal(int codigopostal) {
		this.codigopostal = codigopostal;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getNbares() {
		return nbares;
	}

	public void setNbares(int nbares) {
		this.nbares = nbares;
	}

	
}