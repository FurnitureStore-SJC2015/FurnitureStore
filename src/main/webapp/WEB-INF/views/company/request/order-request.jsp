<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<script type="text/javascript">

function getProviders(i , moduleId){
	
	$.ajax({
		url : "providers",
		type : "GET",
		data: ({
			   text: moduleId
		  }),
		  
		beforeSend : function(xhr) {
			xhr.setRequestHeader("Accept", "application/json");
			xhr.setRequestHeader("Content-Type", "application/json");
		},
		success : function(providers) {
			var btn=$("#btn"+i);
			if (providers.length==0){
				$("#sendButton"+i).hide(1000 );
				$("#attention"+i).show( 1000);
				
			}
			else {
				var create = '<select name="selector'+i+'" class="form-control" id="selector'+i+'">';
				for(var k = 0; k < providers.length;k++)
				{
					var id= providers[k]["id"];
					var val=providers[k]["providerName"];
					create += '<option value="'+id+'">'+val+'</option>';
				}
				create += '</select>';
				$("#selecttd"+i).append(create);
				
				btn.hide(1000);
				$("#sendButton"+i).show(1000);
				
			}

			
			
				
		}
	});
}
	function sendRequest(i, mdlId, mdlCount, mdlNm, mdlCost) {
		var chsnProvider = $("#selector" + i + " option:selected").val();
		var requestValues = {
				
			moduleId : mdlId,
			count : mdlCount,
			moduleCost: mdlCost,
			moduleName: mdlNm,
			chosenProvider : chsnProvider
		}
		$.ajax({
			type : "POST",
			contentType : 'application/json; charset=utf-8',
			url : "send",
			data : JSON.stringify(requestValues), 
			success : function(obj) {
				var temp=$("#record"+i);
				temp.hide(1000 , function(){
	                temp.remove();
	            });
			}
		});
	}
</script>
<div class="col-md-9 well right">

	<div class="col-md-12" align="center">
		<h2 align="center">
			<strong>New Modules Request</strong>
		</h2>
	</div>
	<div class="col-md-12">
		<div class="panel panel-default">
			<div class="panel-heading" align="center">
				<h5>
					<span class="glyphicon glyphicon-list"></span> <strong>New
						Request</strong>
				</h5>
			</div>


			<div class="panel-body">
				<c:set var="i" value="1"></c:set>
				<table class="table table-striped">
					<thead>
						<tr>
							<th>Module ID</th>
							<th>Module Name</th>
							<th>Module Cost</th>
							<th>Module Count</th>
							<th>Provider Name</th>
							<th>Send</th>
						</tr>
					</thead>

					<tbody>
						<c:forEach var="requestUnitDto" items="${requestUnitDtos}">
							<tr id="record${i}">
								<td>${requestUnitDto.moduleId}</td>
								<td>${requestUnitDto.moduleName}</td>
								<td>${requestUnitDto.moduleCost}</td>
								<c:choose>
									<c:when test="${requestUnitDto.count>0}">
										<td>${requestUnitDto.count}</td>
										<td id="selecttd${i}"><button id="btn${i}"
												class="btn btn-success"
												onclick="getProviders(${i},${requestUnitDto.moduleId})">Show
												Providers</button>
											<div align="center" id="attention${i}" style="display: none;">
												<h5>
													<strong>No providers!</strong>
												</h5>
											</div></td>
										<td><button id="sendButton${i}" class="btn btn-success"
												style="display: none;"
												onclick="sendRequest(${i},${requestUnitDto.moduleId},${requestUnitDto.count},'${requestUnitDto.moduleName}',${requestUnitDto.moduleCost})">Process
												Request</button></td>
									</c:when>

									<c:otherwise>
										<td><div>
												<h5>
													<strong>Waiting shipment from provider...</strong>
												</h5>
											</div></td>
										<td></td>
										<td></td>
									</c:otherwise>
								</c:choose>
								<c:set var="i" value="${i + 1}"></c:set>
							</tr>

						</c:forEach>
					</tbody>
				</table>

			</div>
		</div>
	</div>
</div>