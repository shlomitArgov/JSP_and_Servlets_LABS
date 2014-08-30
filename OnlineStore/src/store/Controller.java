package store;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import helpers.ShoppingCart;

import org.apache.catalina.connector.Request;

import online.store.core.StoreItems;

/**
 * Servlet implementation class Controller
 */
@WebServlet(urlPatterns = { "/Controller" }, initParams = { @WebInitParam(name = "email", value = "support@online.store") })
public class Controller extends HttpServlet
{
	private static final String EMAIL_ATTR = "email";

	private static final long serialVersionUID = 1L;
	private static final String COMMAND_PARAM = "command";

	private static final Object START_SHOPPING_COMMAND = "startShopping";
	private static final Object CLEAR_COMMAND = "clear";

	private static final String SHOPPING_CART_ATTR = "cart";

	private String supportMail;
	private int hitCounter;
	private StoreItems store;

	@Override
	public void init(ServletConfig config) throws ServletException
	{
		super.init(config);
		store = new StoreItems();
		supportMail = config.getInitParameter(EMAIL_ATTR);
		System.out.println("Controller.init()");
		System.out.println("supportMail has been initialised with : '"
				+ supportMail + "'");
	}

	@Override
	public void destroy()
	{
		super.destroy();
		System.out.println("Controller.destroy()");
	}

	@Override
	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException
	{
		System.out.println("Controller.service()");
		String command = request.getParameter(COMMAND_PARAM);

		if (command != null)
		{
			if (command.equals(START_SHOPPING_COMMAND))
			{
				handleStartShoppingCommand(request);
			} else if (command.equals(CLEAR_COMMAND))
			{
				handleClearCommand(request);
			}
		}
	}

	private void handleStartShoppingCommand(HttpServletRequest request)
	{
		// Get HTTP session
		HttpSession session = request.getSession(true);
		// Check if the session is new or pre-existing
		if (session.isNew())
		{
			// Add an instance of shopping cart as a session attribute if this
			// is a new session
			ShoppingCart cart = new ShoppingCart();
			request.getSession().setAttribute(SHOPPING_CART_ATTR, cart);
		}
	}

	private void handleClearCommand(HttpServletRequest request)
	{
		HttpSession session = request.getSession(false);
		ShoppingCart cart = (ShoppingCart) session.getAttribute(SHOPPING_CART_ATTR);
		cart.clear();
	}
}
