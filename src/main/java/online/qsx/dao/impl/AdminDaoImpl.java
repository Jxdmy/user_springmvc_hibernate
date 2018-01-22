package online.qsx.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import online.qsx.dao.AdminDao;
import online.qsx.dao.BaseDao;
import online.qsx.model.Admin;

@Repository
public class AdminDaoImpl implements AdminDao{

	@Autowired
	private BaseDao baseDao;
	@Override
	public boolean findByPwdAndName(Admin admin) {
		List<Admin> list = (List<Admin>) baseDao.getHibernateTemplate().find("from Admin");
		for (Admin adminDemo : list) {
			if((adminDemo.getLoginName()).equals(admin.getLoginName())&&
					(adminDemo.getPassword()).equals(admin.getPassword())){
				return true;
			}
		}
		return false;
	}
}
