/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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
/*Servlet de gestion para los informes de la producción de leche.
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
            /* TODO output your page here. You may use following sample code. */
            Consultas co= new Consultas();
            Leche leche = new Leche();
            int valor_leche=0;
            int sumaLitros=0;
            int produccion=0;
            List<Leche> listaLeche = new ArrayList<>();
            try {
                if(request.getParameter("btn_informeLeche")!=null){
                    String finca = request.getParameter("nombre_finca");
                    valor_leche = Integer.parseInt(request.getParameter("valor_leche"));
                    
                    listaLeche = co.CantidadLitrosLeche(finca);
                    for(Leche l: listaLeche){
                        sumaLitros = sumaLitros + l.getLitros_leche();
                              
                    }
                    produccion= sumaLitros*valor_leche;
                    
                    out.println("<head><link href=\"css/stylos1.css\" rel=\"stylesheet\">");
                    out.println("<title>(FUN)Inseminación</title>");            
                    out.println("</head>");
                    out.println("<body><br/><br/>");
                    out.println("<center><h1>Informe Producción de Leche ");
                    
                    out.println("<pre>Los litros de leche producidos por la Finca  "+finca+" son "+sumaLitros+" <br/>"
                            + "los cuales han tenido una producción monetaria de "+produccion+" pesos. </pre>");
                    out.println("<br/>"
                    + "<button onclick=\"self.location.href = 'panelFuncionario.jsp'\">Regresar al panel Principal</button></center><br/><br/>");
                    out.println("</center></body>");
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
