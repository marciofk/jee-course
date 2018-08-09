<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
<jsp:include page="/utils/header.jsp">
	<jsp:param name="title" value="Module 06, Example 08" />
	<jsp:param name="page" value="/module06/example08.jsp" />
</jsp:include>

<%
	Enumeration<String> headers = request.getHeaderNames();
%>

<div class="row">
	<div class="col-sm-6">
		<p>List of all headers</p>
		<table class="table table-striped">
			<thead>
				<tr>
					<th>Method</th>
					<th>Description</th>
				</tr>
			</thead>
			<tbody>

				<%
					while(headers.hasMoreElements()) {
						String headerName = headers.nextElement();
				%>
				<tr>
					<td><%=headerName%></td>
					<td><%=request.getHeader(headerName)%></td>
				</tr>
				<%
					}
				%>

			</tbody>
		</table>
	</div>
</div>

<jsp:include page="/utils/footer.jsp" />