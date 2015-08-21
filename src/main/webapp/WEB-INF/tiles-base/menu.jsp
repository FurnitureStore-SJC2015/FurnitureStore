<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>


<sec:authorize access="isAuthenticated() and hasRole('ROLE_CLIENT')">
	<c:set var="orderCount" value="${loggedClient.orderCount}" />
	<div class="col-md-3">
		<div class="list-group">
			<ul class="list-group">
				<a href='<c:url value="/profile/"/>' class="list-group-item">My
					Profile<span class="badge"></span>
				</a>
				<a href='<c:url value="/client/orders"/>' class="list-group-item">My
					Orders<span class="badge">${orderCount}</span>
				</a>
				<a href='<c:url value="/catalog"/>' class="list-group-item">Shop<span
					class="badge"></span>
				</a>
			</ul>
		</div>
	</div>
</sec:authorize>


<sec:authorize access="isAuthenticated() and hasRole('ROLE_COMPANY')">
	<div class="col-md-3">
		<div class="list-group">
			<ul class="list-group">
				<a href=<c:url value="/catalog"/> class="list-group-item">
					Catalog </a>
				<a href='<c:url value="/company/info"/>' class="list-group-item">
					Shop information </a>
				<a href='<c:url value="/catalog/action"/>' class="list-group-item">
					Modify Shop </a>
				<a href='<c:url value="/catalog/action/add"/>'
					class="list-group-item"> Add new product </a>
				<a href='<c:url value="/catalog/search"/>' class="list-group-item">
					Search </a>
				<a href='<c:url value="/catalog/action/add"/>'
					class="list-group-item"> Kate's Cargo </a>
			</ul>
		</div>
	</div>
</sec:authorize>