<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<div>
	<h3>Create new account!</h3>
	<form:form method="POST" modelAttribute="new_user">
		<div class="form-group">
			<label for="name" class="col-sm-4 control-label">User Name:</label>
			<div class="col-sm-8">
				<form:input path="name" class="form-control" />
			</div>
		</div>

		<div class="form-group">
			<label for="surname" class="col-sm-4 control-label">User
				Surname:</label>
			<div class="col-sm-8">
				<form:input path="surname" class="form-control" />
			</div>
		</div>

		<div class="form-group">
			<label for="login" class="col-sm-4 control-label">User Login:</label>
			<div class="col-sm-8">
				<form:input path="login" class="form-control" />
			</div>
		</div>

		<div class="form-group">
			<label for="password" class="col-sm-4 control-label">User
				Password:</label>
			<div class="col-sm-8">
				<form:password path="password" class="form-control" />
			</div>
		</div>

		<div class="form-group">
			<label for="email" class="col-sm-4 control-label">User Email:</label>
			<div class="col-sm-8">
				<form:input path="email" class="form-control" />
			</div>
		</div>

		<div class="form-group">
			<div class="col-sm-1">
				<input type="submit" value="Register" class="btn btn-lg btn-primary" />
			</div>
		</div>
	</form:form>
</div>

