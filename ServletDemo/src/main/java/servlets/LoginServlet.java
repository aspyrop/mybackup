package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;

import database.AdminDatabase;
import javax.servlet.http.HttpSession;


/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginPage")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	//-------------------------------------------------------------------------------------
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	//-------------------------------------------------------------------------------------
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("LoginPage.html");
	}

	//-------------------------------------------------------------------------------------
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//the following 3 lines are used in order to avoid the cashing of the admin pages
		//by the browser, after we have logged out
		//NOTE: this must be used for all protected pages
//		response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
//		response.setHeader("Pragma", "no-cache");//http1.0
//		response.setHeader("Pragma", "0");//proxies
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		System.out.println(username);
		System.out.println(password);
		
		AdminDatabase db = new AdminDatabase();
				
		try {
			if (db.validateAdmin(username, password)) {
				HttpSession session = request.getSession();
				session.setAttribute("username", username); //important: we set here the param to be passed on to other JSPs or servlets
				response.sendRedirect("AdminPage.jsp"); //URL
			}
			else {
				response.sendRedirect("LoginPage.jsp?error=Invalid admin credentials");
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
			response.sendRedirect("LoginPage.jsp?error=Something went wrong; contact administrator"); //URL
		}
	}
}
