<!DOCTYPE html>

<%@page import="com.dao.JDBCEmployeeDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>


<html>
<head>
<meta charset="utf-8">
<title>Welcome</title>

<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/jquery/jquery-2.2.2.js"></script>
<script src="//code.jquery.com/ui/1.12.0-rc.2/jquery-ui.js"></script>
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">

<script>
	var availableTags = [];

	var fName = $('#fname').val();

	// searching user

	function start() {
		$("#updateDiv").hide();
		$("#idEmployee").prop("readonly", true);
		;
		searchComplate();
	}
	function searchComplate() {

		var sName = $('#sname').val();
		$
				.ajax({

					url : "SearchEmployee?sName=" + sName,
					success : function(result) {
						var responseJson = JSON.parse(result)
						var projects = [ {

						} ];
						availableTags = [];
						$.each(responseJson, function(i, item) {

							availableTags.push({
								value : item.firstName,
								id : item.id
							});
						});
					}

				})
				.done(
						function() {

							$("#sname")
									.autocomplete(
											{
												source : availableTags,
												select : function(event, ui) {

													$("#updateDiv").show();

													$("#idEmployee")
															.val(
																	ui.item ? ui.item.id
																			: "Nothing selected, input was "
																					+ this.value);
													$("#uName")
															.val(
																	ui.item ? ui.item.value
																			: "");

												}

											});
						});
	}
	$(document).on("input", "#sname", function() {
		searchComplate();

	});

	// creating user
	$(document).on("click", "#createUser", function() {
		var fName = $('#fname').val()
		$.ajax({
			url : "createEmployee?fName=" + fName,
			success : function(result) {
				alert(result);
				$("#fname").val('');
				$('#fname').css({
					"background-color" : "white"
				});

			}
		});
	});

	$(document).on("click", "#deleteUser", function() {
		var idEmployee = $('#idEmployee').val()
		$.ajax({
			url : "deleteEmployee?id=" + idEmployee,
			success : function(result) {
				alert(result);
				$("#updateDiv").hide();
				$('#sname').val('');

			}
		});
	});

	$(document).on("click", "#updateEmployee", function() {
		var idEmployee = $('#idEmployee').val()
		var name = $('#uName').val()

		$.ajax({
			url : "updateEmployee?id=" + idEmployee + "&name=" + name,
			success : function(result) {
				alert(result);
				$("#updateDiv").hide();
				$('#sname').val('');

			}
		});
	});

	$(document).on("input", "#fname", function() {
		var fName = $('#fname').val().length;

		if (fName > 0) {
			$('#fname').css({
				"background-color" : "green"
			});
			$("#fNameInfo").html("Checked");
		} else {
			$("#fNameInfo").html("To small name");
			$('#fname').css({
				"background-color" : "blue"
			});
		}
	})
</script>
</head>
<body onload="start()">

	<b>Add employee</b>
	<br> First name:
	<input type="text" id="fname">
	<div id="fNameInfo"></div>
	
	<button id="createUser">add employee</button>

	<br>
	<br><b> Search employee</b>

	<br> First name:
	<input type="text" id="sname">

	<br>
	<br>
	<div id="updateDiv">
		<b>Selected </b><br> Id: <input type="text" id="idEmployee">
		<br> First name: <input type="text" id="uName"> <br>
		<button id="deleteUser">delete user</button>
		<button id="updateEmployee">upload employee</button>
	</div>


</body>
</html>
