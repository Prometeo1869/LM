<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8" import="com.hg.microservices.models.dto*, java.util.*" %>
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
<meta charset="UTF-8">
<title>Mostrar profesores</title>
</head>
<body>
<h1>PROFESORES en JSP</h1><br>
<% 
	List<TeacherDTO> lista = (List<TeacherDTO> request.getAttribute("profesores");
	Iterator<TeacherDTO> it = listado.iterator();
	out.println("<table border="2">);
	out.println("<tr><th>Nombre</th><th>Email</th><th>Salario</th><th>Cursos</th><tr>");
	while(it.hasNext()) {
		TeacherDTO t = (TeacherDTO) it.next();
			out.println("<tr><td>" + it.getName() + "</td><td>" + it.getEmail() + "</td><td>" + getSalario() + "</td>");
			Iterator<CourseDTO> c = t.getCourses().iterator();
			out.println("<td>");
			while(c.hasNext()) {
				out.printl(c.next().getName() + "</td></tr></table>"); %>
</body>
</html>