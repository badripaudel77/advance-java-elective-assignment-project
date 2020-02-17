<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="com.library.entities.User" %>

<!DOCTYPE html>
<html>

<head>
    <meta charset="ISO-8859-1">
    <title>Add User</title>
</head>

<body>
	<h2>Edit the User</h2>

    <% User user = (User)request.getAttribute("userByIdList"); %>
     Id to be Edited : <%=user.getId()%>
     
	<form action="updateUser" method="post">
       
       <input type="hidden" name="id" value="<%=user.getId()%>">
       
		FullName : <input type="text" name="fullName" value="<%=user.getFullName()%>" /> <br> 
		Username :<input type="text" name="username" value="<%=user.getUsername() %>" /> <br> 
		
		Password : <input
			type="password" name="password" value="<%=user.getPassword()%>" /> <br>
	    
	    Role : <input
			type="number" name="role" value="<%=user.getRole()%>" /> <br> 
			<input type="submit"
			value="update user" />
	</form>

</body>
</html>