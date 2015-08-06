<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<div class="col-md-3">

<h2></h2>
	<div class="list-group">
		<ul class="list-group">
			<a href="#" class="list-group-item">Orders<span
				class="badge">${fn:length(user.orders)}</span></a>
			<a href="#" class="list-group-item">Future payments<span
				class="badge">14</span></a>
			<a href="#" class="list-group-item">Dapibus ac facilisis in<span
				class="badge">10</span></a>
		</ul>
	</div>
</div>