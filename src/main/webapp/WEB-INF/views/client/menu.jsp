<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>

<sec:authorize access="isAuthenticated() and hasRole('ROLE_CLIENT')">
	<c:set var="orderCount" value="${client.orderCount}" />
	<div class="col-md-3">
		<div class="list-group">
			<ul class="list-group">
				<a href='<c:url value="/client/profile/"/>' class="list-group-item">My
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