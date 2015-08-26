<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>



<sec:authorize access="isAuthenticated() and hasRole('ROLE_PROVIDER')">

	<div class="col-md-9">

		<div class="panel panel-default">

			<div class="panel-heading">
				<h5 class="text-center">
					<span class="glyphicon glyphicon-cog"></span> <strong>Edit
						provider's profile</strong>
				</h5>
			</div>
			<div class="panel-body">
				<div class="col-md-6 col-md-offset-3">
					<form:form method="POST" modelAttribute="provider"
						class="form-horizontal" enctype="multipart/form-data" role="form">
						<div class="form-group">
							<label for="email" class="col-sm-4 control-label">Email:</label>
							<div class="col-sm-8">
								<form:input path="email" class="form-control" />
								<form:errors path="email" class="danger"></form:errors>
							</div>
						</div>
						<div class="form-group">
							<label for="password" class="col-sm-4 control-label">Password:</label>
							<div class="col-sm-8">
								<form:password path="password" class="form-control" />
								<form:errors path="password" class="danger"></form:errors>
							</div>

						</div>
						<div class="form-group">
							<label for="phone" class="col-sm-4 control-label">Phone:</label>
							<div class="col-sm-8">
								<form:input path="phone" class="form-control" />
								<form:errors path="phone" class="danger"></form:errors>
							</div>

						</div>
						<div class="form-group">
							<label for="providerName" class="col-sm-4 control-label">Provider
								name:</label>
							<div class="col-sm-8">
								<form:input path="providerName" class="form-control" />
								<form:errors path="providerName" class="danger"></form:errors>
							</div>

						</div>
						<div class="form-group">
							<label for="zipCode" class="col-sm-4 control-label">Zip
								code:</label>
							<div class="col-sm-8">
								<form:input path="zipCode" class="form-control" />
								<form:errors path="zipCode" class="danger"></form:errors>
							</div>

						</div>
						<div class="form-group">
							<label for="avatar" class="col-sm-4 control-label">Avatar:</label>
							<div class="col-sm-8">
								<input name="avatar" type="file">
							</div>
						</div>
						<div class="pull-right">
							<input type="submit" class="btn btn-primary" value="Save" />
						</div>
					</form:form>
				</div>
			</div>
		</div>
	</div>
</sec:authorize>





