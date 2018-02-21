package resources;

import javax.ejb.EJB;

import ejb.CalculBons;
import ejb.ClientEjbLocal;
//import javamodeles.Client;
import model.Client; //pointer sur entité Client créé dans ejb

public class LoginBean {
	private Client client ;
	private Integer code ;
	@EJB
	ClientEjbLocal ejbclient ;
	@EJB
	CalculBons calculbons ;

	public LoginBean() {
		client = new Client() ;		
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
	public String validationClient() {
		if ((client=ejbclient.identifierUnClient(client))!=null) {
			calculbons.genererBons(code);
			int bons = client.getBons();
			calculbons.calculerBons(bons);
			client.setBons(calculbons.getNbbons());
			ejbclient.mergeClient(client);
			return "bienvenue" ;
		}
		else return "enregistrement" ;
	}
	public String enregistrerClient() {
		if (ejbclient.rechercherUnClient(client)==null){
			calculbons.genererBons(5);
			client.setBons(calculbons.getNbbons());
			ejbclient.persistClient(client);
			return "bienvenue" ;
		}
		else return "erreur" ;
	}
}
