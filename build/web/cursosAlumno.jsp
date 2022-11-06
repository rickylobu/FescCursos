<%-- 
    Document   : cursosAlumno
    Created on : 1 nov. 2022, 21:16:46
    Author     : Ricardo
--%>

<%@page import="dominio.Curso"%>
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

        <%
            HttpSession sesion = request.getSession();
            Usuario alumno = (Usuario) sesion.getAttribute("user");
        %>
        <title>Cursos de <%=alumno.getNombre()%></title>
    </head>
    <body>
        <jsp:include page="header.jsp"></jsp:include>
        <%
            List<Curso> Cursos = (List<Curso>) request.getAttribute("lista");
            String resp = (String) request.getAttribute("resp");
        %>
        <div class="container-sm">
            <div class="card" >
                <center><div class="card-header">
                        Cursos de <%=alumno.getNombre()%>
                    </div></center>

                <% if (Cursos.isEmpty()) {%>
                <center>
                    <div class="card-header alert alert-success" role="alert">
                        Aquí aparecerán sus cursos, presione el botón "Añadir a Mis Cursos"<br> Puedes explorar en <strong><a href="CursosTodos?listar" style="color: #AA9A70; font-size: 23px;">Cursos</a></strong><br>Mucho éxito en tu aprendizaje <%=alumno.getNombre() + " " + alumno.getApellidos()%>
                    </div>
                </center>                    
                <%} else {
                    int fila = 0;
                    for (Curso curTemp : Cursos) {
                        if (fila == 0) {%>
                <div class="row">
                    <%}%>

                    <div class="col-4">
                        <center>
                            <div class="card" style="width: 18rem;">
                                <img src="<%=curTemp.getRutaImg()%>">
                                <div class="card-body">
                                    <h5 class="card-title"><%=curTemp.getNombre()%></h5>
                                    <h6 class="card-title"><%=curTemp.getNombreProf()%></h6>
                                    <h6 class="card-title"><%=curTemp.getCategoria()%></h6>
                                    <div style="vertical-align: middle;">
                                        <div class="overflow-auto text-sm-center" style="height: 5rem;">
                                            <p class="card-text"><%=curTemp.getDescripcion()%></p>
                                        </div>
                                    </div>                                    
                                    <div class="row">
                                        <div class="col">
                                            <a href="VerCurso?id=<%=curTemp.getId_Curso()%>" class="btn btn-primary">Ver Curso</a>
                                        </div>
                                        <div class="col">
                                            <a href="EliminarMisCursos?id=<%=curTemp.getId_Curso()%>" class="btn btn-danger">Remover</a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </center>
                    </div>
                    <%
                        fila++;
                        if (fila == 3) {%>
                </div>
                <%  fila = 0;
                        }

                    }%>

                <%}%>
            </div>

        </div>
    </body>
</html>
