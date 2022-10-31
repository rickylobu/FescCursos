<%-- 
    Document   : header
    Created on : 1 oct. 2022, 17:09:46
    Author     : Ricardo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <nav class="navbar" style="background-color:#00113D;" >
            <div class="container-fluid">
                <div style="display: flex; justify-content: space-between; align-items: center;">
                    <a href="index.jsp">
                        <img src="img/logoFesc.png" alt="insert" width="92" height="103" padding="2px" />

                    </a>
                </div>
                <div style="display: flex; justify-content: space-between; align-items: center;">
                    <ul class="navbar-nav me-auto mb-2 mb-lg-0" style="flex-direction: row;" >
                        <li class="nav-item">
                            <strong><a class="nav-link" href="CursosTodos?listar" style="padding-left:50px; color: #AA9A70; font-size: x-large;">Cursos</a></strong>
                        </li>
                        <li class="nav-item">
                            <strong><a class="nav-link" href="Asesorias?listar" style="padding-left:50px; color: #AA9A70; font-size: x-large;">Asesorias</a></strong>
                        </li>
                        <li class="nav-item">
                            <strong><a class="nav-link" href="Profesores?listar" style="padding-left:50px; color: #AA9A70; font-size: x-large;">Profesores</a></strong>
                        </li>
                    </ul>
                </div>
                <%
                    HttpSession sesion = request.getSession();
                    if (sesion.getAttribute("log") != null) {
                %>
                <div class="btn-group">
                    <button type="button" class="btn btn-warning dropdown-toggle" data-bs-toggle="dropdown" aria-expanded="false">Cerrar Sesión</button>
                    <ul class="dropdown-menu">
                        <li><a class="dropdown-item" href="cerrar_sesion.jsp">Cerrar Sesión</a></li>
                        <li><hr class="dropdown-divider"></li>
                            <%
                                if (sesion.getAttribute("tipo") == "alumno") {
                            %>

                        <li><a class="dropdown-item" href="MisCursosAlumno?<%=sesion.getAttribute("id")%>">Mis Cursos</a></li>


                        <%
                            }
                            if (sesion.getAttribute("tipo") == "profesor") {
                        %>

                        <li><a class="dropdown-item" href="MisCursosProfesor?<%=sesion.getAttribute("id")%>">Mis Cursos</a></li>

                        <%
                            }
                            if (sesion.getAttribute("tipo") == "admin") {
                        %>

                        <li><a class="dropdown-item" href="AdminDesplegar">Administrador</a></li>

                        <%
                            }
                        } else {
                        %>  
                        <div class="btn-group">
                            <button type="button" class="btn btn-warning dropdown-toggle" data-bs-toggle="dropdown" aria-expanded="false">Iniciar Sesión<br><mark style="background-color: #3565E1";>¿aún no tienes cuenta?</mark></button>
                            <ul class="dropdown-menu">
                                <li><a class="dropdown-item" href="iniciarSesion.jsp">Iniciar Sesión</a></li>
                                <li><hr class="dropdown-divider"></li>
                                <li><a class="dropdown-item" href="registarse.jsp">Registrarse</a></li>
                            </ul>
                        </div>

                        <%
                            }
                        %>
                </div>
        </nav>



    </body>
</html>
