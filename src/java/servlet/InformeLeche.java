/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import persistencia.Consultas;
import persistencia.Leche;

/**
 *
 * @author cuenu
 */
public class InformeLeche extends HttpServlet {

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
            /* TODO output your page here. You may use following sample code. */
            Consultas co= new Consultas();
            Leche leche = new Leche();
            RequestDispatcher rd=null;
            java.util.Date fechaHoy = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("MM/DD/yyyy"); 
            try {
                if(request.getParameter("btn_informeLeche")!=null){
                                        
                    Date FechaIni=sdf.parse(request.getParameter("fecha_inicial"));
                    Date FechaFin=sdf.parse(request.getParameter("fecha_final"));
                    String id_usuario = request.getParameter("id_finca");
                    
                    if (FechaIni.before(fechaHoy) && FechaFin.before(fechaHoy)&& FechaIni.before(FechaFin)) {
                        
                        out.println("<script>");
                        out.println("alert('la finca en ese lapso de tiempo ha producido ... Litros de Leche" 
                            + "Producción de Leche!');");
                        out.println("location.href='http://localhost:8080/WebBovinos/panelFuncionario.jsp';");
                        out.println("</script>");   
                    }else{
                        out.println("<script>");
                        out.println("alert('Error en la fechas..  \n"
                                + "1. la fecha inicial debe ser menor a la fecha final  \n"
                                + "2. Ninguna de las fechas debe ser mayor al día de hoy \n" 
                                + "por favor verifique los datos e intente de nuevo.');");
                        out.println("location.href='http://localhost:8080/WebBovinos/panelFuncionario.jsp';");
                        out.println("</script>");
                    }
                    
                }
            } catch (Exception e) {
                out.println("<script>");
                    out.println("alert('Error consultando la Produccioón de leche... porfavor intente de nuevo!');");
                    out.println("location.href='http://localhost:8080/WebBovinos/panelFuncionario.jsp';");
                    out.println("</script>");
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
