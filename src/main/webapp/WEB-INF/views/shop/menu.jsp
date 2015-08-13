<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<div class="col-md-3">
	<div class="list-group">
		<ul class="list-group">
			<a href=<c:url value="/catalog"/> class="list-group-item"> Catalog 
			</a>
			<a href='<c:url value="/company/info"/>' class="list-group-item"> Shop information
			</a>
			<a href='<c:url value="/company/add"/>' class="list-group-item"> Modify Shop
			</a>
			<a href='<c:url value="/company/add"/>' class="list-group-item"> Kate's Cargo
			</a>
		</ul>
	</div>
</div>