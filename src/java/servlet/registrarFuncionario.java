/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javafx.scene.web.WebEvent;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import jdk.nashorn.internal.runtime.regexp.joni.Syntax;
import persistencia.Consultas;

/**
 *
 * @author cuenu
 */
public class registrarFuncionario extends HttpServlet {
/*Servlet de gestion del perfil del funcionario.
        */
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String contrasenaFunci = request.getParameter("contrasena_funci");
        String cedula = request.getParameter("cedula_usuario");
        String nombre = request.getParameter("nombre_usuario");
        String apellido = request.getParameter("apellido_usuario");
        String correo = request.getParameter("correo_usuario");
        String contrasena = request.getParameter("contrasena");
        String telefono = request.getParameter("telefono");
        
        
        Consultas co= new Consultas();
        if (co.RegistroUsuario(contrasenaFunci, cedula, nombre, apellido, correo, contrasena, telefono)) {
            
                out.println("<script>");
                out.println("alert('Se registro correctamente un nuevo Ganadero o Dueño de finca!');");
                out.println("location.href='http://localhost:8080/WebBovinos/login.jsp';");
                out.println("</script>");
            System.out.println("Guadado exitoso!!");
                //ventana de guardado-.......
                
                       
        }else{
            //response.sendRedirect("login.jsp");
            System.err.println("no guarda");
            response.sendRedirect("registroFuncionario.jsp");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
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
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
