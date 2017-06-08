package by.htp.sportequip.dao;

import java.util.List;

import by.htp.sportequip.entity.Order;

public interface OrderDao {
	boolean createOrder(Order order);

	List<Order> fetchAll();
}
