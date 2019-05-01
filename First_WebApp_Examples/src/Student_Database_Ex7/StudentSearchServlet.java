package Student_Database_Ex7;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class StudentSearchServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String studentList = null;
		//Suppose
		int givenId = -1;
		
		// Retrieve the values of the request parameters
		String idText = request.getParameter("txtId");

		if (idText != null) {
			try {
				givenId = Integer.parseInt(idText);
			} catch (Exception ex) { }
		}

		// Create the data to be sent to the JSP page
		StudentDAO studentDAO = new StudentDAO();

		if (givenId > 0) {
			studentList = studentDAO.getStudentsForGivenId(givenId);
		} 

		// Add the data to the request attributes
		request.setAttribute("studentList", studentList);
		request.setAttribute("txtId", idText);

		// Forward the request back to the JSP page
		request.getRequestDispatcher("StudentSearch.jsp").forward(request, response);
}
}
