<%-- 
    Document   : iniciarSesion
    Created on : 20 oct. 2022, 21:35:13
    Author     : Ricardo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width", initial-scale="1.0">
        <jsp:include page="boostrap.jsp"></jsp:include>
            <title>Iniciar Sesión</title>




        </head>
        <body>
        <jsp:include page="header.jsp"></jsp:include>

    <center>
        <%
        String resp=(String)request.getAttribute("resp");
        %>
        <div class="container-sm">
            <div class="card" style="max-width: 40rem;">
                <div class="card-header">
                    Iniciar Sesión
                </div>
                <%
                    if (resp != null) {
                %>
                <div class="card-header alert alert-danger" role="alert">
                    <%=resp%>
                </div>
                <%
                    }
                %>
               
                <div class="card-body">
                    <form action="IniciarSesion" method="POST">
                        <div class="mb-3 row">
                            <label for="staticEmail" class="col-sm-2 col-form-label">Correo/Email</label>
                            <div class="col-sm-10">
                                <input type="user"  class="form-control-plaintext" name="correo" id="staticEmail" placeholder="ejemplo@gmail.com">
                            </div>
                        </div>
                        <div class="mb-3 row">
                            <label for="inputPassword" class="col-sm-2 col-form-label">Contraseña</label>
                            <div class="col-sm-10">
                                <input type="password" class="form-control" name="contra" id="inputPassword" placeholder="ejemContra1*">
                            </div>
                        </div>
                        <input type="submit" name="accion" value="IniciarSesion" class="btn btn-success">
                    </form>
                </div>
            </div>
        </div>
</center>





    </body>
</html>
