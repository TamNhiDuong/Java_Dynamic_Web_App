<%-- The following two tags allow the use of the JSP and JSTL tags in this source text --%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <title>Student List</title>
	<link rel="stylesheet" type="text/css" href="css/WebAppExamples.css">
</head>
<%--My Code start from here--%>

<h1>Using JSP (JavaServerPage), Servlet program, DAO(DatabaseAcessObject)</h1>

<body>
	
	<div>
	    <h2>Search Student</h2>
	 
<%--ADDING FORM --%>
    
		<form action="studentListService" method="GET">
			<input type="text" name="txtId" />
			<input type="submit" value="Search" />
		</form>

		<%-- If this JSP page is requested with a parameter called 'studentList' 
		     and the list is not empty, then show the data in an HTML table.
		 --%>

	
					<c:out value="${ student}" />
			
		


		<%-- If the list is empty, then show an appropriate message --%>
		<c:if test="${ studentList != null && studentList.size() == 0 }">
			No student found for the given id: <c:out value="${ txtId }" />
		</c:if>
	</div>

</body>
</html> 