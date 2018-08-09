<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page info="Diretivas_5.jsp" %>
<%@ page errorPage="/module06/example03a.jsp" %>  
<%@ page session="false" %>

<jsp:include page="/utils/header.jsp">
	<jsp:param name="title" value="Module 06, Example 03" />
	<jsp:param name="page" value="/module06/example03.jsp" />
</jsp:include>

<p>This page will generate a runtime error</p>
	
	<%
		int [] elemento = new int[0];
		elemento[0] = 
			new java.util.Random().nextInt();
	%>

<jsp:include page="/utils/footer.jsp" />