package nl.hva.jeecourse.module01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import nl.hva.jeecourse.utils.HTMLUtils;

@WebServlet("/module01/example02")
public class Example02 extends HttpServlet {

	private static final long serialVersionUID = 5325891012698250173L;
	
	private String studentName;
	
	@Override
	public void init() throws ServletException {
		super.init();
	}
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("@Example02.init(config) hello world id");
		super.init(config);
	}
	
	@Override
	public void destroy() {
		System.out.println("@Example02.destroy()");
		super.destroy();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		StringBuilder sb = new StringBuilder();

		sb.append(HTMLUtils.buildHeader("01", "02","Servlet lifecycle"));
		sb.append("<div class=\"alert alert-info\" role=\"alert\">");
		sb.append("Executing the doGet method ds - object hashCode = " + this.hashCode());
		sb.append("</div>");
		sb.append(HTMLUtils.buildFooter());

		PrintWriter out = resp.getWriter();
		resp.setContentType("text/html");
		out.println(sb.toString());		
		
		System.out.println("@Example02.doGet()");
	}

}
