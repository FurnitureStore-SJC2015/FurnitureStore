<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>

<sec:authorize access="isAuthenticated() and hasRole('ROLE_CLIENT')">
	<c:set var="profile" value="${loggedClient.profile}"></c:set>
	<div class="col-md-9 ">

		<div class="panel panel-default">
			<div class="panel-heading ">
				<h5 class="text-center">
					<span class="glyphicon glyphicon-user"></span> <strong>${profile.name}'s
						profile</strong>
				</h5>
			</div>
			<div class="panel-body">

				<c:if test="${not empty loggedClient.profile.avatar}">
					<div class="col-md-4">
						<img src="data:image/jpeg;base64,${loggedClient.profile.avatar}"
							class="img-thumbnail">
					</div>
				</c:if>
				<div class="col-md-8">
					<table class="table table-hover table-bordered">
						<thead>
							<tr>
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

					<div class="alert alert-success" id="notify" style="display: none;"></div>

				</div>
			</div>
			<div class="panel-footer clearfix">
				<div class="pull-left">
					<strong>Total spent: ${profile.totalSpent}</strong>
				</div>
				<div class="pull-right">
					<c:url var="edit" value="/profile/edit" />
					<a href="${edit}" class="btn btn-primary">Edit profile</a>
				</div>
			</div>
		</div>
	</div>
</sec:authorize>

