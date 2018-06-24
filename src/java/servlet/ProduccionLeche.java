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
import persistencia.Leche;


/**
 *
 * @author cuenu
 */
public class ProduccionLeche extends HttpServlet {
/*Servlet de gestion para el registro de la producción de leche
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
        try (PrintWriter out = response.getWriter()) {
           ConsultasDAO dao = new ConsultasDAO();
            Consultas co=new Consultas();
            Leche leche = new Leche();
            List<Leche> listLeche = new ArrayList<>();
            String respuesta ="";
            RequestDispatcher rd=null;
            
            try {
                if (request.getParameter("btn_regLeche")!= null) {
                    leche.setFecha_leche(request.getParameter("fecha_leche"));
                    leche.setLitros_leche(Integer.parseInt(request.getParameter("litros_leche")));
                    leche.setId_animal(request.getParameter("id_animal"));
                    
                    respuesta = dao.insertarLeche(leche);
                    request.setAttribute("respuesta", respuesta);
                    
                    out.println("<script>");
                    out.println("alert('Se registro Producción de Leche!');");
                    out.println("location.href='http://localhost:8080/WebBovinos/panelUsuario.jsp';");
                    out.println("</script>");
                }
            }catch(Exception e){
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
