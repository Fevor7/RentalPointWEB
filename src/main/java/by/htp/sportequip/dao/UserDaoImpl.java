package by.htp.sportequip.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import by.htp.sportequip.entity.User;

import static by.htp.sportequip.util.ConstantValue.*;
import static by.htp.sportequip.dao.ConnectionDataBase.*;

public class UserDaoImpl implements UserDao {

	@Override
	public User fetchByCredentials(String login, String password) {
		User user = null;
		ConnectionDataBase connection = new ConnectionDataBase();
		Connection conn = connection.connectDataBase();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement(SQL_STATEMENT_SELECT_USER);
			ps.setString(1, login);
			ps.setString(2, password);
			rs = ps.executeQuery();

			if (rs.next()) {
				String log = rs.getString(2);
				String pas = rs.getString(3);
				String name = rs.getString(4);
				boolean role = rs.getBoolean(5);

				user = new User();
				user.setLogin(log);
				user.setPassword(pas);
				user.setRole(role);
				user.setName(name);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connection.closeConnection(conn, ps, rs);
		}
		return user;
	}

}
