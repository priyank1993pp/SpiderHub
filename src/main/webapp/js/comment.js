/**Storing comment into database using ajax
 * 
 */
function addComment() {
		$.ajax({	url : "service/comment",
					method : "POST",
					dataType : "json",
					processData : false,
					contentType : "application/json",
					data : JSON.stringify({
						comt : $("input[name='comment']").val(),
					}),
					success : function(data) {
						var newRow = $("<tr data-user-id='" + data.id + "'>"
								+ "<td data-field='id'>"
								+ data.id
								+ "</td>"
								+ "<td data-field='firstname'>"
								+ data.firstName
								+ "</td>"
								+ "<td data-field='lastname'>"
								+ data.lastName
								+ "</td>"
								+ "<td data-field='email'>"
								+ data.email
								+ "</td>"
								+ "<td><a class='view' href='javascript:void(0)'>View</a> | "
								+ "<a class='edit' href='javascript:void(0)'>Edit</a> | "
								+ "<a class='delete' href='javascript:void(0)'>Delete</a></td>")
						$("#users").append(newRow);
					}
				});
	}
$(function(){
	
	$("#cmt-form").dialog({
		autoOpen : false,
		buttons : {
			"Comment" : function() {
				if (!$("input[name='id']").val())
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