package com.hg.microservices.models.dto;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.hg.microservices.models.Course;
import com.hg.microservices.models.Teacher;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TeacherDTO extends PersonDTO {
	public TeacherDTO() {

	}

	public Teacher obtenerDTOTeacher(JsonObject object) {

		Teacher tVO = new Teacher();
		Gson gson = new Gson();//

		tVO.setId(object.get("id").getAsString());
		tVO.setName(object.get("name").getAsString());
		tVO.setGender(object.get("gender").getAsString());
		tVO.setEmail(object.get("email").getAsString());
		tVO.setDegree(object.get("degree").getAsString());
		tVO.setSalary(object.get("salary").getAsDouble());

		List<Course> cursos = new LinkedList<>();
		JsonArray json = object.getAsJsonArray("courses");
		
		//String cur = gson.toJson(object.getAsJsonArray("courses"));//
		
		//if (!cur.equals("[]") && !cur.equals("null")) {//

			for (int i = 0; i < json.size(); i++) {
				JsonElement element = json.get(i);
				Course cursoVO = new Course();
				tVO.setName(element.getAsString());
				cursos.add(cursoVO);
			}
		//}//
		tVO.setCourses(cursos);

		return tVO;
	}

	public List<Teacher> obtenerDTO_listProfesores(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String url = "http://localhost:8081/api/colegio/profesores";
		List<Teacher> l = new LinkedList<Teacher>();

		try {
			HttpURLConnection conn = conexionURL(url);
			BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
			String output;

			while ((output = br.readLine()) != null) {
				JsonParser parser = new JsonParser();
				Object obj = parser.parse(output);
				JsonArray json = (JsonArray) obj;

				for (int i = 0; i < json.size(); i++) {
					JsonObject object = (JsonObject) json.get(i);
					l.add(obtenerDTOTeacher(object));
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

	public List<Teacher> obtenerDTO_listProfesores(String output) {
		List<Teacher> l = new LinkedList<Teacher>();
		JsonParser parser = new JsonParser();
		Object obj = parser.parse(output);
		JsonArray json = (JsonArray) obj;
		for (int i = 0; i < json.size(); i++) {
			JsonObject object = (JsonObject) json.get(i);
			l.add(obtenerDTOTeacher(object));
		}
		return l;
	}

}