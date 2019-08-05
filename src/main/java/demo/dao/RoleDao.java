package demo.dao;

import demo.model.Role;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RoleDao {

		@Autowired
		private SessionFactory sessionFactory;


		public List<Role> findAllRoles(){
			return sessionFactory.getCurrentSession().createQuery("SELECT a FROM Role a")
					.getResultList();
		}
}


