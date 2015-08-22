<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<div class="col-md-6 col-md-offset-3">

	<div class="panel panel-default">


		<div class="panel-heading">
			<h5 class="text-center">
				<span class="glyphicon glyphicon-pencil"></span>Create new account!
			</h5>
		</div>

		<div class="panel-body">
			<form:form method="POST" modelAttribute="client"
				class="form-horizontal" role="form" enctype="multipart/form-data">
				<div class="form-group">
					<label for="name" class="col-sm-4 control-label">Name:</label>
					<div class="col-sm-6">
						<form:input path="name" class="form-control" />
						<form:errors path="name" class="danger"></form:errors>
					</div>

				</div>
				<div class="form-group">
					<label for="surname" class="col-sm-4 control-label">Surname:</label>
					<div class="col-sm-6">
						<form:input path="surname" class="form-control" />
						<form:errors path="surname" cssClass=""></form:errors>
					</div>

				</div>

				<div class="form-group">
					<label for="login" class="col-sm-4 control-label">Login:</label>
					<div class="col-sm-6">
						<form:input path="login" class="form-control" />
						<form:errors path="login" class="help-block"></form:errors>
					</div>

				</div>
				<div class="form-group">
					<label for="email" class="col-sm-4 control-label">Email:</label>
					<div class="col-sm-6">
						<form:input path="email" class="form-control" />
						<form:errors path="email" class="help-block"></form:errors>
					</div>

				</div>

				<div class="form-group">
					<label for="image" class="col-sm-4 control-label">Image:</label>
					<div class="col-sm-6">
						<input name="image" type="file">
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