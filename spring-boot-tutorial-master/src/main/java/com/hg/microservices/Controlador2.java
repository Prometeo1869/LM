package com.hg.microservices;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
public class Controlador2 {
        

          @RequestMapping (value="/listado")
          protected void doGet(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {
                  processRequest(request, response);
          }

          protected void processRequest(HttpServletRequest request,
              HttpServletResponse response)
                throws ServletException, IOException {
                

            String uri= "/api/colegio/profesores";
            String uri2="/WEB-INF/vistas/index.jsp";        
            String  url1="http://localhost:8081/api/colegio/profesores";
                               response.setContentType("text/html;charset=UTF-8");
                          
        try {
                URL url = new URL(url1);
                HttpURLConnection conn = (HttpURLConnection)    url.openConnection();
         conn.setRequestMethod("GET");
                conn.setRequestProperty("Accept", "application/json");

             if (conn.getResponseCode() != 200) {
                        throw new RuntimeException("Failed : HTTP error code : "+ conn.getResponseCode());
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