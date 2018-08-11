<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Module 06, Example 01</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="/JEECourse/ext/bootstrap/3.2.2/css/bootstrap.min.css">
<script src="/JEECourse/ext/jquery/1.11.2/jquery-1.11.2.js"></script>
<script src="/JEECourse/ext/bootstrap/3.2.2/js/bootstrap.min.js"></script>
</head>
<body>

<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">Module 06, Example 01</a>
    </div>
    <div>
      	<% if(session.getAttribute("name") == null) { %>
		<form class="navbar-form form-inline pull-right" method="POST" action="/JEECourse/module06/example01b.jsp">
    		<input type="text" placeholder="User name" name="name">
    		<input type="password" placeholder="Password" name="password">
    		<input type="hidden" name="pageSuccess" value="/module06/example01.jsp">
    		<button type="submit" class="btn">Sign in</button>
		</form>
		<% } else { %>
		<ul class="nav navbar-nav navbar-right">
            <li><a href="#">Current user: <%= session.getAttribute("name") %></a></li>
            <li><a href="/JEECourse/module06/example01a.jsp?pageSuccess=/module06/example01.jsp">Sign out</a></li>
        </ul>			
		<% } %>
	</div>	    
  </div>
</nav>
  
<div class="container">
  <div class="jumbotron">
    <h1>Working with Java Server Pages</h1>      
    <p>This page show some examples of JSP tags</p>          
  </div>
</div>

</body>
</html>




