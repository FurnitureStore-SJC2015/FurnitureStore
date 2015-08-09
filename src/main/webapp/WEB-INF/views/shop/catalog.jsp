<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<table>
<c:forEach items= "${list}" var="item">
	 <tr>
	 	<td>
	 		${item.id}
	 	</td>
	 	<td>
	 		${item.name}
	 	</td>
	 </tr>
 </c:forEach>
</table>

<h2>HELLO</h2>