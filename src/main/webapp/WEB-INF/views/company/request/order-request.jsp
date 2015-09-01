<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<script type="text/javascript">

function getProviders(i , moduleId){
	
	$.ajax({
		url : "/FurnitureStore/requests/providers",
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
			dataType : 'json',
			url : "/FurnitureStore/requests/order/send",
			data : JSON.stringify(requestValues), 
			success : function(obj) {
				var temp=$("#record"+i);
				temp.hide( "clip", {direction: "horizontal"}, 1000 , function(){
	                temp.remove();
	            });
				location.reload();
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

							<tr id="record${i}">
								<td>${requestUnitDto.moduleId}</td>
								<td>${requestUnitDto.moduleName}</td>
								<td>${requestUnitDto.moduleCost}</td>
								<td>${requestUnitDto.count}</td>
								<td id="selecttd${i}"><button id="btn${i}"
										class="btn btn-success"
										onclick="getProviders(${i},${requestUnitDto.moduleId})">SHOW
										PROVIDERS</button>
									<div id="attention${i}" style="display: none;">
										<h5>No providers!</h5>
									</div></td>
								<td><button id="sendButton${i}" class="btn btn-success"
										style="display: none;"
										onclick="sendRequest(${i},${requestUnitDto.moduleId},${requestUnitDto.count},'${requestUnitDto.moduleName}',${requestUnitDto.moduleCost})">PROCESS
										REQUEST</button></td>

								<c:set var="i" value="${i + 1}"></c:set>
							</tr>

						</c:forEach>
					</tbody>
				</table>

			</div>
		</div>
	</div>
</div>