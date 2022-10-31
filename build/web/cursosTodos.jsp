<%-- 
    Document   : cursosTodos
    Created on : 30 oct. 2022, 18:11:36
    Author     : Ricardo
--%>

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
            String resp = (String) request.getAttribute("resp");
        %>
        <div class="container-sm">
            <div class="card" >
                <center><div class="card-header">
                    Todos los Cursos
                </div></center>

                <% if (Cursos != null) {
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
                                    <p class="card-text"><%=curTemp.getDescripcion()%></p>
                                    <a href="VerCurso?id=<%=curTemp.getId_Curso()%>" class="btn btn-primary">Ver Curso</a>
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

                        }
                    }%>


            </div>
    </body>
</html>
