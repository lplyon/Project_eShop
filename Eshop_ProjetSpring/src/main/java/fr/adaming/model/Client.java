package fr.adaming.model;

public class Client {

	private Long idClient;
	private String nomClient;
	private String adresse;
	private String mail;
	private String tel;

	public Client() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Client(String nomClient, String adresse, String mail, String tel) {
		super();
		this.nomClient = nomClient;
		this.adresse = adresse;
		this.mail = mail;
		this.tel = tel;
	}

	public Client(Long idClient, String nomClient, String adresse, String mail, String tel) {
		super();
		this.idClient = idClient;
		this.nomClient = nomClient;
		this.adresse = adresse;
		this.mail = mail;
		this.tel = tel;
	}

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

	@Override
	public String toString() {
		return "Client [" + (idClient != null ? "idClient=" + idClient + ", " : "")
				+ (nomClient != null ? "nomClient=" + nomClient + ", " : "")
				+ (adresse != null ? "adresse=" + adresse + ", " : "") + (mail != null ? "mail=" + mail + ", " : "")
				+ (tel != null ? "tel=" + tel : "") + "]";
	}

}
