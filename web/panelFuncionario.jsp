<%-- 
    Document   : panelFuncionario
    Created on : 23/04/2018, 11:21:12 PM
    Author     : cuenu
--%>
<%@page import="persistencia.Animal"%>
<%@page import="persistencia.Consultas"%>
<%@page import="persistencia.ConsultasDAO"%>
<%@page import="java.util.*"%>
<%@page import="persistencia.Finca"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    HttpSession objSesion = request.getSession(false);
    String usuario = (String) objSesion.getAttribute("usuario");
    if(usuario.equals("")){
        response.sendRedirect("login.jsp");
    }
%>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/stylos1.css" rel="stylesheet">
        <link href="css/Panel.css" rel="stylesheet">
        <link href="jquery-ui.min.css" rel="stylesheet">
        <script src="js/alertas.js"></script>
        <link rel="stylesheet" type="text/css" media="all" href="css/calendar-win2k-cold-1.css" title="win2k-cold-1" />
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.8.0/css/bootstrap-datepicker.css">
        
        <title>Funcionario</title>
    </head>
    <% 
        Consultas co= new Consultas();
        List<Finca> datos = new ArrayList();
        List<Animal> datosA = new ArrayList();


    %>
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
        <div class="nav nav-tabs col-xs-10 col-xs-offset-1">
            <a class="h1 col-lg-offset-1">Bienvenido!! </a>
            <a class="h3 col-lg-offset-1">   <% out.println(usuario);%></a>
        </div>
        <ul class="nav nav-tabs col-xs-10 col-xs-offset-1  text-uppercase bg-info h5 ">
            <li><a href="#tab-fincasTotales" data-toggle="tab"> Fincas de Cómbita</a></li>
            <li><a href="#tab-finca" data-toggle="tab">Nueva Finca</a></li>
            <li><a href="#tab-veterinario" data-toggle="tab">Nuevo Veterinario</a></li>
            <li><a href="#tab-leche" data-toggle="tab">Producción de Leche<i class="fa"></i></a></li>
            <li><a href="#tab-insemina" data-toggle="tab">Inseminaciones<i class="fa"></i></a></li>
            <li><a href="#tab-enfermedades" data-toggle="tab">Enfermedades<i class="fa"></i></a></li>
            <li><a href="#tab-ubica" data-toggle="tab">Ubicación<i class="fa"></i></a></li>
        </ul>

        
        <div></div>
        <div class="form-horizontal">
            <div class="tab-content col-xs-8 col-xs-offset-2"><br/><br/>
                <div class="tab-pane active " id="tab-fincasTotales">
                    <form action="ConsultaFinca" method="get" >
                        <span class=" input-group-addon">Código Finca
                        <input type="text" class="form-control" placeholder="Buscador" name="codigo_finca">
                        <button class="btn btn-default" name="btn_buscar" type="submit" >Buscar</button>
                        <button class="btn btn-default" name="btn_eliminar" type="submit" >Eliminar</button>
                        <button class="btn btn-default" name="btn_informePDF" type="submit" >Generar Informe PDF</button>
                        <button class="btn btn-default" name="btn_lista" type="submit" >Ver Lista Completa</button>
                        </span>
                    </form>
                    <br/>
                    <div class="card">
                        <div class="card-header alert-success text-center ">LISTADO TOTAL DE LAS FINCAS DE CÓMBITA </div><br/>
                            <table class="table table-striped" border="2">
                                <tr>
                                    <td>Código de Finca</td>
                                    <td>Nombre de Finca</td>
                                    <td>Extencion de Finca</td>
                                    <td>Cedula del Dueño</td>
                                    <td>Ubicación</td>
                                </tr>
                                <%
                                    if(request.getAttribute("filtro")!= null){
                                        datos = (List<Finca>) request.getAttribute("filtro");
                                    }else{
                                       datos = co.Consultar(); 
                                    }
                                    
                                    for(Finca f :datos){
                                 %>
                                 <tr>
                                     <td> <%= f.getId_finca() %> </td>
                                     <td> <%= f.getNombre_finca()%> </td>
                                     <td> <%= f.getExtencion_finca()%> </td>
                                     <td> <%= f.getId_dueno()%> </td>
                                     <td> <%= f.getId_lugar()%> </td>
                                 </tr>

                                 <%

                                    }
                                %>
                            </table>
                    
                    </div>
                                
                </div>
                <div class="tab-pane" id="tab-finca">
                    <form action="ConsultaFinca" method="get" >
                    <div class="card">
                            <div class="card-header alert-success text-center ">REGISTRAR NUEVA FINCA</div><br/>
                            <div class="card-body">
                                <div class="form-group">
                                    <label class="control-label col-sm-5" for="id_finca">Código único de Finca:</label>
                                    <div class="col-sm-7">
                                        <input type="text" class="form-control" id="id_finca" placeholder="número identificación Finca" name="id_finca">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="control-label col-sm-5" for="nombre_finca">Nombre de Finca:</label>
                                    <div class="col-sm-7">
                                        <input type="text" class="form-control" id="nombre_finca" placeholder="Nombre de la Finca" name="nombre_finca">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="control-label col-sm-5" for="extencion_finca">Extencion de la Finca(Mts):</label>
                                    <div class="col-sm-7">
                                        <input type="text" class="form-control" id="extencion_finca" placeholder="Extencion de la Finca" name="extencion_finca">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="control-label col-sm-5" for="cedula">Número de Cédula del Dueño:</label>
                                    <div class="col-sm-7">
                                        <input type="text" class="form-control" id="cedula" placeholder="número cédula del duaño" name="cedula">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="control-label col-sm-5" for="i_lugar">Lugar de Ubicacion:</label>
                                    <div class="col-sm-7">
                                        <input type="text" class="form-control" id="i_lugar" placeholder="Lugar de ubicación Finca" name="i_lugar">
                                    </div>
                                </div>
                                <div class="form-group"> 
                                        <div class="col-sm-offset-4 col-sm-10">
                                          <button type="submit" class="btn btn-default btn-primary" name="btn_registro">Registrar Finca</button>
                                        </div>
                                </div>
                            </div>
                    </div>
                    </form>
                    
                    
                </div>
                
                 <div class="tab-pane" id="tab-veterinario">
                    <form role="form" method="post" action="regVeterinario">
                        <div class="card">
                            <div class="card-header alert-success text-center ">DATOS DEL MEDICO VETERINARIO</div><br/>
                            <div class="card-body">
                                
                                    <div class="form-group">
                                        <label class="control-label col-sm-5" for="id_animal">Número de Identificación Veterinario:</label>
                                        <div class="col-sm-7">
                                            <input type="text" class="form-control" id="cedula_veterinario" placeholder="número identificación" name="cedula_veterinario">
                                        </div>
                                      </div>
                                      <div class="form-group">
                                        <label class="control-label col-sm-5" for="nombre_animal">Nombre del Veterinario:</label>
                                        <div class="col-sm-7"> 
                                            <input type="text" class="form-control" id="nombre_veterinario" placeholder="nombre del veterinario" name="nombre_veterinario">
                                        </div>
                                      </div>
                                      <div class="form-group">
                                        <label class="control-label col-sm-5" for="apellidos_animal">Apellidos del Veterinario:</label>
                                        <div class="col-sm-7"> 
                                            <input type="text" class="form-control" id="apellidos_veterinario" placeholder="Apellidos del veterinario" name="apellidos_veterinario">
                                        </div>
                                      </div>
                                        
                                        <div class="form-group">
                                            <label class="control-label col-sm-5" for="telefono">Telefono de contacto:</label>
                                            <div class="col-sm-7">
                                                <input type="text" class="form-control" id="telefono" placeholder="telefono" name="telefono">
                                            </div>
                                        </div>
                                        <div class="card">
                                            <div class="card-header alert-success text-center ">DATOS DEL FUNCIONARIO</div><br/>
                                                <div class="card-body">
                                                    <div class="form-group">
                                                            <label class="control-label col-sm-5" for="telefono">Contraseña del Funcionario:</label>
                                                            <div class="col-sm-7">
                                                                <input type="password" id="inputPassword" class="form-control" placeholder="contraseña" required name="contrasena_funcionario">
                                                            </div>
                                                        </div>
                                                </div>

                                        </div>
                                      <div class="form-group"> 
                                        <div class="col-sm-offset-4 col-sm-10">
                                          <button type="submit" class="btn btn-default btn-primary">Registrar Veterinario</button>
                                        </div>
                                      </div>
                                        
                            </div>
                        </div>
                            
                    </form>
                </div>   
                
                
                <div class="tab-pane" id="tab-leche">
                    <div class="card-header alert-success text-center ">PRODUCCIÓN DE LECHE DE LAS FINCAS ENTRE FECHAS  </div><br/>
                    <div class="card-body">
                        <form role="form" method="post" action="infoLeche">
                            <div class="form-group">
                                <label class="control-label col-sm-5" for="fecha_inicial">Fecha inicial</label>
                                <div class="col-sm-7"> 
                                    <input type="text" id="datepickerj" name="fecha_inicial" placeholder="Fecha inicial">
                                </div>
                            </div>

                            <div class="card-body">
                                <div class="form-group">
                                    <label class="control-label col-sm-5" for="fecha_final">Fecha Final</label>
                                    <div class="col-sm-7"> 
                                        <input type="text" id="datepickerK" name="fecha_final" placeholder="Fecha final">
                                    </div>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-sm-5" for="id_finca">Código único de Finca:</label>
                                <div class="col-sm-7">
                                    <input type="text" class="form-control" id="id_finca" placeholder="número identificación Finca" name="id_finca">
                                </div>
                            </div>
                            <div class="form-group"> 
                                <div class="col-sm-offset-4 col-sm-10">
                                   <button type="submit" class="btn btn-default btn-primary" name="btn_informeLeche">ver informe</button>
                                </div>
                            </div>
                        </form>
                </div>
                    </div>
                <div class="tab-pane" id="tab-insemina">
                    <div class="card-header alert-success text-center ">INSEMINACIONES POR FINCAS  </div><br/>
                    <div class="card-body">
                        <form role="form" method="post" action="infoInseminacion">
                            <span class=" input-group-addon">Busqueda de inseminaciones por Código Finca
                                <input type="text" class="form-control" placeholder="Código de la Finca" name="codigo_finca">
                                <button class="btn btn-default" name="btn_inseminaciones_finca" type="submit" >Buscar Finca</button>
                            </span>
                        </form>
                        <form role="form" method="post" action="infoInseminacion">
                            <span class=" input-group-addon">Busqueda de inseminaciones hechas por veterinarios
                                <input type="text" class="form-control" placeholder="Cedula del Inseminador" name="cedula_veterinario">
                                <button class="btn btn-default" name="btn_inseminaciones_veterinario" type="submit" >Buscar Veterinario</button>
                            </span>
                        </form>
                    </div>
                </div>
                <div class="tab-pane" id="tab-enfermedades">
                    <form role="form" method="post" action="infoInseminacion">
                        <span class=" input-group-addon">Busqueda de Enfermedades De Bovinos En Cómbita
                            <input type="text" class="form-control" placeholder="código de la Finca" name="codigo_finca">
                            <button class="btn btn-default" name="btn_enfermedad_finca" type="submit" >Buscar Finca Especifica</button>
                            <button class="btn btn-default" name="btn_enfermedad_general" type="submit" >Mostrar Lista General</button>
                        </span>
                    </form>

                    
                </div>
                <div class="tab-pane" id="tab-ubica">
                    <div class="input-group">
                        <input type="text" class="form-control">
                        <span class="input-group-btn">
                           <button class="btn btn-default" type="button">Buscar</button>
                        </span>
                        
                    </div>
                    <div>
                        <iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d7941.0867917581!2d-73.32764042764963!3d5.634201933662641!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x8e6a7a602413f5f9%3A0x26fb0124c89bb878!2zQ8OzbWJpdGEsIEJveWFjw6E!5e0!3m2!1ses!2sco!4v1526890067095" width="800" height="600" frameborder="0" style="border:0" allowfullscreen></iframe>

                            
                    </div>
                </div>
            </div>
        </div>
        
        <script src="js/jquery.min.js"></script>
        <script src="jquery-ui.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="js/panelFun.js"></script>
        <script>
            $( function() {
              $( "#datepickerj" ).datepicker();
            } );
        </script>
        <script>
            $( function() {
              $( "#datepickerK" ).datepicker();
            } );
        </script>
         <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.8.0/js/bootstrap-datepicker.js"></script>
       
    </body>
</html>
