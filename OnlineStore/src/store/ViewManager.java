package store;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ViewManager
 */
@WebServlet("/ViewManager")
public class ViewManager extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String COMMAND_PARAM = "command";
    
	private static final Object BROWSE_STORE_COMMAND = "browseStore";
	private static final Object VIEW_ITEMS_BY_CATEGORY_COMMAND = "viewItemsByCategory";
    
	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("ViewManager.service()");
		String command = request.getParameter(COMMAND_PARAM);
		String nextPage = null;
		if(command != null && !command.trim().isEmpty())
		{
			System.out.println(command);
			if(command.equals(BROWSE_STORE_COMMAND))
			{
				nextPage = "/browseStore.jsp";
			}
			else if(command.equals(VIEW_ITEMS_BY_CATEGORY_COMMAND))
			{
				nextPage = "/browseItemsjsp";
			}
		}
		if(nextPage != null)
		{
			this.getServletContext().getRequestDispatcher(nextPage).forward(request, response);
		}
	}

}
