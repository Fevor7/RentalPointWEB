package by.htp.sportequip.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import static by.htp.sportequip.util.ConstantValue.*;

public class ContactCommandAction implements CommandAction {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession(true);
		session.setAttribute(SESSION_NAMEATTR_PAGE, SESSION_ATTRIBUTE_CONTACT);
		return PAGE_CONTACT;
	}

}
