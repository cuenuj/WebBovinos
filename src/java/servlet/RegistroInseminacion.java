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
import persistencia.Inseminacion;

/**
 *
 * @author cuenu
 */
public class RegistroInseminacion extends HttpServlet {

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
            ConsultasDAO dao = new ConsultasDAO();
            Consultas co=new Consultas();
            Inseminacion inseminacion = new Inseminacion();
            List<Inseminacion> DatosInsemina = new ArrayList<>();
            String respuesta ="";
            RequestDispatcher rd=null;
            
            try {
                if (request.getParameter("btn_regInseminacion")!= null) {
                    inseminacion.setId_inseminacion(request.getParameter("id_inseminacion"));
                    inseminacion.setId_animal(request.getParameter("id_animal"));
                    inseminacion.setId_veterinario(request.getParameter("cedula_veterinario"));
                    inseminacion.setFecha_inseminacion(request.getParameter("fecha_inseminacion"));
                    inseminacion.setRaza_pajilla(request.getParameter("raza_pajilla"));
                    inseminacion.setSexada(request.getParameter("sexada"));
                    inseminacion.setInseminacion_exitosa("No");
                    
                    respuesta=dao.insertarInseminacion(inseminacion);
                    request.setAttribute("respuesta", respuesta);
                    response.addCookie(new Cookie("mensaje", respuesta));
                    out.println("<head><link href=\"css/stylos1.css\" rel=\"stylesheet\"></head>");
                    out.println("<center><br/><br/><br/><h2 >"+respuesta+"</h2><br/><br/>"
                            + "<button onclick=\"self.location.href = 'panelUsuario.jsp'\">Regresar a Mi Finca</button></center>");
                    
                }else if(request.getParameter("btn_inseminacionExitosa") != null){
                    String id_inseminacion = request.getParameter("id_inseminacion");
                    String exito = request.getParameter("inseminacion_exitosa");
                    if (co.registroInseminacionExitosa(id_inseminacion, exito)) {
                      out.println("<script>");
                    out.println("alert('Se registró correctamente el exito de la inseminación!');");
                    out.println("location.href='http://localhost:8080/WebBovinos/panelUsuario.jsp';");
                    out.println("</script>");
                    }
                }
                rd = request.getRequestDispatcher("panelUsuario.jsp");
            } catch (Exception e) {
                System.err.println("error servelet... Inseminacion");
                e.printStackTrace();
            }
            
        }catch(Exception e){
            e.printStackTrace();
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
