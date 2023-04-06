<%-- 
    Document   : boostrap
    Created on : 1 oct. 2022, 17:11:34
    Author     : Ricardo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <!-- Bootstrap CSS -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

        <%
            /*Varios componentes de Bootstrap utilizan el índice z, la propiedad CSS que ayuda
            a controlar el diseño al proporcionar un tercer eje para organizar el contenido. 
            Utilizamos una escala de índice z predeterminada en Bootstrap que ha sido diseñada 
            para la navegación en capas, información sobre herramientas y ventanas emergentes, modales y más.

    Estos valores más altos comienzan en un número arbitrario, lo suficientemente alto y específico
            para evitar idealmente conflictos. Necesitamos un conjunto estándar de estos en todos 
            nuestros componentes en capas (información sobre herramientas, ventanas emergentes, 
            barras de navegación, menús desplegables, modales) para que podamos ser razonablemente 
            consistentes en los comportamientos. No hay razón por la que no podríamos haber usado 100+ o 500+.

    No fomentamos la personalización de estos valores individuales;
            si cambia uno, es probable que necesite cambiarlos todos.

    Para manejar los bordes superpuestos dentro de los componentes
            (p. ej., botones e entradas en grupos de entrada), usamos valores bajos
            de índice z de un solo dígito de 1, 2 y 3 para los estados predeterminado,
            flotante y activo. En hover/focus/active, traemos un elemento particular al 
            frente con un valor de índice z más alto para mostrar su borde sobre los elementos hermanos.
    
          
        <style>

            $zindex-dropdown:                   1000;
            $zindex-sticky:                     1020;
            $zindex-fixed:                      1030;
            $zindex-offcanvas-backdrop:         1040;
            $zindex-offcanvas:                  1045;
            $zindex-modal-backdrop:             1050;
            $zindex-modal:                      1055;
            $zindex-popover:                    1070;
            $zindex-tooltip:                    1080;
            $zindex-toast:                      1090;


        </style>
   */
        %>
    </head>
    <body>
        <!-- Option 1: Bootstrap Bundle with Popper -->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
    </body>
</html>
