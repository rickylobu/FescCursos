<%-- 
    Document   : VerPractica
    Created on : 13 dic. 2022, 20:38:28
    Author     : Ricardo
--%>

<%@page import="dominio.Recurso"%>
<%@page import="java.util.List"%>
<%@page import="dominio.Practica"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <jsp:include page="boostrap.jsp"></jsp:include>
            <title>Ver Practica</title>
        </head>
        <body>
        <jsp:include page="header.jsp"></jsp:include>
            <br> 
        <%
            Practica prac = (Practica) request.getAttribute("practica");
            List<Recurso> recursos = (List<Recurso>) request.getAttribute("recursos");
        %>
    <center>
        <div class="container-sm">
            <div class="card" >
                <div class="card-header">
                    Ver Práctica: <%=prac.getNombre()%>
                </div>
                <div  class="card-body"style="display: flex; justify-content: space-between; align-items: center;">
                    <div class="row">
                        <div class="col-2">
                            <label for="formGroupExampleInput" class="form-label">Id Curso: <%=prac.getId_Curso()%></label>
                        </div>
                        <div class="col-2">
                            <label for="formGroupExampleInput" class="form-label">Id Practica: <%=prac.getId_Practica()%></label>
                        </div>
                        <div class="col-2">
                            <label for="formGroupExampleInput" class="form-label"># de Práctica: <%=prac.getNumeroPrac()%></label>
                        </div>
                        <div class="col-1">
                        </div>
                        <div class="col-5">
                            <div class="row">
                                <h5 for="formGroupExampleInput" class="form-label">Nombre de la Practica:</h5>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-6">
                                <br>
                                <label for="exampleFormControlTextarea1" class="form-label">Video</label>
                                <%=prac.getLink_Video()%>
                            </div>
                            <div class="col-1">
                            </div>
                            <div class="col-5">
                                <div class="row">
                                    <div class="row">
                                        <h3><%=prac.getNombre()%></h3>
                                    </div>
                                    <h5>Descripción</h5>
                                </div>
                                <div class="row">
                                    <p for="exampleFormControlTextarea1" class="form-label overflow-auto"  rows="6"><%=prac.getDescripcion()%></p>
                                </div>
                                <br>
                                <br>
                                <h5 for="exampleFormControlTextarea1" class="form-label">Recursos</h5>
                                <div class="row" style="background-color:#00113D; color:#C5B268">
                                    <div class="col-2">
                                        <label for="id" class="form-label">idRecurso:</label>
                                    </div>
                                    <div class="col-10">
                                        <label for="formGroupExampleInput" class="form-label">Nombre</label>
                                    </div>
                                </div>
                                <%for (Recurso rec : recursos) {%>
                                <div class="row">
                                    <div class="col-2">
                                        <label for="id" class="form-label"><%=rec.getIdRecurso()%></label>
                                    </div>
                                    <div class="col-10">
                                        <label for="formGroupExampleInput" class="form-label"><a href="<%=rec.getRecurso()%>"><%=rec.getNombre()%></a></label>
                                    </div>
                                </div>
                                <br>
                                <%}%>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

    </center>
</body>
</html>
