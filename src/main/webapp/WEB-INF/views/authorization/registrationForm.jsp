<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<span style="float: right"> <a href="?lang=en">en</a> | <a
	href="?lang=ru">ru</a>
</span>
<div class="col-md-6 col-md-offset-3">
	<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

	<div class="panel panel-default">
		<div class="panel-heading">
			<h5 class="text-center">
				<strong> <span class="glyphicon glyphicon-pencil"></span> <spring:message
						code="register.createLabel" />
				</strong>
			</h5>
		</div>

		<div class="panel-body">
			<form:form method="POST" modelAttribute="client"
				class="form-horizontal" role="form" enctype="multipart/form-data">
				<div class="form-group">
					<label for="name" class="col-sm-4 control-label"><spring:message
							code="register.name" /></label>
					<div class="col-sm-6">
						<form:input path="name" class="form-control" />
						<form:errors path="name" class="danger"></form:errors>
					</div>

				</div>
				<div class="form-group">
					<label for="surname" class="col-sm-4 control-label"><spring:message
							code="register.surname" /></label>
					<div class="col-sm-6">
						<form:input path="surname" class="form-control" />
						<form:errors path="surname" cssClass=""></form:errors>
					</div>

				</div>

				<div class="form-group">
					<label for="login" class="col-sm-4 control-label"><spring:message
							code="register.login" /></label>
					<div class="col-sm-6">
						<form:input path="login" class="form-control" />
						<form:errors path="login" class="help-block"></form:errors>
					</div>

				</div>
				<div class="form-group">
					<label for="email" class="col-sm-4 control-label"><spring:message
							code="register.email" /></label>
					<div class="col-sm-6">
						<form:input path="email" class="form-control" />
						<form:errors path="email" class="help-block"></form:errors>
					</div>

				</div>

				<div class="form-group">
					<label for="image" class="col-sm-4 control-label"><spring:message
							code="register.image" /></label>
					<div class="col-sm-6">
						<input name="image" type="file">
					</div>
				</div>
		</div>
		<div class="panel-footer clearfix">
			<div class="form-group">
				<div class="pull-right">
					<div class="col-sm-6 control-label">
						<button type="submit" class="btn btn-lg btn-primary">
							<spring:message code="register.submit" />
						</button>
					</div>
				</div>
			</div>
		</div>
		</form:form>

	</div>
</div>