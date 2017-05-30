package by.htp.sportequip.service;

import by.htp.sportequip.entity.User;

public interface UserService {
	
	User authorise(String login, String password) throws ServiceNoSuchUserException;
	boolean logOut(User user);
}
