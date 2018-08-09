package nl.hva.jeecourse.module03;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import nl.hva.jeecourse.utils.HTMLUtils;

@WebServlet("/module03/example08")
public class Example08 extends HttpServlet {
	private static final long serialVersionUID = 186083461551010880L;

	public void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		int engineNumber = 0;
		StringBuilder error = new StringBuilder();

		String engine = req.getParameter("engine");
		if (engine == null || engine.equals(""))
			error.append("engine must be informed\n");
		else
			try {
				engineNumber = Integer.parseInt(engine);
			} catch (NumberFormatException e) {
				error.append("Malformed engine: engine must a number\n");
			}

		String query = req.getParameter("query");
		if (query == null || query.equals(""))
			error.append("Query string must be specified\n");

		if (error.length() == 0)
			requestRedirection(req, resp, engineNumber, query);
		else
			showError("03", "08", error.toString(), resp);
	}

	private void showError(String module, String example, String errorMessages,
			HttpServletResponse resp) throws IOException {
		String response = HTMLUtils.buildErrorMessages(module, example,
				errorMessages);

		PrintWriter out = resp.getWriter();
		resp.setContentType("text/html");
		out.println(response);
	}

	private void requestRedirection(HttpServletRequest req,
			HttpServletResponse resp, int engine, String query)
			throws ServletException, IOException {
		String url = null;

		switch (engine) {
		case 1:
			url = "http://www.google.com/search?q=" + query;
			break;
		case 2:
			url = "http://www.bing.com/search?q=" + query;
			break;
		default:
			showError("03", "08", "Invalid site number: " + engine, resp);
			return;

		}
		resp.sendRedirect(url);
	}
}