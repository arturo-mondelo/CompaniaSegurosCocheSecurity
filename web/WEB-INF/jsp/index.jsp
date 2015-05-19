<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><spring:message code="polizas"/></title>
        <style>
            a.one:link {color:#7a997a;}
            a.one:visited {color:#7a997a;}
            a.one:hover {color:#556b55;}

            a.two:link {color:#7a997a;}
            a.two:visited {color:#556b55;}
            a.two:hover {font-size:105%;}

            a.three:link {color:#7a997a;}
            a.three:visited {color:#7a997a;}
            a.three:hover {background:#556b55;}
        </style>
    </head>

    <body ALIGN="center" STYLE="background: #ccffcc; font: 36pt/40pt courier; font-variant: small-caps; border: thick dashed green">
        <a class="one" href="altaCliente.htm"><spring:message code="entrada.alta"/></a>
        <a class="one" href="altaPoliza.htm"><spring:message code="polizas.alta"/></a>
        <a class="one" href="altaVehiculo.htm"><spring:message code="vehiculos.alta"/></a>
        <br>
        <br>
        <br>
        <a class="two" href="mostrarClientes.htm"><spring:message code="entrada.ver"/></a>
        <a class="two" href="mostrarPolizas.htm"><spring:message code="polizas.ver"/></a>
        <a class="two" href="mostrarVehiculos.htm"><spring:message code="vehiculos.ver"/></a>
        <br>
        <br>
        <br>
        <a class="three" href="?lang=en">en</a>
        <a class="three" href="?lang=es">es</a>
        <a class="three" href="j_spring_security_logout">Log Out</a>
        
    </body>
</html>
