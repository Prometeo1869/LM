package com.hg.microservices;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Controlador {
    
    @RequestMapping(value="/saludo")
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        try {
            processRequest(request,response);
        } catch (ServletException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
//    @RequestMapping(value="/saludo")
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
//        try {
//            processRequest(request,response);
//        } catch (ServletException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        } catch (IOException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
        response.setContentType("text/html;charset=UTF-8");
        /*PrintWriter out = response.getWriter();
        out.print("<html><head><title>Tutorías</title></head>");
        out.print("<body>hola</body></html>");*/
        RequestDispatcher  dispacher = request.getRequestDispatcher("WEB-INF/vistas/index.jsp");
        if(dispacher != null) {
        	dispacher.forward(request, response);
        }
        
    }
    
    
}