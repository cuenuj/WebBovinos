<%-- 
    Document   : registroFuncionario
    Created on : 23/04/2018, 11:15:39 PM
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
        <div>
                <pre class="bg-info text-left h4 ">
                    NOTA: 
                    Recuerde que para registrar un 
                    nuevo Funcionario es nesesaria 
                    la autorización del administrador 
                    del sistema</pre>

        </div>
        <div  class="container ">
            <pre class="bg-warning text-left h4 ">
                    complete el siguiente formulario con sus datos y oprima el 
                    botón "Registrar", tenga en cuenta que todos los campos se 
                    deben completar.</pre>
                <form action="registrar" class="form-signin ">
                    <h3 class="form-signin-heading">Permiso de Administrador </h3>
                    <label for="PasswordAdmon" class="sr-only">Contraseña administrador</label>
                    <input type="password" id="PasswordAdmon" class="form-control" placeholder="contrasena administrador" required name="contrasena_funci">
                    <div class="checkbox">
                        
                    </div>
                    <h3 class="form-signin-heading">Datos del Funcionario </h3>
                    <input type="text" id="cedula" class="form-control" placeholder="Cedula" required autofocus name="cedula_usuario">
                    <input type="text" id="nombre" class="form-control" placeholder="Nombre" required autofocus name="nombre_usuario">
                    <input type="text" id="apellido" class="form-control" placeholder="Apellido" required autofocus name="apellido_usuario">
                    <input type="email" id="inputEmail" class="form-control" placeholder="Correo" required autofocus name="correo_usuario">
                    <input type="password" id="inputPassword" class="form-control" placeholder="Contraseña" required name="contrasena">
                    <input type="tel" id="telefono" class="form-control" placeholder="Telefono" required autofocus name="telefono">
                    <!--<h3 class="form-signin-heading">Cargo con el que contará como Funcionario </h3>
                    <input type="text" id="cargo" class="form-control" placeholder="Cargo" required autofocus name="cargo">-->
                    
                    <button class="btn btn-lg btn-primary btn-block" type="submit">Registrar </button>
                </form>
                <a  name="alerta" onclick="javascript:alert('Mensaje');">Vínculo</a>

            </div>
        <script src="js/jquery.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
    </body>
</html>
