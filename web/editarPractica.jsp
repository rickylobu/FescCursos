<%-- 
    Document   : editarPractica
    Created on : 12 dic. 2022, 00:16:09
    Author     : Ricardo
--%>

<%@page import="dominio.Recurso"%>
<%@page import="dominio.Practica"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <jsp:include page="boostrap.jsp"></jsp:include>
            <title>Editar Practica</title>
        </head>
        <body>
        <jsp:include page="header.jsp"></jsp:include>
            <br> 
        <%
            Practica prac = (Practica) request.getAttribute("practicaEditar");
            List<Recurso> recursos = (List<Recurso>) request.getAttribute("recursos");
        %>
    <center>
        <div class="container-sm">
            <div class="card" >
                <div class="card-header">
                    Editar Práctica
                </div>
                <div  class="card-body"style="display: flex; justify-content: space-between; align-items: center;">
                    <form action="ActualizarPractica" method="POST" class="col-12">
                        <div class="row">
                            <div class="col-2">
                                <label for="formGroupExampleInput" class="form-label">Id Curso</label>
                                <input type="text" readonly=»readonly» name="idCurso" class="form-control" id="formGroupExampleInput"  value="<%=prac.getId_Curso()%>">
                            </div>
                            <div class="col-2">
                                <label for="formGroupExampleInput" class="form-label">Id Practica</label>
                                <input type="text" readonly=»readonly» name="idPractica" class="form-control" id="formGroupExampleInput"  value="<%=prac.getId_Practica()%>">
                            </div>
                            <div class="col-2">
                                <label for="formGroupExampleInput" class="form-label"># de Práctica</label>
                                <input type="text" name="numeroPrac" class="form-control" id="formGroupExampleInput"  value="<%=prac.getNumeroPrac()%>">
                            </div>
                            <div class="col-1">
                            </div>
                            <div class="col-5"
                                 <label for="formGroupExampleInput" class="form-label">Nombre de la Practica</label>
                                <input type="text" name="nombrePractica" class="form-control" id="formGroupExampleInput" value="<%=prac.getNombre()%>" placeholder="Ingrese el nombre de su práctica">
                            </div>
                            <div class="row">
                                <div class="col-6">
                                    <br>
                                    <label for="exampleFormControlTextarea1" class="form-label">Video Actual</label>
                                    <%=prac.getLink_Video()%>
                                </div>
                                <div class="col-1">

                                </div>
                                <div class="col-5">
                                    <label for="exampleFormControlTextarea1" class="form-label">Descripción </label>
                                    <textarea name="descripcion" class="form-control overflow-auto" id="exampleFormControlTextarea1" rows="6" placeholder="Describa el contenido de practica"><%=prac.getDescripcion()%></textarea>

                                    <label for="exampleFormControlTextarea1" class="form-label">Link de Youtube <"iframe"> </label>
                                    <textarea name="urlVideo" class="form-control overflow-auto" id="exampleFormControlTextarea1" rows="6" placeholder="1.- En su video de youtube presione 'compartir' 2.- presione insertar <> 3.- copie y pegue aquí el iframe"><%=prac.getLink_Video()%></textarea>
                                    <br>
                                    <input type="submit" name="accion" value="Guardar" class="btn btn-success">

                                </div>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
        <div class="container-sm">
            <div class="card" >
                <div class="card-header">
                    Recursos
                </div>
                <div  class="card-body"style="display: flex; justify-content: space-between; align-items: center;">
                    <form action="AgregarRecurso" method="POST" enctype="multipart/form-data" class="col-12">
                        <div class="row">
                            <div class="col-6">
                                <%for (Recurso rec : recursos) {%>
                                <div class="row">
                                    <div class="col-2">
                                        <label for="id" class="form-label">idRecurso: <%=rec.getIdRecurso()%></label>
                                    </div>
                                    <div class="col-8">
                                        <label for="formGroupExampleInput" class="form-label"><a href="<%=rec.getRecurso()%>"><%=rec.getNombre()%></a></label>
                                    </div>
                                    <div class="col-2">
                                        <a href="EliminarResurso?id=<%=rec.getIdRecurso()%>" class="btn btn-danger btn-sm">Eliminar</a>
                                    </div>
                                </div>
                                <br>
                                <%}%>
                            </div>
                            <div class ="col-6">
                                <div class="row">
                                    <div class="col-3">
                                        <label for="formFile" class="form-label" >Agregar recurso</label>  
                                    </div>
                                    <div class="col-2">
                                        id Curso:
                                    </div>
                                    <div class="col-2">
                                        <input type="text" readonly=»readonly» name="idCurso" class="form-control" id="formGroupExampleInput"  value="<%=prac.getId_Curso()%>">
                                    </div>
                                    <div class="col-3">
                                        id Práctica:
                                    </div>
                                    <div class="col-2">
                                        <input type="text" readonly=»readonly» name="idPractica" class="form-control" id="formGroupExampleInput"  value="<%=prac.getId_Practica()%>">
                                    </div>
                                </div>

                                <input name="recurso" class="form-control" type="file" id="formFile">
                                <br>
                                <input type="text" name="nombreRecurso" class="form-control text-lowercase" id="formGroupExampleInput" placeholder="nombre del recurso">
                                <label for="exampleFormControlTextarea1" class="form-label">Puedes subir más recursos uno por uno</label>
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
