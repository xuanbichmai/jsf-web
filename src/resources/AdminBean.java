package resources;

import javax.ejb.EJB;

import ejb.SessionAdminBean;
import model.Client;

public class AdminBean {
	private Client client ;
	@EJB
	SessionAdminBean sessionadmin ;
	public AdminBean() {
		client = new Client() ;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public String validerAdmin() {
		client.setNom("admin");
		sessionadmin.setClient(client);
		if (sessionadmin.validerAdmin()==true ){
			sessionadmin.setConnecte(true);
			return "info-admin" ;
		}
		else return "";
	}
}
