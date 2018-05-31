/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import persistencia.Consultas;

/**
 *
 * @author cuenu
 */
public class RegistroVeterinario extends HttpServlet {

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
        
        String cedula_veterinario = request.getParameter("cedula_veterinario");
        String nombre_veterinario = request.getParameter("nombre_veterinario");
        String apellidos_veterinario = request.getParameter("apellidos_veterinario");
        String telefono = request.getParameter("telefono");
        String contrasena_funci = request.getParameter("contrasena_funcionario");
        
        
        Consultas co= new Consultas();
        if (co.RegistroVeterinario(contrasena_funci, cedula_veterinario, nombre_veterinario, apellidos_veterinario, telefono)) {
            response.addCookie(new Cookie("mensaje", co.getRespuesta()));
                    out.println("<center><br/><br/><br/><h2 >"+co.getRespuesta()+"</h2><br/><br/>"
                            + "<button onclick=\"self.location.href = 'panelUsuario.jsp'\">Regrezar a Mi Finca</button></center>");
                    
        }else{
            System.err.println("error en el servlet");
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
