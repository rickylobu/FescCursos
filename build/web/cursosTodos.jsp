<%-- 
    Document   : cursosTodos
    Created on : 30 oct. 2022, 18:11:36
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
            <title>Cursos Fesc</title>
        </head>
        <body>
        <jsp:include page="header.jsp"></jsp:include>
        <%
            List<Curso> Cursos = (List<Curso>) request.getAttribute("lista");
            List<String> Categorias = (List<String>) request.getAttribute("categorias");
            List<Usuario> Profesores = (List<Usuario>) request.getAttribute("profesores");
            String busco = request.getParameter("busco");
            String busqueda = request.getParameter("busqueda");
        %>
        <div class="container-sm">
            <div class="card" >
                <center><div class="card-header">
                        <% if (busco != null) {
                                switch (busco) {
                                    case "xNombreCurso":%>
                        Busqueda por Nombre: <%=busqueda%>
                        <% break;
                            case "xCategoria":%>
                        Busqueda por Categoria: <%=busqueda%>
                        <% break;
                            case "xProfesor":%>
                        Busqueda por Profesor: <%=busqueda%>
                        <% break;
                            default:%>
                        Todos los Cursos
                        <% break;
                            }
                        } else { %>
                        Todos los Cursos
                        <% } %>
                    </div></center>

                <div class="card-body">
                    <div class="container">
                        <form action="CursosForm" method="POST" class="col-12">
                            <div class="row" style="align-items: center; vertical-align: middle">
                                <div class="col-4">
                                    <input type="text" name="nombreCurso" class="form-control-lg" id="formGroupExampleInput" placeholder="Ingrese el nombre del curso que Busca">
                                </div> 
                                <% if (Categorias.isEmpty()) {
                                    } else {%>
                                <div class="col-3">
                                    <select class="form-select form-select-lg mb-3" aria-label=".form-select-lg example" name="categoria">
                                        <option selected>Categorias</option>
                                        <% for (String cat : Categorias) {%>
                                        <option value="<%=cat%>"><%=cat%></option>

                                        <% }%>
                                    </select>
                                </div>
                                <% }%>
                                <% if (Profesores.isEmpty()) {
                                    } else {%>
                                <div class="col-3">
                                    <select class="form-select form-select-lg mb-3" aria-label=".form-select-lg example" name="idProfesor">
                                        <option selected>Profesores</option>
                                        <% for (Usuario usr : Profesores) {%>
                                        <option value="<%=usr.getId_Usuario()%>"><%=usr.getNombre()%></option>

                                        <% }%>
                                    </select>
                                </div>
                                <% }%>
                                <div class="col-1">
                                    <input type="submit" name="accion" value="Buscar" class="btn btn-primary btn-gl">
                                </div>
                            </div>
                        </form>
                    </div>
                    <% if (Cursos.isEmpty()) {

                        } else {
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
                                        <a href="VerCurso?id=<%=curTemp.getId_Curso()%>" class="btn btn-primary">Ver Curso</a>
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
