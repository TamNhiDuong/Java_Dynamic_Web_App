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

	@WebServlet("/studentSearchService")
	public class StudentSearchServlet extends HttpServlet {
		private static final long serialVersionUID = 1L;

		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

			List<Student> studentList = null;

			String student ="";
			int givenId = -1;


			// 1. Retrieve the values of the request parameters
			String Idtext = request.getParameter("txtId");

			if (Idtext != null) {
				try {
					givenId = Integer.parseInt(Idtext);
				} catch (Exception ex) { }
			}

			// 2. Create the data to be sent to the JSP page
			StudentDAO studentDAO = new StudentDAO();

			student= studentDAO.getStudentById(givenId);


			// 3. Add the data to the request attributes
			request.setAttribute("studentList", studentList);

			request.setAttribute("txtId", givenId);
			request.setAttribute("student", student);

			// 4. Forward the request back to the JSP page
			
			request.getRequestDispatcher("StudentSearch.jsp").forward(request, response);

		}
}