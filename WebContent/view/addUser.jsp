<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
<!DOCTYPE html>
<html>

<head>
    <meta charset="ISO-8859-1">
    <title>Add User</title>
</head>

<body>
	<h2>Add User</h2>

	<form action="/LibraryManagementSystem/addUser" method="post">

		FullName : <input type="text" name="fullName" /> <br> 
		
		Username :
		<input type="text" name="username" /> <br> 
		
		Password : <input
			type="password" name="password" /> <br>
	    
	    Role : <input
			type="number" name="role" /> <br> <input type="submit"
			value="add user" />
	</form>

</body>
</html>