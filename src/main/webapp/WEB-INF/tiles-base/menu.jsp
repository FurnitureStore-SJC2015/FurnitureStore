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
					catalog<span class="badge"></span>
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
				<a href='<c:url value="/company/incoming"/>' class="list-group-item">
					Incoming orders</a>
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

<sec:authorize access="isAuthenticated() and hasRole('ROLE_PROVIDER')">
	<div class="col-md-3">
		<div class="list-group">
			<ul class="list-group">
				<li class="list-group-item"><a
					href=<c:url value="/provider/profile"/>>PROFILE</a></li>
				<li class="list-group-item"><a
					href='<c:url value="/requests"/>'>REQUESTS </a></li>
				<li class="list-group-item"><a href='<c:url value="/reports"/>'>REPORTS
				</a></li>
				<li class="list-group-item"><a href='<c:url value="/modules"/>'>MODULES</a></li>
			</ul>
		</div>
	</div>
</sec:authorize>