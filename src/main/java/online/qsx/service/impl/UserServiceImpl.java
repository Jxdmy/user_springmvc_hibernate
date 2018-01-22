package online.qsx.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import online.qsx.dao.impl.UserDaoImpl;
import online.qsx.model.User;
import online.qsx.service.UserService;
@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private UserDaoImpl userDaoImpl;
	
	@Override
	public List<User> findAll(User user) {
		return userDaoImpl.findAll(user);
	}

	@Override
	public void save(User user) {
		userDaoImpl.save(user);
	}

	@Override
	public User findById(User user) {
		return userDaoImpl.findById(user);
	}

	@Override
	public void remove(User user) {
		userDaoImpl.remove(user);
	}

	@Override
	public void edit(User user) {
		userDaoImpl.edit(user);
	}

	@Override
	public List<User> serach(String name) {
		// TODO Auto-generated method stub
		return userDaoImpl.serach(name);
	}

}
