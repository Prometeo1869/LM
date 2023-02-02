package com.iesvalleinclan.SpringAPP;

import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
import java.net.*;

@Controller
public class Controlador2 {

	@RequestMapping(value = "/listado")
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		processRequest(request, response);

	}

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String uri = "/api/colegio/profesores";

		String uri2 = "/WEB-INF/vistas/index.jsp";

		String url1 = "http://localhost:8080/api/colegio/profesores";

		response.setContentType("text/html;charset=UTF-8");

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

			System.out.println("Output from Server .... \n");

			while ((output = br.readLine()) != null) {

				System.out.println(output);

			}

			conn.disconnect();

		} catch (MalformedURLException e) {

			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();

		}

	}

}
