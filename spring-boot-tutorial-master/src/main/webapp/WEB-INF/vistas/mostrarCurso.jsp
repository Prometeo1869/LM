<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="com.hg.microservices.models.*, java.util.*" %>
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
<meta charset="UTF-8">
<title>Mostrar curso</title>
</head>
<body>
	<h1>CURSO en JSP</h1>
	<br>
	<table border='2'>
<%
	List<Course> lista = (List<Course>) request.getAttribute("cursos"); 
	Iterator<Course> it = lista.iterator(); 
	out.println("<tr><th>Nombre</th><th>Profesor</th>"); 
	while(it.hasNext()) { 
		Course c = (Course)	it.next(); 
		out.println("<tr><td>" + c.getName() + "</td>"); 
		Teacher t = c.getTeacher(); 
		out.println("<td>" + t.getName() + "</td></tr>"); 
		}
	%> 
	</table>
</body>
</html>