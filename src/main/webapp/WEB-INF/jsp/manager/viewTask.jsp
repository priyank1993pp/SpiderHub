<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
<script src="http://code.jquery.com/ui/1.12.1/jquery-ui.min.js"></script>
<script type="text/javascript" >
function addComment() {
	var cmt = $("input[name='comment']").val();
		var taskid = $("#task").val();
		alert(taskid);
		$.ajax({	
			type : "POST",
			url : "comment.html",
			datatype : "json",
			data : {"desc" :  cmt, "taskId" : taskid}, 
					success : function(data) {
						alert("test");
						$(this).dialog("close");
					}
				});
	}
$(function(){
	
	$("#cmt-form").dialog({
		autoOpen : false,
		buttons : {
			"Comment" : function() {
					addComment();
				$(this).dialog("close");
			}
		}
	});
	
	$("#add").click(function() {
		$("form")[0].reset();
		$("#cmt-form").dialog("open");
	});
})
</script>
<div class="jumbotron">
	<table class="table table-hover">
		<tr>
			<th>ID</th>
			<td>${task.id}</td>
		</tr>
		<tr>
			<th>TaskName</th>
			<td>${task.taskName}</td>
		</tr>
		<tr>
			<th>Description</th>
			<td>${task.taskDescription}</td>
		</tr>

	</table>
	<table class="table table-hover">
		<tr>
			<th>File Name</th>
			<th>File Type</th>
			<th>File Upload Date</th>
			<th>File Download</th>
		</tr>
		<c:forEach items="${fileModel}" var="file">
			<tr>

				<%-- <td><input type="radio" name="files" value="${file.id}" /></td> --%>
				<td>${file.fileName}</td>
				<td>${file.fileType}</td>
				<td>${file.uploadDate}</td>
				<td><a
					href="download.html?file=${file.fileName}.${file.fileType}">Download</a></td>


			</tr>
		</c:forEach>
	</table>

	<c:if test="${not empty comments}">
		<c:forEach items="${comments}" var="c">
			<p>${c.userComment.userName}</p>
			<br/>
			<p>${c.commentDesc}</p>
		</c:forEach>
	</c:if>
	<%-- <form:form modelAttribute="comment" role="form">
		<form:textarea path="commentDesc" rows="2" cols="30"
			class="form-control" required="required" />
		<input type="hidden" name="task" value="${task.id}" />
		<input class="btn btn-primary" type="submit" name="action"
			value="Comment">
	</form:form> --%>
	<button id="add">Add Comment</button>
	
	
	<div id="cmt-form">
		<form>
			<input type="text" name = "comment" />
			<input type="hidden" id = "task" value = "${task.id}" />
			<input name="id" type="hidden" />
		</form>
	</div>
	<a href="assignTask.html?id=${task.id}">Assign</a>
</div>