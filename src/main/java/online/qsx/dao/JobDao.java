package online.qsx.dao;

import java.util.List;

import online.qsx.model.Job;

public interface JobDao {
	List<Job> findAll(Job job);
	Job findById(Job job);
	void save(Job job);
	void remove(Job job);
	void edit(Job job);
}
