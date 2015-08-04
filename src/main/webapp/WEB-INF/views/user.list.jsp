<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<table>
<c:forEach items="${users}" var="user">
<tr>
<td>${user.name}</td>
<td>${user.login}</td>
</tr>
</c:forEach>

</table>
