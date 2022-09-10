package es.everis.gvias.web.utils;


import java.io.InputStream;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import javax.el.ELContext;
import javax.el.ExpressionFactory;
import javax.el.ValueExpression;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Class FacesUtils.
 */
public class FacesUtils {

    /** Variable build properties. */
    private static Properties buildProperties = null;

    /**
     * Obtiene el valor de servlet context.
     *
     * @return servlet context
     */
    public static ServletContext getServletContext() {
        return (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
    }

    /**
     * Obtiene el valor de external context.
     *
     * @return external context
     */
    public static ExternalContext getExternalContext() {
        FacesContext fc = FacesContext.getCurrentInstance();
        return fc.getExternalContext();
    }

    /**
     * Obtiene el valor de http session.
     *
     * @param create valor de create
     * @return http session
     */
    public static HttpSession getHttpSession(boolean create) {
        try {
            return (HttpSession) FacesContext.getCurrentInstance().
                    getExternalContext().getSession(create);
        } catch (Exception e) {
        }
        return null;
    }

    /**
     * Obtiene el valor de managed bean.
     *
     * @param beanName valor de bean name
     * @return managed bean
     */
    public static Object getManagedBean(String beanName) {
        FacesContext fc = FacesContext.getCurrentInstance();
        ELContext elc = fc.getELContext();
        ExpressionFactory ef = fc.getApplication().getExpressionFactory();
        ValueExpression ve = ef.createValueExpression(elc, getJsfEl(beanName), Object.class);
        return ve.getValue(elc);
    }


    /**
     * Reset managed bean.
     *
     * @param beanName valor de bean name
     */
    public static void resetManagedBean(String beanName) {
        FacesContext fc = FacesContext.getCurrentInstance();
        ELContext elc = fc.getELContext();
        ExpressionFactory ef = fc.getApplication().getExpressionFactory();
        ef.createValueExpression(elc, getJsfEl(beanName),
                Object.class).setValue(elc, null);
    }

    /**
     * Asigna el valor de managed bean in session.
     *
     * @param beanName valor de bean name
     * @param managedBean valor de managed bean
     */
    public static void setManagedBeanInSession(String beanName, Object managedBean) {
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put(beanName, managedBean);
    }

    /**
     * Asigna el valor de managed bean in request.
     *
     * @param beanName valor de bean name
     * @param managedBean valor de managed bean
     */
    public static void setManagedBeanInRequest(String beanName, Object managedBean) {
        FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put(beanName, managedBean);
    }

    /**
     * Obtiene el valor de request parameter.
     *
     * @param name valor de name
     * @return request parameter
     */
    public static String getRequestParameter(String name) {
        return FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get(name);
    }

    /**
     * Obtiene el valor de request map value.
     *
     * @param name valor de name
     * @return request map value
     */
    public static Object getRequestMapValue(String name) {
        return FacesContext.getCurrentInstance().getExternalContext().getRequestMap().get(name);
    }

    /**
     * Obtiene el valor de action attribute.
     *
     * @param event valor de event
     * @param name valor de name
     * @return action attribute
     */
    public static String getActionAttribute(ActionEvent event, String name) {
        return (String) event.getComponent().getAttributes().get(name);
    }

    /**
     * Obtiene el valor de builds the attribute.
     *
     * @param name valor de name
     * @return builds the attribute
     */
    public static String getBuildAttribute(String name) {
        if (buildProperties != null)
            return buildProperties.getProperty(name, "unknown");
        InputStream is = null;
        try {
            is = getServletContext().getResourceAsStream("/WEB-INF/buildversion.properties");
            buildProperties = new java.util.Properties();
            buildProperties.load(is);
        } catch (Throwable e) {
            is = null;
            buildProperties = null;
            return "unknown";
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (Throwable t) {
                }
            }
        }
        return buildProperties.getProperty(name, "unknown");
    }


    /**
     * Obtiene el valor de session parameter.
     *
     * @param name valor de name
     * @return session parameter
     */
    public static String getSessionParameter(String name) {
        FacesContext context = FacesContext.getCurrentInstance();
        HttpServletRequest myRequest = (HttpServletRequest) context.getExternalContext().getRequest();
        HttpSession mySession = myRequest.getSession();
        return myRequest.getParameter(name);
    }

    /**
     * Obtiene el valor de faces parameter.
     *
     * @param parameter valor de parameter
     * @return faces parameter
     */
    public static String getFacesParameter(String parameter) {
        // Get the servlet context based on the faces context
        ServletContext sc = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();

        // Return the value read from the parameter
        return sc.getInitParameter(parameter);
    }

    /**
     * Adds the info message.
     *
     * @param msg valor de msg
     */
    public static void addInfoMessage(String msg) {
        addInfoMessage(null, msg);
    }

    /**
     * Adds the info message.
     *
     * @param clientId valor de client id
     * @param msg valor de msg
     */
    public static void addInfoMessage(String clientId, String msg) {
        FacesContext.getCurrentInstance().addMessage(clientId, new FacesMessage(FacesMessage.SEVERITY_INFO, msg, msg));
    }

    /**
     * Adds the warn message.
     *
     * @param clientId valor de client id
     * @param msg valor de msg
     */
    public static void addWarnMessage(String clientId, String msg) {
        FacesContext.getCurrentInstance().addMessage(clientId,
                new FacesMessage(FacesMessage.SEVERITY_WARN, msg, msg));
    }

    /**
     * Adds the error message.
     *
     * @param msg valor de msg
     */
    public static void addErrorMessage(String msg) {
        addErrorMessage(null, msg);
    }

    /**
     * Find component.
     *
     * @param c valor de c
     * @param id valor de id
     * @return UI component
     */
    public static UIComponent findComponent(UIComponent c, String id) {
        if (id.equals(c.getId())) {
            return c;
        }
        Iterator<UIComponent> kids = c.getFacetsAndChildren();
        while (kids.hasNext()) {
            UIComponent found = findComponent(kids.next(), id);
            if (found != null) {
                return found;
            }
        }
        return null;
    }

    /**
     * Find all components.
     *
     * @param root valor de root
     * @param id valor de id
     * @param foundComponents valor de found components
     */
    public static void findAllComponents(UIComponent root, String id,
                                         List<UIComponent> foundComponents) {
        if (id.equals(root.getId())) {
            foundComponents.add(root);
        }
        Iterator<UIComponent> kids = root.getFacetsAndChildren();
        while (kids.hasNext()) {
            findAllComponents(kids.next(), id, foundComponents);
        }
    }

    /**
     * Adds the error message.
     *
     * @param clientId valor de client id
     * @param msg valor de msg
     */
    public static void addErrorMessage(String clientId, String msg) {
        FacesContext.getCurrentInstance().addMessage(clientId, new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, msg));
    }

    /**
     * Obtiene el valor de jsf el.
     *
     * @param value valor de value
     * @return jsf el
     */
    private static String getJsfEl(String value) {
        return "#{" + value + "}";
    }
}