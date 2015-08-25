<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>


<sec:authorize access="isAuthenticated() and hasRole('ROLE_PROVIDER')">
	<div class="col-md-9 ">

		<div class="panel panel-default">
			<div class="panel-heading ">
				<h5 class="text-center">
					<span class="glyphicon glyphicon-user"></span> <strong>${provider.name}'s profile</strong>
				</h5>
			</div>
			<div class="panel-body">

				<c:if test="${not empty provider.avatar}">
					<div class="col-md-4">
						<img src="data:image/jpeg;base64,${provider.avatar}"
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
								<td><strong>${provider.name}</strong></td>
							</tr>
							<tr>
								<td><strong>Surname:</strong></td>
								<td><strong>${provider.surname}</strong></td>
							</tr>
							<tr>
								<td><strong>E-mail:</strong></td>
								<td><strong>${provider.email}</strong></td>
							</tr>
							<tr>
								<td><strong>Provider name:</strong></td>
								<td><strong>${provider.providerName} </strong></td>
							</tr>
							<tr>
								<td><strong>Provider name:</strong></td>
								<td><strong>${provider.providerName} </strong></td>
							</tr>
							<tr>
								<td><strong>Provider phone:</strong></td>
								<td><strong>${provider.phone} </strong></td>
							</tr>
							<tr>
								<td><strong>Zip code:</strong></td>
								<td><strong>${provider.zipCode} </strong></td>
							</tr>
						</tbody>
					</table>
				</div>


			</div>

			<div class="panel-footer clearfix">
				<div class="pull-right">
					<c:url var="edit" value="/profile/edit" />
					<a href="${edit}" class="btn btn-primary">Edit profile</a>
				</div>
			</div>
		</div>
	</div>
</sec:authorize>

