/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import persistencia.Animal;
import persistencia.Consultas;
import persistencia.DetalleHistorial;
import persistencia.Finca;
import persistencia.Inseminacion;

/**
 *
 * @author cuenu
 */
public class ReportePdfFuncionario extends HttpServlet {
/*Servlet de gestion la creacion del archivo pdf del Funcionario.
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
            Consultas co=new Consultas();
            List<Finca> datos = new ArrayList<>();
            List<Inseminacion> listInsemina = new ArrayList(); 
            String respuesta ="";
            RequestDispatcher rd=null;
            String nomfinca=request.getParameter("nombre_finca");
            
            List<Animal> animal = new ArrayList();
            List<DetalleHistorial> historia = new ArrayList();
            
            String criterio;
            try {
                if (request.getParameter("btn_informePDF")!= null && request.getParameter("nombre_finca")!=null) {
                 datos = co.filtrarFinca(nomfinca);
                 listInsemina = co.listaInseminacionFuncionario(nomfinca);
                 //se genera el archivo PDF
                 String Titulo = "SIAG - Sistema de Información para la Administración Ganadera de Cómbita"+"\n"+"\n"+"\n"+"\n";
                 String encabezado = "Reporte MI Finca del usuario:  "+nomfinca+"\n"+"\n";
                 String parrafo ="A continuación encontrará la infomación de los animales existentes, "
                         + "seguido de las Inseminaciones y los controles  de enfermedades que se han realizado en esta finca "+"\n"+"\n"
                         +"Contenido:"+"\n" 
                         + "1.  Lista de animales existentes en la Finca "+"\n"
                         + "2.  Inseminaciones realizadas en la finca "+"\n"
                         + "3.  Control de Enfermedades en la Finca "+"\n"+"\n";
                 String tituloanimales ="1.  Lista de animales existentes en la Finca"+"\n"+"\n";
                 String enfermedades ="\n"+"\n"+"3.  Control de Enfermedades en la Finca "+"\n"+"\n";
                 java.util.Date fechaHoy = new Date();
                 Font fuente= new Font(Font.getFamily("Arial"),14,Font.BOLD);
                 Font fuente1 = new Font(Font.getFamily("Arial"),12);
                 Font fuente2 = new Font(Font.getFamily("Arial"),12,Font.UNDERLINE);
                 Paragraph p= new Paragraph(Titulo,fuente);   
                 Paragraph p1= new Paragraph(encabezado,fuente2);
                 Paragraph p2= new Paragraph("Fecha de Reporte:  "+String.valueOf(fechaHoy)+"\n"+"\n");
                 Paragraph p8= new Paragraph(tituloanimales,fuente);
                 Paragraph p9= new Paragraph(enfermedades,fuente);
                 Paragraph p10= new Paragraph(parrafo,fuente1);
                    PdfPTable tabla= new PdfPTable(10);
                    tabla.setWidthPercentage(100);
                    PdfPTable tablaEnfermedad= new PdfPTable(5);
                    tablaEnfermedad.setWidthPercentage(100);
                    PdfPTable tablaInse = new PdfPTable(7);
                    tablaInse.setWidthPercentage(100);
                    
                    Document documento = new Document(PageSize.A4);
                    String file="c:/Reportes_Bovinos/Reporte_FINCA_"+nomfinca+".pdf";
                    
                    PdfWriter.getInstance(documento,new FileOutputStream(file));
                    
                    PdfPCell cel1 = new PdfPCell(new Paragraph("Código animal",FontFactory.getFont("arial",10,Font.BOLD,BaseColor.BLUE)));
                    PdfPCell cel2 = new PdfPCell(new Paragraph("Nombre animal",FontFactory.getFont("arial",10,Font.BOLD,BaseColor.BLUE)));
                    PdfPCell cel3 = new PdfPCell(new Paragraph("Fecha Nacimiento",FontFactory.getFont("arial",10,Font.BOLD,BaseColor.BLUE)));
                    PdfPCell cel4 = new PdfPCell(new Paragraph("Raza",FontFactory.getFont("arial",10,Font.BOLD,BaseColor.BLUE)));
                    PdfPCell cel5 = new PdfPCell(new Paragraph("Género",FontFactory.getFont("arial",10,Font.BOLD,BaseColor.BLUE)));
                    PdfPCell cel6 = new PdfPCell(new Paragraph("Método concepción",FontFactory.getFont("arial",10,Font.BOLD,BaseColor.BLUE)));
                    PdfPCell cel7 = new PdfPCell(new Paragraph("Etapa animal",FontFactory.getFont("arial",10,Font.BOLD,BaseColor.BLUE)));
                    PdfPCell cel8 = new PdfPCell(new Paragraph("Padre",FontFactory.getFont("arial",10,Font.BOLD,BaseColor.BLUE)));
                    PdfPCell cel9 = new PdfPCell(new Paragraph("Madre",FontFactory.getFont("arial",10,Font.BOLD,BaseColor.BLUE)));
                    PdfPCell cel10 = new PdfPCell(new Paragraph("Observaciones",FontFactory.getFont("arial",10,Font.BOLD,BaseColor.BLUE)));
                   
                    PdfPCell cel11 = new PdfPCell(new Paragraph("Fecha aparición enfermedad",FontFactory.getFont("arial",10,Font.BOLD,BaseColor.BLUE)));
                    PdfPCell cel12 = new PdfPCell(new Paragraph("Nombre enfermedad",FontFactory.getFont("arial",10,Font.BOLD,BaseColor.BLUE)));
                    PdfPCell cel13 = new PdfPCell(new Paragraph("Diagnóstico",FontFactory.getFont("arial",10,Font.BOLD,BaseColor.BLUE)));
                    PdfPCell cel14 = new PdfPCell(new Paragraph("Tratamiento",FontFactory.getFont("arial",10,Font.BOLD,BaseColor.BLUE)));
                    PdfPCell cel15 = new PdfPCell(new Paragraph("Identificación del Veterinario",FontFactory.getFont("arial",10,Font.BOLD,BaseColor.BLUE)));
                    
                    PdfPCell cel16 = new PdfPCell(new Paragraph("Código inseminación",FontFactory.getFont("arial",10,Font.BOLD,BaseColor.BLUE)));
                    PdfPCell cel17 = new PdfPCell(new Paragraph("Código animal",FontFactory.getFont("arial",10,Font.BOLD,BaseColor.BLUE)));
                    PdfPCell cel18 = new PdfPCell(new Paragraph("Fecha inseminacion",FontFactory.getFont("arial",10,Font.BOLD,BaseColor.BLUE)));
                    PdfPCell cel19 = new PdfPCell(new Paragraph("Raza Pajilla",FontFactory.getFont("arial",10,Font.BOLD,BaseColor.BLUE)));
                    PdfPCell cel20 = new PdfPCell(new Paragraph("Sexada",FontFactory.getFont("arial",10,Font.BOLD,BaseColor.BLUE)));
                    PdfPCell cel21 = new PdfPCell(new Paragraph("Veterinario",FontFactory.getFont("arial",10,Font.BOLD,BaseColor.BLUE)));
                    PdfPCell cel22 = new PdfPCell(new Paragraph("Insemianción exitosa",FontFactory.getFont("arial",10,Font.BOLD,BaseColor.BLUE)));
                    
                    documento.open();
                    documento.add(p);
                    documento.add(p1);
                    documento.add(p2);
                    
                    for(Finca f :datos){
                        String idFinca="Nombre dueño de la Finca:  "+f.getNombreDueno()+"  "+f.getApellidoDueno();
                        String nombreFinca="Codigó de Finca:  "+f.getId_finca();
                        String DueñoFinca="Nombre de Finca:  "+f.getNombre_finca()+"\n"+"\n"+"\n"+"\n";
                      Paragraph p5= new Paragraph(idFinca,fuente);
                      Paragraph p6= new Paragraph(nombreFinca,fuente);
                      Paragraph p7= new Paragraph(DueñoFinca,fuente);
                      documento.add(p5);
                      documento.add(p6);
                      documento.add(p7);
                    }
                    documento.add(p10);
                    documento.add(p8);
                    
                    tabla.addCell(cel1);
                    tabla.addCell(cel2);
                    tabla.addCell(cel3);
                    tabla.addCell(cel4);
                    tabla.addCell(cel5);
                    tabla.addCell(cel6);
                    tabla.addCell(cel7);
                    tabla.addCell(cel8);
                    tabla.addCell(cel9);
                    tabla.addCell(cel10);
                    
                    animal = co.filtraAnimalNombre(nomfinca);
                    int cuentaA=0;
                    for(Animal a :animal){
                        tabla.addCell(a.getId_animal());
                        tabla.addCell(a.getNombre_animal());
                        tabla.addCell(a.getFecha_nacimiento());
                        tabla.addCell(a.getRaza_animal());
                        tabla.addCell(a.getGenero_animal());
                        tabla.addCell(a.getMetodo_concepcion());
                        tabla.addCell(a.getEtapa_vida());
                        tabla.addCell(a.getNombrePadre());
                        tabla.addCell(a.getNombreMadre());
                        tabla.addCell(a.getObservaciones());
                        cuentaA++;
                    }
                    documento.add(tabla);
                    
                    String nombreFinca="Número de animales Listados:  "+cuentaA +"\n"+"\n";
                    Paragraph p11 = new Paragraph(nombreFinca,fuente);
                    documento.add(p11);
                    String TituloInsemina ="2. Inseminaciones realizadas en la Finca"+"\n"+"\n";
                    Paragraph p12 = new Paragraph(TituloInsemina,fuente);
                    documento.add(p12);
                    
                    tablaInse.addCell(cel16);
                    tablaInse.addCell(cel17);
                    tablaInse.addCell(cel18);
                    tablaInse.addCell(cel19);
                    tablaInse.addCell(cel20);
                    tablaInse.addCell(cel21);
                    tablaInse.addCell(cel22);
                    
                    int cuentaInsemina = 0;
                    for (Inseminacion i: listInsemina){
                        tablaInse.addCell(i.getId_inseminacion());
                        tablaInse.addCell(i.getId_animal());
                        tablaInse.addCell(i.getFecha_inseminacion());
                        tablaInse.addCell(i.getRaza_pajilla());
                        tablaInse.addCell(i.getSexada());
                        tablaInse.addCell(i.getId_veterinario());
                        tablaInse.addCell(i.getInseminacion_exitosa());
                        cuentaInsemina++;
                    }
                    documento.add(tablaInse);
                    
                    String numInsemina="Número de Inseminaciones:  "+cuentaInsemina;
                    Paragraph p13 = new Paragraph(numInsemina,fuente);
                    documento.add(p13);
                    
                    documento.add(p9);
                    tablaEnfermedad.addCell(cel11);
                    tablaEnfermedad.addCell(cel12);
                    tablaEnfermedad.addCell(cel13);
                    tablaEnfermedad.addCell(cel14);
                    tablaEnfermedad.addCell(cel15);
                    
                    historia = co.listaHistoriaFuncionario(nomfinca);
                    for(DetalleHistorial d :historia){
                        tablaEnfermedad.addCell(d.getFecha_historia());
                        tablaEnfermedad.addCell(d.getEnfermedad());
                        tablaEnfermedad.addCell(d.getDiagnostico());
                        tablaEnfermedad.addCell(d.getTratamiento());
                        tablaEnfermedad.addCell(d.getCedula_veterinario());
                    }
                    documento.add(tablaEnfermedad);
                    documento.close();
                    
                 out.println("<script>");
                 out.println("alert('Se generó exitosamente el PDF!');");
                 out.println("location.href='http://localhost:8080/WebBovinos/panelFuncionario.jsp';");
                 out.println("</script>");
                } else{
                    out.println("<script>");
                   out.println("alert('No se puede generar el archivo! ...Verifique el nombre de la finca e intente de nuevo');");
                   out.println("location.href='http://localhost:8080/WebBovinos/panelFuncionario.jsp';");
                   out.println("</script>");  
                }
            
            }catch(Exception e){
                e.printStackTrace();
                out.println("<script>");
                 out.println("alert('Error de conexion');");
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
