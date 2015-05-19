<%-- 
    Document   : editarVehiculo
    Created on : 25-feb-2015, 12:06:25
    Author     : admin1
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><spring:message code="editarVehiculo.Title"/></title>
    </head>
    <body STYLE="background: #ccffcc">
        <h2 ALIGN="center" STYLE="background: #7a997a; font: 36pt/40pt courier; font-variant: small-caps; border: thick dashed green"><spring:message code="editarVehiculo.Header"/></h2>
    <form:form action="modificarVehiculo.htm" method="post" commandName="miVehiculoModificado">
        <table border="1" ALIGN="center">
            <tr STYLE="background: #7a997a">

            <h3><td><spring:message code="marca"/></td>
                <td><spring:message code="modelo"/></td>
                <td><spring:message code="matricula"/></td>
                <td><spring:message code="numeroPuertas"/></td>
                <td><spring:message code="color"/></td>
                <td><spring:message code="cv"/></td>
            </h3>

            </tr>

            <tr>
            <form:hidden path="id"/> 
            <td> <form:input path="marca" STYLE="background: #ccffcc"/></td>
            <td> <form:input path="modelo" STYLE="background: #ccffcc"/></td>
            <td> <form:input path="matricula" STYLE="background: #ccffcc"/></td>
            <form:errors path="matricula"/>
            <td> <form:input path="numeroPuertas" STYLE="background: #ccffcc"/></td>
            <form:errors path="numeroPuertas"/>
            <td> <form:input path="color" STYLE="background: #ccffcc"/></td>
            <td> <form:input path="cv" STYLE="background: #ccffcc"/></td>
            <form:errors path="cv"/>
            
            </tr>

      
    </form:form>
        </table>
        <br>
        <h2 ALIGN="center"><input type="submit" value="<spring:message code="enviar"/>"></input></h2>
        <br>
          <h3  ALIGN="center"><a href="mostrarVehiculos.htm"><spring:message code="volverCliente"/></a></h3>
</body>
</html>
