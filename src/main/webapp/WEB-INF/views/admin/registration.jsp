<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<head>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
</head>

<div class="col-md-10 col-md-offset-1">
	<ul class="nav nav-tabs">
		<li class="active"><a data-toggle="tab" href="#employee">New
				Employer</a></li>
		<li><a data-toggle="tab" href="#provider">New provider</a></li>
	</ul>

	<div class="tab-content">
		<div id="employee" class="tab-pane fade in active">
			<h3>General info</h3>

			<div class="col-md-8">

				<form:form name="employeeRegistration" modelAttribute="employee"
					method="POST" class="form-horizontal" role="form">
					<div class="form-group">
						<label for="comanyname" class="col-sm-4 control-label">Company
							name:</label>
						<div class="col-sm-8 control-label">
							<input type="text" id="login" name="login" class="form-control"
								placeholder="Enter company name:" value="">
						</div>
					</div>


				</form:form>

			</div>


		</div>
		<div id="provider" class="tab-pane fade">
			<h3>General info</h3>

			<div class="col-md-10">
				<form:form name="newProvider" modelAttribute="provider"
					method="POST" class="form-horizontal" role="form">

					<div class="form-group">
						<label for="name" class="col-sm-4 control-label">Name:</label>
						<div class="col-sm-6 control-label">
							<form:input path="name" class="form-control" />
						</div>
					</div>


					<div class="form-group">
						<label for="phone" class="col-sm-4 control-label">Phone:</label>
						<div class="col-sm-6 control-label">
							<form:input path="phone" class="form-control" />
						</div>
					</div>

					<div class="form-group">
						<label for="email" class="col-sm-4 control-label">Email:</label>
						<div class="col-sm-6 control-label">
							<form:input path="email" class="form-control" />
						</div>
					</div>

					<div class="form-group">
						<label for="zipCode" class="col-sm-4 control-label">Zip
							code:</label>
						<div class="col-sm-6 control-label">
							<form:input path="zipCode" class="form-control" />
						</div>
					</div>



					<div class="form-group">
						<div class="col-sm-6 control-label">
							<input type="submit" value="Register"
								class="btn btn-lg btn-primary" />
						</div>
					</div>
				</form:form>
			</div>
		</div>
	</div>


</div>