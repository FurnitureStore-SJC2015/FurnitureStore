<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<h3>Please Sign In!</h3>

<form:form name="loginForm" action="login" mathod="POST"
	class="form-horizontal" role="form">
	<div class="form-group">
		<label for="login" class="col-sm-4 control-label">User Login:</label>
		<div class="col-sm-8 control-label">
			<input type="text" id="login" name="login" class="form-control"
				placeholder="Enter user name">
		</div>
	</div>
	<div class="form-group">
		<label for="password" class="col-sm-4 control-label">User Password:</label>
		<div class="col-sm-8 control-label">
			<input type="password" id="password" name="password"
				class="form-control" placeholder="Enter user password">
		</div>
	</div>
	<div class="form-group">
		<div class="col-sm-offset8 col-sm-4">
			<button type="submit" class="btn btn-default">Sign In</button>
		</div>
	</div>
</form:form>