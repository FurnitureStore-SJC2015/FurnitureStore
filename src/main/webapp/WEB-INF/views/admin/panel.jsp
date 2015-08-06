<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
						<button class="btn btn-info" onclick="location.href='${showUser}'">Show</button>
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