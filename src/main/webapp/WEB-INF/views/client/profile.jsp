<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>


<sec:authorize access="isAuthenticated() and hasRole('ROLE_CLIENT')">
	<c:set var="profile" value="${client.profile}"></c:set>
	<div class="col-md-9 well">
		<div class="row">
			<div class="col-md-3">
				<img src="data:image/jpeg;base64,${client.encodedAvatar}"
					class="img-thumbnail">
			</div>
			<div class="col-md-6">
				<table class="table table-hover">
					<thead>
						<tr>
							<th>Personal info:</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td><strong>Name:</strong></td>
							<td><strong>${profile.name}</strong></td>
						</tr>
						<tr>
							<td><strong>Surname:</strong></td>
							<td><strong>${profile.surname}</strong></td>
						</tr>
						<tr>
							<td><strong>E-mail:</strong></td>
							<td><strong>${profile.email}</strong></td>
						</tr>
						<tr>
							<td><strong>Current Bonus:</strong></td>
							<td><strong>${profile.bonus.percentage} %</strong></td>
						</tr>
					</tbody>
				</table>
				<button type="button" class="btn btn-primary"
					onclick="location.href='edit'">Edit profile</button>
			</div>
		</div>

		<div class="row">Here goes top-5 future bills</div>
	</div>
</sec:authorize>

