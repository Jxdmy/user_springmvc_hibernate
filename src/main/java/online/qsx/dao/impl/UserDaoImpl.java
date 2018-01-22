package online.qsx.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import online.qsx.dao.BaseDao;
import online.qsx.dao.UserDao;
import online.qsx.model.User;

@Repository
public class UserDaoImpl implements UserDao{
	@Autowired
	private BaseDao baseDao;
	
	public List<User> findAll(User user){
		List<User> list = new ArrayList<>();
		list = (List<User>) baseDao.getHibernateTemplate().find("from User");
		return list;
		
	}

	@Override
	public void save(User user) {
		baseDao.getHibernateTemplate().save(user);
	}

	@Override
	public User findById(User user) {
		return baseDao.getHibernateTemplate().get(User.class, user.getId());
	}

	@Override
	public void remove(User user) {
		baseDao.getHibernateTemplate().delete(user);		
	}

	@Override
	public void edit(User user) {
		baseDao.getHibernateTemplate().update(user);
	}

	@Override
	public List<User> serach(String name) {
		String hql="from User where userName like %"+name+"%"; 
		return (List<User>) baseDao.getHibernateTemplate().find(hql);
	}
}
