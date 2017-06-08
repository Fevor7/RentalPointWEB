package by.htp.sportequip.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import static by.htp.sportequip.util.ConstantValue.*;

public class HomePageCommandAction implements CommandAction {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession(true);
		if (session.getAttribute("user") == null) {
			session.setAttribute("user", "LOGIN");
		}
		return PAGE_HOMEPAGE;
	}
}