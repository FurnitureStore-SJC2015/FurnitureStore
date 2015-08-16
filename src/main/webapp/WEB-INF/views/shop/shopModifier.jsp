<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<div class="col-md-9 well">
	<div class="page-header">
		<h1>Some text</h1>
	</div>
	
	<c:forEach items= "${products}" var="item">
		<div class="media">
		  <a class="pull-left" href="#">
		  	<img src="data:image/jpeg;base64,${item.image}" class="media-object" alt = "${item.name }" height="64" width="64">
		  </a>
		  <div class="media-body">
		    <h4 class="media-heading">${item.name }</h4>
		    <c:url var="link" value="edit/product/${item.id}"/>
		    <button class="btn btn-default" onclick="location.href='${link}'">
		    	Edit
		    </button>
		     <c:url var="link" value="/catalog/action/delete/product/${item.id}"/>
		     <button class="btn btn-default" onclick="location.href='${link}'">
		    	Delete
		    </button>
		  </div>
		</div>
	</c:forEach>
</div>