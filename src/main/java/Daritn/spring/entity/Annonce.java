package Daritn.spring.entity;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "Annonce")
public class Annonce implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long idAnnonce;
	@Column
	private double prix;
	
	@Column
	private double surface;
	@Column
	private double prixm2;

	@Column
	private String lieu;

	@Column
	private String titre;

	@Column
	private String descirption;
	
	@Column
	private String photo;
	
	@ManyToOne
	private User user;
	
	
	
	
	
	public Annonce( double prix, double surface, double prixm2, String lieu, String titre,
			String descirption, String photo) {
		super();
		this.prix = prix;
		this.surface = surface;
		this.prixm2 = prixm2;
		this.lieu = lieu;
		this.titre = titre;
		this.descirption = descirption;
		this.photo = photo;
	}

	

	
	public Annonce() {
		super();
	}




	public Long getIdAnnonce() {
		return idAnnonce;
	}




	public void setIdAnnonce(Long idAnnonce) {
		this.idAnnonce = idAnnonce;
	}




	public double getPrix() {
		return prix;
	}




	public void setPrix(double prix) {
		this.prix = prix;
	}




	public double getSurface() {
		return surface;
	}




	public void setSurface(double surface) {
		this.surface = surface;
	}




	public double getPrixm2() {
		return prixm2;
	}




	public void setPrixm2(double prixm2) {
		this.prixm2 = prixm2;
	}




	public String getLieu() {
		return lieu;
	}

	public void setLieu(String lieu) {
		this.lieu = lieu;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getDescirption() {
		return descirption;
	}

	public void setDescirption(String descirption) {
		this.descirption = descirption;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
	
	@Override
	public String toString() {
		return "Annonce [idAnnonce=" + idAnnonce + ", prix=" + prix + ", surface=" + surface + ", prixm2=" + prixm2
				+ ", lieu=" + lieu + ", titre=" + titre + ", descirption=" + descirption + ", photo=" + photo + "]";
	}
}
