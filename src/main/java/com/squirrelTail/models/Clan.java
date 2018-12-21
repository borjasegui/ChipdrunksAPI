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

import org.hibernate.loader.plan.spi.Fetch;
@Entity
@Table(name="clan")
public class Clan {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int cid;
	@Column(name="nombre")
	private String nombre;
	@Column(name="n_bares")
	private String nbares;


	@ManyToMany(cascade = { CascadeType.ALL }, fetch=FetchType.EAGER)
    @JoinTable(
        name = "usuario_clan", 
        joinColumns = { @JoinColumn(name = "clan_id") }, 
        inverseJoinColumns = { @JoinColumn(name = "usuario_id") }
    )
	private List<Usuario> usuarios;
	
	public Clan() {
		
	}


	public Clan(int cid, String nombre, String nbares, List<Usuario> usuarios) {
		super();
		this.cid = cid;
		this.nombre = nombre;
		this.nbares = nbares;
		this.usuarios = usuarios;
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getNbares() {
		return nbares;
	}


	public void setNbares(String nbares) {
		this.nbares = nbares;
	}


	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public boolean validate() {
		boolean isValid=true;
		
		if(this.nombre==null || this.nombre.equals("")) isValid=false;
		
		return isValid;
	}
	
}