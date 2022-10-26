<%-- 
    Document   : registarse
    Created on : 21 oct. 2022, 20:00:19
    Author     : Ricardo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <jsp:include page="boostrap.jsp"></jsp:include>
            <title>Registrarse</title>
        </head>
        <body>
        <jsp:include page="header.jsp"></jsp:include>
        <br>    
    <center>
        <div class="container-sm">
            <div class="card" >
                <div class="card-header">
                    Registrarse
                </div>
                <div style="display: flex; justify-content: space-between; align-items: center;">
                    <form action="Registarse" method="POST" class="row g-3">
                        <div class="col-md-6">
                            <label for="formGroupExampleInput" class="form-label">Correo/Emali</label>
                            <input type="text" name="correo" class="form-control" id="formGroupExampleInput" placeholder="ejemplo@gmail.com">
                        
                            <label for="formGroupExampleInput" class="form-label">Nombre</label>
                            <input type="text" name="nombre" class="form-control" id="formGroupExampleInput" placeholder="Ingrese su nombre">
                        
                            <label for="formGroupExampleInput" class="form-label">Apellidos</label>
                            <input type="text" name="apellidos" class="form-control" id="formGroupExampleInput" placeholder="Ingrese sus apellidos">
                        
                            <label for="formGroupExampleInput" class="form-label">Fecha de Nacimiento</label>
                            <label for="start">Start date:</label>

                            <input type="date" id="start" name="fecha"
                                   value=""
                                   min="1920-01-01" max="2022-01-01" class="form-control">                        
                        </div>
                        <div class="col-md-6">
                            <label for="formGroupExampleInput" class="form-label">Contraseña</label>
                            <label for="formGroupExampleInput" class="form-label"><mark>Debe contener al menos 8 caracteres, un número, una mayuscula y un caracter raro "¡,*,+,/, etc." </mark></label>
                            <input type="text" name="contra" class="form-control" id="formGroupExampleInput" placeholder="ejempContra1*">
                        
                            <label for="formGroupExampleInput" class="form-label">Repita Contraseña</label>
                            <input type="text" name="contra2" class="form-control" id="formGroupExampleInput" placeholder="ejempContra1*">
                            
                            <br>
                            <input type="submit" name="accion" value="Registrarse" class="btn btn-success" style=align-items: center">
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </center>    
</body>
</html>
