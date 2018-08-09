<%@page import="nl.hva.jeecourse.module06.FinancialAgent"%>
<%@page import="nl.hva.jeecourse.module06.PaymentMethod"%>
<%@page import="java.util.Set"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<jsp:include page="/utils/header.jsp">
	<jsp:param name="title" 
		value="Module 06, Example 06" />
	<jsp:param name="page" 
		value="/module06/example06.jsp" />
</jsp:include>


<%
	Set<PaymentMethod> methods = FinancialAgent.getPaymentPethods();
%>

<p>List of available payment methods</p>

<div class="row">
	<div class="col-sm-6">
		<table class="table table-striped">
			<thead>
				<tr>
					<th>Method</th>
					<th>Description</th>
				</tr>
			</thead>
			<tbody>

				<%	
					for (PaymentMethod method : methods) {
				%>
				<tr>
					<td><img src="<%=method.getIcon()%>" class="img-rounded"></td>
					<td><%=method.getDescription()%></td>
				</tr>
				<%
					}
				%>

			</tbody>
		</table>
	</div>
</div>
<jsp:include page="/utils/footer.jsp" />





