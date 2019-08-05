import demo.model.User;
import demo.service.UserServiceImpl;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { MvcWebConfig.class })
@WebAppConfiguration
@Transactional
public class RoleUserTest {


	public String testName = "testName";

	@Autowired
	UserServiceImpl userService;

	@Autowired
	private SessionFactory sessionFactory;


	@Test
	public void testCreateUser() {

		userService.saveUser(testName, 1);
		Query query= sessionFactory.getCurrentSession().
				createQuery("from User where name=:name");
		query.setParameter("name", testName);
		User user = (User) query.uniqueResult();

		Assert.assertEquals(testName, user.getName());

	}


	@Test
	public void testDeleteUser() {

		Query query = sessionFactory.getCurrentSession().
				createQuery("select id from User where name=:name");
		query.setParameter("name", testName);
		int id = (Integer) query.uniqueResult();

		userService.deleteUser(id);

		query = sessionFactory.getCurrentSession().
				createQuery("select id from User where name=:name");
		query.setParameter("name", testName);

		Assert.assertNull(query.uniqueResult());
	}

}
