<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:include page="/utils/header.jsp">
	<jsp:param name="title" value="JEE Course" />
	<jsp:param name="page" value="/courseinfo/overview.jsp" />
</jsp:include>


<div class="row">
	<div class="col-md-3">
		<h4>Course presentation</h4>
		<p>August/13th 13:00 to 13:30</p>
		<ul class="list-group">
		  <li class="list-group-item">Presentation</li>
		  <li class="list-group-item">Course Objectives</li>
		  <li class="list-group-item">Course Scope</li> 
		  <li class="list-group-item">General rules</li>
		</ul>
		<p>Total time: <b>30 minutes</b></p>
		   		
	</div>
	<div class="col-md-3">
		<h4>HTTP Introduction</h4>
		<p>August/13th 13:30 to 15:00</p>
		<ul class="list-group">
		  <li class="list-group-item">Environment Setup</li>
		  <li class="list-group-item">Architecture</li> 
		  <li class="list-group-item">Request and Response Messages</li>
		  <li class="list-group-item">Status codes</li>
		  <li class="list-group-item">Headers</li>
		  <li class="list-group-item">MIME types</li>
		  <li class="list-group-item">Lab 1</li>
		</ul>		
		<p>Total time: <b>1 hour 30 minutes</b></p>
		<p>Click <a href="slides/00.pdf">here</a> to download the slide</p>

	</div>	
	<div class="col-md-3">
		<h4>Servlet Introduction</h4>
		<p>August/13th 14:30 to 15:30</p>
		<ul class="list-group">
		  <li class="list-group-item">The web tier of the JEE ecosystem</li> 
		  <li class="list-group-item">Web modules</li>
		  <li class="list-group-item">Servlet definition</li>
		  <li class="list-group-item">The request-response paradigm</li>
		  <li class="list-group-item">The servlet lifecycle</li>
		</ul>		
		<p>Total time: <b>1 hour</b></p>
		<p>Click <a href="slides/01.pdf">here</a> to download the slide</p>		
	</div>		
	
	<div class="col-md-3">
		<h4>Servlet Requests</h4>
		<p>August/13th 15:45 to 17:00</p>
		<ul class="list-group">
		  <li class="list-group-item">Request objects</li>
		  <li class="list-group-item">Retrieving query parameters</li> 
		  <li class="list-group-item">Retrieving headers</li>
		  <li class="list-group-item">Retrieving request information</li> 
		</ul>
		<p>Total time: <b>1 hour, 15 minutes </b></p>
		<p>Click <a href="slides/02.pdf">here</a> to download the slide</p>
	</div>	
</div>

<hr>

<div class="row">
	<div class="col-md-3">
		<h4>Servlet Responses</h4>
		<p>August/14th 13:00 to 14:00</p>
		<ul class="list-group">
		  <li class="list-group-item">Generating text and binary data</li>
		  <li class="list-group-item">Setting HTTP status codes</li> 
		  <li class="list-group-item">Sending headers</li>
		  <li class="list-group-item">Sending redirect information</li>
		</ul>
		<p>Total time: 1 hour</p>
		<p>Click <a href="slides/03.pdf">here</a> to download the slide</p>		
	</div>
	
	<div class="col-md-3">
		<h4>Cookies</h4>
		<p>August/14th 14:00 to 15:00</p>
		<ul class="list-group">
		  <li class="list-group-item">How to create Cookies?</li>
		  <li class="list-group-item">How to retrieve Cookies?</li>
		</ul>
		<p>Total time: <b>1 hour</b></p>
		<p>Click <a href="slides/04.pdf">here</a> to download the slide</p>
		
	</div>		
	
	<div class="col-md-3">
		<h4>Session Tracking</h4>
		<p>August/14th 15:15 to 16:00</p>
		<ul class="list-group">
		  <li class="list-group-item">Session tracking techniques</li>
		  <li class="list-group-item">Creating and retrieving a session</li>
		  <li class="list-group-item">Managing session attributes</li> 
		</ul>
		<p>Total time: <b>45 mins</b></p>
		<p>Click <a href="slides/05.pdf">here</a> to download the slide</p>
	</div>		
	
	<div class="col-md-3">
		<h4>JSP</h4>
		<p>August/14th 16:00 to 17:00</p>
		<ul class="list-group">
		  <li class="list-group-item">Architecture</li>
		  <li class="list-group-item">JSP Lifecycle</li> 
		  <li class="list-group-item">Directives</li>
		  <li class="list-group-item">Scriptlets, Expressions, and Declarations</li>
		  <li class="list-group-item">Implicit Object</li>
		  <li class="list-group-item">Forward and Include Actions</li>
		</ul>		
		<p>Total time: <b>1 hour</b></p>
		<p>Click <a href="slides/06.pdf">here</a> to download the slide</p>
	</div>	
		
</div>

<jsp:include page="/utils/footer.jsp" />
    