<%-- 
    Document   : ListaAnimales
    Created on : 21/05/2018, 06:07:11 AM
    Author     : cuenu
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="persistencia.Animal"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <%
        List<Animal> datosA = new ArrayList();
    %>
    <body>
        
        
            <div class="card">
                        <%
                            
                                
                        %>
                        
        <div class="card-header alert-success text-center ">FINCAS DE COMBITA </div>
                        
                            <table class="table table-striped" border="2">
                                <tr>
                                    <td>Código de la Finca</td>
                                    <td>Código del animal</td>
                                    <td>Nombre del animal</td>
                                    <td>Fecha de Nacimiento</td>
                                    <td>Raza</td>
                                    <td>Genero</td>
                                    <td>Metodo de concepcion</td>
                                    <td>Foto del animal</td>
                                    <td>Observaciones</td>
                                </tr>
                                <%
                                    
                                    datosA = (List<Animal>) request.getAttribute("filtro");
                                    for(Animal a :datosA){
                                 %>
                                 <tr>
                                     <td> <%= a.getId_finca() %> </td>
                                     <td> <%= a.getId_animal()%> </td>
                                     <td> <%= a.getNombre_animal()%> </td>
                                     <td> <%= a.getFecha_nacimiento()%> </td>
                                     <td> <%= a.getRaza_animal()%> </td>
                                     <td> <%= a.getGenero_animal()%> </td>
                                     <td> <%= a.getMetodo_concepcion()%> </td>
                                     <td> <%= a.getFoto_animal()%> </td>
                                     <td> <%= a.getObservaciones()%> </td>
                                     
                                 </tr>

                                 <%
                                     
                                    }
                                    
                                %>
                            </table>
                    
                    </div>
                    <div class="form-signin-heading navbar-right">
                        <a class="btn btn-lg btn-primary btn-block" href="panelFuncionario.jsp.jsp">Regresar</a>
                    <a class="btn btn-lg btn-primary btn-block" href="">Imprimir </a>
                </div>
    </body>
</html>
