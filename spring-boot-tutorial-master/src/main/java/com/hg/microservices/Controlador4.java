package com.hg.microservices;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hg.microservices.models.Course;
import com.hg.microservices.models.Student;
import com.hg.microservices.models.Teacher;
import com.hg.microservices.models.dto.CourseDTO;
import com.hg.microservices.models.dto.StudentDTO;
import com.hg.microservices.models.dto.TeacherDTO;

@Controller
public class Controlador4 {
	
	private TeacherDTO teacherDTO = new TeacherDTO();
	private StudentDTO studentDTO = new StudentDTO();
	private CourseDTO courseDTO = new CourseDTO(teacherDTO);

	@RequestMapping(value = "/listadoJSPProfesores")
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		processRequest(request, response);
		
	}

	@RequestMapping(value = "/listadoJSPEstudiantes")
	public void doGet2(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		processRequest2(request, response);
		
	}

	@RequestMapping(value = "/listadoJSPCursos")
	public void doGet3(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		processRequest3(request, response);
		
	}

	public void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String uri = "/WEB-INF/vistas/index.jsp";
		
		List<Teacher> l = teacherDTO.obtenerDTO_listProfesores(request, response);
		
		System.out.println(l.toString());
		
		response.setContentType("text/html;charset=UTF-8");
						
		request.setAttribute("profesores", l);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(uri);

		if (dispatcher != null){
			
			dispatcher.forward(request, response);
			
		}
		
	}

	public void processRequest2(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String uri = "/WEB-INF/vistas/index.jsp";
		
		List<Student> l = studentDTO.obtenerDTO_listEstudiantes(request, response);
		
		Iterator<Student> it = l.listIterator();
		
		response.setContentType("text/html;charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		
		out.println("<html><head><title>Listado de estudiantes</title></head><body>");

		while (it.hasNext()) {
			
			Student t = (Student) it.next();
			
			out.println("<h2>" + t.getName() + " : " + t.getEmail() + "</h2><br>");
			
		}

		out.println("</body></html>");
		
	}

	public void processRequest3(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String uri = "/WEB-INF/vistas/index.jsp";
		
		List<Course> l = courseDTO.obtenerDTO_listCursos(request, response);
		
		Iterator<Course> it = l.listIterator();
		
		response.setContentType("text/html;charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		
		out.println("<html><head><title>Listado de cursos</title></head><body>");

		while (it.hasNext()) {
			
			Course t = (Course) it.next();
			
			
			out.println("<h2>" + t.getName() + " : " + t.getTeacher().getName() + " : " + t.getStart_date() + "</h2><br>");
		}

		out.println("</body></html>");

	}

	public HttpURLConnection conexionURL(String url1) throws IOException {
		
		URL url = new URL(url1);
		
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		
		conn.setRequestMethod("GET");
		
		conn.setRequestProperty("Accept", "application/json");
		
		if (conn.getResponseCode() != 200) {
			
			throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
			
		}
		
		return conn;
		
	}
	
}