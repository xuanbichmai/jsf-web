package resources;

import java.util.Locale;

import javax.faces.context.FacesContext;

public class LangageCommutateur {
	private Locale locale ;
	public Locale getLocale() {
		return locale;
	}
	public void changeLangage(String langage) {
		if (langage.compareTo("en")==0)
			locale = Locale.ENGLISH;
		else locale = Locale.FRENCH ;
		FacesContext.getCurrentInstance().getViewRoot().setLocale(locale);
	}
}
