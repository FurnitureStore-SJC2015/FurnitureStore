<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>

<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/css/bootstrap/bootstrap.css"/>" />
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/css/bootstrap/bootstrap-theme.css"/>" />

<script src="<c:url value="/resources/js/bootstrap.js" />"></script>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

</head>
<body>
	<div class="container">
		<div class="row">
			<tiles:insertAttribute name="header" />
		</div>
		<div class="row">
			<c:if test="${not empty user}">
				<div class="col-md-4">
					<tiles:insertAttribute name="menu" />
				</div>
				<div class="col-md-8">
					<tiles:insertAttribute name="body" />
				</div>
			</c:if>
			<c:if test="${empty user}">
				<div class="col-md-4"></div>
				<div class="col-md-4">
					<tiles:insertAttribute name="body" />
				</div>
				<div class="col-md-4"></div>
			</c:if>

		</div>
	</div>
</body>
</html>