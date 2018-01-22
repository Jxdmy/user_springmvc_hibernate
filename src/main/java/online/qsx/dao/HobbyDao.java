package online.qsx.dao;

import java.util.List;

import online.qsx.model.Hobby;

public interface HobbyDao {
	List<Hobby> findAll(Hobby hobby);
	Hobby findById(Hobby hobby);
	void save(Hobby hobby);
	void remove(Hobby hobby);
	void edit(Hobby hobby);
}
