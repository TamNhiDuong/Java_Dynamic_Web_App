package Student_Database_Ex7;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.List;

import Student_Database_Ex7.Student;
import Student_Database_Ex7.StudentDAO;

	@WebServlet("/studentListService")
	public class StudentListServlet extends HttpServlet {
		private static final long serialVersionUID = 1L;

		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

			List<Student> studentList = null;

			// Create the data to be sent to the JSP page
			StudentDAO studentDAO = new StudentDAO();

			studentList = studentDAO.getAllStudents();

			// Add the data to the request attributes
			request.setAttribute("studentList", studentList);

			// Forward the request back to the JSP page
			request.getRequestDispatcher("StudentList.jsp").forward(request, response);
		}

}
