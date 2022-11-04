<%-- 
    Document   : agregarCurso
    Created on : 30 sep. 2022, 19:10:06
    Author     : Ricardo
--%>

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

        <div class="container-sm">
            <div class="card" >
                <div class="card-header">
                    Agregar Curso
                </div>
                <div style="display: flex; justify-content: space-between; align-items: center;">
                    <form action="CursoImg" method="POST" enctype="multipart/form-data" class="row g-3">
                        <div class="col-md-6">
                            <label for="formGroupExampleInput" class="form-label">Nombre del Curso</label>
                            <input type="text" name="nombreCurso" class="form-control" id="formGroupExampleInput" placeholder="Ingrese el nombre de su curso">
                        </div>
                        <div class="col-md-6">
                            <label for="formGroupExampleInput" class="form-label">Categoria</label>
                            <input type="text" name="categoria" class="form-control" id="formGroupExampleInput" placeholder="escribe la categoria en minusculas">
                        </div>
                        <div class="col-7">
                            <label for="exampleFormControlTextarea1" class="form-label">Descripción </label>
                            <textarea name="descripcion" class="form-control" id="exampleFormControlTextarea1" rows="10" placeholder="Describe el contenido de curso, cuenta un poco del perfil de estudiante o aprendizajes necesarios para tomar tu curso"></textarea>
                        </div>
                        <div class="col-5">
                            <label for="formFile" class="form-label">imágen</label>
                            <input name="imagen" class="form-control" type="file" id="formFile">
                            <br>
                            <input type="submit" name="accion" value="Guardar" class="btn btn-success">
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </center>


</body>
</html>
