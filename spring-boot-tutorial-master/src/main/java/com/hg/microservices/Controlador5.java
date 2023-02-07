package com.hg.microservices;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import com.hg.microservices.models.Teacher;

@Controller
public class Controlador5 {
        
        @GetMapping("/darAltaProfesor")
         protected void doGet2(HttpServletRequest request,
                         HttpServletResponse response)
         throws ServletException, IOException {
                 String uri2="/WEB-INF/vistas/registroProfesor2.jsp";
                        RequestDispatcher dispatcher =
                        request.getRequestDispatcher(uri2);
                        request.setAttribute("profesor", new Teacher());
                        if (dispatcher != null){
                                 dispatcher.forward(request, response);
                        }
         }
}