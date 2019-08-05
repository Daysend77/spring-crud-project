package demo.service;

import demo.dao.UserDao;
import demo.model.Role;
import demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("UserServiceImpl")
public class UserServiceImpl {

	@Autowired
	private UserDao userDao;


	@Transactional
	public int saveUser(String name, int role_id) {
		return userDao.saveUser(name, role_id);
	}

	@Transactional
	public List<User> findAllUser() {
		return userDao.findAllUser();
	}


	@Transactional
	public void updateUser(int id, String name, int roleId){
		userDao.updateUser(id, name, roleId);
	}

	@Transactional
	public void deleteUser(int id){
		userDao.deleteUser(id);
	}

	@Transactional
	public User findUserById(int id){
		return userDao.findUserById(id);
	}

}