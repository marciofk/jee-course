package nl.hva.jeecourse.module01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import nl.hva.jeecourse.utils.HTMLUtils;

@WebServlet("/module01/example03")
public class Example03 extends HttpServlet {

	private static final long serialVersionUID = -3341092708936807971L;

	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException {
		
		StringBuilder sb = new StringBuilder();
		
		sb.append(HTMLUtils.buildHeader("01", "03","Invoking servlets using different methods"));
		sb.append("<div class=\"alert alert-info\" role=\"alert\">");
		sb.append("Executing the servlet using " + req.getMethod());
		sb.append("</div>");
		sb.append(HTMLUtils.buildFooter());

		PrintWriter out = resp.getWriter();
		resp.setContentType("text/html");
		out.println(sb.toString());						
		
		System.out.println("@Example03.doGet(req,resp)");
	}

	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException {
		System.out.println("@Example03.doPost(req,resp): forwarding to doGet");
		doGet(req, resp);
	}

}
