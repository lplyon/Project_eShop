package fr.adaming.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="commandes")
public class Commande {

	// les attributs
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idCommande;
	private Date dateCommande;
	
	@ManyToOne
	@JoinColumn(name = "fk_client", referencedColumnName = "idClient")
	private Client client;
	
	@ManyToMany(mappedBy="lCommandes", fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	private List<Commande> lCommandes;

	public Commande() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Commande(Long idCommande, Date dateCommande) {
		super();
		this.idCommande = idCommande;
		this.dateCommande = dateCommande;
	}

	public Long getIdCommande() {
		return idCommande;
	}

	public void setIdCommande(Long idCommande) {
		this.idCommande = idCommande;
	}

	public Date getDateCommande() {
		return dateCommande;
	}

	public void setDateCommande(Date dateCommande) {
		this.dateCommande = dateCommande;
	}

	@Override
	public String toString() {
		return "Commande [" + (idCommande != null ? "idCommande=" + idCommande + ", " : "")
				+ (dateCommande != null ? "dateCommande=" + dateCommande : "") + "]";
	}

}
