package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HomeServlet
 */
@WebServlet("/home")
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HomeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("GET");
		
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		String passwd = request.getParameter("passwd");
		
		PrintWriter out = response.getWriter();
		
		out.println("<h1>Welcome from GET!</h1>");
		out.println("parameter 1 is = " + fname + "<br>");
		out.println("parameter 2 is = " + lname + "<br>");
		out.println("parameter 3 is = " + passwd + "<br>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("POST");

		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		String passwd = request.getParameter("passwd");
		
		PrintWriter out = response.getWriter();
		
		out.println("<h1>Welcome from POST!</h1>");
		out.println("parameter 1 is = " + fname + "<br>");
		out.println("parameter 2 is = " + lname + "<br>");
		out.println("parameter 3 is = " + passwd + "<br>");
	}

}
