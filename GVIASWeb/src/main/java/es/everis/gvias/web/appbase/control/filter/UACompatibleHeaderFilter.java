package es.everis.gvias.web.appbase.control.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

/**
 * Class UACompatibleHeaderFilter.
 */
public class UACompatibleHeaderFilter implements Filter {

	/**
	 * (non-Javadoc)
	 * @see javax.servlet.Filter#destroy()
	 */
	@Override
	public void destroy() {	
	}


	@Override
	/**
	 * (non-Javadoc)
	 * @see javax.servlet.Filter#doFilter(javax.servlet.ServletRequest, javax.servlet.ServletResponse, javax.servlet.FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse res,
			FilterChain fc) throws IOException, ServletException {
		HttpServletResponse response = (HttpServletResponse) res;
		response.addHeader("X-UA-Compatible", "IE=9");
		
		fc.doFilter(request, res);
	}
	/**
	 * (non-Javadoc)
	 * @see javax.servlet.Filter#init(javax.servlet.FilterConfig)
	 */
	@Override
	public void init(FilterConfig arg0) throws ServletException {	
	}
}
