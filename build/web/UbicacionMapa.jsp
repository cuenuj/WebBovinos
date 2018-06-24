<%-- 
    Document   : UbicacionMapa
    Created on : 10/06/2018, 05:11:46 PM
    Author     : cuenu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="persistencia.Consultas"%>
<%@page import="java.util.*"%>
<%@page import="persistencia.Finca"%>
<!DOCTYPE html>
<html>
    <head>
        <!--
            Capa de presentación. ubicación de la fincas De Cómbita en mapa 
        -->
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/stylos1.css" rel="stylesheet">
        <style>
          
          #map {
            height: 80%;
          }
          
          html, body {
            height: 100%;
            margin: 0;
            padding: 0;
          }
        </style>
    </head>
    <body>
        <div class=""><center>
            <pre class=" h2 "> Vista del mapa de Cómbita </pre>
            <pre class="bg-success text-center h4 ">Las figuras de vacas ubican las fincas en el mapa.</pre></center>
            <a class="btn btn-danger col-lg-offset-0 " href="panelFuncionario.jsp">Regresar</a>
        </div>
        <div id="map"></div>
        <%
            Consultas co= new Consultas();
            List<Finca> lista = co.Consultar();  //new ArrayList<Finca>();
            
        %>

        <script>
          
          var map;
          function initMap() {
            map = new google.maps.Map(document.getElementById('map'), {
              zoom: 16,
              center: new google.maps.LatLng(5.633888,-73.323055),
              mapTypeId: 'roadmap'
            });
              var icons = {
              parking: {
                icon: 'css/images/Cabeza_toro.png'
              }              
            };
            <%
                for(Finca f: lista){
                    String nombre= f.getNombre_finca();
                    String lat=f.getCordenada_latitud();
                    String lon =f.getCordenada_longitud();
                    out.println("new google.maps.Marker({"
                            + "position: {lat:"+lat+",lng:"+lon+"},"
                            + "map: map,"
                            + "label:'"+nombre+"',"
                            + "title:'Finca: "+nombre+"',"
                            + "icon:'css/images/Cabeza_toro.png',"
                            + "});");
                }
            %>
          }
         </script>
         
        <script async defer
        src="https://maps.googleapis.com/maps/api/js?key=AIzaSyALmOm_9JHbwcCC-bkklEP9bKU3qShLR0o&callback=initMap">    
        </script>
        
      </body>
</html>
