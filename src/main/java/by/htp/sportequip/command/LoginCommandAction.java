package by.htp.sportequip.command;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.htp.sportequip.entity.Equipment;
import by.htp.sportequip.entity.User;
import by.htp.sportequip.service.EquipmentService;
import by.htp.sportequip.service.EquipmentServiceImpl;
import by.htp.sportequip.service.ServiceNoSuchUserException;
import by.htp.sportequip.service.UserService;
import by.htp.sportequip.service.UserServiceImpl;

import static by.htp.sportequip.util.ConstantValue.*;

public class LoginCommandAction implements CommandAction {

	private UserService userService;
	private EquipmentService equipService;

	public LoginCommandAction() {
		userService = new UserServiceImpl();
		equipService = new EquipmentServiceImpl();
	}

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		String page = null;

		String login = request.getParameter(REQUEST_PARAM_LOGIN);
		String password = request.getParameter(REQUEST_PARAM_PASSWORD);
		HttpSession session = request.getSession(true);
		User user;
		try {
			user = userService.authorise(login, password);

			if (!user.isRole()) {
				List<Equipment> equipment = equipService.list();
				request.setAttribute(REQUEST_PARAM_LIST_EQ, equipment);
				session.setAttribute("user", user.getName());
				try {
					response.getWriter().print(user.getName());
				} catch (IOException e) {
					e.printStackTrace();
				}
				page = null;
			} else {
				page = PAGE_ADMIN_MAIN;
			}
		} catch (ServiceNoSuchUserException e) {
			try {
				response.getWriter().print("error");
			} catch (IOException e2) {
				e2.printStackTrace();
			}
			page = null;
			request.setAttribute(REQUEST_PARAM_ERROR_MSG, e.getMessage());
			e.printStackTrace();
		}
		return page;
	}
}
