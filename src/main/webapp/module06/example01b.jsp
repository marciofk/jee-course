<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% session.setAttribute("name", request.getParameter("name")); %>
<jsp:forward page="<%= request.getParameter(\"pageSuccess\")%>"></jsp:forward>