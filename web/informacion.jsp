<%-- 
    Document   : informacion
    Created on : 23/04/2018, 11:27:11 PM
    Author     : cuenu
--%>
<%@page import="java.io.File"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/stylos1.css" rel="stylesheet">
        <title>Registro</title>
    </head>
    <body>
        <div class="container" style="padding-top: 1em;">
              <nav class="navbar navbar-default" role="navigation">
                <!-- El logotipo y el icono que despliega el menú se agrupan
                     para mostrarlos mejor en los dispositivos móviles -->
                <div class="navbar-header">
                  <button type="button" class="navbar-toggle" data-toggle="collapse"
                    data-target=".navbar-ex1-collapse">
                        <span class="sr-only">Desplegar navegación</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                  </button>
                  <a class="navbar-brand" >SIAGC</a>
                </div>

                <!-- Agrupar los enlaces de navegación, los formularios y cualquier
                     otro elemento que se pueda ocultar al minimizar la barra -->
                <div class="collapse navbar-collapse navbar-ex1-collapse">
                  <ul class="nav navbar-nav">
                    <li><a href="index.html">Inicio</a></li>
                    <li><a href="descarga.jsp">Descargas</a></li>
                    <li><a href="informacion.jsp">Información</a></li>
                    
                  </ul>

                  <ul class="nav navbar-nav navbar-right">
                    <li class="dropdown">
                      <a href="login.jsp" >Iniciar sesión </a>
                    </li>
                    <li class="dropdown">
                      <a href="#" class="dropdown-toggle" data-toggle="dropdown">Registro usuario <b class="caret"></b></a>
                      <ul class="dropdown-menu">
                          <li><a href="registroFuncionario.jsp">Funcionario secretaria fomento y desarrollo</a></li>
                        <li class="divider"></li>
                        <li><a href="registroUsuarios.jsp">Propietario Finca, Hato</a></li>
                      </ul>
                    </li>
                  </ul>
                </div>
              </nav>
        </div>
        
        
        <script src="js/jquery.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
    </body>
</html>
