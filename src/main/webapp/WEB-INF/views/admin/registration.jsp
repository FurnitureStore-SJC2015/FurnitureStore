<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<sec:authorize access="isAuthenticated() and hasRole('ROLE_ADMIN')">
	<div class="col-md-6 col-md-offset-3">
		<div class="panel panel-default">
			<div class="panel-heading">
				<h5 class="text-center">
					<span class="glyphicon glyphicon-pencil"></span><strong>Provider
						registration</strong>
				</h5>
			</div>
			<div class="panel-body">
				<form:form name="newProvider" modelAttribute="provider"
					method="POST" class="form-horizontal" role="form">
					<div class="form-group">
						<label for="name" class="col-sm-4 control-label">Name:</label>
						<div class="col-sm-6 control-label">
							<form:input path="name" class="form-control" />
							<form:errors path="name" class="danger"></form:errors>
						</div>
					</div>
					<div class="form-group">
						<label for="surname" class="col-sm-4 control-label">Surname:</label>
						<div class="col-sm-6 control-label">
							<form:input path="surname" class="form-control" />
							<form:errors path="surname" class="danger"></form:errors>
						</div>
					</div>

					<div class="form-group">
						<label for="login" class="col-sm-4 control-label">Login:</label>
						<div class="col-sm-6 control-label">
							<form:input path="login" class="form-control" />
							<form:errors path="login" class="danger"></form:errors>
						</div>
					</div>
					<div class="form-group">
						<label for="email" class="col-sm-4 control-label">Email:</label>
						<div class="col-sm-6 control-label">
							<form:input path="email" class="form-control" />
							<form:errors path="email" class="danger"></form:errors>
						</div>
					</div>
					<div class="form-group">
						<label for="providerName" class="col-sm-4 control-label">Company
							name:</label>
						<div class="col-sm-6 control-label">
							<form:input path="providerName" class="form-control" />
							<form:errors path="providerName" class="danger"></form:errors>
						</div>
					</div>
					<div class="form-group">
						<label for="phone" class="col-sm-4 control-label">Phone:</label>
						<div class="col-sm-6 control-label">
							<form:input path="phone" class="form-control" />
							<form:errors path="phone" class="danger"></form:errors>
						</div>
					</div>
					<div class="form-group">
						<label for="zipCode" class="col-sm-4 control-label">Zip
							code:</label>
						<div class="col-sm-6 control-label">
							<form:input path="zipCode" class="form-control" />
							<form:errors path="zipCode" class="danger"></form:errors>
						</div>
					</div>
			</div>
			<div class="panel-footer clearfix">
				<div class="form-group">
					<div class="pull-right">
						<div class="col-sm-6 control-label">
							<input type="submit" value="Register"
								class="btn btn-lg btn-primary" />
						</div>
					</div>
				</div>
			</div>
			</form:form>
		</div>
	</div>
</sec:authorize>
