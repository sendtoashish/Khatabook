<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>All Students</title>

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">

<style type="text/css">
tr:first-child {
	font-weignt: bold;
	background-color: #c6c9c4
}
</style>
</head>
<body>
	<div class="container">
		<h2>Item List and Prices</h2>
		<c:if test="${not empty success}">
			<div class="alert alert-success" role="alert">${success}</div>
		</c:if>

		<hr />
		<table class="table">
			<thead class="thead-dark">
				<tr>
					<td>ID</td>
					<td>Item Name</td>
					<td>Price</td>
					<td>Modify</td>
					<td>Delete</td>
				</tr>
				<c:forEach items="${allItems}" var="i">
					<tr>
						<td>${i.id}</td>
						<td>${i.item}</td>
						<td>${i.price}</td>
						<td><a href="<c:url value='/edit-${i.id}' />">Modify</a></td>
						<td><a href="<c:url value='/delete-${i.id}' />">Delete</a></td>
					</tr>
				</c:forEach>
		</table>
		<hr />
		<p>Total: ${total}</p>
		<hr />
		<div class="form-group">
			<a class="btn btn-secondary" href="<c:url value='/new' />">Add
				New Item</a>
		</div>
	</div>
</body>
</html>