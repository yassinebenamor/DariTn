package Daritn.spring.entity;

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
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table( name = "RendezVous")
public class RendezVous {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="idContrat")
	private Long id;
	
	@Temporal (TemporalType.DATE)
	@Column(name="Date",nullable =false)
	private Date date;
	
	@Column(name="lieu",nullable =false)
	private String lieu;
	
	@Column(name="Etat",nullable=false)
	private String etat;
	
	@OneToOne
	private Annonce annonce;
	
	@OneToOne
	private User demandeur;

}
