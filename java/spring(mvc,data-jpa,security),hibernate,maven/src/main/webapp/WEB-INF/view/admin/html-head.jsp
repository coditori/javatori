<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
<title>${pageTitle}</title>
<link href="${pageContext.request.contextPath}/resources/css/admin.css" type="text/css" rel="stylesheet" >
</head>
<body>
<div id="header">
	<form action="${pageContext.request.contextPath}/login/admin" method="post" class="logout-form">
		<input type="submit" class="button red big" value="Logout" /> <input
			type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
	</form>	
	<h1>${pageTitle}</h1> 
</div>

