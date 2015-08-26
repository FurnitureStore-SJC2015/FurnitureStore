<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>

<h3>
	<strong>Exception name:</strong>
</h3>
<h3>${name}</h3>
<h3>
	<strong>Exception has been caught on page:</strong>
</h3>
<h3>${url}</h3>
<h3>
	<strong>Error message: </strong>
</h3>
<h3>${exception.message}</h3>

