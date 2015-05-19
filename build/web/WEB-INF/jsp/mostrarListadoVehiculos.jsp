<%-- 
    Document   : mostrarListadoVehiculos
    Created on : 24-feb-2015, 18:07:11
    Author     : Arturo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><spring:message code="mostrarVehiculos"/></title>
    </head>
    <body STYLE="background: #ccffcc">
        <h2  ALIGN="center"  STYLE="background: #7a997a; font: 36pt/40pt courier; font-variant: small-caps; border: thick dashed green"><spring:message code="mostrarVehiculos"/></h2>

        <table border="1"  ALIGN="center">
            <thead STYLE="background: #7a997a">
            <th><spring:message code="marca"/></th> 
            <th><spring:message code="modelo"/></th>
            <th><spring:message code="matricula"/></th>
            <th><spring:message code="color"/></th>
            <th><spring:message code="cv"/></th>
            <th><spring:message code="numeroPuertas"/></th>
            <th></th>
            <th></th>

        </thead>       


        <c:forEach items="${listaVehiculos}" var="vehiculo">
            <tr>
                <td>  ${vehiculo.marca}  </td>
                <td>  ${vehiculo.modelo}  </td>
                <td>  ${vehiculo.matricula} </td>
                <td>  ${vehiculo.color}  </td>
                <td>  ${vehiculo.cv}  </td>
                <td>  ${vehiculo.numeroPuertas}  </td>



                <td>
                    <a href="editarVehiculo.htm?idVehiculo=${vehiculo.id}"><spring:message code="modificar"/></a></td>
                <td><a href="eliminarVehiculo.htm?idVehiculo=${vehiculo.id}"><spring:message code="eliminar"/></a>

                </td>

            </tr>

        </c:forEach> 
    </table>
    <h3  ALIGN="center"><a href="index.htm"><spring:message code="volver"/></a></h3>
</body>
</html>
