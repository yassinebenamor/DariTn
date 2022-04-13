package Daritn.spring.entity;

import java.io.Serializable;



import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table( name = "ContratLocation")
public class ContratLocation implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="idContrat")
	private Long id;
	
	@Temporal (TemporalType.DATE)
	@Column(name="Date_Debut",nullable =false)
	private Date dateDebut;
	
	@Temporal (TemporalType.DATE)
	@Column(name="Date_Fin",nullable =false)
	private Date dateFin;
	
	@Column(name="Regles",nullable =false)
	private String regles;
	
	@Column(name="Prix_Loyer",nullable =false)
	private int prixLoyer;
	
	@Column(name="Etat",nullable =false)
	private String etat;
	/*One To One Unidirectionnelle*/
	@OneToOne
	private User Locataire; 
	
	/* One To One Unidirectionnelle */
	@OneToOne
	private Annonce Annonce;
	
}
