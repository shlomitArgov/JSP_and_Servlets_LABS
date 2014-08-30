package helpers;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class SessionFilter
 */
@WebFilter(filterName = "sessionFilter", urlPatterns = { "/Controller" })
public class SessionFilter implements Filter {
	private static final String COMMAND_ATTR = "command";
	private static final Object ADD_ITEM_COMMAND = "addItem";
	private static final Object REMOVE_ITEM_COMMAND = "removeItem";
	private static final Object CLEAR_COMMAND = "clear";
	private static final Object SHOW_ITEMS_COMMAND = "showItems";
	private static final String INDEX_PATH = "http://localhost:8080/OnlineStore";

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("SessionFilter.doFilter()");
		// Check if the session has expired
		HttpSession session = ((HttpServletRequest)request).getSession();
		if (session == null)
		{
			String command =  (String)request.getAttribute(COMMAND_ATTR);
			if (command != null)
			{
				// Check if the command is in (addItem, removeItem, clear, showItems, "")
				if (command.equals(ADD_ITEM_COMMAND) || 
					command.equals(REMOVE_ITEM_COMMAND) ||
					command.equals(CLEAR_COMMAND) || 
					command.equals(SHOW_ITEMS_COMMAND) || 
					command.trim().isEmpty())
				{
					request.getServletContext().getRequestDispatcher(INDEX_PATH).forward(request, response);
				}
				
			}	
		}
		
		// pass the request along the filter chain
		chain.doFilter(request, response);
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void destroy()
	{
		// TODO Auto-generated method stub
		
	}
}
