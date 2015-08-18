<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<c:set var="selectedRoleId" value="${userList[0].role.id}"></c:set>
<c:set var="updateUser" value="users/update/"></c:set>
<c:set var="deleteUser" value="users/delete/"></c:set>
<c:set var="i" value="1"></c:set>

<script type="text/javascript">
	
function deleteUser(userId,i) {
	var selectedOption = $('#selector option:selected').val();
	
	$.ajax({
		url : "users/" + userId+"/delete",
		type : "POST",
		beforeSend : function(xhr) {
			xhr.setRequestHeader("Accept", "application/json");
			xhr.setRequestHeader("Content-Type", "application/json");
		},
		success : function(obj) {
			var temp=$("#record"+i);
			temp.fadeOut(800, function(){
                temp.remove();
            });
			// TODO
		}
	});
}
</script>

<sec:authorize access="isAuthenticated() and hasRole('ROLE_ADMIN')">
	<div class="col-md-12">
		<div class="row">
			<div class="col-md-2">
				<c:url value="/admin/panel" var="panelUrl" />
				<form name="selectForm" action="${panelUrl}" method="POST"
					class="form-horizontal">
					<div class="form-group">
						<label for="selector">Select role:</label> <select name="id"
							class="form-control" id="selector">
							<c:forEach var="item" items="${roleList}">
								<c:if test="${item.id eq selectedRoleId}">
									<option value="${item.id}" selected="selected">${item.name}</option>
								</c:if>
								<c:if test="${item.id ne selectedRoleId}">
									<option value="${item.id}">${item.name}</option>
								</c:if>
							</c:forEach>
						</select>
					</div>
					<div class="form-group">
						<input type="submit" class="btn btn-success" value="Query Users" />
					</div>
				</form>
			</div>
		</div>
		<div class="col-md-12">
			<h1>List of user:</h1>
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
				<c:if test="${not empty userList}">

					<tbody>

						<c:forEach items="${userList}" var="user">
							<tr id="record${i}">
								<td>${i}</td>
								<td>${user.name}</td>
								<td><strong>${user.surname}</strong></td>
								<td><strong>${user.login}</strong></td>
								<td><strong>${user.email}</strong></td>
								<td><strong>${user.role.name}</strong></td>
								<td>
									<button class="btn btn-primary"
										onclick="deleteUser(${user.id},${i})">Delete</button>
								</td>
								<c:set var="i" value="${i + 1}"></c:set>
							</tr>
						</c:forEach>
					</tbody>
				</c:if>
			</table>
		</div>
	</div>
</sec:authorize>