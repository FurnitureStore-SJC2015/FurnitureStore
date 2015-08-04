<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<link href="<c:url value="/resources/css/template.css" />"
	rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

</head>
<body>
	<div class="page">
		<div class="header">
			<tiles:insertAttribute name="header" />
		</div>

		<div class="content">
			<div class="menu">
				<tiles:insertAttribute name="menu" />
			</div>
			<div class="body">
				<tiles:insertAttribute name="body" />
			</div>
		</div>
		<div class="footer">
			<tiles:insertAttribute name="footer" />
		</div>

	</div>
</body>
</html>