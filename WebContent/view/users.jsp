<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="com.library.entities.User" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title> list users - lms</title>
</head>
<body>

<h1>List Users - LMS </h1>

<% List<User> users = (List<User>)request.getAttribute("userList"); %>
   Total number of users : <%=users.size()%>
 
 
 <br />
  <a href="view/addUser.jsp"> Add User </a>

<table border="1">
  <thead>
    <td>S.N</td>
    <td>FullName</td>
    <td>UserName</td>
    <td>Role</td>
    <td> Action </td>
  </thead>  
    
  
   <% for(User usr : users) {%>
  <tr>
     <td><%= usr.getId()%></td>
     <td><%= usr.getFullName()%></td>
     <td><%=usr.getUsername() %></td>
     <td><%=usr.getRole() ==1 ? "Teacher " : "Student" %></td>
     <td>
     <a href="users/getEdit?id=<%= usr.getId()%>" onclick="return confirm('Are you really going to modify this record ? ');">Edit || </a>
     <a href="deleteUser?id=<%= usr.getId()%>" onclick="return confirm('Are you sure to delete this record ?');">Delete</a>
     </</td>
  </tr>
     <%}
     %>

</table>

</body>
</html>