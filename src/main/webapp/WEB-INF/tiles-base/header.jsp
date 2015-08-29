<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<div class="navbar navbar-default" role="navigation">
	<div class="container">
		<div class="navbar-header">
			<a class="navbar-brand" href="<c:url value="/login" />">Furniture
				Store</a>
		</div>

		<c:url var="logout" value="/j_spring_security_logout" />

		<sec:authorize access="isAuthenticated() and hasRole('ROLE_CLIENT')">
			<sec:authentication var="user" property="principal" />
			<ul class="nav navbar-nav navbar-right">
				<li><a href='<c:url value="/client/" />'><span
						class="glyphicon glyphicon-user"></span>Hi, ${user.username}</a></li>
				<li><a href="<c:url value="/cart"/>"><span
						class="glyphicon glyphicon-shopping-cart"></span><strong>My
							cart</strong></a></li>

				<li><a href="<c:url value="/payment/all"/>"><span
						class="glyphicon glyphicon-piggy-bank"></span><strong>My
							payments</strong></a></li>

				<li><a href="<c:url value="${logout}"/>"><span
						class="glyphicon glyphicon-log-out"></span>Logout</a></li>

			</ul>
		</sec:authorize>

		<sec:authorize access="isAuthenticated() and hasRole('ROLE_ADMIN')">
			<ul class="nav navbar-nav">
				<li><a href='<c:url value="/admin/panel" />'><span
						class="glyphicon glyphicon-list-alt"></span>All users</a></li>
				<li><a href='<c:url value="/admin/register/provider"/>'><span
						class="glyphicon glyphicon-user"></span>New Provider</a></li>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<li><a href="<c:url value="${logout}"/>"><span
						class="glyphicon glyphicon-log-out"></span>Logout</a></li>
			</ul>
		</sec:authorize>

		<sec:authorize access="isAuthenticated() and hasRole('ROLE_COMPANY')">
			<ul class="nav navbar-nav navbar-right">
				<li><a href="<c:url value="${logout}"/>"><span
						class="glyphicon glyphicon-log-out"></span>Logout</a></li>
			</ul>

		</sec:authorize>
		<sec:authorize access="isAuthenticated() and hasRole('ROLE_PROVIDER')">
			<ul class="nav navbar-nav">

				<li><a href='<c:url value="/provider/" />'><span
						class="glyphicon glyphicon-user"></span>Hi, ${provider.name}</a></li>
			</ul>

			<ul class="nav navbar-nav navbar-right">
				<li><a href="<c:url value="${logout}"/>"><span
						class="glyphicon glyphicon-log-out"></span>Logout</a></li>
			</ul>
		</sec:authorize>
	</div>

</div>