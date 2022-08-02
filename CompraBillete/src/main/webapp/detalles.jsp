<%@page import="modelo.Billete"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

    <%
    Billete b=(Billete)session.getAttribute("billete");
    if(b==null){
    	response.sendRedirect("Billete.jsp");
    }
    %>

	<h1>Detalles de la compra:</h1>
	<ul>
	<li>Nombre: <%=b.getNombre()%></li>
	<li>Edad: <%=b.getEdad()%></li>
	<li>Billete: <%=b.getBillete()%></li>
	<li>DNI: <%=b.getDni()%></li>
	<li>Núm. Pasajeros: <%=b.getPasajeros()%></li>
	<li>Tipo: 
		<%if (b.isIdayVuelta()){%>
			Ida y vuelta
		<%}else{%>
		Ida
		<%}%>
		</li>
	<li>Importe Total: <%=b.getImporteTotal()%></li>
	</ul>

</body>
</html>