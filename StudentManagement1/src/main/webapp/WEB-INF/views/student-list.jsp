<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css"
	integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS"
	crossorigin="anonymous">

<title>Student List</title>
</head>
<body>
	<div class="container">
		<h3>Student List</h3>
		<hr>
		<!-- Add a search form -->
		<div>
		<form class="form-inline">
			<!-- Add a button -->
			<div>
			<a href="/students/showFormForAdd" class="btn btn-primary btn-sm mb-3"> Add New 
				Student </a> </div> 
				
				<div style="padding-left: 80%; padding-right: 0%">
			<a href="/logout" class="btn btn-primary btn-sm mb-3 mx-auto" >
				Logout </a>
				</div>
		</form>
		</div>
		<table class="table table-bordered table-striped">
			<thead class="thead-dark">
				<tr>
					<th>FirstName</th>
					<th>LastName</th>
					<th>Course</th>
					<th>Country</th>
					<th>Action</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${studentObj}" var="studentObj">
					<tr>
						<td><c:out value="${studentObj.firstName}" /></td>
						<td><c:out value="${studentObj.lastName}" /></td>
						<td><c:out value="${studentObj.course}" /></td>
						<td><c:out value="${studentObj.country}" /></td>
						<td>
							<!-- Add "update" button/link --> <a
							href="/students/showFormForUpdate?id=${studentObj.id}"
							class="btn btn-info btn-sm"> Update </a> <!-- Add "delete" button/link -->
							<a href="/students/delete?id=${studentObj.id}" class="btn btn-danger btn-sm"
							onclick="if (!(confirm('Please confirm if you want to delete this Student Record?'))) return false">
								Delete </a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>