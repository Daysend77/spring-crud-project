package demo.dao;

import demo.model.Role;
import demo.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDao  {

	@Autowired
	private SessionFactory sessionFactory;


	public int saveUser(String name, int role_id){
		Role role = sessionFactory.getCurrentSession().get(Role.class, role_id);
		User user = new User(name, role);
		Integer myId = (Integer)sessionFactory.getCurrentSession().save(user);
		return myId;
	}

	public List<User> findAllUser(){
		return sessionFactory.getCurrentSession().createQuery("SELECT a FROM User a")
				.getResultList();
	}

	public void updateUser(int id, String name, int roleId) {
		Session session = sessionFactory.getCurrentSession();
		Role role = session.get(Role.class, roleId);
		User user = session.get(User.class, id);
		user.setName(name);
		user.setRole(role);
		session.save(user);

	}

	public void deleteUser(int id) {
		User user = new User();
		user.setId(id);
		sessionFactory.getCurrentSession().remove(user);
	}

	public User findUserById(int id){
		return sessionFactory.getCurrentSession().get(User.class, id);
	}
}