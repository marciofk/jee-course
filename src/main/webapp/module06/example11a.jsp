<%@page import="nl.hva.jeecourse.module06.AccessRight"%>
<%@page import="java.util.LinkedList"%>
<%@page import="java.util.List"%>
<%@page import="nl.hva.jeecourse.module06.DBUser"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
   String user = request.getParameter("user");
   String[] access = request.getParameterValues("access");
   List<String> errors = new LinkedList<String>();
   
   if(user == null || user.trim().equals("")) {
	   errors.add("You must inform a valid user");
   }
   
   if(user != null && !user.trim().equals("") && !DBUser.exists(user)) {
	   errors.add("User " + user + " not found in the database");
   }
   
   if(access == null || access.length == 0) {
	   errors.add("You must choose at minimum one access right");
   }
   
   if(errors.size() == 0) {
	   @SuppressWarnings("unchecked")
	   List<AccessRight> accessRights = (List<AccessRight>)session.getAttribute("accessRights");
	   if(accessRights == null) {
		   accessRights = new LinkedList<AccessRight>();
		   session.setAttribute("accessRights",accessRights);
	   }
	   boolean canView = false, canEdit = false, canDelete = false;
	   for(int i=0;i<access.length;i++) {
		   if(access[i].equals("1")) 
			   canView = true;
		   if(access[i].equals("2")) 
			   canEdit = true;		   
		   if(access[i].equals("3")) 
			   canDelete = true;		   		   
	   }
	   accessRights.add(new AccessRight(user,canView,canEdit,canDelete));
   } else {
	   request.setAttribute("errors", errors);
   }
%>

<jsp:forward page="/module06/example11.jsp" />


