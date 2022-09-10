package es.everis.gvias.web.bienvenida;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


/**
 * Class BienvenidaBean.
 */
@ManagedBean(name = "bienvenidaBean")
@SessionScoped
public class BienvenidaBean implements Serializable {

	/** Constante serialVersionUID. */
	private static final long serialVersionUID = 5038769928930867351L;

	
	/** Variable logger. */
	private static Logger logger = LogManager.getLogger();

	/** Variable version. */
	private String version;
	
	/**
	 * Crea una instancia de bienvenida bean.
	 */
	public BienvenidaBean() {
		logger.debug("BienvenidaBean - Inicio");
		
		//TODO
		
		logger.debug("BienvenidaBean - Fin");
		
	}

	/**
	 * Crear arbol barra menu si.
	 *
	 * @param menuOpciones valor de menu si
	 * @param oNodo valor de o nodo
	 * @param menuPadre valor de menu padre
	 * @throws Exception exception
	 */
	
}
