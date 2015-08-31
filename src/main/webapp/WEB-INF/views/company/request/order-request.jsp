<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<script type="text/javascript">
	function sendRequest(i, moduleId, moduleCount) {
		var chosenProvider = $("#selector" + i + " option:selected").text();
		var requestValues = {

			"moduleId" : moduleId,
			"moduleCount" : moduleCount,
			"chosenProvider" : chosenProvider
		}
		$.ajax({
			type : "POST",
			contentType : 'application/json; charset=utf-8',
			dataType : 'json',
			url : "requests/order/send",
			data : JSON.stringify(requestValues), 
			success : function() {
				var temp=$("#record"+i);
				temp.hide( "clip", {direction: "horizontal"}, 1000 , function(){
	                temp.remove();
	            });
			}
		});
	}
</script>

<div class="col-md-9 well right">

	<div class="col-md-12" align="center">
		<h2 align="center">
			<strong>NEW MODULES REQUEST</strong>
		</h2>
	</div>
	<div class="col-md-12">
		<div class="panel panel-default">
			<div class="panel-heading">
				<h5 class="text-center">
					<span class="glyphicon glyphicon-list"></span><strong>New
						Request</strong>
				</h5>
			</div>

			<div class="panel-body">
				<c:set var="i" value="1"></c:set>
				<table class="table table-striped">
					<thead>
						<tr>
							<th>MODULE ID</th>
							<th>MODULE NAME</th>
							<th>MODULE COST</th>
							<th>MODULE COUNT</th>
							<th>PROVIDER NAME</th>
							<th>SEND</th>
						</tr>
					</thead>

					<tbody>

						<c:forEach items="${requestUnitDtos}" var="requestUnitDto">
							<c:if test="${not empty requestUnitDto.chosenProvider">
								<tr id="record${i}">
									<td>${requestUnitDto.moduleId}</td>
									<td>${requestUnitDto.moduleName}</td>
									<td>${requestUnitDto.moduleCost}</td>
									<td>${requestUnitDto.count}</td>
									<td><label for="selector">Payment Form:</label> <select
										name="selector${i}" class="form-control" id="selector${i}"
										onclick="sendRequest(${i},${requestUnitDto.moduleId},${requestUnitDto.count})">
									</select></td>
									<td><button class="btn btn-success"
											onclick="sendRequest(${i},${requestUnitDto.moduleId},${requestUnitDto.count})">PROCESS
											REQUEST</button></td>

									<c:set var="i" value="${i + 1}"></c:set>
								</tr>
							</c:if>
						</c:forEach>
					</tbody>
				</table>
				<div class="col-md-2">
					<c:set var="link" value="request/order/${id}/send"></c:set>
					<button class="btn btn-success" onclick="location.href='${link}'">SEND
						REQUEST</button>
				</div>


			</div>
		</div>
	</div>
</div>