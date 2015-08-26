<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>



<sec:authorize access="isAuthenticated() and hasRole('ROLE_CLIENT')">

	<div class="col-md-9">

		<div class="panel panel-default">

			<div class="panel-heading">
				<h5 class="text-center">
				<span class="glyphicon glyphicon-cog"></span>
					<strong>Edit profile</strong>
				</h5>
			</div>
			<div class="panel-body">
				<div class="col-md-6 col-md-offset-3">
					<form:form method="POST" modelAttribute="client"
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
							<label for="image" class="col-sm-4 control-label">Image:</label>
							<div class="col-sm-8">
								<input name="image" type="file">
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





