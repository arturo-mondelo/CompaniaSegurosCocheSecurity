<%-- 
    Document   : login_page
    Created on : 03-mar-2015, 11:20:26
    Author     : admin1
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
    </head>
    <body ALIGN="center" STYLE="background: #ccffcc; font: 36pt/40pt courier; font-variant: small-caps; border: thick dashed green">
         
        <form action="j_spring_security_check" method="post" name="loginForm">
            <h7 ALIGN="center"><spring:message code="userName"/><input type="text" name="nombre_usuario"/></h7>
            <br>
            <h7 ALIGN="center"><spring:message code="contrasena"/><input type="password" name="contrasena"/></h7>
            <br>
            <input type="submit" name="submit" value="<spring:message code="entrar"/>"/>
            <br>
           
        </form>
            <c:if test="${error!=null}">
            <h2 style="color: red"><c:out value="${error}"/></h2>
            
        </c:if>
    </body>
</html>
