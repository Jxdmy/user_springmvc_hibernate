package online.qsx.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import online.qsx.dao.impl.AdminDaoImpl;
import online.qsx.model.Admin;
import online.qsx.service.AdminService;
@Service
public class AdminServiceImpl implements AdminService{

	@Autowired
	private AdminDaoImpl adminDaoImpl;
	@Override
	public boolean findByPwdAndName(Admin admin) {
		return adminDaoImpl.findByPwdAndName(admin);
	}
}
