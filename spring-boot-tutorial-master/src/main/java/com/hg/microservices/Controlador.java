package com.hg.microservices;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class Controlador {


        private static final long serialVersionUID = 1L;

        /**
           * Processes requests for both HTTP <code>GET</code> and
           * <code>POST</code> methods.
           *
           * @param request servlet request
           * @param response servlet response
           * @throws ServletException if a servlet-specific error occurs
           * @throws IOException if an I/O error occurs
           */
          protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
          {

            System.out.println("hola");
            response.setContentType("text/html;charset=UTF-8");
            /*PrintWriter out = response.getWriter();
            out.println("<html><head><title>Tutorías</title></head>");
            out.println("<body>hola</body></html>");
            */ 
            RequestDispatcher dispatcher = request.getRequestDispatcher("/api/colegio/profesores");
                            
            if (dispatcher != null)
            {
              dispatcher.forward(request, response);
            }
          }

          /**
           * Handles the HTTP <code>GET</code> method.
           *
           * @param request servlet request
           * @param response servlet response
           * @throws ServletException if a servlet-specific error occurs
           * @throws IOException if an I/O error occurs
           */
          
          @RequestMapping (value="/saludo")
          protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
          {
                  processRequest(request, response);
          }

          /**
           * Handles the HTTP <code>POST</code> method.
           *
           * @param request servlet request
           * @param response servlet response
           * @throws ServletException if a servlet-specific error occurs
           * @throws IOException if an I/O error occurs
           */
          protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
          {
            processRequest(request, response);
          }

          /**
           * Returns a short description of the servlet.
           *
           * @return a String containing servlet description
           */
          public String getServletInfo()
          {
            return "Short description";
          }// </editor-fold>


}