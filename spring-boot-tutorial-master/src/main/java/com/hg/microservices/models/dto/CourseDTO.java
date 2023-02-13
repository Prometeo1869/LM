package com.hg.microservices.models.dto;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.hg.microservices.models.Course;

public class CourseDTO {
	
	private TeacherDTO teacherDTO;

	public CourseDTO(TeacherDTO teacherDTO) {

		this.teacherDTO = teacherDTO;

	}

	public Course obtenerDTOCourse(JsonObject object) {

		Course tVO = new Course();

		tVO.setKey(Long.parseLong(object.get("key").toString()));
		tVO.setName(object.get("name").toString());
		tVO.setTeacher(teacherDTO.obtenerDTOTeacher(object.get("teacher").getAsJsonObject()));
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		String fecha1 = object.get("start_date").toString();
		fecha1 = fecha1.substring(1, fecha1.length() - 1);
		tVO.setStart_date(LocalDate.parse(fecha1, formatter));
		System.out.println(object.get("start_date").toString());
		String fecha2 = object.get("ending_date").toString();
		fecha2 = fecha2.substring(1, fecha2.length() - 1);
		tVO.setEnding_date(LocalDate.parse(fecha2, formatter));
		System.out.println(object.get("ending_date").toString());

		return tVO;

	}

	public List<Course> obtenerDTO_listCursos(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String url = "http://localhost:8080/api/colegio/cursos";
		List<Course> l = new LinkedList<Course>();

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
					l.add(obtenerDTOCourse(object));
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
}
