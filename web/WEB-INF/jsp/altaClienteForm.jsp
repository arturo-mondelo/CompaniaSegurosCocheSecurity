<%-- 
    Document   : altaClienteForm
    Created on : 24-feb-2015, 11:51:19
    Author     : admin1
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><spring:message code="nuevoCliente"/></title>
    </head>
    <body STYLE="background: #ccffcc">
        <h1 ALIGN="center" STYLE="background: #7a997a; font: 36pt/40pt courier; font-variant: small-caps; border: thick dashed green"><spring:message code="nuevoCliente"/></h1>
         <form:form action="guardarCliente.htm" commandName="miCliente" method="post">
          <table border="1"  ALIGN="center">
             
              <thead>
        
                  
                  <tr><th><spring:message code="nombre"/></th><td><form:input path="nombre" STYLE="background: #ccffcc"/>
                      <form:errors path="nombre" cssStyle="Color:red" /></td></tr>
              
                  <tr><th><spring:message code="edad"/></th><td><form:input path="edad" STYLE="background: #ccffcc"/>
                      <form:errors path="edad" cssStyle="Color:green"/></td></tr>           
                  <tr><th><spring:message code="dni"/></th> <td><form:input path="dni" STYLE="background: #ccffcc"/>
                      <form:errors path="dni" cssStyle="Color:red"/></td></tr>
              
                  <tr><th><spring:message code="calle"/></th><td><form:input path="direccion.calle" STYLE="background: #ccffcc"/></td></tr>
              
                  <tr><th><spring:message code="numero"/></th><td><form:input path="direccion.numero" STYLE="background: #ccffcc"/></td></tr>
              
                  <tr><th><spring:message code="piso"/></th><td><form:input path="direccion.piso" STYLE="background: #ccffcc"/></td></tr>
            
                  <tr><th><spring:message code="cp"/></th><td><form:input path="direccion.cp" STYLE="background: #ccffcc"/></td></tr>
                  
                
              </thead>
           
    </table>
                    
          <br>
          <h2 ALIGN="center"><input type="submit" value="<spring:message code="enviar"/>"/></h2>
          <br>
          <h3  ALIGN="center"><a href="index.htm"><spring:message code="volver"/></a></h3>
        
              </form:form>
    </body>
</html>
