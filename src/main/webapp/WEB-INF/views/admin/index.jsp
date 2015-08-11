<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<sec:authorize access="isAuthenticated() and hasRole('ROLE_ADMIN')">
	<div class="col-md-12">
		<div class="row">
			<div class="col-md-2 col-md-offset-5">
				<c:url value="/admin/panel" var="panelUrl" />
				<form name="selectForm" action="${panelUrl}" method="POST"
					class="form-horizontal">
					<div class="form-group">
						<label for="sel1">Select role:</label> <select name="id"
							class="form-control" id="sel1">
							<c:forEach var="item" items="${roleList}">
								<option value="${item.id}">${item.name}</option>
							</c:forEach>
						</select>
					</div>
					<div class="form-group">
						<input type="submit" value="Submit" />
					</div>
				</form>
			</div>
		</div>

		<c:if test="${not empty userList}">
			<div class="col-md-12 well">
				<h1>All Users</h1>
				<table class="table table-striped">
					<thead>
						<tr>
							<th>#</th>
							<th>Name</th>
							<th>Surname</th>
							<th>Login</th>
							<th>E-mail</th>
							<th>Role</th>
							<th>Action</th>
						</tr>
					</thead>
					<tbody>
						<c:set var="i" value="1"></c:set>
						<c:forEach items="${userList}" var="user">
							<tr>
								<td>${i}</td>
								<td>${user.name}</td>
								<td><strong>${user.surname}</strong></td>
								<td><strong>${user.login}</strong></td>
								<td><strong>${user.email}</strong></td>
								<td><strong>${user.role.name}</strong></td>
								<td><c:set var="showUser" value="admin/users/${user.id}"></c:set>
									<c:set var="updateUser" value="admin/users/${user.id}/update"></c:set>
									<c:set var="deleteUser" value="admin/users/${user.id}/delete"></c:set>
									<button class="btn btn-info"
										onclick="location.href='${showUser}'">Show</button>
									<button class="btn btn-primary"
										onclick="location.href='${updateUser}'">Update</button>
									<button class="btn btn-danger"
										onclick="location.href='${deleteUser}'">Delete</button></td>
								<c:set var="i" value="${i + 1}"></c:set>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</c:if>
	</div>

</sec:authorize>