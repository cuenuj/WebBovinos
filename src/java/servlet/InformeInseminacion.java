/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import persistencia.Consultas;
import persistencia.Inseminacion;

/**
 *
 * @author cuenu
 */
public class InformeInseminacion extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            Consultas co= new Consultas();
            Inseminacion inseminacion = new Inseminacion();
            List<Inseminacion> datos = new ArrayList();
            String respuesta ="";
            RequestDispatcher rd=null;
            String criterio;
            
            if (request.getParameter("btn_inseminacionesFinca")!=null) {
                criterio = request.getParameter("codigo_finca");
                response.addCookie(new Cookie("mensaje", respuesta));
                datos = co.ListarInseminacionFinca(criterio);
                out.println("<table border=\"2\">"
                        + "<tr>\n" +
                            "<td>Código de Inseminacion</td>\n" +
                            "<td>Fecha de Inseminación</td>\n" +
                            "<td>Raza Pajilla</td>\n" +
                            "<td>Sexada</td>\n" +
                            "<td>Inseminador</td>\n" +
                            "<td>Código de la Res</td>\n" +
                            "<td>resultado Inseminación</td>\n" +
                            "</tr>");
                
                for(Inseminacion i :datos){
                    out.println("<tr>\n" +
                            "<td>"+i.getId_inseminacion()+"</td>\n" +
                            "<td>"+i.getFecha_inseminacion()+"</td>\n" +
                            "<td>"+i.getRaza_pajilla()+"</td>\n" +
                            "<td>"+i.getSexada()+"</td>\n" +
                            "<td>"+i.getId_veterinario()+"</td>\n" +
                            "<td>"+i.getId_animal()+"</td>\n" +
                            "<td>"+i.getInseminacion_exitosa()+"</td>\n" +
                            "</tr>");
                    
                 
                }
                request.setAttribute("filtro", datos);
                
                        out.println("<center><br/><br/><br/><h2 >"+respuesta+"</h2><br/><br/>"
                            + "<button onclick=\"self.location.href = 'panelFuncionario.jsp'\">Regrezar </button></center>");
                    
            }
            
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
