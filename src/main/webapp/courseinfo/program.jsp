<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:include page="/utils/header.jsp">
	<jsp:param name="title" value="JEE Course" />
	<jsp:param name="page" value="/courseinfo/overview.jsp" />
</jsp:include>


<div class="row">
	<div class="col-md-3">
		<h4>Course presentation</h4>
		<!-- <p>August/13th 13:00 to 13:15</p> -->
		<ul class="list-group">
		  <li class="list-group-item">Presentation</li>
		  <li class="list-group-item">Course Objectives</li>
		  <li class="list-group-item">Course Scope</li> 
		  <li class="list-group-item">General rules</li>
		</ul>
		<p>Total time: <b>15 minutes</b></p>
		   		
	</div>
	<div class="col-md-3">
		<h4>HTTP Introduction</h4>
		<!-- <p>August/13th 13:15 to 14:45</p> -->
		<ul class="list-group">
		  <li class="list-group-item"><a href="https://github.com/marciofk/jee-course" target="_blank">Initial Setup</a></li>
		  <li class="list-group-item">Architecture</li> 
		  <li class="list-group-item">Request and Response Messages</li>
		  <li class="list-group-item">Status codes</li>
		  <li class="list-group-item">Headers</li>
		  <li class="list-group-item">MIME types</li>
		  <li class="list-group-item"><a href="lab1.html">Lab 1</a></li>
		</ul>		
		<p>Total time: <b>1 hour 30 minutes</b></p>
		<p>Click <a href="slides/00.pdf">here</a> to download the slide</p>

	</div>	
	<div class="col-md-3">
		<h4>Servlet Introduction</h4>
		<!-- <p>August/13th 15:00 to 17:00</p> -->
		<ul class="list-group">
		  <li class="list-group-item">The web tier of the JEE ecosystem</li> 
		  <li class="list-group-item">Web modules</li>
		  <li class="list-group-item">Servlet definition</li>
		  <li class="list-group-item">The request-response paradigm</li>
		  <li class="list-group-item">The servlet lifecycle</li>
		  <li class="list-group-item"><a href="lab2.html">Lab 2</a></li>

		</ul>		
		<p>Total time: <b>2 hours</b></p>
		<p>Click <a href="slides/01.pdf">here</a> to download the slide</p>		
	</div>		
	
	<div class="col-md-3">
		<h4>Servlet Requests</h4>
		<!-- <p>August/14th 13:00 to 14:30</p> -->
		<ul class="list-group">
		  <li class="list-group-item">Request objects</li>
		  <li class="list-group-item">Retrieving query parameters</li>
		  <li class="list-group-item">Retrieving headers</li>
		  <li class="list-group-item">Retrieving request information</li>
		  <li class="list-group-item">Retrieving the request body</li>
		  <li class="list-group-item"><a href="lab3.html">Lab 3</a></li>
		</ul>
		<p>Total time: <b>1 hour 30 minutes </b></p>
		<p>Click <a href="slides/02.pdf">here</a> to download the slide</p>
	</div>
</div>

<hr>

<div class="row">
	<div class="col-md-3">
		<h4>Servlet Responses</h4>
		<!-- <p>August/14th 14:30 to 16:00</p> -->
		<ul class="list-group">
		  <li class="list-group-item">Generating text and binary data</li>
		  <li class="list-group-item">Setting HTTP status codes</li> 
		  <li class="list-group-item">Sending headers</li>
		  <li class="list-group-item">Sending redirect information</li>
		  <li class="list-group-item"><a href="lab4.html">Lab 4</a></li>
		</ul>
		<p>Total time: 1 hour 15 minutes (assuming 15 minutes break)</p>
		<p>Click <a href="slides/03.pdf">here</a> to download the slide</p>		
	</div>
	
	<div class="col-md-3">
		<h4>Cookies</h4>
		<!-- <p>August/14th 16:00 to 17:00</p> -->
		<ul class="list-group">
		  <li class="list-group-item">How to create Cookies?</li>
		  <li class="list-group-item">How to retrieve Cookies?</li>
		  <li class="list-group-item"><a href="lab5.html">Lab 5</a></li>

		</ul>
		<p>Total time: <b>1 hour</b></p>
		<p>Click <a href="slides/04.pdf">here</a> to download the slide</p>
		
	</div>		
	
	<div class="col-md-3">
		<h4>Session Tracking</h4>
		<!-- <p>August/15th 13:00 to 15:15</p> -->
		<ul class="list-group">
		  <li class="list-group-item">Session tracking techniques</li>
		  <li class="list-group-item">Creating and retrieving a session</li>
		  <li class="list-group-item">Managing session attributes</li>
		  <li class="list-group-item">Listeners (*)</li>
		  <li class="list-group-item"><a href="#">Lab 6</a></li>
		</ul>
		<p>Total time: <b>2 hours 15 minutes</b></p>
		<p>Click <a href="slides/05.pdf">here</a> to download the slide</p>
	</div>		
	
	<div class="col-md-3">
		<h4>JSP</h4>
		<!-- <p>August/15th 15:30 to 17:00</p> -->
		<ul class="list-group">
		  <li class="list-group-item">Architecture</li>
		  <li class="list-group-item">JSP Lifecycle</li> 
		  <li class="list-group-item">Directives</li>
		  <li class="list-group-item">Scriptlets, Expressions, and Declarations</li>
		  <li class="list-group-item">Implicit Object</li>
		  <li class="list-group-item">Forward and Include Actions</li>
		</ul>		
		<p>Total time: <b>1 hour 30 minutes</b></p>
		<p>Click <a href="slides/06.pdf">here</a> to download the slide</p>
	</div>

    <div class="row">
        <div class="col-md-3">
            <h4>JAX-RS</h4>
            <!-- <p>August/16th 13:00 to 17:00</p> -->
            <ul class="list-group">
              <li class="list-group-item">REST services</li>
              <li class="list-group-item">Resources</li>
              <li class="list-group-item">Producers and Consumers</li>
              <li class="list-group-item">Path Parameters</li>
              <li class="list-group-item">Query Parameters</li>
              <li class="list-group-item">Custom Responses</li>
              <li class="list-group-item">CORS</li>
		      <li class="list-group-item"><a href="#">Lab 7</a></li>
            </ul>
            <p>Total time: 5 hours</p>
            <p>Click <a href="slides/08.pdf">here</a> to download the slide</p>
        </div>

        <div class="col-md-3">
            <h4>Additional topics and JWT</h4>
            <!-- <p>August/16th 13:00 to 17:00</p> -->
            <ul class="list-group">
              <li class="list-group-item">Listeners</li>
              <li class="list-group-item">Filters</li>
              <li class="list-group-item">JWT and Java APIs</li>
              <li class="list-group-item"><a href="#">Lab 8</a></li>
            </ul>
            <p>Total time: 5 hours</p>
            <p>Click <a href="#">here</a> to download the slide</p>

        </div>
    </div>


</div>

<jsp:include page="/utils/footer.jsp" />
    