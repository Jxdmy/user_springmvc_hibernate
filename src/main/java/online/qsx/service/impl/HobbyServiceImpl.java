package online.qsx.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import online.qsx.dao.impl.HobbyDaoImpl;
import online.qsx.model.Hobby;
import online.qsx.service.HobbyService;

@Service
public class HobbyServiceImpl implements HobbyService{
	@Autowired
	private HobbyDaoImpl hobbyDaoImpl;
	@Override
	public List<Hobby> findAll(Hobby hobby) {
		return hobbyDaoImpl.findAll(hobby);
	}
	@Override
	public void save(Hobby hobby) {
		hobbyDaoImpl.save(hobby);
	}

	@Override
	public Hobby findById(Hobby hobby) {
		return hobbyDaoImpl.findById(hobby);
	}

	@Override
	public void remove(Hobby hobby) {
		hobbyDaoImpl.remove(hobby);
	}

	@Override
	public void edit(Hobby hobby) {
		hobbyDaoImpl.edit(hobby);
	}
}
