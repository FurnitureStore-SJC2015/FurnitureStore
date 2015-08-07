<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="navbar navbar-default" role="navigation">
	<div class="container">
		<div class="navbar-header">
			<a class="navbar-brand" href="<c:url value="" />">Furniture Store</a>
		</div>
		<c:if test="${not empty user}">
			<ul class="nav navbar-nav navbar-right">
				<li><a href='<c:url value="/client/profile/${user.id}" />'>Hi, ${user.name}</a></li>
				<li><a href="<c:url value="/logout"/>">Logout</a></li>
			</ul>
		</c:if>
	</div>

</div>