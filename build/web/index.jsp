<%-- 
    Document   : index
    Created on : 29 sep. 2022, 19:50:32
    Author     : Ricardo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>

    <center>
        <form action="pruebaServletDao" method="POST">
            <input type="submit" name="accion" value="Listar">
            <input type="submit" name="accion" value="Nuevo">

        </form>
        <div>
            <table>
                <thead>
                    <tr>
                        <th>idCurso</th>
                        <th>idProfesor</th>
                        <th>NombreCurso</th>
                        <th>Descripción</th>
                        <th>Imágen</th>
                        <th>Acciones</th>
                    </tr>
                </thead>
                <tbody>
                <c:forEach var="curTemp" items="${lista}">
                    <tr>
                        <td>${curTemp.getId_Curso()}</td>
                        <td>${curTemp.getId_Profesor()}</td>
                        <td>${curTemp.getNombre()}</td>
                        <td>${curTemp.getDescripcion()}</td>
                        <td><img src="ControlerIMG?idCurso=${cursoTemp.getId_Curso()}" width="250" height="230"></td>
                        <td>
                            <form action="pruebaServletDao" method="POST">
                                <input type="submit" name="accion" value="Editar">
                                <input type="submit" name="accion" value="Borrar">

                            </form>
                        </td>
                    </tr>



                </c:forEach>
                </tbody>
            </table>
        </div>

    </center>


</body>
</html>
