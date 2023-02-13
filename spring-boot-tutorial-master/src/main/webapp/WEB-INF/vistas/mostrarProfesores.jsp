<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.list"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Tutorías</title>
</head>

<body>
    <h1 align="center">Hola
        <%
        List<Teacher> lista;
            if(request.getParameter("profesores")!=null){
                lista = request.getParameter("profesores");
				//TODO: 
                out.println(request.getParameter("profesores"));
            }
        %>
    </h1><br>

    ${Teacher.getName}<br>
    ${Teacher.getDegree}<br>
</body>
</html>