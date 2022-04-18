package Daritn.spring.entity;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name = "Avis")
public class Avis implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="idAvis")
	private int idAvis;
	private int  Nombre;
	//private int iduser; 
	public Avis(int idAvis, int nombre) {
		super();
		this.idAvis = idAvis;
		Nombre = nombre;
	}
	public Avis() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getIdAvis() {
		return idAvis;
	}
	public void setIdAvis(int idAvis) {
		this.idAvis = idAvis;
	}
	public int getNombre() {
		return Nombre;
	}
	public void setNombre(int nombre) {
		Nombre = nombre;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Nombre;
		result = prime * result + idAvis;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Avis other = (Avis) obj;
		if (Nombre != other.Nombre)
			return false;
		if (idAvis != other.idAvis)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Avis [idAvis=" + idAvis + ", Nombre=" + Nombre + "]";
	}
	

	

}
