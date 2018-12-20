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
	private int codigoPostal;
	@Column(name="email")
	private String email;
	
	@Column(name="password")
	private String password;
	@Column(name="n_bares")
	private int n�bares;
	
	
	public Usuario() {

	}

	public Usuario(int nid, String nombre, String email, int codigoPostal, String password, int n�bares) {
		super();
		this.nid = nid;
		this.nombre = nombre;
		this.email = email;
		this.codigoPostal = codigoPostal;
		this.password = password;
		this.n�bares = n�bares;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getCodigoPostal() {
		return codigoPostal;
	}

	public void setCodigoPostal(int codigoPostal) {
		this.codigoPostal = codigoPostal;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getN�bares() {
		return n�bares;
	}

	public void setN�bares(int n�bares) {
		this.n�bares = n�bares;
	}
}