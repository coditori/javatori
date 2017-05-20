<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 

<html>
<head>
<title>${title}</title>
</head>
<body>
	<c:choose>
		<c:when test="${pageContext.request.remoteUser != null}">
			Logged in menu: Hello <b><c:out value="${pageContext.request.remoteUser}"></c:out></b>
		</c:when>
		<c:otherwise>
			Hello to the Springol please login to see something...
		</c:otherwise>
	</c:choose>
</body>
</html>