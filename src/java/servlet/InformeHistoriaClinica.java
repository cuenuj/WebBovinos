/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import com.sun.javafx.scene.control.skin.VirtualFlow;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import persistencia.Consultas;
import persistencia.DetalleHistorial;
import persistencia.Inseminacion;

/**
 *
 * @author cuenu
 */
public class InformeHistoriaClinica extends HttpServlet {

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
            List<DetalleHistorial> detHist = new ArrayList<>();
            String respuesta ="";
            RequestDispatcher rd=null;
            String criterio;
                      
            if (request.getParameter("btn_enfermedad_finca")!=null) {
                criterio = request.getParameter("nombre_fincaH");
            
                out.println("<head><link href=\"css/stylos1.css\" rel=\"stylesheet\">");
                out.println("<title>(FUN)Historia Clinica</title>");            
                out.println("</head>");
                out.println("<body><br/><br/>");
                
                out.println("<center><h1>Informe de Historias Clinicas  ");
                if(request.getParameter("nombre_fincaH").equals("")){
                        out.println("<center><pre class=\"bg-warning text-left h4 \"> No hay datos para mostrar!!"
                                + "Por favor verifique el nombre de la finca e intente de nuevo.</pre></center>");

                    }else{
                        out.println("<center><pre class=\"bg-warning text-left h4 \"> Historias Clinicas Realizadas en la Finca "+criterio+"</pre></center>");
                    }
                out.println("<center><table border=\"2\" color=\"Blue\">"
                        + "<tr>\n" +
                            "<td>Fecha</td>\n" +
                            "<td>observacones</td>\n" +
                            "<td>Enfermedad</td>\n" +
                            "<td>Diagnostico</td>\n" +
                            "<td>Tratamiento</td>\n" +
                            "<td>código historia</td>\n" +
                            "<td>veterinario</td>\n" +
                            "</tr>");
                detHist = co.listaHistoriaFuncionario(criterio);
                for(DetalleHistorial dH : detHist){
                    out.println("<tr>\n" +
                            "<td>"+dH.getFecha_historia()+"</td>\n" +
                            "<td>"+dH.getObservaciones()+"</td>\n" +
                            "<td>"+dH.getEnfermedad()+"</td>\n" +
                            "<td>"+dH.getDiagnostico()+"</td>\n" +
                            "<td>"+dH.getTratamiento()+"</td>\n" +
                            "<td>"+dH.getId_historial()+"</td>\n" +
                            "<td>"+dH.getCedula_veterinario()+"</td>\n" +
                            "</tr>");
                }
                out.println("</table>");
                out.println("<center><br/>"
                    + "<button onclick=\"self.location.href = 'panelFuncionario.jsp'\">Regresar al panel Principal</button></center><br/><br/>");
                
                out.println("</center></body>");
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
