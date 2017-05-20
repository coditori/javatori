<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ include file="html-head.jsp" %>

<div id="container">
	<form:form action="" modelAttribute="user" method="POST">
		<table>
			<tr>
				<td><label>First name:</label></td>
				<td><form:input path="firstName"/></td>
			</tr>
			<tr>
				<td><label>Last name:</label></td>
				<td><form:input path="lastName"/></td>
			</tr>
			<tr>
				<td><label>Username:</label></td>
				<td><form:input path="username"/></td>
			</tr>
			<tr>
				<td><label>Email:</label></td>
				<td><form:input path="email"/></td>
			</tr>
			<tr>
				<td><label>Password:</label></td>
				<td><form:input path="password"/></td>
			</tr>
			<tr>
				<td><label>Role:</label></td>
				<td><form:select path="role" items="${roles}" itemValue="id" itemLabel="role"/></td>
			</tr>
			<tr>
				<td><label>enabled</label></td>
				<td><form:input path="enabled"/></td>
			</tr>
			<tr>
				<td><label></label></td>
				<td><input type="submit" value="Save" class="save"/></td>
			</tr>
		</table>
	</form:form>
	<a href="${pageContext.request.contextPath}/admin/user/list">Back to List</a>
</div>