<%-- 
    Document   : admin
    Created on : 28 oct. 2022, 16:00:47
    Author     : Ricardo
--%>

<%@page import="java.util.List"%>
<%@page import="dominio.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width", initial-scale="1.0">
        <jsp:include page="boostrap.jsp"></jsp:include>

            <title>Administrador</title>
        </head>
        <body>
        <jsp:include page="header.jsp"></jsp:include>

        <%
            List<Usuario> alums = (List<Usuario>) request.getAttribute("alumnos");
            List<Usuario> profs = (List<Usuario>) request.getAttribute("profesores");
            List<Usuario> admins = (List<Usuario>) request.getAttribute("admins");

        %>  
        <div class="container-md">
            <center>
                <div class="card" >
                    <div class="card-header">
                        Alumnos
                    </div>
                    <table class="table align-middle">
                        <thead>
                            <tr class="table-primary">
                                <th style="background-color:#00113D; color:#C5B268">idUsuario</th>
                                <th style="background-color:#00113D; color:#C5B268">Correo</th>
                                <th style="background-color:#00113D; color:#C5B268">Nombre</th>
                                <th style="background-color:#00113D; color:#C5B268">Apellidos</th>
                                <th style="background-color:#00113D; color:#C5B268">Fecha Nac</th>
                                <th style="background-color:#00113D; color:#C5B268">Alumnos</th>
                                <th style="background-color:#00113D; color:#C5B268">Acciones</th>
                            </tr>
                        </thead>
                        <tbody>
                            <% if (alums != null) {
                            for (Usuario alumno : alums) {%>
                            <tr>
                                <td><%=alumno.getId_Usuario()%></td>
                                <td><%=alumno.getCorreo()%></td>
                                <td><%=alumno.getNombre()%></td>
                                <td><%=alumno.getApellidos()%></td>
                                <td><%=alumno.getFecha_Nac()%></td>
                                <td><%=alumno.isAlumno()%></td>
                                <td>
                                    <div>
                                        <a href="HacerProfesor?id=<%=alumno.getId_Usuario()%>" class="btn btn-warning btn-sm">Hacer Profesor</a>
                                        <a href="HacerAdmin?id=<%=alumno.getId_Usuario()%>" class="btn btn-dark btn-sm">Hacer Administrador</a>
                                    </div>
                                </td>
                            </tr>
                            <% }
                        }%>     
                        </tbody>
                    </table>
                </div>
                <div class="card" >
                    <div class="card-header">
                        Profesores
                    </div>
                    <table class="table align-middle">
                        <thead>
                            <tr class="table-primary">
                                <th style="background-color:#00113D; color:#C5B268">idUsuario</th>
                                <th style="background-color:#00113D; color:#C5B268">Correo</th>
                                <th style="background-color:#00113D; color:#C5B268">Nombre</th>
                                <th style="background-color:#00113D; color:#C5B268">Apellidos</th>
                                <th style="background-color:#00113D; color:#C5B268">Fecha Nac</th>
                                <th style="background-color:#00113D; color:#C5B268">Profesores</th>
                                <th style="background-color:#00113D; color:#C5B268">Acciones</th>
                            </tr>
                        </thead>
                        <tbody>
                            <% if (profs != null) {
                            for (Usuario prof : profs) {%>
                            <tr>
                                <td><%=prof.getId_Usuario()%></td>
                                <td><%=prof.getCorreo()%></td>
                                <td><%=prof.getNombre()%></td>
                                <td><%=prof.getApellidos()%></td>
                                <td><%=prof.getFecha_Nac()%></td>
                                <td><%=prof.isProfesor()%></td>
                                <td>
                                    <div>
                                        <a href="HacerAlumno?id=<%=prof.getId_Usuario()%>" class="btn btn-info btn-sm">Hacer Alumno</a>
                                        <a href="HacerAdmin?id=<%=prof.getId_Usuario()%>" class="btn btn-dark btn-sm">Hacer Administrador</a>
                                    </div>
                                </td>
                            </tr>
                            <% }
                        }%>     
                        </tbody>
                    </table>
                </div>
                <div class="card" >
                    <div class="card-header">
                        Administradores
                    </div>
                    <table class="table align-middle">
                        <thead>
                            <tr class="table-primary">
                                <th style="background-color:#00113D; color:#C5B268">idUsuario</th>
                                <th style="background-color:#00113D; color:#C5B268">Correo</th>
                                <th style="background-color:#00113D; color:#C5B268">Nombre</th>
                                <th style="background-color:#00113D; color:#C5B268">Apellidos</th>
                                <th style="background-color:#00113D; color:#C5B268">Fecha Nac</th>
                                <th style="background-color:#00113D; color:#C5B268">Administradores</th>
                                <th style="background-color:#00113D; color:#C5B268">Acciones</th>
                            </tr>
                        </thead>
                        <tbody>
                            <% if (admins != null) {
                            for (Usuario admin : admins) {%>
                            <tr>
                                <td><%=admin.getId_Usuario()%></td>
                                <td><%=admin.getCorreo()%></td>
                                <td><%=admin.getNombre()%></td>
                                <td><%=admin.getApellidos()%></td>
                                <td><%=admin.getFecha_Nac()%></td>
                                <td><%=admin.isAdmin()%></td>
                                <td>
                                    <div>
                                        <a href="HacerAlumno?id=<%=admin.getId_Usuario()%>" class="btn btn-info btn-sm">Hacer Alumno</a>
                                        <a href="HacerProfesor?id=<%=admin.getId_Usuario()%>" class="btn btn-warning btn-sm">Hacer Profesor</a>
                                    </div>
                                </td>
                            </tr>
                            <% }
                        }%>     
                        </tbody>
                    </table>
                </div>
            </center>
        </div>
    </body>
</html>
