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
        <center>
            
        <div class="container-sm">
            <div class="card" >
                <div class="card-header">
                    Video: Bienvenido a FescCursos
                </div>
                <div  class="card-body"style="display: flex; justify-content: space-between; align-items: center;">
                    <div class="row">
                        <div class="col-12" style="padding-left: 280px">
                            <iframe width="560" height="315" src="https://www.youtube.com/embed/7oJ_JGsDDTk" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share" allowfullscreen></iframe>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        </center>
</body>
</html>
