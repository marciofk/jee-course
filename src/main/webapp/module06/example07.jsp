<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
<jsp:include page="/utils/header.jsp">
	<jsp:param name="title" value="Module 06, Example 07" />
	<jsp:param name="page" value="/module06/example06.jsp" />
</jsp:include>

<p><% out.println("<script>alert('Hello. You are using the following remote address: " + 
	request.getRemoteAddr() + "')</script>"); %></p>

<jsp:include page="/utils/footer.jsp" />