package Daritn.spring.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
	@Column(nullable=false)
	private boolean achat;

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

	@JsonIgnore
    @OneToMany(mappedBy = "annonce")
    private Set<Favoris> favoris;
	
	public Set<Favoris> getFavoris() {
	        return this.favoris;
	    }



}
