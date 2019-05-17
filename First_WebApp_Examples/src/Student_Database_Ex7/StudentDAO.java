package Student_Database_Ex7;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Student_Database_Ex7.ConnectionParameters;
import Student_Database_Ex7.Student;

public class StudentDAO {

	private final String username;
	private final String password;
	private final String databaseURL;

	public StudentDAO() throws Exception {
		username = ConnectionParameters.username;
		password = ConnectionParameters.password;
		databaseURL = ConnectionParameters.databaseURL;

		try {
			Class.forName(ConnectionParameters.jdbcDriver);
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}

	private Connection openConnection() throws SQLException {
		Connection dbConnection = DriverManager.getConnection(databaseURL, username, password);
		return dbConnection;
	}

	private void closeConnection(Connection dbConnection) throws SQLException {
		if (dbConnection != null) {
			dbConnection.close();
		}
	}

	// 1
	public ArrayList<Student> getAllStudents() throws SQLException {
		ArrayList<Student> StudentList = new ArrayList<Student>();
		Connection dbConnection = null;

		try {
			dbConnection = openConnection();

			String sqlText = "SELECT * FROM Student";

			PreparedStatement preparedStatement = dbConnection.prepareStatement(sqlText);

			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String firstname = resultSet.getString("firstname");
				String lastname = resultSet.getString("lastname");
				String streetaddress = resultSet.getString("streetaddress");
				int postcode = resultSet.getInt("postcode");
				String postoffice = resultSet.getString("postoffice");

				StudentList.add(new Student(id, firstname, lastname, streetaddress, postcode, postoffice));
			}
			return StudentList;

		} catch (SQLException sqle) {
			throw sqle;

		} finally {
			closeConnection(dbConnection);
		}
	}

	// 2
	public Student getStudentById(int studentId) throws SQLException {
		Connection dbConnection = null;

		try {
			dbConnection = openConnection();

			String sqlText = "SELECT * FROM Student WHERE id = ?";

			PreparedStatement preparedStatement = dbConnection.prepareStatement(sqlText);
			preparedStatement.setInt(1, studentId);

			ResultSet resultSet = preparedStatement.executeQuery();

			Student student = new Student();

			if (resultSet.next()) {

				int id = resultSet.getInt("id");
				String FirstName = resultSet.getString("firstname");
				String LastName = resultSet.getString("lastname");
				String StreetAddress = resultSet.getString("streetaddress");
				int PostCode = resultSet.getInt("postcode");
				String PostOffice = resultSet.getString("postoffice");

				student.setId(id);
				student.setFirstname(FirstName);
				student.setLastname(LastName);
				student.setStreetaddress(StreetAddress);
				student.setPostcode(PostCode);
				student.setPostoffice(PostOffice);

			}

			return student;

		} catch (SQLException sqle) {
			throw sqle;

		} finally {
			closeConnection(dbConnection);
		}
	}

	// 3
	public Student deleteStudent(int studentId) throws SQLException {
		Connection dbConnection = null;

		try {
			dbConnection = DriverManager.getConnection(databaseURL, username, password);

			String sqlText = "DELETE FROM Student WHERE id = ?";
			PreparedStatement preparedStatement = dbConnection.prepareStatement(sqlText);
			preparedStatement.setInt(1, studentId);

			preparedStatement.executeQuery();

			return null;

		} catch (SQLException sqle) {
			throw sqle;

		} finally {
			if (dbConnection != null) {
				try {
					dbConnection.close();
				} catch (SQLException sqle) {
					System.out.println("\nClose connection failed. \n" + sqle.getMessage());
				}
			}
		}

	}

	public int insertStudent(Student student) {

		Connection dbConnection = null;
		try {
			dbConnection = openConnection();

			String sqlText = "INSERT INTO Student (id, firstname, lastname, streetaddress, postcode, postoffice) VALUES (?, ?, ?, ?, ?, ?)";

			PreparedStatement preparedStatement = dbConnection.prepareStatement(sqlText);
			preparedStatement.setInt(1, student.getId());
			preparedStatement.setString(2, student.getFirstname());
			preparedStatement.setString(3, student.getLastname());
			preparedStatement.setString(4, student.getStreetaddress());
			preparedStatement.setInt(5, student.getPostcode());
			preparedStatement.setString(6, student.getPostoffice());

			preparedStatement.executeUpdate();

			return 0;
		} catch (SQLException sqle) {

			if (sqle.getErrorCode() == ConnectionParameters.PK_VIOLATION_ERROR) {
				return 1;
			} else {
				return -1;
			}

		} finally {
			if (dbConnection != null) {
				try {
					closeConnection(dbConnection);
				} catch (SQLException sqle) {
					System.out.println("\nClose connection failed. \n" + sqle.getMessage());
				}
			}
		}
	}

}