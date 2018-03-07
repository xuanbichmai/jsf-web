package resources;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.component.html.HtmlDataTable;

import ejb.ClientEjbLocal;
import ejb.SessionAdminBean;
import model.Client;

public class DetailsClients {
	private HtmlDataTable dataTable;
	/////////////////////////////////////////////////////////////
	private List<Client> lesclients;
	@EJB
	ClientEjbLocal ejbclient;
	@EJB
	SessionAdminBean sessionbean;
	/////////////////////////////////////////////////////////////
	@PostConstruct
	public void init() {
		if (sessionbean.getConnecte() == true) {
			lesclients = ejbclient.selectTousSaufAdmin();
			sessionbean.setConnecte(false);
		}
	}
	public void supprimerClient(Client client) {
		if (client != null) {
			ejbclient.removeClient(client);
			lesclients = ejbclient.selectTousSaufAdmin();
		}
	}
	public List<Client> getLesclients() {
		return lesclients;
	}
	public void setLesclients(List<Client> lesclients) {
		this.lesclients = lesclients;
	}
	public HtmlDataTable getDataTable() {
		return dataTable;
	}
	public void setDataTable(HtmlDataTable dataTable) {
		this.dataTable = dataTable;
	}
}
