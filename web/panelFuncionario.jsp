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
            <a class="h1 col-lg-offset-1">Bienvenido Funcionario!! </a>
            <a class="h5 col-lg-offset-5">   <% out.println(usuario);%></a>
        </div>
        <ul class="nav nav-tabs col-xs-9 col-xs-offset-1  text-uppercase bg-info h5 ">
            <li><a href="#tab-fincasTotales" data-toggle="tab"> Fincas de Cómbita</a></li>
            <li><a href="#tab-finca" data-toggle="tab">Nueva Finca</a></li>
            <li><a href="#tab-veterinario" data-toggle="tab">Nuevo Veterinario</a></li>
            <li><a href="#tab-leche" data-toggle="tab">Producción de Leche<i class="fa"></i></a></li>
            <li><a href="#tab-insemina" data-toggle="tab">Inseminaciones<i class="fa"></i></a></li>
            <li><a href="#tab-enfermedades" data-toggle="tab">Enfermedades<i class="fa"></i></a></li>
        </ul>

        
        <div></div>
        <div class="form-horizontal">
            <div class="tab-content col-xs-8 col-xs-offset-2"><br/><br/>
                <div class="tab-pane active " id="tab-fincasTotales">
                    <div>
                        <pre class="bg-warning text-left h4 ">
                        Genere un archivo tipo PDF con la informacion de una Finca, en el sigiuente recuadro  
                        ingrese el nombre de la finca y presione el botón "Generar Informe PDF".</pre>
                        <form action="infoPdfFuncionario" method="get">
                            <input type="text" class="col-sm-4 " placeholder="Nombre de la finca" name="nombre_finca">
                            <button class="btn btn-primary" name="btn_informePDF" type="submit" >Generar Informe PDF</button>
                        </form>
                    </div>
                    <form action="UbicacionMapa.jsp" method="post">
                        <pre class="bg-success text-left h4 ">
        Vista del mapa de Cómbita con la ubicación de las fincas.</pre>
                        <button class="btn btn-danger col-xs-8 col-xs-offset-4" name="btn_mapa" type="submit" >Ver mapa de Cómbita</button>
                    </form>
                    
                    <div><br/><br/><br/><br/>
                        <form action="ConsultaFinca" method="get" >
                            <pre class="bg-warning text-left h4 ">
                            A continuación podrá ver todas las fincas registradas,  
                            ingrese el codigo único de la finca y presione el botón  "Buscar Finca",
                            o en el botón "ver Lista Completa de Fincas" para ver todo el listado de nuevo.
                            </pre>
                            <span class=" input-group-addon">Código Finca <br/><br/>
                            <input type="text" class="col-sm-5" placeholder="código Único de Finca" name="codigo_finca">
                            <button class="btn btn-default" name="btn_buscar" type="submit" >Buscar Finca</button>

                            <button class="btn btn-default" name="btn_lista" type="submit" >Ver Lista Completa de Fincas</button>
                            </span>
                        </form>
                    </div>
                    <br/>
                    <div class="card">
                        <div class="card-header alert-success text-center ">LISTADO TOTAL DE LAS FINCAS DE CÓMBITA </div><br/>
                            <table class="table table-striped" border="2">
                                <tr>
                                    <td>Código de Finca</td>
                                    <td>Nombre de Finca</td>
                                    <td>coordenada Latitud</td>
                                    <td>coordenada Longitud</td>
                                    <td>Cédula del Dueño</td>
                                    <td>Ubicación/Vereda</td>
                                </tr>
                                <%
                                    if(request.getAttribute("filtro")!= null){
                                        datos = (List<Finca>) request.getAttribute("filtro");
                                    }else{
                                       datos = co.Consultar(); 
                                    }
                                    int cuentaFinca=0;
                                    for(Finca f :datos){
                                 %>
                                 <tr>
                                     <td> <%= f.getId_finca() %> </td>
                                     <td> <%= f.getNombre_finca()%> </td>
                                     <td> <%= f.getCordenada_latitud()%> </td>
                                     <td> <%= f.getCordenada_longitud()%> </td>
                                     <td> <%= f.getId_dueno()%> </td>
                                     <td> <%= f.getId_lugar()%> </td>
                                 </tr>

                                 <%
                                     cuentaFinca++;
                                    }
                                %>
                            </table>
                            <div class="form-group">
                                        <label class="control-label col-sm-7 h3 bg-info" >Número de fincas en lista:</label>
                                        <label class="control-label col-sm-5 h3 bg-info" ><%=cuentaFinca%>  en total.</label>
                                    </div>
                    </div>
                                
                </div>
                <div class="tab-pane" id="tab-finca">
                    <form action="ConsultaFinca" method="get" >
                    <div class="card">
                            <div class="card-header alert-success text-center ">REGISTRAR NUEVA FINCA</div><br/>
                            <div class="card-body">
                                <pre class="bg-warning text-left h4 ">
                        Registre a continuación las fincas Nuevas, pertenecientes al municipio de Cómbita 
                        ingrese los datos de la Finca seguido del boton "Registrar Finca".
                                </pre>
                                <div class="form-group">
                                    <label class="control-label col-sm-5" for="id_finca">Código único de Finca:</label>
                                    <div class="col-sm-3">
                                        <input type="text" class="form-control" id="id_finca" placeholder="Código de la Finca" name="id_finca">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="control-label col-sm-5" for="nombre_finca">Nombre de Finca:</label>
                                    <div class="col-sm-4">
                                        <input type="text" class="form-control" id="nombre_finca" placeholder="Nombre de la Finca" name="nombre_finca">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="control-label col-sm-5" for="cordenada_latitud">Coordenada latitud:</label>
                                    <div class="col-sm-4">
                                        <input type="text" class="form-control" id="cordenada_latitud" placeholder="cordenada latitud" name="cordenada_latitud">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="control-label col-sm-5" for="cordenada_longitud">Coordenada longitud:</label>
                                    <div class="col-sm-4">
                                        <input type="text" class="form-control" id="cordenada_longitud" placeholder="cordenada longitud" name="cordenada_longitud">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="control-label col-sm-5" for="cedula">Número de Cédula del Dueño:</label>
                                    <div class="col-sm-4">
                                        <input type="text" class="form-control" id="cedula" placeholder="número cédula del duaño" name="cedula">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="control-label col-sm-5" for="i_lugar">Vereda donde se Ubica:</label>
                                    <div class="col-sm-4">
                                        <input type="text" class="form-control" id="i_lugar" placeholder="vereda de ubicación de la Finca" name="i_lugar">
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
                            <div class="card-header alert-success text-center ">DATOS DEL PROFESIONAL VETERINARIO</div><br/>
                            <div class="card-body">
                                <pre class="bg-warning text-left h4 ">
                        Registre a continuación Veterinarios Nuevos, ingrese los datos del profesional 
                        luego la contraseña de usted como funcionario seguido del botón "Registrar Veterinario".
                                </pre>
                                    <div class="form-group">
                                        <label class="control-label col-sm-5" for="id_animal">Número de Identificación Veterinario:</label>
                                        <div class="col-sm-3">
                                            <input type="text" class="form-control" id="cedula_veterinario" placeholder="número identificación" name="cedula_veterinario">
                                        </div>
                                      </div>
                                      <div class="form-group">
                                        <label class="control-label col-sm-5" for="nombre_animal">Nombre del Veterinario:</label>
                                        <div class="col-sm-4"> 
                                            <input type="text" class="form-control" id="nombre_veterinario" placeholder="nombre del veterinario" name="nombre_veterinario">
                                        </div>
                                      </div>
                                      <div class="form-group">
                                        <label class="control-label col-sm-5" for="apellidos_animal">Apellidos del Veterinario:</label>
                                        <div class="col-sm-4"> 
                                            <input type="text" class="form-control" id="apellidos_veterinario" placeholder="Apellidos del veterinario" name="apellidos_veterinario">
                                        </div>
                                      </div>
                                        
                                        <div class="form-group">
                                            <label class="control-label col-sm-5" for="telefono">Teléfono de contacto:</label>
                                            <div class="col-sm-3">
                                                <input type="text" class="form-control" id="telefono" placeholder="telefono" name="telefono">
                                            </div>
                                        </div>
                                        <div class="card">
                                            <div class="card-header alert-success text-center ">DATOS DEL FUNCIONARIO</div><br/>
                                                <div class="card-body">
                                                    <div class="form-group">
                                                            <label class="control-label col-sm-5" for="telefono">Contraseña del Funcionario:</label>
                                                            <div class="col-sm-3">
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
                    <div class="card-header alert-success text-center ">PRODUCCIÓN DE LECHE DE LAS FINCAS </div><br/>
                    <div class="card-body">
                        <form role="form" method="post" action="infoLeche">
                            <pre class="bg-warning text-left h4 ">
                        A continuación usted puede obtener un reporte de la producción de leche de una finca, 
                        ingrese el nombre de la finca en cuestión y oprima el boton "Ver Informe".
                                </pre>
                            
                            <div class="form-group">
                                <label class="control-label col-sm-5" for="nombre_finca">Nombre de Finca:</label>
                                <div class="col-sm-4">
                                    <input type="text" class="form-control" id="id_finca" placeholder="Nombre de la Finca" name="nombre_finca">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-sm-5" for="valor_leche">Precio del Litro de leche sin puntos ni espacios:</label>
                                <div class="col-sm-4">
                                    <input type="text" class="form-control" id="valor_leche" placeholder="Precio litro de leche" name="valor_leche">
                                </div>
                            </div>
                            <div class="form-group"> 
                                <div class="col-sm-offset-4 col-sm-10">
                                   <button type="submit" class="btn btn-default btn-primary" name="btn_informeLeche">Ver Informe</button>
                                </div>
                            </div>
                        </form>
                </div>
                    </div>
                <div class="tab-pane" id="tab-insemina">
                    <div class="card-header alert-success text-center ">INSEMINACIONES POR FINCAS  </div><br/>
                    <div class="card-body">
                        <pre class="bg-warning text-left h4 ">
            A continuación usted puede obtener un balance de las inseminaciones de una finca en específico, 
            ingrese el Código Único de la finca seguido del botón "Buscar Finca".

            De igual manera encontrará el reporte de Inseminación, junto a mas información en el 
            archivo PDF, que puede generar en la pestaña "FINCAS DE CÓMBITA" 
                        </pre>
                        <form role="form" method="post" action="infoInseminacion">
                            <span class=" input-group-addon">Busqueda de inseminaciones por el nombre de Finca<br/><br/>
                                <input type="text" class="col-sm-4" placeholder="Nombre de la Finca" name="nombre_finca">
                                <button class="btn btn-default" name="btn_inseminaciones_finca" type="submit" >Buscar Finca</button>
                            </span>
                        </form>
                        
                    </div>
                </div>
                <div class="tab-pane" id="tab-enfermedades">
                    <form role="form" method="post" action="infoHistoria">
                        <pre class="bg-warning text-left h4 ">
            A continuación usted puede obtener un Reporte de las Historias clinicas 
            realizadas en una finca especifica, ingrese el nombre de la finca 
            seguido del botón "Buscar Finca Específica".
                        </pre>    
                        <span class=" input-group-addon">Busqueda de Enfermedades De Bovinos En Cómbita <br/><br/>
                            <input type="text" class="col-sm-4" placeholder="Nombre de la Finca" name="nombre_fincaH">
                            <button class="btn btn-default" name="btn_enfermedad_finca" type="submit" >Buscar Finca Específica</button>
                            <button class="btn btn-default" name="btn_enfermedad_general" type="submit" >Mostrar Lista General</button>
                        </span>
                    </form>

                    
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
