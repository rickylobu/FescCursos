<%-- 
    Document   : agregarPractica
    Created on : 8 nov. 2022, 16:32:04
    Author     : Ricardo
--%>

<%@page import="dominio.Curso"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8" />
        <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
        <jsp:include page="boostrap.jsp"></jsp:include>
            <title>Agregar Práctica</title>
        </head>
        <body>
        <jsp:include page="header.jsp"></jsp:include>
            <br>    
        <center>
        <%
            Curso cur = (Curso) request.getAttribute("CursoPractica");
            int idCurso = cur.getId_Curso();
            String nombreCurso = cur.getNombre();
            String numeroP=String.valueOf(request.getAttribute("numeroPractica"));
            int numeroPrac=Integer.parseInt(numeroP);
        %> 
        <div class="container-sm">
            <div class="card" >
                <div class="card-header">
                    Agregar Practica a Curso id: <%=idCurso%> "<%=nombreCurso%>"
                </div>
                <div  class="card-body"style="display: flex; justify-content: space-between; align-items: center;">
                    <form action="AgregarPractica" method="POST" enctype="multipart/form-data" class="col-12">
                        <div class="row">
                            <div class="col-7">
                                <div class ="row">
                                    <div class="col-2">
                                        <label for="formGroupExampleInput" class="form-label" >id Curso</label>
                                        <input type="text" name="idCurso" class="form-control" id="formGroupExampleInput" value="<%=idCurso%>">
                                    </div>
                                    <div class="col-2">
                                        <label for="formGroupExampleInput" class="form-label" ># Práctica</label>
                                        <input type="text" name="numeroPrac" class="form-control" id="formGroupExampleInput" value="<%=numeroPrac%>">
                                    </div>
                                    <div class="col-8"
                                         <label for="formGroupExampleInput" class="form-label">Nombre de la Practica</label>
                                        <input type="text" name="nombrePractica" class="form-control" id="formGroupExampleInput" placeholder="Ingrese el nombre de su práctica">
                                    </div>
                                </div>
                                <label for="exampleFormControlTextarea1" class="form-label">Descripción </label>
                                <textarea name="descripcion" class="form-control overflow-auto" id="exampleFormControlTextarea1" rows="10" placeholder="Describa el contenido de practica"></textarea>
                            </div>
                            <div class="col-5">
                                <label for="exampleFormControlTextarea1" class="form-label">Link de Youtube <"iframe"> </label>
                                <textarea name="urlVideo" class="form-control overflow-auto" id="exampleFormControlTextarea1" rows="5" placeholder="1.- En su video de youtube presione 'compartir' 2.- presione insertar <> 3.- copie y pegue aquí el iframe"></textarea>
                                <label for="formFile" class="form-label">Recurso</label>
                                <input name="recurso" class="form-control" type="file" id="formFile">
                                <br>
                                <input type="text" name="nombreRecurso" class="form-control text-lowercase" id="formGroupExampleInput" placeholder="nombre del recurso">
                                <label for="exampleFormControlTextarea1" class="form-label">Si requieres subir más recursos los puedes agregar en EditarPractica</label>
                                <br>
                                <input type="submit" name="accion" value="Guardar" class="btn btn-success">
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>

    </body>
</html>
