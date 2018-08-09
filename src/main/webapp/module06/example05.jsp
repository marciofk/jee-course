<%@ page import="java.util.Date"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="/utils/header.jsp">
	<jsp:param name="title" value="Module 06, Example 05" />
	<jsp:param name="page" value="/module06/example05.jsp"/>
</jsp:include>

<%!
  public static SimpleDateFormat sdf = new SimpleDateFormat();



%>

<% Date date = new Date(); %>

<ul class="list-group">
  <li class="list-group-item">Current date: <%= getCurrentDate(date,"dd/MM/yyyy") %></li>
  <li class="list-group-item">Current time: <%= getCurrentDate(date,"hh:mm:ss") %></li>
</ul>

<%! 
    public String getCurrentDate(Date date,String pattern) {
		sdf.applyPattern(pattern);
		return sdf.format(date);
	}
%>

<jsp:include page="/utils/footer.jsp"/>