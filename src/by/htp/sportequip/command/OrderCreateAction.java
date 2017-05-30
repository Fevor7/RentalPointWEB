package by.htp.sportequip.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.htp.sportequip.entity.Equipment;
import by.htp.sportequip.entity.Order;
import by.htp.sportequip.entity.User;
import by.htp.sportequip.service.OrderService;
import by.htp.sportequip.service.OrderServiceImpl;

import static by.htp.sportequip.util.ConstantValue.*;

import java.sql.Date;
import java.util.List;

public class OrderCreateAction implements CommandAction{
	
	private OrderService service;
	
	public OrderCreateAction(){
		service = new OrderServiceImpl();
	}
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		String page = PAGE_ORDER_LIST;
		String userId = request.getParameter(PARAM_USER_ID);
		String equipId = request.getParameter(PARAM_EQUIPMENT_ID);
		String dateStart = request.getParameter(PARAM_DATE_START);
		String dateEnd = request.getParameter(PARAM_DATE_END);
		System.out.println(userId+" "+ equipId+" "+ dateStart+" "+ dateEnd);
		User user = new User();
		user.setUserId(Long.valueOf(userId));
		
		Equipment equip = new Equipment();
		equip.setEquipId(Long.valueOf(equipId));
		
		Date start = Date.valueOf(dateStart);
		Date end = Date.valueOf(dateEnd);
		service.makeOrder(user, equip, start, end);
		List<Order> orderList = service.orderAll();
		request.setAttribute(REQUEST_PARAM_LIST_ORDER, orderList);
		return page;
	}

}
