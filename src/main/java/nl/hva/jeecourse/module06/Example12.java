package nl.hva.jeecourse.module06;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/module06/example12")
public class Example12 extends HttpServlet {

	private static final long serialVersionUID = -7729359387753081064L;

	@Override
	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		String user = request.getParameter("user");
		String[] access = request.getParameterValues("access");
		List<String> errors = new LinkedList<String>();

		if (user == null || user.trim().equals("")) {
			errors.add("You must inform a valid userr");
		}

		if (user != null && !user.trim().equals("") && !DBUser.exists(user)) {
			errors.add("User " + user + " not found in the database");
		}

		if (access == null || access.length == 0) {
			errors.add("You must choose at minimum one access right");
		}

		if (errors.size() == 0) {
			HttpSession session = request.getSession();
			@SuppressWarnings("unchecked")
			List<AccessRight> accessRights = (List<AccessRight>) session
					.getAttribute("accessRights");
			if (accessRights == null) {
				accessRights = new LinkedList<>();
				session.setAttribute("accessRights", accessRights);
			}
			boolean canView = false, canEdit = false, canDelete = false;
			for (int i = 0; i < access.length; i++) {
				if (access[i].equals("1"))
					canView = true;
				if (access[i].equals("2"))
					canEdit = true;
				if (access[i].equals("3"))
					canDelete = true;
			}
			accessRights
					.add(new AccessRight(user, canView, canEdit, canDelete));
		} else {
			request.setAttribute("errors", errors);
		}

		RequestDispatcher dispatcher = request
				.getRequestDispatcher("/module06/example12.jsp");
		dispatcher.forward(request, response);

	}

}
