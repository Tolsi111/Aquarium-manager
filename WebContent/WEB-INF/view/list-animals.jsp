<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>

<html>

<head>
	<title>List Animals</title>
	
	<!-- reference the css -->
	<link type="text/css"
		rel="stylesheet"
		href="${pageContext.request.contextPath}/resources/css/style.css"/>
</head>
	
<body>
	
	<div id="wraper">
		<div id="header">
			<h2>Animal Manager</h2>
		</div>
		
		<div id="container">
			<div id="content">
				
				<!-- add annimal button -->
				<input type="button" value="Add an animal"
					onclick="window.location.href='showAddAnimalForm'; return false;"
					class="add-button"
				/>
				
				<!-- html table -->
				<table>
					<tr>
						<th>Name</th>
						<th>Age</th>
						<th>Personality</th>
					</tr>
					
					<c:forEach var="tempAnimal" items="${animals}">
					<tr>
						<td>${tempAnimal.name}</td>
						<td>${tempAnimal.age}</td>
						<td>${tempAnimal.personality}</td>
					</tr>
					</c:forEach>
					
				</table>
				
			</div>
		</div>
		
	</div>

</body>

</html>