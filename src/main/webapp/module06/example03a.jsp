<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.io.*" %>    
<%@ page isErrorPage="true"%>    
    
<jsp:include page="/utils/header.jsp">
	<jsp:param name="title" value="Module 06, Example 03" />
	<jsp:param name="page" value="/module06/example04.jsp" />
</jsp:include>

<div class="panel panel-danger">
	<div class="panel-heading">Error generated during the execution of the page <%= request.getRequestURL() %></div>
	<div class="panel-body">
		<ul class="list-group">
 				<li class="list-group-item">toString: <%=exception.toString()%></li>
 				<li class="list-group-item">Class: <%=exception.getClass().getName()%></li>
		</ul>
		<p>Stack Trace</p>
		<pre><%exception.printStackTrace(new PrintWriter(out));%></pre>
	</div>
</div>

<jsp:include page="/utils/footer.jsp" />