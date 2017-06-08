package by.htp.sportequip.service;

import java.sql.Date;
import java.util.List;

import by.htp.sportequip.entity.Equipment;
import by.htp.sportequip.entity.Order;
import by.htp.sportequip.entity.User;

public interface OrderService {
	Order makeOrder(User user, Equipment Equipment, Date start, Date end);

	List<Order> orderAll();
}
