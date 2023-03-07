package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class DashboardServlet
 */
@WebServlet("/dashboard")
public class DashboardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DashboardServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    //-------------------------------------------------------------------------------------
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//the following 3 lines are used in order to avoid the cashing of the admin pages
		//by the browser, after we have logged out
		//NOTE: this must be used for all protected pages
		response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
		response.setHeader("Pragma", "no-cache");//http1.0
		response.setHeader("Pragma", "0");//proxies
		
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("id");
		
		//the following code is for avoiding to go to dashboard by an immediate typing of its URL link
		//NOTE: this must be used for all protected pages
		if (username != null) {
		
			PrintWriter out = response.getWriter();
			out.println("<h1>GET Request</h1>");
			out.println("<p>Welcome " + username + "</p>");
			out.println("<p><a href='classes'>Classes</a></p>");
			out.println("<p><a href='subjects'>Subjects</a></p>");
			out.println("<p><a href='teachers'>Teachers</a></p>");
			out.println("<p><a href='students'>Students</a></p>");
			out.println("<p><a href='logout'>Logout</a></p>");
		}
		else {
			response.sendRedirect("LoginPage.html");
		}
			
	}

    //-------------------------------------------------------------------------------------
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
