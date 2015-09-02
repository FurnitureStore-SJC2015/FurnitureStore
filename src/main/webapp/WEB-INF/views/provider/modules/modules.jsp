<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<c:set var="i" value="1"></c:set>
<script type="text/javascript">
	
function deleteModule(moduleId,i) {
		
	$.ajax({
		url : "/FurnitureStore/modules/"+moduleId+"/delete",
		type : "POST",
		beforeSend : function(xhr) {
			xhr.setRequestHeader("Accept", "application/json");
			xhr.setRequestHeader("Content-Type", "application/json");
		},
		success : function(obj) {
			var temp=$("#record"+i);
			temp.fadeOut(1000, function(){
                temp.remove();
            });
		}
	});
}

function getModulesToAdd(providerId){
	
	$.ajax({
		url : "/FurnitureStore/modules/provider/"+providerId,
		type : "GET",
		beforeSend : function(xhr) {
			xhr.setRequestHeader("Accept", "application/json");
			xhr.setRequestHeader("Content-Type", "application/json");
		},
		success : function(modules) {
			$('#selector').empty();	
			$("#selector")[0].options.add( new Option("<-- Select -->","0"));
			for (i=0;i<modules.length;i++){
				var id=modules[i]["id"];
				var value=modules[i]["name"];
				$("#selector")[0].options.add( new Option(value,id));
			}
			
		}
	});
}

function addModule() {
	var mdlId = $("#selector option:selected").val();
	
	$.ajax({
		type : "POST",
		url : "/FurnitureStore/modules/provider/add/"+mdlId, 
		beforeSend : function(xhr) {
			xhr.setRequestHeader("Accept", "application/json");
			xhr.setRequestHeader("Content-Type", "application/json; charset=utf-8");
		},
		success : function(obj) {
			location.reload();
            }
		});
}

</script>

<div class="col-md-9">
	<div class="panel panel-default">
		<div class="panel-heading">
			<h5 class="text-center">
				<span class="glyphicon glyphicon-edit"></span><strong>Provided
					modules list</strong>
			</h5>
		</div>
		<div class="panel-body">
			<div class="col-md-3">
				<select name="selector" class="form-control" id="selector"
					onclick="getModulesToAdd(${providerId})">
				</select>
			</div>
			<div class="col-md-3">
				<button class="btn btn-success" onclick="addModule()">
					Add modules
				</button>
			</div>
			<table class="table table-striped">
				<thead>
					<tr>
						<th>MODULE</th>
						<th>PICTURE</th>
						<th>DELETE</th>

					</tr>
				</thead>

				<tbody>

					<c:forEach items="${modules}" var="module">
						<tr id="record${i}">
							<td>${module.moduleType}</td>
							<td><c:if test="${not empty module.image}">
									<div class="col-md-4">
										<img src="data:image/jpeg;base64,${module.image}"
											class="img-thumbnail">
									</div>
								</c:if></td>

							<td>
								<button class="btn btn-default"
									onclick="deleteModule(${module.id},${i})">
									<span class="glyphicon glyphicon-trash"></span>
								</button>
							</td>
							<c:set var="i" value="${i + 1}"></c:set>
						</tr>
					</c:forEach>
				</tbody>
			</table>

		</div>

		<div class="panel-footer clearfix"></div>
	</div>

</div>