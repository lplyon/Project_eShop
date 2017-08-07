package fr.adaming.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Class model Client
 * @author Semi-Croustillant
 *
 */
@Entity
@Table(name = "clients")
public class Client {

	// les attributs
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idClient;
	private String nomClient;
	private String adresse;
	private String mail;
	private String tel;

	@OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
	private List<Commande> lcommandes;

	/**
	 * Constructeur non-parametrique
	 */
	public Client() {
		super();
	}

	/**
	 * Constructeur sans ID
	 * @param nomClient
	 * @param adresse
	 * @param mail
	 * @param tel
	 */
	public Client(String nomClient, String adresse, String mail, String tel) {
		super();
		this.nomClient = nomClient;
		this.adresse = adresse;
		this.mail = mail;
		this.tel = tel;
	}

	/**
	 * Constructeur avec ID
	 * @param idClient
	 * @param nomClient
	 * @param adresse
	 * @param mail
	 * @param tel
	 */
	public Client(Long idClient, String nomClient, String adresse, String mail, String tel) {
		super();
		this.idClient = idClient;
		this.nomClient = nomClient;
		this.adresse = adresse;
		this.mail = mail;
		this.tel = tel;
	}

	// GETTER - SETTER

	public Long getIdClient() {
		return idClient;
	}

	public void setIdClient(Long idClient) {
		this.idClient = idClient;
	}

	public String getNomClient() {
		return nomClient;
	}

	public void setNomClient(String nomClient) {
		this.nomClient = nomClient;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public List<Commande> getLcommandes() {
		return lcommandes;
	}

	public void setLcommandes(List<Commande> lcommandes) {
		this.lcommandes = lcommandes;
	}

	// TO STRING
	@Override
	public String toString() {
		return "Client [" + (idClient != null ? "idClient=" + idClient + ", " : "")
				+ (nomClient != null ? "nomClient=" + nomClient + ", " : "")
				+ (adresse != null ? "adresse=" + adresse + ", " : "") + (mail != null ? "mail=" + mail + ", " : "")
				+ (tel != null ? "tel=" + tel : "") + "]";
	}

}
