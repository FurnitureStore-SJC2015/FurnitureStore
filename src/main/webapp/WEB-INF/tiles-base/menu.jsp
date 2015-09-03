<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
	language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>


<sec:authorize access="isAuthenticated() and hasRole('ROLE_CLIENT')">
	<c:set var="orderCount" value="${loggedClient.orderCount}" />
	<div class="col-md-3">
		<div class="list-group">
			<ul class="list-group">
				<a href='<c:url value="/client/"/>' class="list-group-item">My
					Profile<span class="badge"></span>
				</a>
				<a href='<c:url value="/order/all"/>' class="list-group-item">My
					Orders<span class="badge">${orderCount}</span>
				</a>
				<a href='<c:url value="/catalog"/>' class="list-group-item">To
					Catalog<span class="badge"></span>
				</a>
			</ul>
		</div>
	</div>
</sec:authorize>


<sec:authorize access="isAuthenticated() and hasRole('ROLE_COMPANY')">
	<div class="col-md-3">
		<div class="list-group">
			<ul class="list-group">
				<li class="list-group-item"><a href='<c:url value="/catalog"/>'>Catalog</a></li>
				<li class="list-group-item"><a
					href='<c:url value="/company/incoming"/>'>Incoming Orders</a></li>
				<li class="list-group-item"><a
					href='<c:url value="/modules/catalog"/>'>Modules Catalog</a></li>

				<li class="list-group-item"><a
					href='<c:url value="/shipments"/>'>Shipments</a></li>
			</ul>
		</div>
	</div>
</sec:authorize>

<sec:authorize access="isAuthenticated() and hasRole('ROLE_PROVIDER')">
	<div class="col-md-3">
		<div class="list-group">
			<ul class="list-group">
				<li class="list-group-item"><a
					href='<c:url value="/provider/profile"/>'>Profile</a></li>
				<li class="list-group-item"><a
					href='<c:url value="/requests"/>'>Requests </a></li>
				<li class="list-group-item"><a href='<c:url value="/reports"/>'>Reports
				</a></li>
				<li class="list-group-item"><a href='<c:url value="/modules"/>'>Modules</a></li>
			</ul>
		</div>
	</div>
</sec:authorize>