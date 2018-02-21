package resources;

import javamodeles.Client;

public class LoginBean {
	private Client client ;
	private Integer code ;
	
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
		return "bienvenue" ;
	}
	public String enregistrerClient() {
		return "bienvenue" ;
	}
}
