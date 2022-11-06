<%-- 
    Document   : agregarCurso
    Created on : 30 sep. 2022, 19:10:06
    Author     : Ricardo
--%>

<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8" />
        <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
        <jsp:include page="boostrap.jsp"></jsp:include>
            <title>Agregar Curso</title>
        </head>

        <body>
        <jsp:include page="header.jsp"></jsp:include>
            <br>    
        <center>
        <%
            List<String> Categorias = (List<String>) request.getAttribute("categorias");
        %>
        <div class="container-sm">
            <div class="card" >
                <div class="card-header">
                    Agregar Curso
                </div>
                <div  class="card-body"style="display: flex; justify-content: space-between; align-items: center;">
                    <form action="CursoImg" method="POST" enctype="multipart/form-data" class="col-12">
                        <div class="row">
                            <div class="col-7">
                                <label for="formGroupExampleInput" class="form-label">Nombre del Curso</label>
                                <input type="text" name="nombreCurso" class="form-control" id="formGroupExampleInput" placeholder="Ingrese el nombre de su curso">
                                <label for="exampleFormControlTextarea1" class="form-label">Descripción </label>
                                <textarea name="descripcion" class="form-control overflow-auto" id="exampleFormControlTextarea1" rows="10" placeholder="Describe el contenido de curso, cuenta un poco del perfil de estudiante o aprendizajes necesarios para tomar tu curso"></textarea>
                            </div>
                            <div class="col-5">
                                <label for="formGroupExampleInput" class="form-label">Categoria</label>
                                <% if (Categorias.isEmpty()) {
                                    } else { %>
                                <select class="form-select form-select-lg mb-3" aria-label=".form-select-lg example" name="categoria">
                                    <option selected>Categorias</option>
                                    <% for (String cat : Categorias) {%>
                                    <option value="<%=cat%>"><%=cat%></option>

                                    <% }%>
                                    <option value="otra">otra</option>
                                </select>

                                <input type="text" name="categoriaNueva" class="form-control text-lowercase" id="formGroupExampleInput" placeholder="si tu categoria es otra, escribe aquí la nueva categoria">
                                <% }%>
                                <label for="formFile" class="form-label">imágen</label>
                                <input name="imagen" class="form-control" type="file" id="formFile">
                                <br>
                                <input type="submit" name="accion" value="Guardar" class="btn btn-success">

                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </center>


</body>
</html>
