package by.htp.sportequip.dao;

import by.htp.sportequip.entity.User;

public interface UserDao {
	User fetchByCredentials(String login, String password);
}
