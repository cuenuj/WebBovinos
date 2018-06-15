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
import persistencia.ConsultasDAO;
import persistencia.DetalleHistorial;
import persistencia.HistoriaClinica;

/**
 *
 * @author cuenu
 */
public class RegistroHistoria extends HttpServlet {

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
            ConsultasDAO dao= new ConsultasDAO();
            Consultas co= new Consultas();
            HistoriaClinica historia= new HistoriaClinica();
            DetalleHistorial detalle = new DetalleHistorial();
            List<HistoriaClinica> listHistoria = new ArrayList<>();
            RequestDispatcher rd=null;
            String respuesta="";
            
            try {
                if (request.getParameter("btn_regHistoria")!= null) {
                    historia.setId_historia(request.getParameter("id_historia"));
                    historia.setId_animal(request.getParameter("id_animal"));
                    detalle.setFecha_historia(request.getParameter("fecha_historia"));
                    detalle.setObservaciones(request.getParameter("observaciones"));
                    detalle.setEnfermedad(request.getParameter("enfermedad"));
                    detalle.setDiagnostico(request.getParameter("diagnostico"));
                    detalle.setTratamiento(request.getParameter("tratamiento"));
                    detalle.setId_historial(request.getParameter("id_historia"));
                    detalle.setCedula_veterinario(request.getParameter("cedula_veterinario"));
                    
                    if( co.registrarHistoriaClinica(historia)){
                        respuesta=dao.insertarDetalleHistoria(detalle);
                        request.setAttribute("respuesta", respuesta);
                        response.addCookie(new Cookie("mensaje", respuesta));
                        out.println("<head><link href=\"css/stylos1.css\" rel=\"stylesheet\"></head>");
                        out.println("<center><br/><br/><br/><h2 >"+respuesta+"</h2><br/><br/>"
                            + "<button onclick=\"self.location.href = 'panelUsuario.jsp'\">Regresar a Mi Finca</button></center>");
                    
                    }else{
                        out.println("<script>");
                        out.println("alert('Error al registrar datos, por favor intente de nuevo');");
                        out.println("location.href='http://localhost:8080/WebBovinos/panelUsuario.jsp';");
                        out.println("</script>");
                        System.out.println("Error... dao.insertarHistoria es False");
                    }
                    
                   rd =request.getRequestDispatcher("PanelUsuario.jsp");
                }
            }catch(Exception e){
                e.printStackTrace();
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
