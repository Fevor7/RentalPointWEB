package by.htp.sportequip.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import by.htp.sportequip.entity.Equipment;

import static by.htp.sportequip.util.ConstantValue.*;
import static by.htp.sportequip.dao.ConnectionDataBase.*;

public class EquipmentDaoImpl implements EquipmentDao {

	@Override
	public List<Equipment> fetchAllEquip() {
		List<Equipment> equipList = new ArrayList<Equipment>();
		ConnectionDataBase connection = new ConnectionDataBase();
		Connection conn = connection.connectDataBase();
		ResultSet rs = null;
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(SQL_STATEMENT_SELECT_EQUIP);
			rs = ps.executeQuery();
			while (rs.next()) {
				Long equipId = rs.getLong(1);
				String name = rs.getString(2);
				String title = rs.getString(3);
				Double price = rs.getDouble(4);
				String type = rs.getString(5);
				String url = rs.getString(6);
				boolean rentStatus = rs.getBoolean(7);
				Equipment equip = new Equipment(equipId, name, title, price, type, url,rentStatus);
				equipList.add(equip);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connection.closeConnection(conn, ps, rs);
		}
		return equipList;
	}

	@Override
	public List<Equipment> fetchTypeEquip(String typeEquip, String select) {
		ConnectionDataBase connection = new ConnectionDataBase();
		List<Equipment> equipList = new ArrayList<Equipment>();
		Connection conn = connection.connectDataBase();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement(select);
			ps.setString(1, typeEquip);
			rs = ps.executeQuery();
			while (rs.next()) {
				Long equipId = rs.getLong(1);
				String name = rs.getString(2);
				String title = rs.getString(3);
				Double price = rs.getDouble(4);
				String type = rs.getString(5);
				String url = rs.getString(6);
				boolean rentStatus = rs.getBoolean(7);
				Equipment equip = new Equipment(equipId, name, title, price, type, url,rentStatus);
				equipList.add(equip);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connection.closeConnection(conn, ps, rs);
		}
		return equipList;
	}
}
