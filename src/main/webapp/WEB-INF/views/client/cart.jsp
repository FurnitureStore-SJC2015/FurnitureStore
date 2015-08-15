<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>

<sec:authorize access="isAuthenticated() and hasRole('ROLE_CLIENT')">
	<div class="col-md-9">

		<button type="button" class="btn btn-link">Choose payment scheme</button>

	</div>


</sec:authorize>