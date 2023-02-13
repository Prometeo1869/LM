<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
<meta charset="UTF-8">
<title>Dar alta curso</title>
</head>
<body>
<h1>FORM desde JSP</h1>
<form th:object="${curso}" action="/api/colegio/curso" method="post">
        Profesor id: 	<input th:field="*{teacher:{id}}" type="text" name="teacher"><br></br>
        Nombre Curso:  	<input th:field="*{name}" type="text" name="name"><br></br>
        <input type="submit" value="Confirmar">
</form>
</body>
</html>