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

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.hg.microservices.models.Student;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentDTO extends PersonDTO {
	public StudentDTO() {
		
	}
	
	public Student obtenerDTOStudent(JsonObject object) {
		
		Student tVO = new Student();
		tVO.setId(object.get("id").toString());
		tVO.setName(object.get("name").toString());
		tVO.setGender(object.get("gender").toString());
		tVO.setEmail(object.get("email").toString());
		tVO.setSchoolarship(Boolean.parseBoolean(object.get("schoolarship").toString()));
		tVO.setState(Integer.getInteger(object.get("state").toString()));
		System.out.println(object.getAsJsonArray("courses").toString());

		return tVO;
		
	}

	public List<Student> obtenerDTO_listEstudiantes(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String url = "http://localhost:8080/api/colegio/estudiantes";
		List<Student> l = new LinkedList<Student>();

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
					l.add(obtenerDTOStudent(object));
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