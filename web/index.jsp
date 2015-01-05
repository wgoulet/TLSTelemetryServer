<%-- 
    Document   : index
    Created on : Jan 1, 2015, 7:02:13 PM
    Author     : wgoulet
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>JSP Page</title>
	</head>
	<body>
		<h1>TLS Telemetry Server</h1>
		<jsp:useBean id="tdviewer" scope="session" class="org.jdt.tlstelemetry.TDViewProvider" />
			<table border="1">
				<tr>
					<td>ClientName</td>
					<td>Ciphersuite</td>
					<td>Protocol</td>
					<td>Certificate Subject</td>
					<td>Certificate Issuer</td>
					<td>Certificate Signature Algorithm</td>
				</tr>
		<c:forEach items="${tdviewer.TDelements}" var="element">
			<tr>
				<td>
			${element.clientname}
				</td>
				<td>
			${element.cipherSuite}
				</td>
				<td>
			${element.protocol}
				</td>
				<td>
			${element.subject}
				</td>
				<td>
			${element.issuer}
				</td>
				<td>
			${element.sigalg}
				</td>
			</tr>
		</c:forEach>
			</table>
	</body>
</html>
