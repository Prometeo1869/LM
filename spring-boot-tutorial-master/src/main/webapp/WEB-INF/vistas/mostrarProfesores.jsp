<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="com.hg.microservices.models.*, java.util.*" %>
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
<meta charset="UTF-8">
<title>Mostrar profesores</title>
</head>
<body>
	<h1>PROFESORES en JSP</h1>
	<br>
<%
	List<Teacher> lista = (List<Teacher>) request.getAttribute("profesores"); 
	Iterator<Teacher> it = lista.iterator(); 
	out.println("<table border='2'>"); 
	out.println("<tr><th>Nombre</th><th>Email</th><th>Salario</th><th>Cursos</th><tr>"); 
	while(it.hasNext()) { 
		Teacher t = (Teacher)	it.next(); 
		out.println("<tr><td>" + t.getName() + "</td><td>" + t.getEmail() + "</td><td>" + t.getSalary() + "</td>"); 
		Iterator<Course> c = t.getCourses().iterator(); 
		out.println("<td>"); 
		while(c.hasNext()) { 
			out.println(c.next().getName() + "</td></tr></table>"); 
		}}
	%> 
</body>
</html>