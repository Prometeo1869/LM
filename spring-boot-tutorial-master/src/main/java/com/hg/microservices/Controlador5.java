package com.hg.microservices;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hg.microservices.models.Course;
import com.hg.microservices.models.Student;
import com.hg.microservices.models.Teacher;
import com.hg.microservices.models.dto.TeacherDTO;

@Controller
public class Controlador5 {

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

	@RequestMapping(value = "/darAltaCurso")
	public void doGet2(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest2(request, response);
	}

	protected void processRequest2(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String uri = "/WEB-INF/vistas/registroCurso.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(uri);
		request.setAttribute("curso", new Course());
		if (dispatcher != null) {
			dispatcher.forward(request, response);
		}
	}
	
	@RequestMapping(value = "/listadoProfesoresJSP")
	public void doGet3(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest3(request, response);
	}

	protected void processRequest3(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String uri = "/WEB-INF/vistas/mostarProfesores.jsp";
		TeacherDTO teacher = new TeacherDTO();
		List<Teacher> lista = teacher.obtenerDTO_listProfesores(request, response);
		RequestDispatcher dispatcher = request.getRequestDispatcher(uri);
		request.setAttribute("profesores", lista);
		if (dispatcher != null) {
			dispatcher.forward(request, response);
		}
	}
}