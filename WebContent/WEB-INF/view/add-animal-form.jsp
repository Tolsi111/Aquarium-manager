<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>

<html>
<head>
	<title>Save Animal</title>
	
	<!-- reference the css -->
	<link type="text/css"
		rel="stylesheet"
		href="${pageContext.request.contextPath}/resources/css/style.css"/>
		
	<link type="text/css"
		rel="stylesheet"
		href="${pageContext.request.contextPath}/resources/css/add-animal-style.css"/>
</head>

<body>

	<div id="wraper">
		<div id="header">
			<h2>Animal Manager</h2>
		</div>
	</div>
	
	<div id="container">
		<h3>Add An Animal</h3>
		
		<form:form action="saveAnimal" modelAttribute="animal" method="POST">
			<table>
				<tbody>
					<tr>
						<td><label>Name</label></td>
						<td><form:input path="name" /></td>
					</tr>
					<tr>
						<td><label>Age</label></td>
						<td><form:input path="age" /></td>
					</tr>
					<tr>
						<td><label>Personality</label></td>
						<td><form:input path="personality" /></td>
					</tr>
					<tr>
						<td><label>Personality</label></td>
						<td><input type="submit" value="Save" class="save"/></td>
					</tr>
				</tbody>
			</table>
			
		</form:form>
		
		<div style="clear; both;"></div>
		
		<p>
			<a href="${pageContext.request.contextPath}/animal/list">Back</a>
		</p>
		
	</div>

</body>

</html>