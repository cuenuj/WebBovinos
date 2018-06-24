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
                    <li><a href="registroFuncionario.jsp">Registro usuario</a></li>
                    
                  </ul>
                </div>
              </nav>
        </div>
        <div class="tab-content col-xs-8 col-xs-offset-2">
            <pre class="bg-warning text-left h4 ">
                    Este sistema permite la gestión de información resultante de las actividades 
                    ganaderas en el municipio de Cómbita- Boyacá. El sistema permite el acceso a 
                    dos tipos de usuarios: funcionarios y dueños de fincas. El funcionario es 
                    quien tienen acceso a la información y reportes que se generan en cada una de
                    las fincas. Los dueños de las fincas son quienes ingresan la información de 
                    los bovinos y de algunas de las actividades más importantes en relación con la
                    actividad de ganadería. 
                  </pre>
            <pre class="bg-warning text-left h4 ">
                       <a class="text-center" > Secretaría De Innovación, Fomento Agropecuario Y Desarrollo Socioeconómico. </a>

                        <a class="text-center" >Misión</a>
                        La Secretaría de Innovación, Fomento Agropecuario y Desarrollo Socioeconómico 
                        tiene como misión lograr el desarrollo social, comunitario, turístico, agropecuario 
                        y económico del Municipio, mediante la formulación y ejecución de políticas, planes 
                        y programas sectoriales garantizando la participación ciudadana.

                                                
                        <a class="text-warning">Información de contacto</a>
                        Tel. (57) (8) 7310010
                        innovacionyfagropecuario@combita-boyaca.gov.co
                        Dirección: calle 3 No. 5-63
                        Correo electrónico: innovacionyfagropecuario@combita-boyaca.gov.co
                        Teléfono: (057) (8) 7310010

                        <a class="text-warning " >Nelson Rafael Parra</a>
                        Secretario de Innovación, Fomento Agropecuario y Desarrollo Socioeconómico

                        
                        <a class="text-warning  " >Horario de atención al público:</a> 
                        Lunes a Viernes de 8:00 a.m a 1:00 p.m 
                        y de 2:00 p.m a 5:00 p.m
                        
                        Visitanos en la Página web : 
                        <a class="text-center" href="http://www.combita-boyaca.gov.co" > http://www.combita-boyaca.gov.co</a>
                        

                  </pre>
        </div>
                
        <script src="js/jquery.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
    </body>
</html>
