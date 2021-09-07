<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
				<!-- refresh button -->
				<button onClick="window.location.href='list'; return false;" class="add-button">Refresh List</button>
				
				<!-- search animal form -->
			<form:form action="search" method="GET">
                Search Animal: <input type="text" name="theSearchName" />
                
                <input type="submit" value="Search" class="add-button" />
            </form:form>
				
				<!-- html table -->
				<table>
					<tr>
						<th>Name</th>
						<th>Age</th>
						<th>Personality</th>
						<th>Action</th>
					</tr>
					
					<c:forEach var="tempAnimal" items="${animals}">
					
					<!-- Create update link with customer id -->
					<c:url var="updateLink" value="/animal/showUpdateAnimalForm">
						<c:param name="animalId" value="${tempAnimal.id}"/>
					</c:url>
					
					<!-- Create delete link -->
					<c:url var="deleteLink" value="/animal/deleteAnimal">
						<c:param name="animalId" value="${tempAnimal.id}"/>
					</c:url>
					
					<tr>
						<td>${tempAnimal.name}</td>
						<td>${tempAnimal.age}</td>
						<td>${tempAnimal.personality}</td>
						<td>
							<a href="${updateLink}">Update</a>|<a href="${deleteLink}" onclick="if (!(confirm('Are you sure you wish to delete this animal?'))) return false">Delete</a>
						</td>
					</tr>
					</c:forEach>
					
				</table>
				
			</div>
		</div>
		
	</div>

</body>

</html>