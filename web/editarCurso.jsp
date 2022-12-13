<%-- 
    Document   : editarCurso
    Created on : 11 oct. 2022, 22:45:16
    Author     : Ricardo
--%>

<%@page import="dominio.Practica"%>
<%@page import="java.util.List"%>
<%@page import="dominio.Curso"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <jsp:include page="boostrap.jsp"></jsp:include>
            <title>Editar Curso</title>
        </head>
        <body>
        <jsp:include page="header.jsp"></jsp:include>
            <br>  
        <%
            Curso curso = (Curso) request.getAttribute("curEdit");
            List<String> Categorias = (List<String>) request.getAttribute("categorias");
            List<Practica> practicas = (List<Practica>) request.getAttribute("practicas");
        %>
    <center>
        <div class="container-sm">
            <div class="card" >
                <div class="card-header">
                    Editar Curso
                </div>
                <div  class="card-body"style="display: flex; justify-content: space-between; align-items: center;">
                    <form action="ActualizarCurso" method="POST" enctype="multipart/form-data" class="col-12">
                        <div class="row">
                            <div class="col-8">
                                <div class="row">
                                    <div class="col-2">
                                        <label for="formGroupExampleInput" class="form-label">Id Curso</label>
                                        <input type="text" name="idCurso" class="form-control" id="formGroupExampleInput"  value="<%=curso.getId_Curso()%>">
                                    </div>
                                    <div class="col-10">
                                        <label for="formGroupExampleInput" class="form-label">Nombre del Curso</label>
                                        <input type="text" name="nombreCurso" class="form-control" id="formGroupExampleInput" placeholder="Ingrese el nombre de su curso" value="<%=curso.getNombre()%>">
                                    </div>
                                </div>
                                <div class="row">
                                    <label for="formGroupExampleInput" class="form-label">Categoria</label>
                                    <div class="col-5">
                                        <% if (Categorias.isEmpty()) {
                                            } else {%>
                                        <select class="form-select form-select-lg mb-3" aria-label=".form-select-lg example" name="categoria">
                                            <option selected><%=curso.getCategoria()%></option>
                                            <% for (String cat : Categorias) {%>
                                            <option value="<%=cat%>"><%=cat%></option>
                                            <% }%>
                                            <option value="otra">otra</option>
                                        </select>
                                        <% }%>
                                    </div>
                                    <div class="col-7">
                                        <input type="text" name="categoriaNueva" class="form-control text-lowercase" id="formGroupExampleInput" placeholder="si tu categoria es otra, escribe aquí la nueva categoria">
                                    </div>
                                </div>

                                <label for="exampleFormControlTextarea1" class="form-label">Descripción </label>
                                <textarea name="descripcion" class="form-control overflow-auto" id="exampleFormControlTextarea1" rows="6" placeholder="Describe el contenido de curso, cuenta un poco del perfil de estudiante o aprendizajes necesarios para tomar tu curso"><%=curso.getDescripcion()%></textarea>
                            </div>


                            <div class="col-4">
                                <label for="formFile" class="form-label">imágen</label>
                                <img src="<%=curso.getRutaImg()%>" class="col-11 img-fluid" style="padding-bottom: 1rem;">
                                <input name="imagen" class="form-control" type="file" id="formFile">
                                <br>
                                <input type="submit" name="accion" value="Guardar" class="btn btn-success">
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
        <div class="container-sm">
            <div class="card" >
                <div class="card-header">
                    Practicas
                </div>
                <center>
                    <a class="btn btn-success" href="NuevaPractica?id=<%=curso.getId_Curso()%>">Nuevo Practica</a>
                </center>
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
                            <a href="EditarPractica?id=<%=prac.getId_Practica()%>" class="btn btn-warning btn-sm">Editar</a>
                        </div>
                        <div class="col-2">
                            <a href="EliminarPractica?id=<%=prac.getId_Practica()%>" class="btn btn-danger btn-sm">Eliminar</a>
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
