package es.everis.gvias.beans;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.primefaces.PrimeFaces;

import es.everis.gvias.core.appbase.model.biz.fachada.Fachada;
import es.everis.gvias.navigation.MigaBean;

@ManagedBean(name = "loginBean")
@SessionScoped
public class LoginBean implements Serializable{
	
	private static final long serialVersionUID = -662525153579275538L;
    private Fachada fachada;
    private String action;
	private String passAdministrador;
  
	@ManagedProperty(value="#{migaBean}")
	private MigaBean migaBean;
	
	@PostConstruct
    public void initPage() {
        cargarDatos();
    }
	
	public void cargarDatos() {
    	    	
	}
	
	public void login(ActionEvent e) {
    	System.out.println(" NO ME LO CREO "+passAdministrador);
        FacesMessage message = null;
        boolean loggedIn = false;
         
        if(passAdministrador != null && passAdministrador.equals("admin")) {
            loggedIn = true;
            message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Bienvenido", "Admin");
            PrimeFaces.current().ajax().update("growl");
            action = "administracion";
        } else {
            loggedIn = false;
            message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Error de login", "Contraseña incorrecta");
        }
        
        FacesContext.getCurrentInstance().addMessage(null, message);
		PrimeFaces.current().ajax().update("growl");

	}
	
    public String action() {
        return action;
    }

	public String getPassAdministrador() {
		return passAdministrador;
	}

	public void setPassAdministrador(String passAdministrador) {
		this.passAdministrador = passAdministrador;
	}

	public MigaBean getMigaBean() {
		return migaBean;
	}

	public void setMigaBean(MigaBean migaBean) {
		this.migaBean = migaBean;
	}
}
