<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
<meta charset="UTF-8">
<title>Dar alta profesores 2</title>
</head>
<body>
<h1>FORM desde JSP</h1>
<form th:object="${profesor}" action="/api/colegio/profesor" method="post">
        Grado:	 <input th:field="*{degree}" type="text" name="degree"><br></br>
        Salario: <input th:field="*{salary}" type="text" name="salary"><br></br>
        ID: 	 <input th:field="*{id}" 	 type="text" name="id"><br></br>
        Nombre:  <input th:field="*{name}" 	 type="text" name="name"><br></br>
        Género:  <input th:field="*{gender}" type="text" name="gender"><br></br>
        Email:   <input th:field="*{email}"  type="text" name="email"><br></br>
        <input type="submit" value="Confirmar">
</form>
</body>
</html>
<!-- https://parzibyte.me/blog/2019/08/26/procesar-formulario-spring-boot/ -->