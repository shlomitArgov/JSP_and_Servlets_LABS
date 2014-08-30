package store;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/Login")
public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private static final String USERNAME_PARAM = "username";
	private static final String USERNAME_ATTR = "username";
	private static final Object DEFAULT_USERNAME = "Guest";
	private static final String WELCOME_JSP_PATH = "/WEB-INF/Welcome.jsp";
	private static final String LAST_VISIT_COOKIE = "lastvisitCookie";
	private static final String LAST_VISIT_ATTR = "lastvisitAttr";
	
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		System.out.println("LoginServlet.init()");
}
	
	public void destroy() {
		super.destroy();
		System.out.println("LoginServlet.destroy()");
}
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("LoginServlet.service()");
		// Get username parameter from the request and set validation username as a request attribute
		String username = request.getParameter(USERNAME_PARAM);
		if(username != null && !(username.trim().isEmpty()))
		{
			request.setAttribute(USERNAME_ATTR, username);	
		}
		else
		{
			request.setAttribute(USERNAME_ATTR, DEFAULT_USERNAME);
		}
		
		// Invalidate existing session
		HttpSession session = request.getSession(false);
		if (session != null)
		{
			session.invalidate();
			System.out.println("LoginServlet.service() - invalidated existing session");
		}
		
		// Get existing cookies
		Cookie[] cookies = request.getCookies();
		
		// Store previous visit date if exists
		String lastVisitDate = null;
		if(cookies != null && cookies.length != 0)
		{
			for (Cookie cookie : cookies) 
			{
				if(cookie.getName().equals(LAST_VISIT_COOKIE))
				{
					lastVisitDate = cookie.getValue();
				}
			}	
		}
		
		// Set visit date cookie in current response
		Cookie currentVisitDateCookie = new Cookie(LAST_VISIT_COOKIE, (new Date()).toString());
		// Set cookie expiration to 1 week (in seconds)
		currentVisitDateCookie.setMaxAge(3600*24*7);
		response.addCookie(currentVisitDateCookie);
		
		// Add last visit date attribute to request
		request.setAttribute(LAST_VISIT_ATTR, lastVisitDate);
		// Forward the request to the next page
		request.getServletContext().getRequestDispatcher(WELCOME_JSP_PATH).forward(request, response);
	}
}
