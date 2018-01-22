package online.qsx.dao.impl;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import online.qsx.dao.BaseDao;
import online.qsx.dao.JobDao;
import online.qsx.model.Job;

@Repository
public class JobDaoImpl implements JobDao{
	@Autowired
	private BaseDao baseDao;
	@Override
	public List<Job> findAll(Job job) {
		List<Job> list = (List<Job>) baseDao.getHibernateTemplate().find("from Job");
		return list;
	}
	@Override
	public void save(Job job) {
		baseDao.getHibernateTemplate().save(job);
	}

	@Override
	public Job findById(Job job) {
		return baseDao.getHibernateTemplate().get(Job.class, job.getId());
	}

	@Override
	public void remove(Job job) {
		baseDao.getHibernateTemplate().delete(job);		
	}

	@Override
	public void edit(Job job) {
		baseDao.getHibernateTemplate().update(job);
	}

}
