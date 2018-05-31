<%-- 
    Document   : panelUsuario
    Created on : 28/04/2018, 12:42:32 PM
    Author     : cuenu
--%>

<%@page import="persistencia.DetalleHistorial"%>
<%@page import="persistencia.Animal"%>
<%@page import="persistencia.Finca"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="persistencia.Consultas"%>
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
        
        <title>Usuario</title>
    </head>
    <% 
        Consultas co= new Consultas();
        List<Finca> datos = new ArrayList();
        List<Animal> animal = new ArrayList();
        List<DetalleHistorial> historia = new ArrayList();
        
    %>
    <body>
        <div class="nav nav-tabs col-xs-10 col-xs-offset-1">
            <a class="h1 col-lg-offset-1">Bienvenido!! </a>
            <a class="h3 col-lg-offset-1">   <% out.println(usuario);%></a>
            <a class="btn btn-lg btn-primary col-lg-offset-2 bottom-right" href="login.jsp">Cerrar sesión</a>
        </div>
        <ul class="nav nav-tabs col-xs-10 col-xs-offset-1 text-uppercase bg-info h5 ">
            <li><a href="#tab-miFinca" data-toggle="tab">Mi Finca</a></li>
            <li><a href="#tab-animal" data-toggle="tab">Registrar Animal</a></li>
            <li><a href="#tab-insemina" data-toggle="tab">Registrar inseminación</a></li>
            <li><a href="#tab-leche" data-toggle="tab">Registrar Produccion de Leche </a></li>
            <li><a href="#tab-historial" data-toggle="tab">Registrar His. Clinico </a></li>
            
        </ul>
            <div class="form-horizontal">
                <div class="tab-content col-xs-8 col-xs-offset-2"><br/><br/>
                    <div class="tab-pane active" id="tab-miFinca">
                            <div class="card">
                                <div class="card-header alert-success text-center "> DATOS DE MI FINCA </div><br/>
                                <div class="card-body">
                                    <%
                                            if(request.getAttribute("filtro")!= null){
                                                datos = (List<Finca>) request.getAttribute("filtro");
                                            }else{
                                               datos = co.ListarFincaUsuario(usuario);
                                            }

                                            for(Finca f :datos){
                                        %>
                                    <div class="form-group">
                                        <label class="control-label col-sm-6 h4" for="id_finca">Propietario:</label>
                                        <div class="col-sm-5">
                                            <label class="control-label col-sm-5 text-uppercase h3" ><%= f.getExtencion_finca()%></label>
                                            <label class="control-label col-sm-4 text-uppercase h3" ><%= f.getId_dueno()%></label>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="control-label col-sm-6 h4" for="id_finca">Código único de Mi Finca:</label>
                                        <div class="col-sm-5">
                                            <label class="control-label col-sm-5 h2 text-primary" ><%= f.getId_finca()%></label>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="control-label col-sm-6 h4" for="id_finca">Nombre de Mi Finca:</label>
                                        <div class="col-sm-5">
                                            <label class="control-label col-sm-5 text-uppercase h3" ><%= f.getNombre_finca()%></label>
                                            
                                        </div>
                                    </div>
                                    
                                    <%

                                        }
                                        String cuentaAnimal = co.cantidadAnimalporFinca(usuario);
                                    %>
                                    <div class="form-group">
                                        <label class="control-label col-sm-6 h4" for="id_finca">Cantidad de Bovinos activos:</label>
                                        <div class="col-sm-5">
                                            <label class="control-label col-sm-5 h3" ><%=cuentaAnimal%></label>
                                            
                                        </div>
                                    </div>
                             <!--               -------
                                    <div class="form-group">
                                        <label class="control-label col-sm-6 h4" for="id_finca">Cantidad de Inseminaciones:</label>
                                        <div class="col-sm-5">
                                            <label class="control-label col-sm-5 h3" >.....</label>
                                            
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="control-label col-sm-6 h4" for="id_finca">Cantidad de Bovinos activos:</label>
                                        <div class="col-sm-5">
                                            <%
                                            //String cantidadAnimal = co.cantidadAnimalporFinca(usuario);
                                            
                                            %>
                                            <label class="control-label col-sm-5 h3" ><%//=cantidadAnimal%> Cabezas.</label>
                                            
                                        </div>
                                    </div>
                                            -->
                                    <div>
                                        <form role="form" method="post" action="PdfUsuario"> 
                                            <div class="col-sm-offset-8 col-sm-10">
                                              <button type="submit" class="btn btn-default btn-primary" name="btn_genera_pdf">Imprimir reporte de Mi Finca PDF</button>
                                            </div>
                                        </form>
                                    </div><br/> <br/>  
                                </div>
                                <div class="card-header alert-success text-center "> LISTA DE ANIMALES DE MI FINCA</div><br/>
                                <div class="card-body">
                                    <table class="table table-striped" border="2">
                                    <tr>
                                        <td>Código de la Finca</td>
                                        <td>Código del animal</td>
                                        <td>Nombre del animal</td>
                                        <td>Fecha de Nacimiento</td>
                                        <td>Raza</td>
                                        <td>Genero</td>
                                        <td>Metodo de concepcion</td>
                                        <td>Etapa del animal</td>
                                        <td>Observaciones</td>
                                    </tr>
                                    <%
                                            animal = co.filtrarAnimal(usuario);
                                            for(Animal a :animal){
                                        %>
                                        <tr>
                                            <td> <%= a.getId_finca() %> </td>
                                            <td> <%= a.getId_animal()%> </td>
                                            <td> <%= a.getNombre_animal()%> </td>
                                            <td> <%= a.getFecha_nacimiento()%> </td>
                                            <td> <%= a.getRaza_animal()%> </td>
                                            <td> <%= a.getGenero_animal()%> </td>
                                            <td> <%= a.getMetodo_concepcion()%> </td>
                                            <td> <%= a.getEtapa_vida()%> </td>
                                            <td> <%= a.getObservaciones()%> </td>
                                        </tr>
                                     <%
                                        }
                                     %>
                                    </table>
                                </div>
                                  <div class="card-header alert-success text-center "> ENFERMEDADES PADECIDAS EN MI FINCA</div><br/>
                                  <div class="card-body">
                                      <table class="table table-striped" border="2">
                                    <tr>
                                        
                                        <td>Fecha aparición enfermedad</td>
                                        <td>Enfermedad </td>
                                        <td>Diagnostico del veterinario</td>
                                        <td>Tratamiento establecido</td>
                                        <td>veterinario</td>
                                    </tr>
                                    <%
                                            historia = co.listaHisto(usuario);
                                            for(DetalleHistorial d :historia){
                                        %>
                                        <tr>
                                            <td> <%= d.getFecha_historia()%> </td>
                                            <td> <%= d.getEnfermedad()%> </td>
                                            <td> <%= d.getDiagnostico()%> </td>
                                            <td> <%= d.getTratamiento()%> </td>
                                            <td> <%= d.getCedula_veterinario()%> </td>
                                            
                                        </tr>
                                     <%
                                        }
                                     %>
                                    </table>
                                  </div>
                                    
                            </div>
                        
                                                              
                    </div>
                
                <div class="tab-pane" id="tab-animal">
                    <form role="form" method="post" action="creaAnimal">
                        <div class="card">
                            <div class="card-header alert-success text-center ">DATOS DEL SEMOVIENTE</div><br/>
                            <div class="card-body">
                                
                                    <div class="form-group">
                                        <label class="control-label col-sm-5" for="id_animal">código del animal:</label>
                                        <div class="col-sm-7">
                                            <input type="text" class="form-control" id="id_animal" placeholder="Código del animal" name="id_animal">
                                        </div>
                                      </div>
                                      <div class="form-group">
                                        <label class="control-label col-sm-5" for="nombre_animal">Nombre del animal:</label>
                                        <div class="col-sm-7"> 
                                            <input type="text" class="form-control" id="nombre_animal" placeholder="nombre del Animal" name="nombre_animal">
                                        </div>
                                      </div>
                                      <div class="form-group">
                                        <label class="control-label col-sm-5" for="fecha_nacimiento">Fecha De Nacimiento:</label>
                                        <div class="col-sm-7"> 
                                            
                                            <input type="text" id="datepickerA" name="fecha_nacimiento" placeholder="Fecha de nacimiento">
                                        </div>
                                      </div>
                                        <div class="form-group">
                                            <label class="control-label col-sm-5" for="raza_animal">Raza del Animal:</label>
                                            <div class="col-sm-7">
                                                <select class="form-control col-sm-7" id="sel1" name="raza_animal">
                                              <option selected value="0"> Elija una opción </option>
                                                        <option>Normando</option>
                                                        <option>Simmental</option>
                                                        <option>Jersey</option>
                                                        <option>Holstein</option>
                                                        <option>Ayrshire</option>
                                                        <option>Criolla</option>
                                              </select>
                                            </div>
                                            
                                        </div>
                                        <div class="form-group">
                                            <label class="control-label col-sm-5" for="genero_animal">Genero del Animal:</label>
                                            <div class="col-sm-7">
                                                <select class="form-control col-sm-7" id="sel1" name="genero_animal">
                                              <option selected value="0"> Elija una opción </option>
                                                        <option>Macho</option>
                                                        <option>Hembra</option>
                                                        
                                              </select>
                                            </div>
                                            
                                        </div>
                                        <div class="form-group">
                                            <label class="control-label col-sm-5" for="metodo_concepcion">Metodo de concepción:</label>
                                            <div class="col-sm-7">
                                                <select class="form-control col-sm-7" id="sel1" name="metodo_concepcion">
                                              <option selected value="0"> Elija una opción </option>
                                                        <option>Natural</option>
                                                        <option>Inseminación</option>
                                                        
                                              </select>
                                            </div>
                                            
                                        </div>
                                        <div class="form-group">
                                            <label class="control-label col-sm-5" for="etapa_animal">Etapa de Vida:</label>
                                            <div class="col-sm-7">
                                                <select class="form-control col-sm-7" id="sel1" name="etapa_animal">
                                              <option selected value="0"> Elija una opción </option>
                                                        <option>Ternero(a)/option>
                                                        <option>Novill0(a)</option>
                                                        <option>Toro</option>
                                                        <option>Preñana</option>
                                                        <option>Produciendo Leche</option>
                                                        <option>Descanso</option>
                                                        
                                              </select>
                                            </div>
                                            
                                        </div>
                                        <div class="form-group">
                                        <label class="control-label col-sm-5" for="nombre_padre">Nombre del Padre:</label>
                                        <div class="col-sm-7"> 
                                            <input type="text" class="form-control" id="nombre_padre" placeholder="nombre del Padre" name="nombre_padre">
                                        </div>
                                      </div>
                                      <div class="form-group">
                                        <label class="control-label col-sm-5" for="nombre_madre">Nombre de la Madre:</label>
                                        <div class="col-sm-7"> 
                                            <input type="text" class="form-control" id="nombre_madre" placeholder="nombre de la Madre" name="nombre_madre">
                                        </div>
                                      </div>
                                        <div class="form-group">
                                        <label class="control-label col-sm-5" for="foto_animal">Foto del Animal:</label>
                                        <div class="col-sm-7"> 
                                            <input type="file" id="files" name="files[]" />
                                        </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="control-label col-sm-5" for="observaciones">Observaciones:</label>
                                            <div class="col-sm-7">
                                                <input type="text" class="form-control" id="observaciones" placeholder="Observaciones" name="observaciones">
                                            </div>
                                        </div>
                                        <div class="card">
                                            <div class="card-header alert-success text-center ">DATOS DE LA FINCA DONDE HABITA</div><br/>
                                                <div class="card-body">
                                                    <div class="form-group">
                                                            <label class="control-label col-sm-5" for="id_finca">codigo de la finca donde habita el animal:</label>
                                                            <div class="col-sm-7">
                                                                <input type="text" id="id_finca" class="form-control" placeholder="Codigo de la finca" required name="id_finca">
                                                            </div>
                                                        </div>
                                                </div>

                                        </div>
                                      <div class="form-group"> 
                                        <div class="col-sm-offset-4 col-sm-10">
                                          <button type="submit" class="btn btn-default btn-primary" name="btn_registroAnimal">Registrar Animal</button>
                                        </div>
                                      </div>
                                        
                            </div>
                        </div>
                            
                    </form>
                    <div>
                        <pre class="bg-info text-left h5 ">
                            NOTA: 
                            a continuación usted puede cambiar la etapa 
                            o el estado de sus animales (Reses)de acuerdo 
                            a la evolución y/o ciclo de vida de cada uno. 

                            Ingrese el código de la Res seguido a esto 
                            seleccione la Etapa y presione el Boton 
                            "Cambiar Etapa"
                        </pre>

                    </div>
                    <form role="form" method="post" action="creaAnimal">
                    <div class="card-header alert-success text-center ">DATOS DEL SEMOVIENTE</div><br/>
                            <div class="card-body">
                                <div class="form-group">
                                    <label class="control-label col-sm-5" for="id_animal">código del animal:</label>
                                    <div class="col-sm-7">
                                        <input type="text" class="form-control" id="id_animal" placeholder="Código del animal" name="id_animal">
                                    </div>
                                </div>
                                <div class="form-group">
                                            <label class="control-label col-sm-5" for="metodo_concepcion">Etapa de Vida:</label>
                                            <div class="col-sm-7">
                                                <select class="form-control col-sm-7" id="sel1" name="metodo_concepcion">
                                              <option selected value="0"> Elija una opción </option>
                                                        <option>Ternero(a)</option>
                                                        <option>Novillo(a)</option>
                                                        <option>toro</option>
                                                        <option>Preñana</option>
                                                        <option>Produciendo Leche</option>
                                                        <option>Descanso</option>
                                                        <option>fallecido(Inactivo)</option>
                                              </select>
                                            </div>
                                            
                                </div>
                                <div class="form-group"> 
                                    <div class="col-sm-offset-4 col-sm-10">
                                        <button type="submit" class="btn btn-default btn-primary" name="btn_cambiaEtapa">Cambiar Etapa</button>
                                    </div>
                                </div>
                            </div>
                    </form>
                </div>
                    
                
                <div class="tab-pane" id="tab-insemina">
                    <form role="form" method="post" action="creaInseminacion">
                        <div class="card">
                            <div class="card-header alert-success text-center ">DATOS DE LA INSEMINACIÓN</div><br/>
                            <div class="card-body">
                                <div class="form-group">
                                    <label class="control-label col-sm-5" for="id_inseminacion">Código único de Inseminación:</label>
                                    <div class="col-sm-7">
                                        <input type="text" class="form-control" id="id_inseminacion" placeholder="Código de inseminación" name="id_inseminacion">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="control-label col-sm-5" for="id_animal">código del animal:</label>
                                    <div class="col-sm-7">
                                        <input type="text" class="form-control" id="id_animal" placeholder="Código del animal" name="id_animal">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="control-label col-sm-5" for="cedula_veterinario">Cédula del veterinario:</label>
                                    <div class="col-sm-7">
                                        <input type="text" class="form-control" id="cedula_veterinario" placeholder="Cédula del veterinario" name="cedula_veterinario">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="control-label col-sm-5" for="cedula_veterinario">Fecha de inseminación</label>
                                    <div class="col-sm-7">
                                        <input type="text" id="datepicker" name="fecha_inseminacion" placeholder="Fecha de inseminación">
                                    </div>
                                </div>
                                <div class="form-group">
                                        
                                      </div>
                                <div class="form-group">
                                    <label class="control-label col-sm-5" for="raza_pajilla">Raza de la Pajilla:</label>
                                    <div class="col-sm-7">
                                        <select class="form-control col-sm-7" id="sel1" name="raza_pajilla">
                                            <option selected value="0"> Elija una opción </option>
                                                <option>Normando</option>
                                                        <option>Simmental</option>
                                                        <option>Jersey</option>
                                                        <option>Holstein</option>
                                                        <option>Ayrshire</option>
                                                        <option>Criolla</option>
                                        </select>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="control-label col-sm-5" for="sexada">Sexada:</label>
                                    <div class="col-sm-7">
                                        <select class="form-control col-sm-7" id="sel1" name="sexada">
                                            <option selected value="0"> Elija una opción </option>
                                                <option>Si</option>
                                                <option>No</option>
                                                        
                                        </select>
                                    </div>
                                            
                                </div>
                                <div class="form-group"> 
                                    <div class="col-sm-offset-4 col-sm-10">
                                        <button type="submit" class="btn btn-default btn-primary" name="btn_regInseminacion">Registrar Inseminación</button>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </form>
                    <div>
                        <pre class="bg-info text-left h5 ">
                            NOTA: 
                            a continuación encontrará un campo para registrar 
                            la efectividad del procedimiento de Inseminación.

                            transcurridos 20 dias del proceso, es nesesario realizarle un
                            tacto a la Res inseminada, con el fin de establecer si ha 
                            sido exitosa dicha Inseminación.
                        </pre>

                    </div>
                    <form role="form" method="post" action="creaInseminacion">
                        <div class="card">
                            <div class="card-header alert-success text-center ">¿LA INSEMINACIÓN FUE EXITOSA? </div><br/>
                            <div class="card-body">
                                <div class="form-group">
                                    <label class="control-label col-sm-5" for="id_inseminacion">Código único de Inseminación:</label>
                                    <div class="col-sm-7">
                                        <input type="text" class="form-control" id="id_inseminacion" placeholder="Código de inseminación" name="id_inseminacion">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="control-label col-sm-5" for="inseminacion_exitosa">Inseminación exitosa:</label>
                                    <div class="col-sm-7">
                                        <select class="form-control col-sm-7" id="sel1" name="inseminacion_exitosa">
                                            <option selected value="0"> Elija una opción </option>
                                                <option>Si</option>
                                                <option>No</option>
                                                        
                                        </select>
                                    </div>
                                            
                                </div>
                                <div class="form-group"> 
                                        <div class="col-sm-offset-4 col-sm-10">
                                            <button type="submit" class="btn btn-default btn-primary" name="btn_inseminacionExitosa">Registrar resultado</button>
                                        </div>
                                </div>
                            </div>
                        </div>
                    </form>
                </div>

                <div class="tab-pane" id="tab-leche">
                    
                    <form role="form" method="post" action="ReporteLeche">
                        <div class="card">
                            <div class="card-header alert-success text-center ">PRODUCCIÓN DE LECHE ( POR DÍAS ) </div><br/>
                            <div class="card-body">
                                <div class="form-group">
                                    <label class="control-label col-sm-5" for="id_animal">Código único del Animal:</label>
                                    <div class="col-sm-7">
                                        <input type="text" class="form-control" id="id_animal" placeholder="Codigo del animal" name="id_animal">
                                    </div>
                                </div>
                                <div class="form-group">
                                        <label class="control-label col-sm-5" for="fecha_leche">Fecha del ordeño:</label>
                                        <div class="col-sm-7"> 
                                            <input type="text" id="datepickerB" name="fecha_leche" placeholder="Fecha del ordeño">
                                        </div>
                                      </div>
                                <div class="form-group">
                                    <label class="control-label col-sm-5" for="litros_leche">Litros de leche producidos:</label>
                                    <div class="col-sm-7">
                                        <select class="form-control col-sm-7" id="sel1" name="litros_leche">
                                            <option selected value="5"> Elija una opción </option>
                                                <option>5</option><option>6</option>
                                                <option>7</option><option>8</option>
                                                <option>9</option><option>10</option>
                                                <option>11</option><option>12</option>
                                                <option>13</option><option>14</option>
                                                <option>15</option><option>16</option>
                                                <option>17</option><option>18</option>
                                                <option>19</option><option>20</option>
                                                <option>21</option><option>22</option>
                                                <option>23</option><option>24</option>
                                                <option>25</option><option>26</option>
                                                <option>27</option><option>28</option>
                                                <option>29</option><option>30</option>
                                                <option>31</option><option>32</option>
                                                <option>33</option><option>34</option>
                                                <option>35</option><option>36</option>
                                                <option>37</option><option>38</option>
                                                <option>39</option><option>40</option>
                                                <option>41</option><option>42</option>
                                                <option>43</option><option>44</option>
                                                <option>45</option><option>46</option>
                                                <option>47</option><option>48</option>
                                                <option>49</option><option>50</option>
                                                <option>51</option><option>52</option>
                                                <option>53</option><option>54</option>
                                                <option>55</option><option>56</option>
                                                <option>57</option><option>58</option>
                                                <option>59</option><option>60</option>
                                                <option>61</option><option>62</option>
                                                <option>63</option><option>64</option>
                                                
                                        </select>
                                    </div>
                                            
                                </div>
                                <div class="form-group"> 
                                        <div class="col-sm-offset-4 col-sm-10">
                                            <button type="submit" class="btn btn-default btn-primary" name="btn_regLeche" onclick="$('#f_date_b2').val($('#f_date_b').val())">Registrar Producción</button>
                                        </div>
                                </div>
                            </div>
                        </div>
                    </form>
                </div>
                <div class="tab-pane" id="tab-historial">
                    <form role="form" method="post" action="creaHistoria">
                        <div class="card">
                            <div class="card-header alert-success text-center ">DATOS DEL ANIMAL PASIENTE  </div><br/>
                            <div class="card-body">
                                <div class="form-group">
                                    <label class="control-label col-sm-5" for="id_historial">Código unico de Historial clínico:</label>
                                    <div class="col-sm-7">
                                        <input type="text" class="form-control" id="id_historial" placeholder="Codigo del hsitorial clínico" name="id_historia">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="control-label col-sm-5" for="id_animal">Código único del Animal:</label>
                                    <div class="col-sm-7">
                                        <input type="text" class="form-control" id="id_animal" placeholder="Codigo del animal" name="id_animal">
                                    </div>
                                </div>
                                <div class="card-header alert-success text-center ">DATOS DE LA SESIÓN CLÍNICA</div><br/>
                                
                                <div class="form-group">
                                        <label class="control-label col-sm-5" for="fecha_historia">Fecha de la sesión Clínica:</label>
                                        <div class="col-sm-7"> 
                                            <input type="text" id="datepickerC" name="fecha_historia" placeholder="Fecha de la Sesión Clínica">
                                        </div>
                                      </div>
                                <div class="form-group">
                                    <label class="control-label col-sm-5" for="cedula_veterinario">Cédula del veterinario:</label>
                                    <div class="col-sm-7">
                                        <input type="text" class="form-control" id="cedula_veterinario" placeholder="Cédula del veterinario" name="cedula_veterinario">
                                    </div>
                                </div>
                                <div class="card-header alert-success text-center ">OBSERVACIONES</div><br/>
                                <div class="form-group">
                                    <label class="control-label col-sm-5" for="observaciones">Se encontró:</label>
                                    <div class="col-sm-7">
                                        <input type="text" class="form-control" id="observaciones" placeholder="Observaciones" name="observaciones">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="control-label col-sm-5" for="enfermedad">Enfermedad hayada:</label>
                                    <div class="col-sm-7">
                                        <select class="form-control col-sm-7" id="sel1" name="enfermedad">
                                            <option selected value="0"> Ninguna </option>
                                                <option>Parvo</option><option>Aptosa</option>
                                                
                                        </select>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="control-label col-sm-5" for="diagnostico">Diagnostico:</label>
                                    <div class="col-sm-7">
                                        <input type="text" class="form-control" id="diagnostico" placeholder="Diagnostico" name="diagnostico">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="control-label col-sm-5" for="tratamiento">Tratamiento:</label>
                                    <div class="col-sm-7">
                                        <input type="text" class="form-control" id="cedula_veterinario" placeholder="Tratamiento" name="tratamiento">
                                    </div>
                                </div>
                                
                                <div class="form-group"> 
                                        <div class="col-sm-offset-4 col-sm-10">
                                            <button type="submit" class="btn btn-default btn-primary" name="btn_regHistoria">Registrar sesion Clinica</button>
                                        </div>
                                </div>
                            </div>
                        </div>
                    </form>
                </div>
                
            </div>
        </div>
        <script src="js/jquery.min.js"></script>
        <script src="jquery-ui.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script>
            $( function() {
              $( "#datepickerA" ).datepicker();
            } );
            </script>
            <script>
            $( function() {
              $( "#datepicker" ).datepicker();
            } );
            </script>
            <script>
            $( function() {
              $( "#datepickerB" ).datepicker();
            } );
            </script>
            <script>
            $( function() {
              $( "#datepickerC" ).datepicker();
            } );
            </script>
        <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.8.0/js/bootstrap-datepicker.js"></script>
        
    </body>
</html>
