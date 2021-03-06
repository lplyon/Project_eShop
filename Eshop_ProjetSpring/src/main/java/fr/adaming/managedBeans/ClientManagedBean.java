package fr.adaming.managedBeans;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;

import fr.adaming.model.Client;
import fr.adaming.service.IGeneriqueService;

@ManagedBean(name = "clientMB")
@ViewScoped
public class ClientManagedBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Client client;
	private List<Client> lClients;

	@ManagedProperty(value = "#{clientServiceBean}")
	private IGeneriqueService<Client> clientService;

	public ClientManagedBean() {
		super();
		this.client = new Client();
	}

	@PostConstruct
	public void init() {
		this.lClients = clientService.consulterTout();
	}

	public void setClientService(IGeneriqueService<Client> clientService) {
		this.clientService = clientService;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public List<Client> getlClients() {
		return lClients;
	}

	public void setlClients(List<Client> lClients) {
		this.lClients = lClients;
	}

	// Methodes Metiers
	public String ajouterClient() {
		clientService.ajouter(this.client);

		this.lClients = clientService.consulterTout();
		return "index";
	}
	
	public String modifierClient(){
		clientService.modifier(this.client);
		this.lClients = clientService.consulterTout();
		return "index";
	}
	
	
	public String supprimerClient(){
		clientService.supprimer(this.client.getIdClient());
		this.lClients = clientService.consulterTout();
		return "index";
	}
	
	public String rechercherClient(){
		this.client=clientService.consulterParId(this.client.getIdClient());
		this.lClients = clientService.consulterTout();
		return "index";
	}
	
	
	

}
