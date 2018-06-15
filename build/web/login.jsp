<%-- 
    Document   : login
    Created on : 23/04/2018, 11:21:12 PM
    Author     : cuenu
--%>
<%@page import="java.io.File"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
    <title>Gestion de Bovinos</title>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/stylos1.css" rel="stylesheet">
        
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
                    <li><a href="registroFuncionario.jsp">Registro usuario</a></li>
                    
                  </ul>
                </div>
              </nav>
            </div>
            <center>
                <div class="container ">
                    <h1>SIAGC</h1>
                    <h3><a class="text-center h4" >Sistema de Información para la Administración Ganadera de Cómbita </a></h3>
                    
                    <pre class="lead h1 bg">IDENTIFICACIÓN DE USUARIOS PARA INGRESO AL SISTEMA</pre>
                 
                    <pre class="bg-warning text-left h4 ">
                        Para ingresar al sistema es nesesario la autenticación de usuario, por favor 
                        ingrese su correo y contraseña luego pulse el botón "Iniciar".</pre>
                </div>
                
            </center>
            <div class="container">

                <form action="iniciar" class="form-signin" id="forminicio">
                    <h2 class="form-signin-heading text-center">DATOS DE USUARIO </h2>
                    <label for="inputEmail" class="sr-only">Correo de usuario</label>
                    <input type="email" id="inputEmail" class="form-control" placeholder="correo" required autofocus name="correo">
                    <label for="inputPassword" class="sr-only">Contraseña</label>
                    <input type="password" id="inputPassword" class="form-control" placeholder="contraseña" required name="contrasena">
                    <div class="checkbox">

                        
                    </div>
                    <button class="btn btn-lg btn-primary btn-block" type="submit">Iniciar  </button>
                    <a href=""> olvido la clave? </a>
                    
                </form>

            </div>
            <div>
                <pre class="bg-info text-left h4 ">
                    NOTA: 
                    Si aun no tiene una cuenta con nosotros. puede solicitar el registro 
                    al funcionario de la alcaldía o el administrador del sistema.
                    </pre>

            </div>
            
        <script src="js/jquery.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        
    </body>
</html>
