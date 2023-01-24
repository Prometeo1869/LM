package com.hg.microservices;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.hg.microservices.models.dto.StudentDTO;
import com.hg.microservices.models.dto.TeacherDTO;

@Controller
public class Controlador4 {

	@RequestMapping(value = "/listadoJSP2")
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String uri2 = "/WEB-INF/vistas/index.jsp";
		List<TeacherDTO> l = obtenerDTO_list(request, response);
		Iterator<TeacherDTO> it = l.listIterator();
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<html><head><title>Listado de profesores</title></head>"
				+ "<body style='background:#384861'><center><h1 style='color:orange'>"
				+ "<b>LISTADO DE PROFESORES</b></h1></center><br>");

		while (it.hasNext()) {
			out.println(
					"<center><h2 style='color:white'>" + ((TeacherDTO) it.next()).toString() + "</h2></center><br>");
		}

		List<StudentDTO> m = obtenerDTO_listS(request, response);
		Iterator<StudentDTO> it2 = m.listIterator();
		out.println("<hr><center><h1><b>LISTADO DE ALUMNOS</b></h1></center><br>");

		while (it.hasNext()) {
			out.println(
					"<center><h2 style='color:white'>" + ((StudentDTO) it2.next()).toString() + "</h2></center><br>");
		}

		out.println("</body></html>");
	}

	protected List<TeacherDTO> obtenerDTO_list(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String uri = "/api/colegio/profesores";

		String url1 = "http://localhost:8081/api/colegio/profesores";
		List<TeacherDTO> l = new LinkedList<TeacherDTO>();
		TeacherDTO t;
		try {
			URL url = new URL(url1);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/json");

			if (conn.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
			}

			BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));

			String output;
			// tratar la lista de objetos JSON
			while ((output = br.readLine()) != null) {
				System.out.println(output.toString());
				JsonParser parser = new JsonParser();
				Object obj = parser.parse(output);
				JsonArray json = (JsonArray) obj;
				for (int i = 0; i < json.size(); i++) {

					JsonObject object = (JsonObject) json.get(i);
					// hay que parsear uno a uno los atributos del objeto Teacher y añadirlo a una
					// lista
					Gson gson = new Gson();

					String id = gson.toJson(object.get("id"));
					String name = gson.toJson(object.get("name"));
					String gender = gson.toJson(object.get("gender"));
					String degree = gson.toJson(object.get("degree"));
					double salario = Double.valueOf(gson.toJson(object.get("salary")));

					t = new TeacherDTO();
					t.setId(id);
					t.setName(name);
					t.setGender(gender);
					t.setDegree(degree);
					t.setSalary(salario);

					l.add(t);
				}

			}
			conn.disconnect();

		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return l;

	}

	protected List<StudentDTO> obtenerDTO_listS(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String uri = "/api/colegio/estudiantes";

		String url1 = "http://localhost:8081/api/colegio/estudiantes";
		List<StudentDTO> l = new LinkedList<StudentDTO>();
		StudentDTO t;
		try {
			URL url = new URL(url1);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/json");

			if (conn.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
			}

			BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));

			String output;
			// tratar la lista de objetos JSON
			while ((output = br.readLine()) != null) {
				System.out.println(output.toString());
				JsonParser parser = new JsonParser();
				Object obj = parser.parse(output);
				JsonArray json = (JsonArray) obj;
				for (int i = 0; i < json.size(); i++) {

					JsonObject object = (JsonObject) json.get(i);
					// hay que parsear uno a uno los atributos del objeto Teacher y añadirlo a una
					// lista
					Gson gson = new Gson();

					String id = gson.toJson(object.get("id"));
					String name = gson.toJson(object.get("name"));
					Boolean schoolarship = Boolean.valueOf(gson.toJson(object.get("schoolarship")));
					Integer state = Integer.valueOf(gson.toJson(object.get("state")));

					t = new StudentDTO();
					t.setId(id);
					t.setName(name);
					t.setSchoolarship(schoolarship);
					t.setState(state);

					l.add(t);
				}

			}
			conn.disconnect();

		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return l;

	}

}
