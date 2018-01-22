package online.qsx.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import online.qsx.dao.impl.JobDaoImpl;
import online.qsx.model.Job;
import online.qsx.service.JobService;

@Service
public class JobServiceImpl implements JobService{
	@Autowired
	private JobDaoImpl jobDaoImpl;
	@Override
	public List<Job> findAll(Job job) {
		return jobDaoImpl.findAll(job);
	}
	@Override
	public void save(Job job) {
		jobDaoImpl.save(job);
	}

	@Override
	public Job findById(Job job) {
		return jobDaoImpl.findById(job);
	}

	@Override
	public void remove(Job job) {
		jobDaoImpl.remove(job);
	}

	@Override
	public void edit(Job job) {
		jobDaoImpl.edit(job);
	}
}
