<%-- 
    Document   : mostrarfincas
    Created on : 18/05/2018, 01:45:18 AM
    Author     : cuenu
--%>

<%@page import="persistencia.Finca"%>
<%@page import="java.util.LinkedList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/stylos1.css" rel="stylesheet">
        <link href="css/Panel.css" rel="stylesheet">
        <title>Finca</title>
    </head>
    <body>
        <h1>fincas...</h1>
        <br/>
        
        <a class="btn btn-lg btn-primary btn-block" href="panelFuncionario.jsp">Regresar</a>
        <br/>
        <br/>
        <h1>Lista de la tabla empresa:</h1>
        
        <table border="2">
            <tr>
                <th>id_finca</th>
                <th>Dueño</th>
                                
            </tr>
            <c:forEach var="listaFincas" items="${f}">
			<tr>
				<td><c:out value="${f.finca}"/></td>
				<td><c:out value="${f.dueno}"/></td>
				
                        </tr>
		</c:forEach>
        </table>
        <br/>
        <a class="btn btn-lg btn-primary btn-block" href="">Imprimir PDF</a>
        
        <script src="js/jquery.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="js/panelFun.js"></script>
    </body>
</html>
