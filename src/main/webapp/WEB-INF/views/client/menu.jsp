<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<div class="col-md-3">
	<c:if test="${not empty user}">
		<div class="list-group">
			<ul class="list-group">
				<a href='<c:url value="/client/profile/"/>' class="list-group-item">My
					Profile<span class="badge"></span>
				</a>
				<a href='<c:url value="/client/orders"/>' class="list-group-item">My
					Orders<span class="badge">${orderCount}</span>
				</a>
				<a href="#" class="list-group-item">Position<span class="badge"></span></a>
				<a href="#" class="list-group-item">Position<span class="badge"></span></a>
			</ul>
		</div>
	</c:if>
</div>