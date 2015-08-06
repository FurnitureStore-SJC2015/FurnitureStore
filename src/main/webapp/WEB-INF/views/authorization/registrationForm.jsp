<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<div class="col-md-6 col-md-offset-3 well">
	<div class="col-md-8 col-md-offset-2">
		<h3>Create new account!</h3>
		<div>
			<div class="panel-body">
				<form:form method="POST" modelAttribute="user"
					class="form-horizontal" role="form">
					<div class="form-group">
						<label for="name" class="col-sm-4 control-label">Name:</label>
						<div class="col-sm-8">
							<form:input path="name" class="form-control" />
						</div>
						<form:errors path="name" class="danger"></form:errors>
					</div>
					<div class="form-group">
						<label for="surname" class="col-sm-4 control-label">Surname:</label>
						<div class="col-sm-8">
							<form:input path="surname" class="form-control" />
						</div>
						<form:errors path="surname" cssClass=""></form:errors>
					</div>

					<div class="form-group">
						<label for="login" class="col-sm-4 control-label">Login:</label>
						<div class="col-sm-8">
							<form:input path="login" class="form-control" />
						</div>
						<form:errors path="login" class="help-block"></form:errors>
					</div>

					<div class="form-group">
						<label for="password" class="col-sm-4 control-label">Password:</label>
						<div class="col-sm-8">
							<form:password path="password" class="form-control" />
						</div>
						<form:errors path="password" class=""></form:errors>
					</div>

					<div class="form-group">
						<label for="email" class="col-sm-4 control-label">Email:</label>
						<div class="col-sm-8">
							<form:input path="email" class="form-control" />
						</div>
						<form:errors path="email" class="help-block"></form:errors>
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