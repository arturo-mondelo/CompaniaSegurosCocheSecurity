<%-- 
    Document   : altaPolizaForm
    Created on : 24-feb-2015, 16:24:37
    Author     : Arturo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><spring:message code="altaPoliza"/></title>
    </head>
    <body STYLE="background: #ccffcc">
        <h1 ALIGN="center" STYLE="background: #7a997a; font: 36pt/40pt courier; font-variant: small-caps; border: thick dashed green"><spring:message code="altaPoliza"/></h1>

        <form:form action="guardarPoliza.htm" method="post" commandName="miPoliza">
            <table border="1"  ALIGN="center">
                <thead>

                    <tr><th><spring:message code="capitalMaximoPorSiniestro"/></th>
                        <td><form:input path="capitalMaximoPorSiniestro" STYLE="background: #ccffcc"/></td></tr>
            
                    <tr><th><spring:message code="cuantia"/></th>
                        <td><form:input path="cuantia" STYLE="background: #ccffcc"/></td></tr>
            
                    <tr><th><spring:message code="condiciones"/></th>
                        <td><form:input path="condiciones" STYLE="background: #ccffcc"/></td></tr>
           
                    <tr><th><spring:message code="vehiculo"/></th>
            <td><form:select path="vehiculo" STYLE="background: #ccffcc">
                        <form:options items="${listaVehiculos}" itemValue="id" itemLabel="matricula"/>
                </form:select></td></tr>
            
                    <tr><th><spring:message code="cliente"/></th>
            <td><form:select path="cliente" STYLE="background: #ccffcc">
                        <form:options items="${listaClientes}" itemValue="id" itemLabel="nombre"/>


                </form:select></td></tr>
                <br>
                </thead>
            </table>
            
                <h2 ALIGN="center"><input type="submit" value="<spring:message code="enviar"/>"/></h2>
        </form:form>
                <br>
          <h3  ALIGN="center"><a href="index.htm"><spring:message code="volver"/></a></h3>
    </body>
</html>
