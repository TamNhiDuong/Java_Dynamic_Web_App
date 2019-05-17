package Student_Database_Ex7;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import Student_Database_Ex7.Student;
import Student_Database_Ex7.StudentDAO;

	@WebServlet("/studentSearchService")
	public class StudentSearchServlet extends HttpServlet {
		private static final long serialVersionUID = 1L;

		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			try {
			Student student  = new Student();
			int givenId = -1;

			String studentId = request.getParameter("txtId");

			
			if (studentId != null) {
				try {
					givenId = Integer.parseInt(studentId);
				} catch (Exception ex) { 
					
				}
			}
			
			try {
				StudentDAO studentDAO;
				studentDAO = new StudentDAO();
				student = studentDAO.getStudentById(givenId);
			} catch (Exception e) {
				
				e.printStackTrace();
			}
					
			request.setAttribute("student", student);
			request.setAttribute("txtId", studentId);
			request.getRequestDispatcher("StudentSearch.jsp").forward(request, response);
		}catch(Exception e) {
			
		}

		}
	
	}