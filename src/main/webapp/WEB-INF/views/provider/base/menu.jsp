<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<div class="col-md-3">
	<div class="list-group">
		<ul class="list-group">
			<li class="list-group-item"><a
				href=<c:url value="/provider/profile"/>>PROFILE</a></li>
			<li class="list-group-item"><a
				href='<c:url value="/provider/module_requests"/>'>REQUESTS </a></li>
			<li class="list-group-item"><a
				href='<c:url value="/provider/reports"/>'>REPORTS </a></li>
			<li class="list-group-item"><a
				href='<c:url value="/provider/module_list"/>'>MODULES</a></li>
		</ul>
	</div>
</div>