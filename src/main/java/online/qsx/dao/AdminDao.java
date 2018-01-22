package online.qsx.dao;

import online.qsx.model.Admin;


public interface AdminDao {
	boolean findByPwdAndName(Admin admin);
}
