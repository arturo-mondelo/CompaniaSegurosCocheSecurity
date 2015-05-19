<%-- 
    Document   : mostrarListadoDeClientes
    Created on : 24-feb-2015, 11:52:14
    Author     : admin1
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><spring:message code="mostrarClientes"/></title>
    </head>
    <body STYLE="background: #ccffcc">
       <h2  ALIGN="center" STYLE="background: #7a997a; font: 36pt/40pt courier; font-variant: small-caps; border: thick dashed green"><spring:message code="mostrarClientes"/></h2>

       <table border="1"  ALIGN="center">
                <thead STYLE="background: #7a997a">
                    <th><spring:message code="nombre"/></th>
                    <th><spring:message code="edad"/></th>
                    <th><spring:message code="dni"/></th> 
                    <th><spring:message code="calle"/></th>
                    <th><spring:message code="numero"/></th>
                    <th><spring:message code="piso"/></th>
                    <th><spring:message code="cp"/></th>
                    <th><spring:message code="polizas"/></th>
                    <th></th>
                    <th></th>
                    </thead>
             

        
        <c:forEach items="${listaClientes}" var="cliente">
        <tr>
            <td>  ${cliente.nombre}  </td>
            <td>  ${cliente.edad} </td>
            <td>  ${cliente.dni}  </td>
            <td>  ${cliente.direccion.calle}  </td>
            <td>  ${cliente.direccion.numero}  </td>
            <td>  ${cliente.direccion.piso}  </td>
            <td>  ${cliente.direccion.cp}  </td>
             <td>
                        <c:forEach items="${cliente.polizas}" var="pol">
                             ${pol.id}  ${pol.vehiculo.marca} ${pol.vehiculo.modelo}<br>
                        </c:forEach>
                    </td>
                    
                    <td> <a href="editarCliente.htm?idCliente=${cliente.id}"><spring:message code="modificar"/></a></td>
                    <td><a href="eliminarCliente.htm?idCliente=${cliente.id}"><spring:message code="eliminar"/></a></td>
       

        </tr>
    </c:forEach>
    </table>
                    <br>
                    <h3  ALIGN="center"><a href="index.htm"><spring:message code="volver"/></a></h3>
    </body>
</html>
