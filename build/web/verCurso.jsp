<%-- 
    Document   : verCurso
    Created on : 1 nov. 2022, 23:06:24
    Author     : Ricardo
--%>

<%@page import="dominio.Practica"%>
<%@page import="dominio.Curso"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <jsp:include page="boostrap.jsp"></jsp:include>
        <%
            Curso curso = (Curso) request.getAttribute("cursoSelec");
            String resp = (String) request.getAttribute("resp");
            String resp2 = (String) request.getAttribute("resp2");
            List<Practica> practicas = (List<Practica>) request.getAttribute("practicas");

        %>
        <title><%=curso.getNombre()%></title>
    </head>
    <body>
        <jsp:include page="header.jsp"></jsp:include>
            <br> 
        <center>
            <div class="container-sm">
            <%if (resp != null) {%>
            <center>
                <div class="card-header alert alert-danger" role="alert">
                    <%=resp%>
                </div>
            </center>
            <%}%>
            <%if (resp2 != null) {%>
            <center>
                <div class="card-header alert alert-success" role="alert">
                    <%=resp2%>
                </div>
            </center>
            <%}%>
            <div class="card" style="display: flex; justify-content: space-between; align-items: center;">
                <div class="card-header">
                    Ver Curso: <%=curso.getNombre()%>
                </div>
                <div class="row">
                    <div class="col">
                        <h3 ><%=curso.getNombre()%></h3>
                        <div class="row">
                            <div class="col">
                                <h5 >Id Curso: <%=curso.getId_Curso()%></h5>
                            </div>
                            <div class="col">
                                <h5 >Categoria: <%=curso.getCategoria()%></h5>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col">
                                <h5 >Profesor: <%=curso.getNombreProf()%></h5>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col">
                                <p ><%=curso.getDescripcion()%></p>
                            </div>
                        </div>
                    </div>
                    <div class="col">
                        <a class="btn btn-success" href="MisCursosAgregar?id=<%=curso.getId_Curso()%>">Agregar a Mis Cursos</a>
                        <br>
                        <img src="<%=curso.getRutaImg()%>" class="img-fluid">  
                    </div>
                </div>

            </div>
        </div>
        <div class="container-sm">
            <div class="card" >
                <div class="card-header">
                    Practicas
                </div>
                <div  class="card-body"style="justify-content: space-between; align-items: center;">
                    <div class="row" style="background-color:#00113D; color:#C5B268">
                        <div class="col-2">
                            <label for="id" class="form-label"># Practica</label>
                        </div>
                        <div class="col-6">
                            <label for="formGroupExampleInput" class="form-label">Nombre</label>
                        </div>
                        <div class="col-4">
                            <label for="formGroupExampleInput" class="form-label">Acciones</label>
                        </div>
                    </div>
                    <br>
                    <%for (Practica prac : practicas) {%>
                    <div class="row">
                        <div class="col-2">
                            <label for="id" class="form-label"><%=prac.getNumeroPrac()%></label>
                        </div>
                        <div class="col-6">
                            <label for="formGroupExampleInput" class="form-label"><%=prac.getNombre()%></label>
                        </div>
                        <div class="col-2">
                            <a href="VerPractica?id=<%=prac.getId_Practica()%>" class="btn btn-warning btn-sm">Ver Práctica</a>
                        </div>
                    </div>
                    <br>
                    <%}%>
                </div>
            </div>
        </div>
    </center>
</body>
</html>
