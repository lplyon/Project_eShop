package fr.adaming.model;

import java.util.Date;

public class Commande {

	private Long idCommande;
	private Date dateCommande;

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
