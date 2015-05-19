<%-- 
    Document   : mostrarListadoPolizas
    Created on : 24-feb-2015, 17:02:58
    Author     : Arturo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><spring:message code="mostrarPolizas"/></title>
    </head>
    <body STYLE="background: #ccffcc">
        <h2  ALIGN="center" ALIGN="center"  STYLE="background: #7a997a; font: 36pt/40pt courier; font-variant: small-caps; border: thick dashed green"><spring:message code="mostrarPolizas"/></h2>

        <table border="1"  ALIGN="center">
            <thead STYLE="background: #7a997a">
            <th><spring:message code="cliente"/></th>
            <th><spring:message code="marca"/></th>
            <th><spring:message code="modelo"/></th>
            <th><spring:message code="matricula"/></th>
            <th><spring:message code="capitalMaximoPorSiniestro"/></th>
            <th><spring:message code="cuantia"/></th>
            <th><spring:message code="condiciones"/></th> 
            <th></th>
            <th></th>


        </thead>       


        <c:forEach items="${listaPolizas}" var="poliza">
            <tr>
                <td>  ${poliza.cliente.nombre}  </td>
                <td>  ${poliza.vehiculo.marca}  </td>
                <td>  ${poliza.vehiculo.modelo}  </td>
                <td>  ${poliza.vehiculo.matricula}  </td>
                <td>  ${poliza.capitalMaximoPorSiniestro}  </td>
                <td>  ${poliza.cuantia} </td>
                <td>  ${poliza.condiciones}  </td>



                <td>
                    <a href="editarPoliza.htm?idPoliza=${poliza.id}"><spring:message code="modificar"/></a></td>
                <td><a href="eliminarPoliza.htm?idPoliza=${poliza.id}"><spring:message code="eliminar"/></a>

                </td>

            </tr>
        </c:forEach> 
    </table>
    <br>
    <br>
    <h3  ALIGN="center"><a href="index.htm"><spring:message code="volver"/></a></h3>
</body>
</html>
