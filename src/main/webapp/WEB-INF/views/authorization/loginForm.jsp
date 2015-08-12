<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<div class="col-md-6 well">
	<div class="col-md-8 col-md-offset-2 ">
		<div class="panel-body">
			<h3>Please Sign In!</h3>
			<c:url value="/j_spring_security_check" var="loginUrl" />
			<form:form name="loginForm" action="${ loginUrl}" method="POST"
				class="form-horizontal" role="form">
				<div class="form-group ">
					<label for="login" class="col-sm-3 control-label">Login:</label>
					<div class="col-sm-9 control-label">
						<input type="text" id="login" name="login" class="form-control"
							placeholder="Enter user login" value="${new_client.login}">
					</div>
				</div>
				<div class="form-group">
					<label for="password" class="col-sm-3 control-label">Password:</label>
					<div class="col-sm-9 control-label">
						<input type="password" id="password" name="password"
							class="form-control" placeholder="Enter user password">
					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-offset3 col-sm-9">
						<button type="submit" class="btn btn-success btn-sm">Sign
							in</button>
						<button type="reset" class="btn btn-default btn-sm">Reset</button>
					</div>
				</div>
			</form:form>
		</div>
		<div class="panel-footer">
			Not Registered? <a href="<c:url value="/register"/>" class="">Register
				here</a>
		</div>

	</div>
</div>