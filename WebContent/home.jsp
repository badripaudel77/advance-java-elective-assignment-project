<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

  <h2> Home page  </h2>
  <p>You are Logged In as <span style="color: green;"> 
  <%=session.getAttribute("sessionValue")%></span></p>
  <a href="users" >List Users</a>
</body>
</html>