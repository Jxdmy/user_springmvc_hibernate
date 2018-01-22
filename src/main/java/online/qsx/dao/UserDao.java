package online.qsx.dao;

import java.util.List;

import online.qsx.model.User;

public interface UserDao {
	List<User> findAll(User user);
	User findById(User user);
	void save(User user);
	void remove(User user);
	void edit(User user);
	List<User> serach(String name);
}
