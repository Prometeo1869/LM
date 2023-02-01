<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Tutorías</title>
</head>

<body style="margin-left:50px">
<h2>FORMULARIO PROFESORES</h2>
	<form action="obtenerDTO_listProfesores" method="get">
		<p>ID:</p><input type="text" name="id"><br><br> 
		<p>NOMBRE:</p><input type="text" name="name"><br><br> 
		<p>GÉNERO:</p><input type="text" name="gender"><br><br>
		<p>EMAIL:</p><input type="text" name="email"><br><br> 
		<p>GRADO:</p><input type="text" name="degree"><br><br> 
		<p>SALARIO:</p><input type="number" name="salary"><br><br>
		<p><input type="submit" value="Enviar"></p>
	</form>
</body>
</html>