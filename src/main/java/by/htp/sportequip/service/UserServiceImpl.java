package by.htp.sportequip.service;

import by.htp.sportequip.dao.UserDao;
import by.htp.sportequip.dao.UserDaoImpl;
import by.htp.sportequip.entity.User;
import by.htp.sportequip.service.ServiceNoSuchUserException;
import by.htp.sportequip.service.UserService;

public class UserServiceImpl implements UserService {

	private UserDao dao;

	public UserServiceImpl() {
		dao = new UserDaoImpl();
	}

	@Override
	public User authorise(String login, String password) throws ServiceNoSuchUserException {
		User user = dao.fetchByCredentials(login, password);
		if (user == null) {
			throw new ServiceNoSuchUserException("Invalid credentials");
		}
		return user;
	}

	@Override
	public boolean logOut(User user) {
		return false;
	}
}
