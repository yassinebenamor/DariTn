package Daritn.spring.entity;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table( name = "Achat")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Achat implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	
	@OneToOne
	private ContratAchat contrat;

	public Long getId() {return id;}


	public ContratAchat getContrat() {return contrat;}

	public void setContrat(ContratAchat contrat) {this.contrat = contrat;}

	@Override
	public String toString() {
		return "Achat [id=" + id + ", contrat=" + contrat + "]";
	}

	
}