package es.everis.gvias.filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class RequestEncodeFilter implements Filter {
	// FilterConfig object
	private FilterConfig filterConfig = null;

	// Default constructor
	public RequestEncodeFilter() {
		System.out.println("RequestEncodeFilter creado correctamente");
	}

	// Intitialization method
	public void init(FilterConfig filterConfig) {
		this.filterConfig = filterConfig;
	}
	
	/*
	 * ESTE FILTRO SE ESTÁ USANDO PARA EVITAR EL ERROR DE CODIFICACION
	 * EN LAS LLAMADAS (AJAX=FALSE) QUE SE USAN AL GENERAR REPORTES PDF
	 */
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {

	
		String path = ((HttpServletRequest) request).getRequestURI();
		if (!path.contains("visor") && !path.contains("visor_dev")) {
//			SE EXCLUYEN LAS PETICIONES DEL VISOR YA QUE DA UN PROBLEMA DE VISUALIZACIÓN
			request.setCharacterEncoding("UTF-8");
		    chain.doFilter(request, response);
			response.setContentType("text/html; charset=UTF-8");
		}else {
			 chain.doFilter(request, response);
		}
	}

	public void destroy() {
		this.filterConfig = null;
	}
}
