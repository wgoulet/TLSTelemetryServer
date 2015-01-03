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
		<h1>Hello World!</h1>
		<jsp:useBean id="tdviewer" scope="session" class="org.jdt.tlstelemetry.TDViewProvider" />
		<c:forEach items="${tdviewer.TDelements}" var="element">
			CipherSuite: ${element.cipherSuite}
			<br>
			Protocol: ${element.protocol}
			<br>
			Subject: ${element.subject}
			<br>
			Issuer: ${element.issuer}
			<br>
			SigAlg: ${element.sigalg}
			<br>
		</c:forEach>
	</body>
</html>
