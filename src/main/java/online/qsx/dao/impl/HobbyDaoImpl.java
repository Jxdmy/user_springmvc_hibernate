package online.qsx.dao.impl;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import online.qsx.dao.BaseDao;
import online.qsx.dao.HobbyDao;
import online.qsx.model.Hobby;

@Repository
public class HobbyDaoImpl implements HobbyDao{
	@Autowired
	private BaseDao baseDao;
	@Override
	public List<Hobby> findAll(Hobby hobby) {
		List<Hobby> list = (List<Hobby>) baseDao.getHibernateTemplate().find("from Hobby");
		return list;
	}
	@Override
	public void save(Hobby hobby) {
		baseDao.getHibernateTemplate().save(hobby);
	}

	@Override
	public Hobby findById(Hobby hobby) {
		return baseDao.getHibernateTemplate().get(Hobby.class, hobby.getId());
	}

	@Override
	public void remove(Hobby hobby) {
		baseDao.getHibernateTemplate().delete(hobby);		
	}

	@Override
	public void edit(Hobby hobby) {
		baseDao.getHibernateTemplate().saveOrUpdate(hobby);
	}

}
