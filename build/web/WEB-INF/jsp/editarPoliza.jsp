<%-- 
    Document   : editarPoliza
    Created on : 24-feb-2015, 17:12:22
    Author     : Arturo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><spring:message code="editarPoliza.Title"/></title>
    </head>
    <body STYLE="background: #ccffcc">
        <h2 ALIGN="center" STYLE="background: #7a997a; font: 36pt/40pt courier; font-variant: small-caps; border: thick dashed green"><spring:message code="editarPoliza.Header"/></h2>
        <form:form action="modificarPoliza.htm" method="post" commandName="miPolizaModificada">
            <table border="1" ALIGN="center">
                <tr STYLE="background: #7a997a">

                <h3><td> <spring:message code="capitalMaximoPorSiniestro"/></td>
                    <td><spring:message code="cuantia"/></td>
                    <td><spring:message code="condiciones"/></td>
                    <td><spring:message code="vehiculo"/></td>
                    <td><spring:message code="cliente"/></td>
                </h3>

            </tr>

            <tr>
                <form:hidden path="id"/> 
                <td> <form:input path="capitalMaximoPorSiniestro" STYLE="background: #ccffcc"/></td>
                <td> <form:input path="cuantia" STYLE="background: #ccffcc"/></td>
                <td> <form:input path="condiciones" STYLE="background: #ccffcc"/></td>
                <td> <form:select path="vehiculo" STYLE="background: #ccffcc">
                        <form:options items="${listaVehiculosModificados}" itemValue="id" itemLabel="matricula"/>


                    </form:select></td>
                <td> <form:select path="cliente" STYLE="background: #ccffcc">
                        <form:options items="${listaClientesModificados}" itemValue="id" itemLabel="nombre"/>


                    </form:select></td>
            </tr>

        </form:form> 
    </table>
    <br>
        <h2 ALIGN="center"><input type="submit" value="<spring:message code="enviar"/>"></input></h2>
        <br>
          <h3  ALIGN="center"><a href="mostrarPolizas.htm"><spring:message code="volverCliente"/></a></h3>
</body>
</html>
