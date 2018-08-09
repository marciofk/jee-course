<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<jsp:include page="/utils/header.jsp">
	<jsp:param name="title" value="Module 06, Example 02" />
	<jsp:param name="page" value="/module06/example02.jsp" />
</jsp:include>

<div class="container">
	<h4>JSP lifecycle</h4>
	<div class="alert alert-info" role="alert">
		<p>@This example illustrates the JSP lifecycle. See the logs in
			your application server</p>
		<p>This instance is using the hashCode <mark><%=hashCode() %></mark></p>	
	</div>
</div>

<%!public void jspInit() {
		getServletContext().log("Initializing the JSP instance " + getServletInfo() + " hashCode: " + hashCode());
	}

	public void jspDestroy() {
		getServletContext().log("Destroying the JSP instance " + getServletInfo() + " hashCode: " + hashCode());
	}%>

<%
	getServletContext().log("Executing the service method " + getServletInfo() + " hashCode: " + hashCode());
%>

<jsp:include page="/utils/footer.jsp" />