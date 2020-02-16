<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<h1 style="text-align: center; color: green">Library Management
		System</h1>
  
  <h3 style="color:red; height:60px;width:400px;">${errorMsg}</h3> 
		

	<form name="userLogin" method="post" action="userLogin">

		Username : <input type="text" name="username" /> <br /> 
		Password : <input type="password" name="password" /> <br /> 
		
		<input type="submit"value="submit" />

	</form>

</body>
</html>