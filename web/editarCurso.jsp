<%-- 
    Document   : editarCurso
    Created on : 11 oct. 2022, 22:45:16
    Author     : Ricardo
--%>

<%@page import="dominio.Curso"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <jsp:include page="boostrap.jsp"></jsp:include>
        
    </head>
    <body>
        <jsp:include page="header.jsp"></jsp:include>
        <br>    
    <center>
        <form action="pruebaServletDao" method="POST">
                <input type="submit" name="accion" value="Listar">

            </form>
    <%
        
    Curso curso=(Curso)request.getAttribute("curEdit");
    
    %>
        <div style="display: flex; justify-content: space-between; align-items: center;">
        <form action="ActualizarCurso" method="POST" enctype="multipart/form-data" class="row g-3">
            <div class="col-md-6">
                <label for="formGroupExampleInput" class="form-label">Id Curso</label>
                <input type="text" name="idCurso" class="form-control" id="formGroupExampleInput" value="<%=curso.getId_Curso()%>">
            </div>
            <div class="col-md-6">
                <label for="formGroupExampleInput" class="form-label">Nombre del Curso</label>
                <input type="text" name="nombreCurso" class="form-control" id="formGroupExampleInput" placeholder="Ingrese el nombre de su curso" value="<%=curso.getNombre()%>">
            </div>
            <div class="col-md-6">
                <label for="formGroupExampleInput" class="form-label">Categoria</label>
                <input type="text" name="categoria" class="form-control" id="formGroupExampleInput" placeholder="escribe la categoria en minusculas" value="<%=curso.getCategoria()%>">
            </div>
            <div class="col-7">
                <label for="exampleFormControlTextarea1" class="form-label">Descripción </label>
                <textarea name="descripcion" class="form-control" id="exampleFormControlTextarea1" rows="10" placeholder="Describe el contenido de curso, cuenta un poco del perfil de estudiante o aprendizajes necesarios para tomar tu curso"><%=curso.getDescripcion()%></textarea>
            </div>
            <div class="col-5">
                <label for="formFile" class="form-label">imágen</label>
                <img src="<%=curso.getRutaImg()%>" width="250" height="200">
                <input name="imagen" class="form-control" type="file" id="formFile">
                <br>
            <input type="submit" name="accion" value="Guardar" class="btn btn-success">
            </div>
            </form>
            </div>
    </center>
    </body>
</html>
