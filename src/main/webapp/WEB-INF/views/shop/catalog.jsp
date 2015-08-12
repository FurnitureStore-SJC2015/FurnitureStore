<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<div class="col-md-9 well">
	<div class="page-header">
		<h1>"Products catalog</h1>
	</div>
	
	<c:forEach items= "${list}" var="item">
		<div class="media">
		  <a class="pull-left" href="#">
		  	<img src="data:image/jpeg;base64,${item.image}" class="media-object" alt = "${item.name }" height="150" width="150">
		  </a>
		  <div class="media-body">
		    <h4 class="media-heading">${item.name }</h4>
		    ${item.description }
		    ...
		  </div>
		</div>
	</c:forEach>
	
	
	<div class="col-md-9">
			<h2>Product</h2>
			<h3>${product.description}</h3>
		</div>
		
	<ul class="pagination">
	<li><a href="#">&laquo;</a></li>
	<c:forEach var = "i" begin="1" end="${pageCount}">
		<li><a href = "#">${i}</a></li>
	</c:forEach>
	  <li><a href="#">&raquo;</a></li>
	</ul>
</div>