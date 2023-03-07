package servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.StudentDatabase;
import entity.Student;

/**
 * Servlet implementation class AdminServlet
 */
@WebServlet("/AdminServletxxxxxxxxxxxx")
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    //--------------------------------------------------------------------------------------------
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println(getServletContext().getContextPath() );
		
		StudentDatabase db = new StudentDatabase();
		try {
			List<Student> students = db.getAllStudents();
			RequestDispatcher dispatcher = request.getRequestDispatcher("AdminPage.jsp");
			request.setAttribute("students", students);
			dispatcher.forward(request, response);
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}


}
