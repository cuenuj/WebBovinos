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
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/stylos1.css" rel="stylesheet">
        <style>
          /* Always set the map height explicitly to define the size of the div
           * element that contains the map. */
          #map {
            height: 80%;
          }
          /* Optional: Makes the sample page fill the window. */
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
        <script>
          var map;
          function initMap() {
            map = new google.maps.Map(document.getElementById('map'), {
              zoom: 14,
              center: new google.maps.LatLng(5.633888,  -73.323055),
              mapTypeId: 'roadmap'
            });
              var icons = {
              parking: {
                icon: 'css/images/Cabeza_toro.png'
              }              
            };

            var features = [
               {
                position: new google.maps.LatLng(5.6376992347903106, -73.31879464019775),
                type: 'parking'
              }, {
                position: new google.maps.LatLng(5.6176995282092855, -73.32937399734496),
                type: 'parking'
              }, {
                position: new google.maps.LatLng(5.6276995018901448, -73.3182474695587),
                type: 'parking'
              }
            ];
            
            
            // Create markers.
            features.forEach(function(feature) {
              var marker = new google.maps.Marker({
                position: feature.position,
                icon: icons[feature.type].icon,
                map: map
              });
            });
          }
         </script>
        <script async defer
        src="https://maps.googleapis.com/maps/api/js?key=AIzaSyALmOm_9JHbwcCC-bkklEP9bKU3qShLR0o&callback=initMap">
            
        </script>
      </body>
</html>
