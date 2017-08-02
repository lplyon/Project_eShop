package fr.adaming.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "commandes")
public class Commande {

	// les attributs
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idCommande;

	@Temporal(TemporalType.DATE)
	private Date dateCommande;

	@ManyToOne
	@JoinColumn(name = "fk_client", referencedColumnName = "idClient")
	private Client client;

	@OneToMany(mappedBy = "commande", cascade = CascadeType.ALL)
	private List<LigneCommande> lLignesCommandes;

	// Constructeur vide
	public Commande() {
		super();
	}

	// Constructeur avec id
	public Commande(Long idCommande, Date dateCommande, Client client) {
		super();
		this.idCommande = idCommande;
		this.dateCommande = dateCommande;

	}

	// Constructeur sans id
	public Commande(Date dateCommande) {
		super();
		this.dateCommande = dateCommande;

	}

	// GETTER - SETTER
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

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public List<LigneCommande> getlLignesCommandes() {
		return lLignesCommandes;
	}

	public void setlLignesCommandes(List<LigneCommande> lLignesCommandes) {
		this.lLignesCommandes = lLignesCommandes;
	}

	// TO STRING
	@Override
	public String toString() {
		return "Commande [" + (idCommande != null ? "idCommande=" + idCommande + ", " : "")
				+ (dateCommande != null ? "dateCommande=" + dateCommande + ", " : "")
				+ (client != null ? "client=" + client + ", " : "")
				+ (lLignesCommandes != null ? "lLignesCommandes=" + lLignesCommandes : "") + "]";
	}

}
