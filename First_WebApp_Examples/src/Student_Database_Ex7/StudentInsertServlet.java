package Student_Database_Ex7;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Student_Database_Ex7.Student;
import Student_Database_Ex7.StudentDAO;

@WebServlet("/studentInsertService")

public class StudentInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		StudentDAO studentDAO = null;
		try {
			studentDAO = new StudentDAO();
		} catch (Exception e) {
			e.printStackTrace();
		}

		int studentId = -1;

		int postcode = -1;
		String idText = request.getParameter("txtId");
		String firstNameText = request.getParameter("txtFirstName");
		String lastNameText = request.getParameter("txtLastName");
		String streetaddressText = request.getParameter("txtStreet");
		String postcodeText = request.getParameter("txtPostcode");
		String postofficeText = request.getParameter("txtPostoffice");

		if (idText != null) {
			try {
				studentId = Integer.parseInt(idText);
			} catch (Exception ex) {
			}
		}

		if (postcodeText != null) {
			try {
				postcode = Integer.parseInt(postcodeText);
			} catch (Exception ex) {
			}
		}

		Student inputStudent = new Student(studentId, firstNameText, lastNameText, streetaddressText, postcode,
				postofficeText);

		int returnInt = studentDAO.insertStudent(inputStudent);

		String message = "OK";
		if (returnInt == 0) {
			message = ("Student data saved successfully.");
		} else if (returnInt == 1) {
			message = ("Cannot save the student data. Student " + studentId + " is already in used.");
		} else if (returnInt == -1) {
			message = ("The database is temporarily unavailable. Please try again later.");
		}

		request.setAttribute("confirmMessage", message);

		request.getRequestDispatcher("StudentInsert.jsp").forward(request, response);
	}

}
