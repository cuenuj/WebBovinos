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
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import persistencia.Animal;
import persistencia.Consultas;
import persistencia.ConsultasDAO;
import persistencia.Finca;

/**
 *
 * @author cuenu
 */
public class registrarAnimal extends HttpServlet {

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
        try (PrintWriter out= response.getWriter()){
            ConsultasDAO dao = new ConsultasDAO();
            Consultas co=new Consultas();
            Animal animal = new Animal();
            List<Animal> datosA = new ArrayList<>();
            String respuesta ="";
            RequestDispatcher rd=null;
            
            String criterio;
            try{
                if (request.getParameter("btn_registroAnimal")!= null) {
                    animal.setId_animal(request.getParameter("id_animal"));
                    animal.setNombre_animal(request.getParameter("nombre_animal"));
                    animal.setFecha_nacimiento(request.getParameter("fecha_nacimiento"));
                    animal.setRaza_animal(request.getParameter("raza_animal"));
                    animal.setGenero_animal(request.getParameter("genero_animal"));
                    animal.setMetodo_concepcion(request.getParameter("metodo_concepcion"));
                    animal.setFoto_animal(request.getParameter("files[]"));
                    animal.setObservaciones(request.getParameter("observaciones"));
                    animal.setId_finca(request.getParameter("id_finca"));
                    
                    respuesta=dao.insertarAnimal(animal);
                    request.setAttribute("respuesta", respuesta);
                    
                }else if(request.getParameter("btn_buscarAnimal")!= null){
                    criterio = request.getParameter("codigo_finca");
                    datosA = (List<Animal>) co.filtrarAnimal(criterio);
                    request.setAttribute("filtroA", datosA);
                }
                rd = request.getRequestDispatcher("panelFuncionario.jsp");
            }catch (Exception e){
                e.printStackTrace();
            }
            rd.forward(request, response);
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
