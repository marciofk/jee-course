<%@page import="java.util.LinkedHashSet"%>
<%@page import="java.util.Set"%>
<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<jsp:include page="/utils/header.jsp">
	<jsp:param name="title" value="Module 06, Example 09" />
	<jsp:param name="page" value="/module06/example09.jsp" />
</jsp:include>

<%
	// Adding a new participant
	String participant = request.getParameter("participant");

	if (participant != null && !participant.trim().equals("")) {

		@SuppressWarnings("unchecked")
		Set<String> list = (Set<String>) session
				.getAttribute("participants");

		if (list == null) {
			list = new LinkedHashSet<String>();
			session.setAttribute("participants", list);
		}
		list.add(participant);
	}
	
	String remove = request.getParameter("remove");
	
	if (remove != null && !remove.trim().equals("")) {

		@SuppressWarnings("unchecked")
		Set<String> list = (Set<String>) session
				.getAttribute("participants");

		if (list != null) {
			list.remove(remove);
		}
	}	
	
%>

<div class="container">
	<div class="row">
		<div class="col-sm-6">
			<div class="panel panel-primary">
				<div class="panel-heading">Add new meeting participant</div>
				<div class="panel-body">
					<form role="form" action="/JEECourse/module06/example09.jsp">
						<div class="form-group">
							<label for="name">Full name:</label> <input type="text"
								class="form-control" name="participant">
						</div>
						<button type="submit" class="btn btn-default">Add</button>
					</form>
				</div>
			</div>
		</div>
		<div class="col-sm-6">
			<%
				@SuppressWarnings("unchecked")
				Set<String> members = (Set<String>)session.getAttribute("participants");
				if(members == null || members.size() == 0) {
			%>
				<p>Member list is empty</p>
			<%
				} else {
			%>
			<p>Meeting members</p>
			<ul class="list-group">
				<%
					for(String member : members) {
				%>
				
				<li class="list-group-item"><%= member%>
				<span class="badge">
				<a href="/JEECourse/module06/example09.jsp?remove=<%= member %>">
					<span class="glyphicon glyphicon-remove" aria-hidden="true"></span>
				</a>
				</span>
				</li>		
				<%
					}
				%>
			</ul>
			<% } %>
		</div>
	</div>
</div>

<jsp:include page="/utils/footer.jsp" />