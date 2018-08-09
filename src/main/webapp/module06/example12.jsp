<%@page import="nl.hva.jeecourse.module06.DBUser"%>
<%@page import="nl.hva.jeecourse.module06.AccessRight"%>
<%@page import="java.util.List"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.LinkedHashMap"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<jsp:include page="/utils/header.jsp">
	<jsp:param name="title" value="Module 06, Example 12" />
	<jsp:param name="page" value="/module06/example12.jsp" />
</jsp:include>

<div class="container">

	<div class="alert alert-info alert-dismissible" role="alert">
  		<button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
  		<span class="glyphicon glyphicon-info-sign" aria-hidden="true"></span>
  		This example illustrates the usage of the <em>forward</em> action and the usage of scope
  		variables. It is a fictitious application that gives access rights to users, given the selected file.<br><br>
  		To test, you can use the following users: <%= DBUser.getUsersAsString() %> 
	</div>					
	
	<div class="row">
		<div class="col-sm-6">
			<div class="panel panel-primary">
				<div class="panel-heading">acme.doc: file sharing</div>
				<div class="panel-body">
					<form role="form" action="/JEECourse/module06/example12">
						<div class="form-group">
							<label for="age">User name:</label> 
							<input type="text" class="form-control" name="user">
						</div>
						
						<div class="form-group">
							<label for="access">Access type:</label>
						    <label class="checkbox-inline">
						      <input type="checkbox" name="access" value="1">read
						    </label>
						    <label class="checkbox-inline">
						      <input type="checkbox" name="access" value="2">write
						    </label>
						    <label class="checkbox-inline">
						      <input type="checkbox" name="access" value="3">delete
						    </label>						
						</div>
						<button type="submit" class="btn btn-default">add</button>
					</form>
					
					<%
						@SuppressWarnings("unchecked")
						List<String> errorList = (List<String>)request.getAttribute("errors");
						if(errorList != null && errorList.size() > 0) {
							for(String error : errorList) {	
					%>
					
					<div class="alert alert-warning alert-dismissible" role="alert">
  						<button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
						<strong>Warning! <%= error%></strong> 
					</div>					
					
					<%
							}
						}
					%>
				</div>
			</div>
		</div>
		
		<div class="col-sm-6">
			<%
				@SuppressWarnings("unchecked")
				List<AccessRight> rightList = (List<AccessRight>)session.getAttribute("accessRights");
				if(rightList == null || rightList.size() == 0) {
			%>
				<p>List of access is empty</p>
			<%
				} else {
			%>
			<p>Access rights</p>
 			<table class="table table-bordered">
    			<thead>
      				<tr>
        				<th>Name</th>
        				<th>can read?</th>
        				<th>can write?</th>
        				<th>can delete?</th>
      				</tr>
    			</thead>
    			<tbody>
					<%
						for(AccessRight right : rightList) {
					%>
						<tr>
							<td><%= right.getName() %></td>
							<td><span class="glyphicon <%= right.isCanView() ? "glyphicon glyphicon-ok" : "glyphicon glyphicon-remove"%>" aria-hidden="true"></span></td>
							<td><span class="glyphicon <%= right.isCanEdit() ? "glyphicon glyphicon-ok" : "glyphicon glyphicon-remove"%>" aria-hidden="true"></span></td>
							<td><span class="glyphicon <%= right.isCadDelete()  ? "glyphicon glyphicon-ok" : "glyphicon glyphicon-remove"%>" aria-hidden="true"></span></td>
						</tr>
					<%
						}
					%>
				</tbody>
			</table>
			<% } %>
		</div>
	</div>
</div>		

<jsp:include page="/utils/footer.jsp" />