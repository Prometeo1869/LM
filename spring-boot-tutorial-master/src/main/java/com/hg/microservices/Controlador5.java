package com.hg.microservices;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hg.microservices.models.Course;
import com.hg.microservices.models.Teacher;
import com.hg.microservices.models.dto.CourseDTO;
import com.hg.microservices.models.dto.TeacherDTO;

@Controller
public class Controlador5 {

	//DAR ALTA PROFESOR
	@RequestMapping(value = "/darAltaProfesor")
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String uri2 = "/WEB-INF/vistas/registroProfesor2.jsp";

		response.setContentType("text/html;charset=UTF-8");
		request.setAttribute("profesor", new Teacher());
		RequestDispatcher dispatcher = request.getRequestDispatcher(uri2);
		if (dispatcher != null) {
			dispatcher.forward(request, response);
		}
	}

	//JSP DAR ALTA CURSO
	@RequestMapping(value = "/darAltaCurso")
	public void doGet2(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest2(request, response);
	}

	protected void processRequest2(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String uri = "/WEB-INF/vistas/registroCurso.jsp";
		
		response.setContentType("text/html;charset=UTF-8");
		request.setAttribute("curso", new Course());
		RequestDispatcher dispatcher = request.getRequestDispatcher(uri);
		
		if (dispatcher != null) {
			dispatcher.forward(request, response);
		}
	}
	
	//JSP MOSTRAR PROFESORES
	@RequestMapping(value = "/listadoProfesoresJSP")
	public void doGet3(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest3(request, response);
	}

	protected void processRequest3(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String uri = "/WEB-INF/vistas/mostrarProfesores.jsp";
		TeacherDTO teacher = new TeacherDTO();
		List<Teacher> lista = teacher.obtenerDTO_listProfesores(request, response);
		RequestDispatcher dispatcher = request.getRequestDispatcher(uri);
		request.setAttribute("profesores", lista);
		if (dispatcher != null) {
			dispatcher.forward(request, response);
		}
	}
	
	//JSP MOSTRAR CURSOS
	@RequestMapping(value = "/listadoCursosJSP")
	public void doGet4(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest4(request, response);
	}

	protected void processRequest4(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String uri = "/WEB-INF/vistas/mostrarCurso.jsp";
		CourseDTO curso = new CourseDTO();
		List<Course> lista = curso.obtenerDTO_listCursos(request, response);
		RequestDispatcher dispatcher = request.getRequestDispatcher(uri);
		request.setAttribute("cursos", lista);
		if (dispatcher != null) {
			dispatcher.forward(request, response);
		}
	}
	
}