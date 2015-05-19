<%-- 
    Document   : editarCliente
    Created on : 24-feb-2015, 11:51:55
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
        <title><spring:message code="editarCliente.Title"/></title>
    </head>
    <body STYLE="background: #ccffcc">
        <h2 ALIGN="center" STYLE="background: #7a997a; font: 36pt/40pt courier; font-variant: small-caps; border: thick dashed green"><spring:message code="editarCliente.Header"/></h2>
        <form:form action="modificarCliente.htm" method="post" commandName="miClienteModificado">
         <table border="1" ALIGN="center">
            <tr STYLE="background: #7a997a">
                   
                     <h3><td><spring:message code="nombre"/></td>
                    <td><spring:message code="edad"/></td>
                     <td><spring:message code="dni"/></td>
                    <td><spring:message code="calle"/></td>
                     <td><spring:message code="numero"/></td>
                     <td><spring:message code="piso"/></td>
                     <td><spring:message code="cp"/></td></h3>
                    
                </tr>
             
                 <tr>
                        <form:hidden path="id"/> 
                        <td> <form:input path="nombre" STYLE="background: #ccffcc"/></td>
                        <form:errors path="nombre"/>
                        <td> <form:input path="edad" STYLE="background: #ccffcc"/></td>
                        <form:errors path="edad"/>
                        <td> <form:input path="dni" STYLE="background: #ccffcc"/></td>
                        <form:errors path="dni"/>
                        <td> <form:input path="direccion.calle" STYLE="background: #ccffcc"/></td>
                        <td> <form:input path="direccion.numero" STYLE="background: #ccffcc"/></td>
                        <td> <form:input path="direccion.piso" STYLE="background: #ccffcc"/></td>
                        <td> <form:input path="direccion.cp" STYLE="background: #ccffcc"/></td>
                </tr>
    
            
               
             
         </form:form>
             </table>
        <br>
        <h2 ALIGN="center"><input type="submit" value="<spring:message code="enviar"/>"></input></h2>
        <br>
          <h3  ALIGN="center"><a href="mostrarClientes.htm"><spring:message code="volverCliente"/></a></h3>
    </body>
</html>
