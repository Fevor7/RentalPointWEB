package by.htp.sportequip.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import by.htp.sportequip.entity.Equipment;
import by.htp.sportequip.entity.Order;
import by.htp.sportequip.entity.User;

import static by.htp.sportequip.util.ConstantValue.*;
import static by.htp.sportequip.dao.ConnectionDataBase.*;

public class OrderDaoImpl implements OrderDao {

	@Override
	public boolean createOrder(Order order) {
		ConnectionDataBase connection = new ConnectionDataBase();
		Connection conn = connection.connectDataBase();
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(SQL_STATEMENT_ORDER_CREATE);
			ps.setLong(1, order.getUser().getUserId());
			ps.setLong(2, order.getEquipment().getEquipId());
			ps.setDate(3, order.getDateStart());
			ps.setDate(4, order.getDateEnd());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connection.closeConnection(conn, ps);
		}
		return false;
	}

	@Override
	public List<Order> fetchAll() {
		ConnectionDataBase connection = new ConnectionDataBase();
		List<Order> listOrder = new ArrayList<Order>();
		Connection conn = connection.connectDataBase();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement(SQL_STATEMENT_SELECT_ORDER);
			rs = ps.executeQuery();
			while (rs.next()) {
				Long orderId = rs.getLong(1);
				Long userId = rs.getLong(2);
				User user = new User(userId);
				Long equipId = rs.getLong(3);
				Equipment equip = new Equipment(equipId);
				Date dateStart = rs.getDate(4);
				Date dateEnd = rs.getDate(5);
				Order order = new Order(orderId, user, equip, dateStart, dateEnd);
				listOrder.add(order);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connection.closeConnection(conn, ps, rs);
		}
		return listOrder;
	}

}
