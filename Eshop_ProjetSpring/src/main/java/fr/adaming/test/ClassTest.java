package fr.adaming.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import fr.adaming.model.Categorie;
import fr.adaming.model.Client;
import fr.adaming.service.IGeneriqueService;

public class ClassTest {
	
	public static void main(String[] args) {
		//Récupération du contexte
		
				ApplicationContext cxt=new ClassPathXmlApplicationContext("application-context.xml");
//				IGeneriqueService<Categorie> catService= (IGeneriqueService<Categorie>) cxt.getBean("categorieMB");
				
				IGeneriqueService<Client> clService=(IGeneriqueService<Client>) cxt.getBean("clientMB");
//				Categorie cat1= new Categorie("pro", (byte)0, "image");
//				catService.ajouter(cat1);
//				System.out.println(cat1);
				
				Client cl= new Client("nom"," adresse", "mail", "tel");
				clService.ajouter(cl);
				System.out.println(cl);
				
	}
	
	
	
}
