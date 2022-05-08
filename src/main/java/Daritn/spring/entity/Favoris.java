package Daritn.spring.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@Data
@ToString
@NoArgsConstructor
@Entity
@Table(name = "Favoris")
public class Favoris implements Serializable  {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long idFavoris;


	
	@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_annonce", referencedColumnName = "idAnnonce")
    private Annonce annonce;
	  public void setAnnonce(Annonce annonce) {
	        this.annonce = annonce;
	    }
	  @OneToOne
	  private User user;
}
