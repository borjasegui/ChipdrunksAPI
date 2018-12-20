package com.squirrelTail.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
@Entity
@Table(name="clan")
public class Clan {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int cid;
	@Column(name="nombre")
	private String nombre;
	
	@ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
        name = "usuario_clan", 
        joinColumns = { @JoinColumn(name = "clan_id") }, 
        inverseJoinColumns = { @JoinColumn(name = "usuario_id") }
    )
	private List<Usuario> usuarios;
	
	public Clan() {
		
	}

	

	public Clan(int cid, String nombre, List<Usuario> usuarios) {
		super();
		this.cid = cid;
		this.nombre = nombre;
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

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	
	
}