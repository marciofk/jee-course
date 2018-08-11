package nl.hva.jeecourse.module02;

import nl.hva.jeecourse.utils.HTMLUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

@WebServlet("/module02/example06")
public class Example06 extends HttpServlet {
	private static final long serialVersionUID = 7575900159776417573L;

	private String getBody(HttpServletRequest request) throws IOException {

		String body = null;
		StringBuilder stringBuilder = new StringBuilder();
		BufferedReader bufferedReader = null;
		InputStream inputStream = request.getInputStream();
		if (inputStream != null) {
			bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
			char[] charBuffer = new char[1024];
			int bytesRead = -1;
			while ((bytesRead = bufferedReader.read(charBuffer)) > 0) {
				stringBuilder.append(charBuffer, 0, bytesRead);
			}
		} else {
			stringBuilder.append("");
		}
		return stringBuilder.toString();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String contentType = request.getContentType();

		String body = getBody(request);
		
		StringBuilder sb = new StringBuilder();
		
		sb.append(HTMLUtils.buildHeader("02", "06","Retrieving request body"));
		sb.append("<table class=\"table table-striped\">");
		sb.append("<thead>");
		sb.append("<tr>");
		sb.append("<th>Information</th>");
		sb.append("<th>Value</th>");
		sb.append("</tr>");
		sb.append("</thead>");
		sb.append("</tbody>");

		sb.append("<tr><td>Content-Type</td><td>" + contentType + "</td></tr>");
		sb.append("<tr><td>Body</td><td>" + body + "</td></tr>");

		sb.append("</tbody>");

		sb.append(HTMLUtils.buildFooter());

		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		out.println(sb.toString());		

	}
}