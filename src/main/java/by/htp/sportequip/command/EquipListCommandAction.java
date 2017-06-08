package by.htp.sportequip.command;

import static by.htp.sportequip.util.ConstantValue.*;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.htp.sportequip.entity.Equipment;
import by.htp.sportequip.service.EquipmentService;
import by.htp.sportequip.service.EquipmentServiceImpl;

public class EquipListCommandAction implements CommandAction {

	private EquipmentService equipService;

	public EquipListCommandAction() {
		equipService = new EquipmentServiceImpl();
	}

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		String page = PAGE_USER_MAIN;
		List<Equipment> equipment = null;
		String typeEquip = request.getParameter(REQUEST_PARAM_EQUIP_TYPE);
		String nameEquip = request.getParameter(REQUEST_PARAM_EQUIP_NAME);
		String filter = request.getParameter(REQUEST_PARAM_EQUIP_FILTER);
		boolean boolfillter = Boolean.parseBoolean(filter);
		HttpSession session = request.getSession(true);

		if ((REQUEST_PARAM_EQUIP_ALL).equals(typeEquip)) {
			equipment = equipService.list();
			session.setAttribute(SESSION_NAMEATTR_PAGE, SESSION_ATTRIBUTE_EQUIP_ALL);
		} else {
			String paramSession = sessionParam(typeEquip, nameEquip);
			session.setAttribute(SESSION_NAMEATTR_PAGE, paramSession);
			session.setAttribute(SESSION_NAMEATTR_EQUIPTYPE, typeEquip);
			equipment = equipService.listType(typeEquip, nameEquip);
		}
		if (boolfillter == true) {
			String filterPrMin = request.getParameter(REQUEST_PARAM_EQUIP_FILTER_MIN);
			String filterPrMax = request.getParameter(REQUEST_PARAM_EQUIP_FILTER_MAX);

			equipment = equipService.filterPr(filterPrMin, filterPrMax, equipment);
		}

		request.setAttribute(REQUEST_PARAM_LIST_EQ, equipment);
		return page;
	}

	private String sessionParam(String type, String name) {
		String result = null;
		if ((REQUEST_PARAM_EQUIP_ALL).equals(name)) {
			result = type;
		} else {
			result = name;
		}
		return result;
	}
}