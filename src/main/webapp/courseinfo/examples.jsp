<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:include page="/utils/header.jsp">
	<jsp:param name="title" value="JEE Course" />
	<jsp:param name="page" value="/courseinfo/examples.jsp" />
</jsp:include>


<div class="row">
	<div class="col-md-3">
		<h4>HTTP Introduction</h4>
		<div class="panel panel-default">
			<div class="panel-body">
				<p>Please execute the JavaFX application developed for this module. It is a Simple Web Client 
				that allows students to understand and manipulate the elements of HTTP messages.</p>
				<p>Locate the package <em>nl.hva.jeecourse.module00</em> and execute the class
				<em>SimpleWebClient</em></p>
			</div>	
		</div>	
	</div>	
	<div class="col-md-3">
		<h4>1. Servlet Introduction</h4>
		<div class="list-group">
			<a href="${pageContext.request.contextPath}/module01/example01.html" class="list-group-item">Example 01: Invoking an empty servlet</a>
			<a href="${pageContext.request.contextPath}/module01/example02.html" class="list-group-item">Example 02: Understanding the servlet lifecycle</a>
			<a href="${pageContext.request.contextPath}/module01/example03.html" class="list-group-item">Example 03: Invoking servlets using different methods</a>
			<a href="${pageContext.request.contextPath}/module01/example04.html" class="list-group-item">Example 04: Generating responses</a>
		</div>		
	</div>		
	<div class="col-md-3">
		<h4>2. Servlet Requests</h4>
		<div class="list-group">
			<a href="${pageContext.request.contextPath}/module02/example01.html" class="list-group-item">Example 01: Retrieving HTTP parameters</a>
			<a href="${pageContext.request.contextPath}/module02/example02.html" class="list-group-item">Example 02: Retrieving all HTTP parameters</a>
			<a href="${pageContext.request.contextPath}/module02/example03.html" class="list-group-item">Example 03: Retrieving HTTP headers</a>
			<a href="${pageContext.request.contextPath}/module02/example04.html" class="list-group-item">Example 04: Retrieving all HTTP headers</a>
			<a href="${pageContext.request.contextPath}/module02/example05.html" class="list-group-item">Example 05: Retrieving HTTP request information</a>
		</div>		
	</div>			
	
	<div class="col-md-3">
		<h4>3. Servlet Responses</h4>
		<div class="list-group">
			<a href="${pageContext.request.contextPath}/module03/example01.html" class="list-group-item">Example 01: Generating a HTML response</a>
			<a href="${pageContext.request.contextPath}/module03/example02.html" class="list-group-item">Example 02: Generation a JSON respone</a>
			<a href="${pageContext.request.contextPath}/module03/example03.html" class="list-group-item">Example 03: Generating a binary response</a>
			<a href="${pageContext.request.contextPath}/module03/example04.html" class="list-group-item">Example 04: Changing HTTP status codes</a>
		</div>		
	</div>	
</div>

<hr>

<div class="row">
	
	<div class="col-md-3">
		<h4>4. Servlet Responses</h4>
		<div class="list-group">
			<a href="${pageContext.request.contextPath}/module03/example05.html" class="list-group-item">Example 05: Changing HTTP status codes and messages</a>
			<a href="${pageContext.request.contextPath}/module03/example06.html" class="list-group-item">Example 06: Adding headers in the response object</a>
			<a href="${pageContext.request.contextPath}/module03/example07.html" class="list-group-item">Example 07: Generating independent URIs</a>
			<a href="${pageContext.request.contextPath}/module03/example08.html" class="list-group-item">Example 08: Redirecting responses</a>
		</div>		
	</div>	
	
	<div class="col-md-3">
		<h4>5. Cookies</h4>
		<div class="list-group">
			<a href="${pageContext.request.contextPath}/module04/example01.html" class="list-group-item">Example 01: Sending Cookies</a>
			<a href="${pageContext.request.contextPath}/module04/example02.html" class="list-group-item">Example 02: Reading Cookies</a>
		</div>
		<h4>6. Session Management</h4>
		<div class="list-group">
			<a href="${pageContext.request.contextPath}/module05/example.html" class="list-group-item">Integrated Session Example</a>
		</div>		
	</div>
	
	<div class="col-md-3">
		<h4>7. Java Server Pages</h4>
		<div class="list-group">
			<a href="${pageContext.request.contextPath}/module06/example01.jsp" class="list-group-item">Example 01: The first JSP page</a>
			<a href="${pageContext.request.contextPath}/module06/example02.jsp" class="list-group-item">Example 02: JSP lifecycle</a>
			<a href="${pageContext.request.contextPath}/module06/example03.jsp" class="list-group-item">Example 03: JSP directives: An error page</a>
			<a href="${pageContext.request.contextPath}/module06/example04.jsp" class="list-group-item">Example 04: JSP declarations</a>
			<a href="${pageContext.request.contextPath}/module06/example05.jsp" class="list-group-item">Example 05: JSP expressions</a>
			<a href="${pageContext.request.contextPath}/module06/example06.jsp" class="list-group-item">Example 06: JSP scriptlets</a>
		</div>		
	</div>
	
	<div class="col-md-3">
		<h4>8. Java Server Pages</h4>
		<div class="list-group">
			<a href="${pageContext.request.contextPath}/module06/example07.jsp" class="list-group-item">Example 07: Implicit object <em>out</em></a>
			<a href="${pageContext.request.contextPath}/module06/example08.jsp" class="list-group-item">Example 08: Implicit object <em>request</em></a>
			<a href="${pageContext.request.contextPath}/module06/example09.jsp" class="list-group-item">Example 09: Implicit object <em>session</em></a>
			<a href="${pageContext.request.contextPath}/module06/example10.jsp" class="list-group-item">Example 10: Implicit object <em>application</em></a>
			<a href="${pageContext.request.contextPath}/module06/example11.jsp" class="list-group-item">Example 11: Using the request scope and forward action</a>
			<a href="${pageContext.request.contextPath}/module06/example12.jsp" class="list-group-item">Example 12: JSP and Servlets</a>
		</div>		
	</div>
	
</div>

<div class="row">

	<div class="col-md-3">
		<h4>9. JAX-RS resources</h4>
		<div class="list-group">
			<a href="${pageContext.request.contextPath}/services/rest/flashcards" class="list-group-item">Example: Acessing resources</a>
			<a href="${pageContext.request.contextPath}/services/rest/flashcards/1" class="list-group-item">Example: Acessing resources using path parameters</a>
		</div>
	</div>

	<div class="col-md-3">
		<h4>10. JAX-RS sub-resources</h4>
		<div class="list-group">
			<a href="${pageContext.request.contextPath}/services/rest/flashcards/1/questions" class="list-group-item">Example: Acessing sub-resources</a>
		</div>
	</div>

	<div class="col-md-3">
		<h4>11. JAX-RS query parameters</h4>
		<div class="list-group">
			<a href="${pageContext.request.contextPath}/services/rest/flashcards/1/questions/1/answers?correct=true" class="list-group-item">Example: Using query parameters</a>
		</div>
	</div>

	<div class="col-md-3">
		<h4>12. CORS</h4>
		<div class="list-group">
			<a href="${pageContext.request.contextPath}/services/rest/flashcards/1/questions/2/answers" class="list-group-item">Example: CORS headers</a>
		</div>
	</div>

</div>


<hr>

<jsp:include page="/utils/footer.jsp" />
    