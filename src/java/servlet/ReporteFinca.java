/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import com.sun.javafx.scene.control.skin.VirtualFlow;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import persistencia.Consultas;
import persistencia.ConsultasDAO;
import persistencia.Finca;

/**
 *
 * @author cuenu
 */
public class ReporteFinca extends HttpServlet {
/*Servlet de gestion para las fincas y la generacion del archivo pdf.
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
        response.setContentType("text/html:charset=UTF-8");
        try (PrintWriter out= response.getWriter()){
            ConsultasDAO dao = new ConsultasDAO();
            Consultas co=new Consultas();
            Finca finca = new Finca();
            List<Finca> datos = new ArrayList<>();
            String respuesta ="";
            RequestDispatcher rd=null;
            
            String criterio; 
            try {
                if (request.getParameter("btn_registro")!= null) {
                    finca.setId_finca(request.getParameter("id_finca"));
                    finca.setNombre_finca(request.getParameter("nombre_finca"));
                    finca.setCordenada_latitud(request.getParameter("cordenada_latitud"));
                    finca.setCordenada_longitud(request.getParameter("cordenada_longitud"));
                    finca.setId_dueno(request.getParameter("cedula"));
                    finca.setId_lugar(request.getParameter("i_lugar"));
                    
                    respuesta=dao.insertar(finca);
                    request.setAttribute("respuesta", respuesta);
                    response.addCookie(new Cookie("mensaje", respuesta));
                        out.println("<head><link href=\"css/stylos1.css\" rel=\"stylesheet\"></head>");
                        out.println("<center><br/><br/><br/><h2 >"+respuesta+"</h2><br/><br/>"
                            + "<button onclick=\"self.location.href = 'panelUsuario.jsp'\">Regresar a Mi Finca</button></center>");
                    
                }else if(request.getParameter("btn_modificar")!= null){
                    finca.setId_finca(request.getParameter("id_finca"));
                    finca.setNombre_finca(request.getParameter("nombre_finca"));
                    finca.setCordenada_latitud(request.getParameter("cordenada_latitud"));
                    finca.setCordenada_longitud(request.getParameter("cordenada_longitud"));
                    finca.setId_dueno(request.getParameter("cedula"));
                    finca.setId_lugar(request.getParameter("i_lugar"));
                    
                    respuesta=dao.modificar(finca);
                    request.setAttribute("respuesta", respuesta);
                    response.addCookie(new Cookie("mensaje", respuesta));
                        out.println("<head><link href=\"css/stylos1.css\" rel=\"stylesheet\"></head>");
                        out.println("<center><br/><br/><br/><h2 >"+respuesta+"</h2><br/><br/>"
                            + "<button onclick=\"self.location.href = 'panelUsuario.jsp'\">Regrezar a Mi Finca</button></center>");
                    
                }else if(request.getParameter("btn_eliminar")!= null){
                    String finc = request.getParameter("codigo_finca");
                    dao.eliminar(finc);
                    request.setAttribute("respuesta", respuesta);
                    out.println("<script>");
                    out.println("alert('Se elimino la finca "+finca+"!');");
                    out.println("location.href='http://localhost:8080/WebBovinos/panelFuncionario.jsp';");
                    out.println("</script>");
                    
                }else if(request.getParameter("btn_buscar")!= null){
                    criterio = request.getParameter("codigo_finca");
                    datos = (List<Finca>) co.filtrar(criterio);
                    request.setAttribute("filtro", datos);
                }
                else if(request.getParameter("btn_lista")!= null){
                    datos = (List<Finca>) co.Consultar();
                    request.setAttribute("filtro", datos);
                }
                else if(request.getParameter("btn_informePDF")!=null){
                    ReportePdfUsuario pdfFun= new ReportePdfUsuario();
                }
                rd = request.getRequestDispatcher("panelFuncionario.jsp");
            } catch (Exception e) {
                e.printStackTrace();
                    out.println("alert('Sin acceso a finca... porfavor intente de nuevo.');");
                    
            }
            rd.forward(request, response);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        
 //       persistencia.ListaFinca fincas = new persistencia.ListaFinca();                
//        String[][] fincasR= fincas.mostrar();
 //       request.setAttribute("fincas", fincasR);
 //       RequestDispatcher rd = request.getRequestDispatcher("mostrarfincas.jsp");
 //       rd.forward(request, response);
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
