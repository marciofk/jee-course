<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title><%= request.getParameter("title") %></title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="/JEECourse/ext/bootstrap/3.2.2/css/bootstrap.min.css">
<script src="/JEECourse/ext/jquery/1.11.2/jquery-1.11.2.js"></script>
<script src="/JEECourse/ext/bootstrap/3.2.2/js/bootstrap.min.js"></script>
</head>
<body>

<nav class="navbar navbar-default">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="<%= request.getContextPath()%>/index.jsp"><%= request.getParameter("title") %></a>
    </div>
	<div>
      <ul class="nav navbar-nav">
        <li class="dropdown">
          <a class="dropdown-toggle" data-toggle="dropdown" href="#">Contents
          <span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li><a href="<%= request.getContextPath()%>/courseinfo/overview.jsp">Course Overview</a></li>
            <li><a href="<%= request.getContextPath()%>/courseinfo/program.jsp">Course Program</a></li>
          </ul>
        </li>
        <li><a href="<%= request.getContextPath()%>/courseinfo/examples.jsp">Examples</a></li>

        <li><a href="<%= request.getContextPath()%>/courseinfo/about.jsp">About</a></li>         
      </ul>      
    </div>    
    <div>
      	<% if(session.getAttribute("name") == null) { %>
		<form class="navbar-form form-inline pull-right"  action="/JEECourse/module06/example01b.jsp" method="POST">
    		<input type="text" placeholder="User name" name="name">
    		<input type="password" placeholder="Password" name="password">
    		<input type="hidden" name="pageSuccess"  value='<%= request.getParameter("page")%>'/>
    		<button type="submit" class="btn">Sign in</button>
		</form>
		<% } else { %>
		<ul class="nav navbar-nav navbar-right">
            <li><a href="#">Current user: <%= session.getAttribute("name") %></a></li>
            <li><a href="/JEECourse/module06/example01a.jsp?pageSuccess=<%=request.getParameter("page")%>">Sign out</a></li>
        </ul>			
		<% } %>
	</div>	    
  </div>
</nav>

<div class="container">

<!-- container, body and HTML tags are still opened -->