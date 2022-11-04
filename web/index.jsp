<%-- 
   Document   : index
   Created on : 29 sep. 2022, 19:50:32
   Author     : Ricardo
--%>

<%@page import="dominio.Curso"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width", initial-scale="1.0">
        <jsp:include page="boostrap.jsp"></jsp:include>

            <title>FescCursos</title>
        </head>
        <body>
        <jsp:include page="header.jsp"></jsp:include>

        <%
            List<Curso> Cursos = (List<Curso>) request.getAttribute("lista");
            String resp = (String) request.getAttribute("resp");

            if (resp != null) {
        %>
    <center>
        <div class="card-header alert alert-success" role="alert">
            <%=resp%>
        </div>
    </center>
    <%}%>
</body>
</html>
