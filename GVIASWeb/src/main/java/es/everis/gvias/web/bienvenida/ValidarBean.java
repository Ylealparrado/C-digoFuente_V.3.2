package es.everis.gvias.web.bienvenida;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Class ValidarBean.
 */
@ManagedBean(name = "validarBean")
public class ValidarBean implements Serializable {

    /** Constante serialVersionUID. */
    private static final long serialVersionUID = 5527240823093076022L;
    
    /** Variable log. */
    private static Logger logger = LogManager.getLogger();
	
    /** Variable status. */
    private String status = "No menu item has been clicked yet.";

    /**
     * Obtiene el valor de status.
     *
     * @return status
     */
    public String getStatus() {
        return status;
    }

    /**
     * Establece el valor de status.
     *
     * @param status nuevo valor de status
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * Menu clicked.
     *
     * @param event valor de event
     */
    public void menuClicked(ActionEvent event) {
//    	PENDIENTEMIGRACION
//        if ((event.getComponent() != null) && (event.getComponent() instanceof DefaultMenuItem)) {
//            setStatus("Menu Item \"" + ((DefaultMenuItem) event.getComponent()).getValue() + "\" was clicked.");
//            log.debug("Menu Item \"" + ((DefaultMenuItem) event.getComponent()).getValue() + "\" was clicked.");
//        }
    }

    /**
     * Logout.
     *
     * @param e valor de e
     */
    public void logout(ActionEvent e) {

        //procesarInformacion("La sesión ha caducado", PopupInformacion.TIPO_INFORMACION.MENSAJE_INFORMATIVO);
        try {
            logger.warn("Comprobar que efectivamente al eliminarse la sesión se elimina los datos de edición");
            logger.info("Cerrando sesion[" + ((HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false)).getId() + "] controlado");

            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuarioWeb", null);

            FacesContext.getCurrentInstance().getExternalContext().getRequest();

            ((HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false)).invalidate();
        } catch (Exception oEx) {
            logger.error("Error al cerrar la sesión.", oEx);
        }

    }

}
