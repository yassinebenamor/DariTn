package Daritn.spring.entity;

import javax.persistence.Column;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

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
@Table( name = "Location")
public class Location {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="idLocation")
	private Long id;
		
	@Column(name="type",nullable = false)
	private String type;
	
	@OneToOne
	private ContratLocation Contrat;
	
	@OneToOne
	private User Locataire;

	
}
