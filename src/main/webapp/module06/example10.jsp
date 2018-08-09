<%@page import="java.text.DateFormat"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.LinkedHashMap"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<jsp:include page="/utils/header.jsp">
	<jsp:param name="title" value="Module 06, Example 10" />
	<jsp:param name="page" value="/module06/example10.jsp" />
</jsp:include>

<%!
	private static final DateFormat df = new SimpleDateFormat("dd/MM/yyyy - hh:mm:ss");
%>

<%
	// Adding a message
	String message = request.getParameter("message");
	int messagesSent = getNumberOfMessagesSent(request);

	if (message != null && !message.trim().equals("")) {
		@SuppressWarnings("unchecked")
		Map<String,String> messages = (Map<String,String>) application
				.getAttribute("messages");

		if (messages == null) {
			messages = new LinkedHashMap<String,String>();
			application.setAttribute("messages", messages);
		}
		// get logged user
		String loggedUser = (String) session.getAttribute("name");
		if(loggedUser == null || loggedUser.trim().equals("")) {
			loggedUser = "anonymous user";
		}
		loggedUser = df.format(new java.util.Date()) + " - " + loggedUser;
		messages.put(loggedUser, message);
		messagesSent++;
	}
	response.addCookie(new Cookie("messagesSent",Integer.toString(messagesSent)));
%>

<%!
	public int getNumberOfMessagesSent(HttpServletRequest req) {
		Cookie [] cookies = req.getCookies();
		if(cookies == null) {
			return 0;
		}
			
		for(int i=0;i<cookies.length;i++) {
			if(cookies[i].getName().equals("messagesSent")) {
				return Integer.parseInt(cookies[i].getValue());
			}
		}
		return 0;
	}
%>

<div class="container">
	<div class="row">
		<div class="col-sm-6">
			<div class="panel panel-default">
				<div class="panel-heading">Public wall</div>
				<div class="panel-body">
					<form role="form" action=
					"<%= pageContext.getServletContext().getContextPath() %>/module06/example10.jsp">
						<div class="form-group">
							<label for="name">Message:</label> <input type="text"
								class="form-control" name="message">
						</div>
						<button type="submit" class="btn btn-default">Add</button>
					</form>
				</div>
			</div>
			<ul class="list-group">
  				<li class="list-group-item">
    				<span class="badge"><%= messagesSent %></span>Number of messages sent during this session
  				</li>
			</ul>
		</div>
		
		<div class="col-sm-6">
			<%
				@SuppressWarnings("unchecked")
				Map<String,String> messages = (Map<String,String>)application.getAttribute("messages");
				if(messages == null || messages.size() == 0) {
			%>
				<p>Wall is empty</p>
			<%
				} else {
			%>
			<p>Wall contents</p>
			<ul class="list-group">
				<%
					for(String key : messages.keySet()) {
				%>
				<li class="list-group-item">
					<span class="glyphicon glyphicon-comment" aria-hidden="true"></span>
					<%= key + ": " + messages.get(key)%>
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