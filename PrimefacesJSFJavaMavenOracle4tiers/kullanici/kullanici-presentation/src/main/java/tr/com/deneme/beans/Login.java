package tr.com.deneme.beans;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.persistence.Entity;

import org.primefaces.context.RequestContext;

@ManagedBean(name = "login")
@SessionScoped
@Entity
public class Login implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String username;
	private String password;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void checkUser(ActionEvent event) {
		RequestContext context = RequestContext.getCurrentInstance();
		FacesMessage message = null;
		boolean loggedIn = false;

		if (username != null && username.equals("admin") && password != null && password.equals("123")) {
			loggedIn = true;
			message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Welcome", username);
			
		} else {
			loggedIn = false;
			message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Loggin Error", "Invalid credentials");
		}

		FacesContext.getCurrentInstance().addMessage(null, message);
		context.addCallbackParam("loggedIn", loggedIn);
	}

	public Login() {

	}

}
