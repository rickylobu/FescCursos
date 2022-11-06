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
        <nav class="navbar navbar-expand-md" style="background-color:#00113D;" >
            <div class="container">
                <center>
                    <div style="display: flex; justify-content: space-between; align-items: center;">
                        <a href="index.jsp">
                            <img src="img/logoFesc.png" alt="insert" width="92" height="103" padding="2px" />
                            <h6 class="nav-item" style="color: #AA9A70; font-size: small;"">Home</h6>                    
                        </a>
                    </div>
                </center>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarScroll" aria-controls="navbarScroll" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarScroll" style="display: flex; justify-content: space-between;">
                    <ul class="navbar-nav me-auto mb-2 my-lg-0 navbar-nav-scroll" style="--bs-scroll-height: 100px; display: contents;" >
                        <li class="nav-item" style="padding-right:2rem; padding-left: 12rem;">
                            <strong><a class="nav-link" href="CursosTodos?listar" style="padding-left:50px; color: #AA9A70; font-size: x-large;">Cursos</a></strong>
                        </li>
                        <li class="nav-item" style="padding-right:2rem;">
                            <strong><a class="nav-link" href="Asesorias?listar" style="padding-left:50px; color: #AA9A70; font-size: x-large;">Asesorias</a></strong>
                        </li>
                        <li class="nav-item" style="padding-right:12rem;">
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

                        <li><a class="dropdown-item" href="MisCursosAlumno">Mis Cursos</a></li>


                        <%
                            }
                            if (sesion.getAttribute("tipo") == "profesor") {
                        %>

                        <li><a class="dropdown-item" href="MisCursosProfesor">Mis Cursos</a></li>

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
            </div>
        </nav>



    </body>
</html>
