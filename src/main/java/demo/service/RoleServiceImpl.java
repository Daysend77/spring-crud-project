package demo.service;


import demo.dao.RoleDao;

import demo.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RoleServiceImpl {

	@Autowired
	private RoleDao roleDao;


	@Transactional
	public List<Role> findAllRoles() {
		return roleDao.findAllRoles();
	}

}


