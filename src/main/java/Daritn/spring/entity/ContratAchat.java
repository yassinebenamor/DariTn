package Daritn.spring.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table( name = "ContratAchat")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ContratAchat implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="id")
	
	private Long id;
	
	@FutureOrPresent(message = "la date d'achat doit etre superieure ou agale a la date d'aujourd'hui")
	@Temporal (TemporalType.DATE)
	@Column(name="dateAchat",nullable =false)
	private Date dateAchat;
	
	@NotNull(message = "vous devez entrer les reglements d'achat")
	@Column(name="reglement",length = 1500,nullable =false)
	private String reglement;
	
	@Enumerated(EnumType.STRING)
    private EnumeratedEtat etat;
    
	@OneToOne
	private User acheteur;
	
	@OneToOne
	private Annonce annonce;

	public Long getId() {return id;}

	public Date getDateAchat() {return dateAchat;}

	public void setDateAchat(Date dateAchat) {this.dateAchat = dateAchat;}

	public String getReglement() {return reglement;}

	public void setReglement(String reglement) {this.reglement = reglement;}

	public User getAcheteur() {return acheteur;}

	public void setAcheteur(User acheteur) {this.acheteur = acheteur;}

	public Annonce getAnnonce() {return annonce;}

	public void setAnnonce(Annonce annonce) {this.annonce = annonce;}

	@Override
	public String toString() {
		return "ContratAchat [Id=" + id + ", dateAchat=" + dateAchat + ", reglement=" + reglement + ", acheteur=" + acheteur
				+ ", annonce=" + annonce + "]";
	}

	public ContratAchat(Long id) {
		super();
		this.id = id;
	}

	

	

}
