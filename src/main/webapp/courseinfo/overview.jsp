<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:include page="/utils/header.jsp">
	<jsp:param name="title" value="JEE Course" />
	<jsp:param name="page" value="/courseinfo/overview.jsp" />
</jsp:include>


<div class="row">
	
	<div class="col-md-12">
		<h4>Course Objectives</h4>
   		<p>This course provides an introduction to server-side programming with
   		Java Servlets and JAX-RS for the development of server-side apps and RESTful Web Services.
   		These are core components of the JEE specification and mastering such APIs will improve the
   		learning curve of the overall <abbr title="Java Enterprise Edition">JEE</abbr>.
            <ol>
                <li>Understand the Java Enterprise Architecture</li>
                <li>Create web applications using Servlets</li>
                <li>Write code to generate dynamic content</li>
                <li>Transfer data using JSON</li>
                <li>Write RESTFul web services with JAX-RS</li>
                <li>Implement Security using JSON Web Tokens (JWT)</li>
            </ol>
   		</p>
	</div>	
	
</div>

<div class="row">

	<div class="col-md-12">
		<h4>What is not part of the course scope</h4>
   		<p>It is a server-side course. HTML5 and client-side programming techniques
   		(JavaScript, Javascript Frameworks) are not included. Web Server configuration
   		and tuning, JEE security, EJB, JPA and Hibernate, Async I/O are not included.</p>
	</div>

</div>
	
<div class="row">	
	
 	<div class="col-md-4">
		<h4>Duration</h4>
		<p>
		20 hrs of mixed sessions (lectures and lab). The module will be taught
		in five days during the month of August 2018.
		Lectures and labs will be taught in English.
		</p>
	</div>
	
 	<div class="col-md-4">
		<h4>Evaluation</h4>
		<p>Development of a case-study presented during the labs. Students build a JEE project</p>
	</div>
 	<div class="col-md-4">
		<h4>Target Audience</h4>
		<p>
			Software Engineering students with intermediate Java knowledge and some familiarity with web programming.
		</p>
	</div>	
</div>

<jsp:include page="/utils/footer.jsp" />
    