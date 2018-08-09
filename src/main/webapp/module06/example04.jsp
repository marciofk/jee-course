<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<jsp:include page="/utils/header.jsp">
	<jsp:param name="title" value="Module 06, Example 04" />
	<jsp:param name="page" value="/module06/example04.jsp" />
</jsp:include>

<%!private int fatorial(int valor) {
		if (valor == 1)

			return valor;

		if (valor == 0)

			return 1;

		return valor * fatorial(valor - 1);

	}%>
	
	
<div class="container">
	<div class="alert alert-info" role="alert">
		<p>Exemple of the usage of declarations &lt;%! ... %&gt;</p><br>
		<p>
			10! is equal to
			<%=fatorial(10)%></p>
		
		<p>
			6! is equal to
			<%=fatorial(6)%></p>
		
		<p>
			0! is equal to
			<%=fatorial(0)%></p>		
	</div>
</div>	



<jsp:include page="/utils/footer.jsp" />