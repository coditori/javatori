<%@ include file="html-head.jsp" %>

<div id="container">
<table>
<tr>
	<th>ID</th>
	<th>First Name</th>
	<th>Last Name</th>
</tr>
<c:forEach var="user" items="${users}">
	<tr>
		<td>${user.id}</td>
		<td>${user.firstName}</td>
		<td>${user.lastName}</td>
	</tr>
</c:forEach>
</table>
</div>
</body>
<a class="footerLink" href="${pageContext.request.contextPath}/admin/user/add">Add a user</a>
</html>