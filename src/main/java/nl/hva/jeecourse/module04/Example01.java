package nl.hva.jeecourse.module04;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import nl.hva.jeecourse.utils.HTMLUtils;

@WebServlet("/module04/example01")
public class Example01 extends HttpServlet {
	private static final long serialVersionUID = -8003223521997565201L;

	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String news = req.getParameter("news");

		// Add cookies
		Cookie cookie = new Cookie("nameCookie", URLEncoder.encode(name,"UTF-8"));
		cookie.setMaxAge(3 * 60); // 3 minutes
		cookie.setPath("/");
		resp.addCookie(cookie);

		cookie = new Cookie("emailCookie", URLEncoder.encode(email,"UTF-8"));
		cookie.setMaxAge(60 * 60 * 24 * 360); // 1 year
		resp.addCookie(cookie);
		
		cookie = new Cookie("newsCookie", URLEncoder.encode(news,"UTF-8"));
		cookie.setMaxAge(60 * 60 * 24 * 360); // 1 year
		resp.addCookie(cookie);		
		
		createResponse("04","01",resp);
	}

	private void createResponse(String module, String example,
			HttpServletResponse resp) throws IOException {
		
		StringBuilder sb = new StringBuilder();
		
		sb.append(HTMLUtils.buildHeader(module, example,"Saving cookies"));
		sb.append("<div class=\"alert alert-info\" role=\"alert\">");
		sb.append("Your preferences were saved as cookies");
		sb.append("</div>");
		sb.append(HTMLUtils.buildFooter());

		PrintWriter out = resp.getWriter();
		resp.setContentType("text/html");
		out.println(sb.toString());				

		
	}
	
	
	
}