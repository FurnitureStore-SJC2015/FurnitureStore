<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<span style="float: right"> <a href="?lang=en">en</a> | <a
	href="?lang=ru">ru</a>
</span>

<div class="col-md-12">
	<div class="col-md-4 col-md-offset-4">
		<div class="panel panel-default">
			<div class="panel-heading">
				<h5 class="text-center">
					<span class="glyphicon glyphicon-pencil"></span><strong><spring:message
							code="label.signin" /></strong>
				</h5>
			</div>
			<div class="panel-body">
				<c:url value="/j_spring_security_check" var="loginUrl" />
				<form:form name="loginForm" action="${ loginUrl}" method="POST"
					class="form-horizontal" role="form">
					<c:if test="${not empty error}">
						<div class="form-group has-warning">
							<div class="col-md-12">
								<label class="control-label" for="errorMessage">${error}</label>
							</div>
						</div>
					</c:if>
					<c:if test="${not empty logout}">
						<div class="form-group has-success">
							<div class="col-md-12">
								<label class="control-label" for=logoutMessage>${logout}</label>
							</div>
						</div>
					</c:if>
					<div class="form-group ">
						<label for="login" class="col-sm-3 control-label"><spring:message
								code="label.login" /></label>
						<div class="col-sm-9 control-label">
							<input type="text" id="login" name="login" class="form-control"
								placeholder=<spring:message
							code="label.enteruserlogin" />
								value="${new_client.login}">
						</div>
					</div>
					<div class="form-group">
						<label for="password" class="col-sm-3 control-label"><spring:message
								code="label.password" /></label>
						<div class="col-sm-9 control-label">
							<input type="password" id="password" name="password"
								class="form-control"
								placeholder=<spring:message
								code="label.enteruserpassword" />>
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-6">
							<input id="remember_me" name='_spring_security_remember_me'
								type="checkbox" /> <label for="remember_me"><spring:message
									code="label.remember" /></label>

						</div>
					</div>
					<div class="form-group">
						<div class="text-center">
							<button type="submit" class="btn btn-success btn-sm">
								<spring:message code="label.signin" />
							</button>
							<button type="reset" class="btn btn-default btn-sm">
								<spring:message code="label.reset" />
							</button>
						</div>
					</div>
				</form:form>
			</div>

			<div class="panel-footer clearfix">
				<div class="pull-right">
					<spring:message code="label.notregistered" />
					<a href="<c:url value="/register"/>" class=""><spring:message
							code="label.register" /></a>
				</div>
			</div>
		</div>
	</div>
</div>