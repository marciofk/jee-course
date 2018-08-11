package nl.hva.jeecourse.module05;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import nl.hva.jeecourse.utils.HTMLUtils;

@WebServlet("/module05/example05")
public class Example05 extends HttpServlet {
	private static final long serialVersionUID = -6826090516842455880L;

	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		HttpSession session =  req.getSession();
		
		session.invalidate();
		
		StringBuilder sb = new StringBuilder();
		
		sb.append(HTMLUtils.buildHeader("05","04","Getting session information"));
		sb.append("<div class=\"alert alert-info\" role=\"alert\">");
		sb.append("<p>Session was invalidated</p>");
		sb.append("</div>");
		sb.append("<p><a href=\"" + 
		
				resp.encodeURL("/JEECourse/module05/example.html") + "\">Back to the main page</a></p>");
		
		
		
		sb.append(HTMLUtils.buildFooter());

		PrintWriter out = resp.getWriter();
		resp.setContentType("text/html");
		out.println(sb.toString());		
		
		
	}
}