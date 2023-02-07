<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Tutorías</title>
</head>

<body>
    <h1 align="center">Hola
        <%
        //List<Teacher> lista = request.getParameter("profesores");
            if(request.getParameter("profesores")!=null){
                out.println(request.getParameter("profesores"));
            }
        %>
    </h1><br>

    ${Teacher.getName}<br>
    ${Teacher.getDegree}<br>
</body>
</html>