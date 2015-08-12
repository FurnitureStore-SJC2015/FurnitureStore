<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>

<div class="navbar navbar-default" role="navigation">
	<div class="container">
		<div class="navbar-header">
			<a class="navbar-brand" href="<c:url value="/" />">Furniture
				Store</a>
		</div>



		<sec:authorize access="isAuthenticated() and hasRole('ROLE_CLIENT')">

			<c:if test="${not empty user}">
				<ul class="nav navbar-nav navbar-right">
					<li><a href='<c:url value="/client/profile/" />'>Hi,
							${user.name}</a></li>
					<li><a href="<c:url value="/logout"/>">Logout</a></li>
				</ul>
			</c:if>

		</sec:authorize>

		<sec:authorize access="isAuthenticated() and hasRole('ROLE_ADMIN')">
			<ul class="nav navbar-nav navbar-right">
				<li><a href="<c:url value="/logout"/>">Logout</a></li>
			</ul>
		</sec:authorize>

	</div>

</div>