package store;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import online.store.core.StoreItems;

/**
 * Servlet implementation class Controller
 */
@WebServlet(
		urlPatterns = { "/Controller" }, 
		initParams = { 
				@WebInitParam(name = "email", value = "support@online.store")
		})
public class Controller extends HttpServlet {
	private static final String EMAIL_ATTR = "email";

	private static final long serialVersionUID = 1L;
    
	private String supportMail;
    private int hitCounter;
    private StoreItems store;
    
    @Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		store = new StoreItems();
		supportMail = config.getInitParameter(EMAIL_ATTR);
		System.out.println("Controller.init()");
		System.out.println("supportMail has been initialised with : '" + supportMail + "'");
	}

	@Override
	public void destroy() {
		super.destroy();
		System.out.println("Controller.destroy()");
	}


   @Override
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
	   System.out.println("Controller.service()");
	}

}
