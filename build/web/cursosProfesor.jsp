<%-- 
    Document   : cursosProfesor
    Created on : 31 oct. 2022, 08:49:57
    Author     : Ricardo
--%>

<%@page import="dominio.Usuario"%>
<%@page import="dominio.Curso"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width", initial-scale="1.0">
        <jsp:include page="boostrap.jsp"></jsp:include>

        <%
            HttpSession sesion = request.getSession();
            Usuario prof = (Usuario) sesion.getAttribute("user");
            List<Curso> Cursos = (List<Curso>) request.getAttribute("lista");
        %>
        <title>Cursos de <%=prof.getNombre()%></title>
    </head>
    <body>
                <jsp:include page="header.jsp"></jsp:include>

        <div class="container-md">
            <center>
                <form action="pruebaServletDao" method="POST">

                    <input type="submit" name="accion" value="Nuevo">

                </form> 
                </body>
            </center>
            <% if (Cursos.isEmpty()) {%>
            <center>
                <div class="card-header alert alert-success" role="alert">
                    Aquí aparecerán sus cursos, presione el botón "Nuevo" <br> Mucho éxito profesor(a) <%=prof.getNombre() + " " + prof.getApellidos()%>
                </div>
            </center>
            <%} else {%>
            <center>
                <table class="table align-middle">
                    <thead>
                        <tr class="table-primary">
                            <th style="background-color:#00113D; color:#C5B268">idCurso</th>
                            <th style="background-color:#00113D; color:#C5B268">idProfesor</th>
                            <th style="background-color:#00113D; color:#C5B268">NombreCurso</th>
                            <th style="background-color:#00113D; color:#C5B268">Descripción</th>
                            <th style="background-color:#00113D; color:#C5B268">Categoria</th>
                            <th style="background-color:#00113D; color:#C5B268">Imágen</th>
                            <th style="background-color:#00113D; color:#C5B268">Acciones</th>
                        </tr>
                    </thead>
                    <tbody>
                        <%for (Curso curTemp : Cursos) {%>
                        <tr>
                            <td><%=curTemp.getId_Curso()%></td>
                            <td><%=curTemp.getId_Profesor()%></td>
                            <td><%=curTemp.getNombre()%></td>
                            <td><%=curTemp.getDescripcion()%></td>
                            <td><%=curTemp.getCategoria()%></td>
                            <td><img src="<%=curTemp.getRutaImg()%>" width="250" height="200"></td>
                            <td>
                                <div>
                                    <a href="EditarCurso?id=<%=curTemp.getId_Curso()%>" class="btn btn-warning btn-sm">Editar</a>
                                    <a href="EliminarCurso?id=<%=curTemp.getId_Curso()%>" class="btn btn-danger btn-sm">Eliminar</a>


                                </div>
                            </td>
                        </tr>

                        <% }%>

                    </tbody>
                </table>

            </center>

            <%}%>

</html>
