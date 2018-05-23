<%-- 
    Document   : panelUsuario
    Created on : 28/04/2018, 12:42:32 PM
    Author     : cuenu
--%>

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
        <title>Usuario</title>
    </head>
    <body>
        <div class="nav nav-tabs col-xs-10 col-xs-offset-1">
            <a class="h1 col-lg-offset-1">Bienvenido!! </a>
            <a class="h3 col-lg-offset-1">   <% out.println(usuario);%></a>
            <a class="btn btn-lg btn-primary col-lg-offset-2 bottom-right" href="login.jsp">Cerrar sesión</a>
        </div>
        <ul class="nav nav-tabs col-xs-10 col-xs-offset-1 text-uppercase bg-info h5 ">
            <li><a href="#tab-animal" data-toggle="tab">Registrar Animal</a></li>
            <li><a href="#tab-insemina" data-toggle="tab">Registrar inseminación</a></li>
            <li><a href="#tab-leche" data-toggle="tab">Registrar Produccion de Leche </a></li>
            <li><a href="#tab-historial" data-toggle="tab">Registrar His. Clinico </a></li>
            
        </ul>

        

        <div class="form-horizontal">
            <div class="tab-content col-xs-5 col-xs-offset-3"><br/><br/>
                <div class="tab-pane active" id="tab-animal">
                    <form role="form" method="post" action="creaAnimal">
                        <div></div>
                        <div class="card">
                            <div></div>
                            <div class="card-header alert-success text-center ">DATOS DE LA VACA</div>
                            <div class="card-body">
                                
                                    <div class="form-group">
                                        <label class="control-label col-sm-5" for="id_animal">Número de Identificación del animal:</label>
                                        <div class="col-sm-7">
                                            <input type="text" class="form-control" id="id_animal" placeholder="número identificación" name="id_animal">
                                        </div>
                                      </div>
                                      <div class="form-group">
                                        <label class="control-label col-sm-5" for="id_finca">código de finca a la que pertenece:</label>
                                        <div class="col-sm-7"> 
                                            <input type="text" class="form-control" id="id_finca" placeholder="Código de la finca" name="id_finca">
                                        </div>
                                      </div>
                                      <div class="form-group">
                                        <label class="control-label col-sm-5" for="nombre_animal">Nombre del Animal:</label>
                                        <div class="col-sm-7"> 
                                            <input type="text" class="form-control" id="nombre" placeholder="nombre del animal" name="nombre_animal">
                                        </div>
                                      </div>
                                      <div class="form-group">
                                          <label class="control-label col-sm-5" for="nombre_animal">Fecha de nacimiento:</label>
                                            <div class='input-group date' id='datetimepicker1'>
<%--aqui el calendario--%>                      <div id="datepicker"></div>
                                                                                                
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="control-label col-sm-5" for="nombre_animal">Raza del Animal:</label>
                                            <div class="col-sm-7">
                                                <select class="form-control col-sm-7" id="sel1" name="raza_animal">
                                              <option selected value="0"> Elige una opción </option>
                                              <option>Normando</option>
                                              <option>Pasiega</option>
                                              <option>Simmental</option>
                                              <option>Jersey</option>
                                              <option>Tudanca</option>
                                              <option>Holstein</option>
                                              <option>Búfala</option>
                                              <option>Cebú</option>
                                              <option>Bon</option>
                                              <option>Lucerna</option>
                                              <option>Harton</option>
                                            </select>
                                            </div>
                                            
                                        </div>
                                        <div class="form-group">
                                            <label class="control-label col-sm-5" for="nombre_animal">Genero:</label>
                                            <div class="col-sm-7">
                                                <select class="form-control col-sm-7" id="sel1" name="genero_animal">
                                              <option selected value="0"> Elige una opción </option>
                                              <option>Macho</option>
                                              <option>Hembra</option>
                                                                                           
                                            </select>
                                            </div>
                                            
                                        </div>
                                        
                                            <div class="form-group">
                                                <label class="control-label col-sm-5" for="concepcion">Metodo de concepción:</label>
                                                <div class="col-sm-7">
                                                    <select class="form-control col-sm-7" id="sel1" name="concepcion">
                                                        <option selected value="0"> Elige una opción </option>
                                                        <option>natural</option>
                                                        <option>inseminacion</option>
                                                        <option>desconocido</option>                                             
                                                    </select>
                                                </div>
                                          </div>
                                        <div>
                                            <label class="control-label col-sm-5" for="foto_animal">Foto del animal:</label>
                                            <div class="col-sm-7">
                                                <input type="file" id="files" name="files[]" />
                                                
                                            </div>
                                        </div>
                                        <br/><br/>
                                        <div class="form-group">
                                        <label class="control-label col-sm-5" for="observaciones">Observaciones:</label>
                                        <div class="col-sm-7">
                                            <input type="text" class="form-control" id="observaciones" placeholder="Obsevaciones" name="observaciones">
                                        </div>
                                      </div>
                                      
                                      <div class="form-group"> 
                                        <div class="col-sm-offset-4 col-sm-10">
                                          <button type="submit" class="btn btn-default btn-primary">Guardar</button>
                                        </div>
                                      </div>
                                
                            </div>
                        </div>
                    </form>
                </div>
                    
                
                <div class="tab-pane" id="tab-insemina">
                    <div >
                    <input type="text" id="inputEmail" class="form-control" placeholder="Nombre del Bovino" required autofocus name="Nombre del Bovino">
                    </div>
                    <div >
                    <input type="text" id="inputPassword" class="form-control" placeholder="Finca" required name="Finca">
                    </div>
                </div>

                <div class="tab-pane" id="tab-leche">
                    <div class="input-group">
                        <span class="input-group-addon">*</span>
                        <input type="text" class="form-control" placeholder="Nombre Finca">
                    </div>

                    <div class="input-group">
                        <span class="input-group-addon">*</span>
                        <input type="text" class="form-control" placeholder="Dueño Finca">
                        
                    </div>
                </div>
                <div class="tab-pane" id="tab-historial">
                    <div class="input-group">
                        <span class="input-group-addon">*</span>
                        <input type="text" class="form-control" placeholder="Nombre Bovino">
                    </div>

                    <div class="input-group">
                        <span class="input-group-addon">*</span>
                        <input type="text" class="form-control" placeholder="Nombre finca">
                        
                    </div>
                </div>
                
            </div>
        </div>
        <script src="js/jquery.min.js"></script>
        <script src="jquery-ui.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script> $( "#datepicker" ).datepicker({
	inline: true
        });
        </script>
        <script >
  
</script>
    </body>
</html>
