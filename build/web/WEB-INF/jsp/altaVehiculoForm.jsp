<%-- 
    Document   : altaVehiculoFrom
    Created on : 24-feb-2015, 17:17:39
    Author     : Arturo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><spring:message code="nuevoVehiculo"/></title>
    </head>
    <body STYLE="background: #ccffcc">
        <h1 ALIGN="center" STYLE="background: #7a997a; font: 36pt/40pt courier; font-variant: small-caps; border: thick dashed green"><spring:message code="nuevoVehiculo"/></h1>
        <form:form action="guardarVehiculo.htm" commandName="miVehiculo" method="post">
            
            <table border="1"  ALIGN="center">
             
              <thead>
            
                  <tr><th><spring:message code="matricula"/></th>
                      <td><form:input path="matricula" STYLE="background: #ccffcc"/>
                      <form:errors path="matricula" cssStyle="Color:red"/></td></tr>
            
                  <tr><th><spring:message code="marca"/></th>
                      <td><form:input path="marca" STYLE="background: #ccffcc"/></td></tr>
            
                  <tr><th><spring:message code="modelo"/></th>
                      <td><form:input path="modelo" STYLE="background: #ccffcc"/></td></tr>
            
           
                  <tr><th><spring:message code="color"/></th>
                      <td><form:input path="color" STYLE="background: #ccffcc"/></td></tr>
            
                  <tr><th><spring:message code="cv"/></th>
                      <td><form:input path="cv" STYLE="background: #ccffcc"/>
                      <form:errors path="cv" cssStyle="Color:red"/></td></tr>
            
                  <tr><th><spring:message code="numeroPuertas"/></th>
                      <td><form:input path="numeroPuertas" STYLE="background: #ccffcc"/>
                      <form:errors path="numeroPuertas" cssStyle="Color:red"/></td></tr>
              </thead>
            </table>
              <br>
            
            
            <h2 ALIGN="center"><input type="submit" value="<spring:message code="enviar"/>"/></h2>
        </form:form>
            
            <br>
          <h3  ALIGN="center"><a href="index.htm"><spring:message code="volver"/></a></h3>
    </body>
</html>
